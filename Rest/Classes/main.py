from fastapi import FastAPI, HTTPException, status
from models import Poll, Question, Answer, database_polls

app = FastAPI()


# create poll
@app.post("/polls/create", status_code=status.HTTP_201_CREATED)
async def create_poll(poll: Poll):
    database_polls.append(poll)
    return poll


# get all polls
@app.get("/polls/get")
async def get_all_polls():
    return database_polls


# get poll by id
@app.get("/polls/{poll_id}/get")
async def get_this_poll(poll_id: int):
    for poll in database_polls:
        if poll.p_id == poll_id:
            return poll
    raise HTTPException(status_code=404, detail="Poll not found")


# vote for answer in poll
@app.post("/polls/{poll_id}/vote")
async def vote_for_answer_poll(poll_id: int, question_id: int, answer_id: int):
    for poll in database_polls:
        if poll.p_id == poll_id:
            for question in poll.questions:
                if question.q_id == question_id:
                    for answer in question.answers:
                        if answer.a_id == answer_id:
                            answer.answer_no += 1
                            return answer
                    raise HTTPException(status_code=404, detail="Answer not found")
            raise HTTPException(status_code=404, detail="Question not found")
    raise HTTPException(status_code=404, detail="Poll not found")


# unvote in poll
@app.post("/polls/{poll_id}/unvote")
async def unvote(poll_id: int, question_id: int, answer_id: int):
    for poll in database_polls:
        if poll.p_id == poll_id:
            for question in poll.questions:
                if question.q_id == question_id:
                    for answer in question.answers:
                        if answer.a_id == answer_id:
                            answer.answer_no -= 1
                            return answer
                    raise HTTPException(status_code=404, detail="Answer not found")
            raise HTTPException(status_code=404, detail="Question not found")
    raise HTTPException(status_code=404, detail="Poll not found")


# delete poll
@app.delete("/polls/{poll_id}/delete")
async def delete_poll(poll_id: int):
    for poll in database_polls:
        if poll.p_id == poll_id:
            database_polls.remove(poll)
            return poll
    raise HTTPException(status_code=404, detail="Poll not found")


# create new question
@app.post("/polls/{poll_id}/questions/create")
async def create_question(poll_id: int, question: Question):
    for poll in database_polls:
        if poll.p_id == poll_id:
            poll.questions.append(question)
            return question
    raise HTTPException(status_code=404, detail="Poll not found")


# update question
@app.put("/polls/{poll_id}/questions/{question_id}/update")
async def update_question(poll_id: int, question_id: int, question: Question):
    for poll in database_polls:
        if poll.p_id == poll_id:
            for q in poll.questions:
                if q.q_id == question_id:
                    q.question = question.question
                    return q
            raise HTTPException(status_code=404, detail="Question not found")
    raise HTTPException(status_code=404, detail="Poll not found")


# delete question
@app.delete("/polls/{poll_id}/questions/{question_id}/delete")
async def delete_question(poll_id: int, question_id: int):
    for poll in database_polls:
        if poll.p_id == poll_id:
            for question in poll.questions:
                if question.q_id == question_id:
                    poll.questions.remove(question)
                    return question
            raise HTTPException(status_code=404, detail="Question not found")
    raise HTTPException(status_code=404, detail="Poll not found")


# create new answer
@app.post("/polls/{poll_id}/questions/{question_id}/answers/create")
async def create_answer(poll_id: int, question_id: int, answer: Answer):
    for poll in database_polls:
        if poll.p_id == poll_id:
            for question in poll.questions:
                if question.q_id == question_id:
                    question.answers.append(answer)
                    return answer
            raise HTTPException(status_code=404, detail="Question not found")
    raise HTTPException(status_code=404, detail="Poll not found")


# update answer
@app.put("/polls/{poll_id}/questions/{question_id}/answers/{answer_id}/update")
async def update_answer(poll_id: int, question_id: int, answer_id: int, answer: Answer):
    for poll in database_polls:
        if poll.p_id == poll_id:
            for question in poll.questions:
                if question.q_id == question_id:
                    for ans in question.answers:
                        if ans.a_id == answer_id:
                            ans.answer = answer.answer
                            return ans
                    raise HTTPException(status_code=404, detail="Answer not found")
            raise HTTPException(status_code=404, detail="Question not found")
    raise HTTPException(status_code=404, detail="Poll not found")


# delete answer
@app.delete("/polls/{poll_id}/questions/{question_id}/answers/{answer_id}/delete")
async def delete_answer(poll_id: int, question_id: int, answer_id: int):
    for poll in database_polls:
        if poll.p_id == poll_id:
            for question in poll.questions:
                if question.q_id == question_id:
                    for answer in question.answers:
                        if answer.a_id == answer_id:
                            question.answers.remove(answer)
                            return answer
                    raise HTTPException(status_code=404, detail="Answer not found")
            raise HTTPException(status_code=404, detail="Question not found")
    raise HTTPException(status_code=404, detail="Poll not found")


# get poll results
@app.get("/polls/{poll_id}/results")
async def get_poll_results(poll_id: int):
    result = []
    for poll in database_polls:
        if poll.p_id == poll_id:
            for question in poll.questions:
                result.append([question.question])
                for answer in question.answers:
                    result.append([answer.answer, answer.answer_no])
            return result
    raise HTTPException(status_code=404, detail="Poll not found")


# get all polls results
@app.get("/polls/results")
async def get_all_polls_results():
    result = []
    for poll in database_polls:
        result.append([poll.poll_name])
        for question in poll.questions:
            result.append([question.question])
            for answer in question.answers:
                result.append([answer.answer, answer.answer_no])
    return result


# get question results
@app.get("/polls/{poll_id}/questions/{question_id}/results")
async def get_question_results(poll_id: int, question_id: int):
    result = []
    for poll in database_polls:
        if poll.p_id == poll_id:
            for question in poll.questions:
                if question.q_id == question_id:
                    result.append([question.question])
                    for answer in question.answers:
                        result.append([answer.answer, answer.answer_no])
                    return result
            raise HTTPException(status_code=404, detail="Question not found")
    raise HTTPException(status_code=404, detail="Poll not found")
