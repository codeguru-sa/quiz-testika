import { Component, OnInit } from '@angular/core';
import { takeQuizService } from '../service/take.quiz.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-take-quiz',
  templateUrl: './take-quiz.component.html',
  styleUrls: ['./take-quiz.component.css']
})
export class TakeQuizComponent implements OnInit {
  subInt;
  status: any;
  constructor(private takeQuizService: takeQuizService, private router: Router) { }

  ngOnInit(): void {
    
  }
  takeDbms(){
    this.subInt=1001;
    this.takeQuizService.takeQuestion(this.subInt).subscribe(res=>{
      this.status=res;
    });
  }
  takeJava(){
    this.subInt=1002;
    this.takeQuizService.takeQuestion(this.subInt).subscribe(res=>{
      this.status=res;
    });
  }
  takeAngular(){
    this.subInt=1003;
    this.takeQuizService.takeQuestion(this.subInt).subscribe(res=>{
      this.status=res;
    });
  }
  takeC(){
    this.subInt=1004;
    this.takeQuizService.takeQuestion(this.subInt).subscribe(res=>{
      this.status=res;
    });
  }
}
const questionSection = document.getElementById('section-b');
const startQuizBtn = document.getElementById('section-a');
const eachQuestion = document.getElementById('question');
const nextBtn = document.getElementById('next');
const options = document.getElementById('main-quiz-container').children;
const quizOverText1 = document.getElementById('over-text-1');
const quizOverText2 = document.getElementById('over-text-2');

startQuizBtn.addEventListener('click', startQuiz);

function startQuiz() {
    startQuizBtn.classList.add('hide');
    questionSection.classList.remove('hide');
    quizBody(questionsCounter);
}

function restartQuiz() {
    document.getElementById('quiz-over').classList.add('hide');
    questionSection.classList.remove('hide');
    nextBtn.classList.add('hide');
    questionsCounter = 0;
    quizBody(questionsCounter);
}

let question;
let option;

let questions = [{
        question: "Who popularized the rule of law in the 19th century?",
        options: [
            "Rotimi Amaechi",
            "A.V Dicey",
            "Olusegun Obasanjo",
            "Atiku Abubakar"
        ],
        answer: 1
    },
    {
        question: "What year did Nigeria gain independence?",
        options: [
            "1985",
            "1960",
            "1990",
            "1963"
        ],
        answer: 1
    },
    {
        question: "Who is the founder of Microsoft?",
        options: [
            "Donald Trump",
            "Jimi Agbaje",
            "Mark Zuckerberg",
            "Bill Gates"
        ],
        answer: 3
    },
    {
        question: "What year was Nigeria amalgamated and by who?",
        options: [
            "Queen Elizabeth 1914",
            "Carlie Symond 1920",
            "Lord Frederick Lugard 1914",
            "General Abacha 1960"
        ],
        answer: 2
    },
    {
        question: "What year did Barcelona win six trophies?",
        options: [
            "2009",
            "2006",
            "2008",
            "2010"
        ],
        answer: 0
    },
];

function quizBody(index) {
    question = eachQuestion.innerHTML = questions[index].question;
    option = document.getElementById('0').innerHTML = '{A} ' + questions[index].options[0]
    option = document.getElementById('1').innerHTML = '{B} ' + questions[index].options[1];
    option = document.getElementById('2').innerHTML = '{C} ' + questions[index].options[2];
    option = document.getElementById('3').innerHTML = '{D} ' + questions[index].options[3];
    questionsAnswered = document.getElementById('q-c').innerHTML = questionsCounter + '/' + questions.length;
    score = document.getElementById('s-c').innerHTML = 'Score: ' + scoreCounter;
}
let score;
let scoreCounter = 0;
let questionsAnswered;
let questionsCounter = 0;

function choose(element) {
    for (let i = 0; i < questions.length; i++) {
        if (questionsCounter == i && element.id == questions[i].answer) {
            scoreCounter += 5;
            score = document.getElementById('s-c').innerHTML = 'Score: ' + scoreCounter;
        } else {
            element.classList.remove('options');
            element.classList.add('wrong');
            score = document.getElementById('s-c').innerHTML = 'Score: ' + scoreCounter;
        }
    }
    lockOptions();
}

function lockOptions() {
    for (let i = 0; i < options.length; i++) {
        options[i].classList.add('disabled');
        nextBtn.classList.remove('hide');
        if (Number(options[i].id )== questions[questionsCounter].answer) {
            options[i].classList.add('correct');
            options[i].classList.remove('wrong');
        }
    }
}

function quizOver() {
    questionSection.classList.add('hide');
    document.getElementById('quiz-over').classList.remove('hide');
    if (scoreCounter <= 10) {
        quizOverText1.innerHTML = 'Well Done!';
        quizOverText2.innerHTML = 'You Scored ' + scoreCounter;
    } else if (scoreCounter <= 20) {
        quizOverText1.innerHTML = 'Bravo!';
        quizOverText2.innerHTML = 'You Scored ' + scoreCounter;
    } else {
        quizOverText1.innerHTML = 'Excellent!';
        quizOverText2.innerHTML = 'You Scored ' + scoreCounter;
    }
}

function next() {
    if (questionsCounter == questions.length - 1) {
        quizOver();
        scoreCounter = 0;
    } else if (questionsCounter < questions.length - 1) {
        nextBtn.classList.add('hide');
        questionsCounter += 1;
        quizBody(questionsCounter);
    }
    document.getElementById('0').classList.remove('correct', 'wrong', 'disabled');
    document.getElementById('0').classList.add('options');
    document.getElementById('1').classList.remove('correct', 'wrong', 'disabled');
    document.getElementById('1').classList.add('options');
    document.getElementById('2').classList.remove('correct', 'wrong', 'disabled');
    document.getElementById('2').classList.add('options');
    document.getElementById('3').classList.remove('correct', 'wrong', 'disabled');
    document.getElementById('3').classList.add('options');
};