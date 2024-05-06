from request_handler import *
import sys


def print_commands():
    print("----- Commands -----")
    print("1) getServices")
    print("2) describeService")
    print("3) getOperationResult")
    print("4) getCompositeTestResult")
    print("5) getGenerateCompositeNumbers")
    print("6) getCompositeNumbersList")
    print("7) listCommands")
    print("8) exit")
    print("--------------------")


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: python client.py <address:port>")
        sys.exit(1)
    server = sys.argv[1]
    request_handler = RequestHandler(server)
    print_commands()

    success, response = request_handler.test_connection()
    if success:
        print("Połączenie z serwerem jest aktywne.")
    else:
        print("Błąd połączenia z serwerem:", response)
        sys.exit(1)

    while True:
        arg = input("Enter command: ").strip()

        if arg == "getServices" or arg == "1":
            try:
                print(request_handler.get_services())
            except Exception as e:
                print(e)

        elif arg == "describeService" or arg == "2":
            print("Enter object name: ")
            service = input()
            try:
                print(request_handler.describe_service(service))
            except Exception as e:
                print(e)

        elif arg == "getOperationResult" or arg == "3":
            print("Enter operation name (ADD, MIN, MAX, AVG): ")
            operation = input()
            if operation not in ["ADD", "MIN", "MAX", "AVG"]:
                print("Invalid operation")
                continue

            print("Enter numbers: ")
            input_str = input()
            if not input_str:
                print("Invalid input")
                continue
            for num in input_str.split():
                if not num.isdigit():
                    print("Invalid input")
                    continue
            numbers = [int(num) for num in input_str.split()] if input_str else []
            try:
                print(request_handler.get_operation_result(operation, numbers))
            except Exception as e:
                print(e)

        elif arg == "getCompositeTestResult" or arg == "4":
            print("Enter number: ")
            try:
                number = int(input() or 0)
                print(request_handler.get_composite_tester_result(number))
            except Exception as e:
                print(e)

        elif arg == "getGenerateCompositeNumbers" or arg == "5":
            print("Enter max value: ")
            try:
                max_value = int(input() or 0)
                print(request_handler.get_stream_composite_numbers_result(max_value))
            except Exception as e:
                print(e)

        elif arg == "getCompositeNumbersList" or arg == "6":
            print("Enter max value: ")
            try:
                max_value = int(input() or 0)
                print(request_handler.get_list_composite_numbers_result(max_value))
            except Exception as e:
                print(e)

        elif arg == "exit" or arg == "8":
            break

        elif arg == "listCommands" or arg == "7":
            print_commands()

        else:
            print("Unknown command")

    print("Exiting...")
