import requests
import json
import os
from fastapi import FastAPI, HTTPException, Form, Request
from fastapi.templating import Jinja2Templates
from dotenv import load_dotenv
from datetime import datetime, timedelta
from fastapi.exceptions import RequestValidationError
from fastapi.responses import HTMLResponse

# Create FastAPI instance
app = FastAPI()

# Create Jinja2Templates instance
templates = Jinja2Templates(directory="templates")

# Load environment variables
load_dotenv()

# Get API keys from environment variables
API_KEY_CURR = os.getenv("API_KEY_CURRENCY")  # API to CurrencyApi
API_KEY_EXCHANGE = os.getenv("API_KEY_EXCHANGE_GENERATE")  # API to ExchangeRateApi
API_KEY = os.getenv("API_KEY")  # API to this service


# function to verify if the api key is valid
def verify_api_key(api_key: str):
    file = open('api_keys.txt', 'r')
    for line in file:
        if api_key in line:
            return True
    return False


# function to handle RequestValidationError
@app.exception_handler(RequestValidationError)
async def validation_exception_handler(request: Request, exc: RequestValidationError):
    error_message = ", ".join([f"{err['loc'][1]}: {err['msg']}" for err in exc.errors()])
    return templates.TemplateResponse("error.html", {"request": request, "error_message": error_message},
                                      status_code=400)


# function to handle HTTPException
@app.exception_handler(HTTPException)
async def http_exception_handler(request: Request, exc: HTTPException):
    return templates.TemplateResponse("error.html", {"request": request, "error_message": exc.detail},
                                      status_code=exc.status_code)


# homepage route
@app.get("/", response_class=HTMLResponse)
async def homepage(request: Request):
    if not verify_api_key(API_KEY):
        raise HTTPException(status_code=401, detail="Your API key is invalid, you can't use this service")

    if not API_KEY_CURR or not API_KEY_EXCHANGE:
        raise HTTPException(status_code=500, detail="Missing API_KEY_CURRENCY or API_KEY_EXCHANGE_GENERATE")

    return templates.TemplateResponse("home.html", {"request": request})  # render home.html


# function to convert string to int and remove unnecessary characters
def string_to_int(string):
    return int(string.replace('€', '').replace('m', '0000').replace('k', '0').replace('.', '').replace(' ', ''))


# function to get the most valuable player by club id
def get_most_valuable_player_by_club_id(parsed):
    try:
        players = parsed['players']
        players_with_market_value = [player for player in players if player.get('marketValue')]
        players_with_market_value = sorted(players_with_market_value,
                                           key=lambda x: string_to_int(x.get('marketValue', '0')), reverse=True)
        most_valuable_player = players_with_market_value[0]
        value = most_valuable_player.get('marketValue')

        return most_valuable_player, value
    except Exception as e:
        return e


# async function to get the most valuable player by club name and year
@app.post("/myApp/results/player", response_class=HTMLResponse)
async def results(request: Request, club_name: str = Form(...), year: str = Form(...)):
    if not verify_api_key(API_KEY):
        raise HTTPException(status_code=401, detail="Your API key is invalid, you can't use this service")

    if not club_name or not year:
        raise HTTPException(status_code=400, detail="Missing parameters: club_name or year")

    try:
        club_name = club_name.replace(' ', '%20')

        try:
            req = requests.get(
                f'https://transfermarkt-api.vercel.app/clubs/search/{club_name}?page_number=1')  # get club id
            parsed = json.loads(req.text)
            club_id = parsed['results'][0]['id']
        except Exception:
            raise HTTPException(status_code=404, detail="Api not responded or club not found")

        try:
            req = requests.get(
                f'https://transfermarkt-api.vercel.app/clubs/{club_id}/players?season_id={year}')  # get players
            parsed1 = json.loads(req.text)
            most_expensive_player, value = get_most_valuable_player_by_club_id(parsed1)  # get the most valuable player
        except Exception:
            raise HTTPException(status_code=404, detail="Api not responded or player not found")

        value = string_to_int(value) * currency_converter()
        value = str(round(value, 2)) + " PLN"
        name, age, position, dateofbirth, nationality, height, foot, valueofplayer = parse_info_about_player(
            most_expensive_player, value)  # parse info about player

        return templates.TemplateResponse("results.html",
                                          context={"request": request, "name": name, "age": age, "position": position,
                                                   "dateofbirth": dateofbirth, "nationality": nationality,
                                                   "height": height, "foot": foot,
                                                   "valueofplayer": valueofplayer})  # render results.html

    except Exception:
        raise HTTPException(status_code=404, detail="Failed to get player info beacuse of api error or parsing error")

    # function to get the average value of 1 EUR in PLN from two different APIs


