from pydantic import BaseModel
from typing import List

class Answer(BaseModel):
    a_id: int
    answer: str
    answer_no: int = 0


class Question(BaseModel):
    q_id: int
    question: str
    answers: List[Answer]


class Poll(BaseModel):
    p_id: int
    poll_name: str
    questions: List[Question]


database_polls: List[Poll] = [
    Poll(
        p_id=1,
        poll_name="Football poll",
        questions=[
            Question(
                q_id=1,
                question="What is your favorite team",

                answers=[
                    Answer(a_id=1, answer="Real Madrid"),
                    Answer(a_id=2, answer="FCB"),
                    Answer(a_id=3, answer="PSG"),
                ],
            ),
            Question(
                q_id=2,
                question="What is your least favorite team?",
                answers=[
                    Answer(a_id=1, answer="Man United"),
                    Answer(a_id=2, answer="Liverpool"),
                    Answer(a_id=3, answer="Juventus")
                ],
            )
        ],
    ),
    Poll(
        p_id=2,
        poll_name="Meeting poll",
        questions=[
            Question(
                q_id=1,
                question="Best day for meeting?",
                answers=[
                    Answer(a_id=1, answer="Monday"),
                    Answer(a_id=2, answer="Friday"),
                    Answer(a_id=3, answer="Saturday"),
                ],
            ),
            Question(
                q_id=2,
                question="What about an hour?",
                answers=[
                    Answer(a_id=1, answer="10:00"),
                    Answer(a_id=2, answer="12:00"),
                    Answer(a_id=3, answer="15:00"),
                ],
            )
        ],
    )
]