def currency_converter():
    try:
        req = requests.get(
            f"https://api.currencyapi.com/v3/latest?apikey={API_KEY_CURR}&currencies=PLN&base_currency=EUR")
        parsed = json.loads(req.text)
        value1 = parsed['data']['PLN']['value']
    except Exception:
        raise HTTPException(status_code=404, detail="Currency Api not responded")

    try:
        req = requests.get(f"https://v6.exchangerate-api.com/v6/{API_KEY_EXCHANGE}/latest/EUR")
        parsed = json.loads(req.text)
        value2 = parsed['conversion_rates']['PLN']
    except Exception:
        raise HTTPException(status_code=404, detail="Exchange currency api not responded")

    return (value1 + value2) / 2


# function to parse info about player
def parse_info_about_player(parsed, value):
    try:
        name = parsed['name']
        age = parsed['age']
        position = parsed['position']
        dateofbirth = parsed['dateOfBirth']
        nationality = parsed["nationality"][0]
        height = parsed['height']
        foot = parsed['foot']
        valueofplayer = value

        return name, age, position, dateofbirth, nationality, height, foot, valueofplayer
    except Exception:
        raise HTTPException(status_code=404, detail="Failed to parse info about player")


# async function to convert money to PLN
@app.post("/myApp/results/money", response_class=HTMLResponse)
async def get_currency_values(request: Request, date_from: str = Form(...), date_to: str = Form(...),
                              currency: str = Form(...), money: str = Form(...)):
    if not verify_api_key(API_KEY):
        raise HTTPException(status_code=401, detail="Your API key is invalid, you can't use this service")

    if not date_from or not date_to or not currency or not money:
        raise HTTPException(status_code=400, detail="Missing parameters: date_from, date_to, currency, or money")

    try:
        frankfurter_sum = 0
        frankfurter_max_value = 0
        frankfurter_min_value = float('inf')
        try:
            req = requests.get(
                f"https://api.frankfurter.app/{date_from}..{date_to}?amount=1&from={currency}&to=PLN")  # get currency values from Frankfurter Api
            parsed = json.loads(req.text)
            days_frankfurter = 0
            for date, rate in parsed['rates'].items():
                days_frankfurter += 1
                frankfurter_sum += rate['PLN']
                frankfurter_max_value = max(frankfurter_max_value, rate['PLN'])
                frankfurter_min_value = min(frankfurter_min_value, rate['PLN'])
        except Exception:
            raise HTTPException(status_code=404, detail="Frankfurter Api not responded")

        start_date = datetime.strptime(date_from, '%Y-%m-%d').date()
        end_date = datetime.strptime(date_to, '%Y-%m-%d').date()
        days = (end_date - start_date).days
        sum = 0
        i = 200
        nbp_sum = 0
        days_of_nbp_raport = 0
        nbp_max_value = 0
        nbp_min_value = float('inf')

        try:
            while sum < days:
                # this is because NBP Api allows to get currency values for 367 days at once
                # I want to do this save and get 200 days at once
                if sum + 200 > days:
                    i = days - sum
                end_date = start_date + timedelta(days=i)
                start_date += timedelta(days=1)
                req = requests.get(
                    f"http://api.nbp.pl/api/exchangerates/rates/A/{currency}/{start_date}/{end_date}")  # get currency values from NBP Api
                start_date = end_date
                sum += 200
                parsed = req.json()
                days_of_nbp_raport += len(parsed['rates'])
                for j in range(len(parsed['rates'])):
                    nbp_sum += parsed['rates'][j]['mid']
                    nbp_max_value = max(nbp_max_value, parsed['rates'][j]['mid'])
                    nbp_min_value = min(nbp_min_value, parsed['rates'][j]['mid'])
        except Exception:
            raise HTTPException(status_code=404, detail="NBP Api not responded")

        nbp_mean = round(nbp_sum / days_of_nbp_raport * float(money), 2)
        frankfurter_mean = round(frankfurter_sum / days_frankfurter * float(money), 2)
        glob_min = round(min(frankfurter_min_value, nbp_min_value) * float(money), 2)
        glob_max = round(max(frankfurter_max_value, nbp_max_value) * float(money), 2)
        glob_mid = round((frankfurter_sum / days_frankfurter + nbp_sum / days_of_nbp_raport) / 2 * float(money), 2)

        return templates.TemplateResponse("results_money.html",
                                          context={"request": request, "money": money, "currency": currency,
                                                   "date_from": date_from, "date_to": date_to,
                                                   "global_min": glob_min,
                                                   "global_max": glob_max,
                                                   "glob_mid": glob_mid, "nbp_mid": nbp_mean,
                                                   "frankfurter_mid": frankfurter_mean})  # render results_money.html
    except Exception:
        raise HTTPException(status_code=404, detail="Failed to get currency values because of apis error")
