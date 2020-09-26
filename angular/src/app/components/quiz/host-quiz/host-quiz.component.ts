import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HostQuizService } from 'src/app/service/host.quiz.form.service';
import { Router } from '@angular/router';
import { Quiz } from 'src/app/model/quiz.model';


@Component({
  selector: 'app-host-quiz',
  templateUrl: './host-quiz.component.html',
  styleUrls: ['./host-quiz.component.css']
})
export class HostQuizComponent implements OnInit {

  currentSubject: string;
  questionsArr = [];
  completeForm= [];
  myObj: any[];
  showForm: boolean= true;
  status: Quiz[];
  subInt;
  quiz: Quiz;
  currentStatus: boolean = true;

  constructor(private hostQuizService:HostQuizService, private router: Router ) {   }

  ngOnInit(): void {   

  }
  quizForm :FormGroup= new FormGroup({
      subject: new FormControl(''),
      question: new FormControl('',Validators.required),
      answer: new FormControl('',Validators.required),
      option1: new FormControl('',Validators.required),
      option2: new FormControl('',Validators.required),
      option3: new FormControl('',Validators.required),
      option4: new FormControl('',Validators.required)
  });

  get subject(){
    return this.quizForm.get('subject');
  }
  get question(){
    return this.quizForm.get('question');
  }
  get option1(){
    return this.quizForm.get('option1');
  }
  get option2(){
    return this.quizForm.get('option2');
  }
  get option3(){
    return this.quizForm.get('option3');
  }
  get option4(){
    return this.quizForm.get('option4');
  }
  get answer(){
    return this.quizForm.get('answer');
  }

  onSubmit() {
    this.myObj = this.questionsArr;
    console.log(this.myObj)
    this.hostQuizService.hostQuestion(this.myObj).subscribe(res=>{
      this.status = res;
      if(this.status){
        alert('Quiz submit!');
        this.quizForm.reset();
      }
    });
  }

  addQuestion() {
    this.questionsArr.push(this.quizForm.value);
    this.quizForm.get('question').reset();
    this.quizForm.get('option1').reset();
    this.quizForm.get('option2').reset();
    this.quizForm.get('option3').reset();
    this.quizForm.get('option4').reset();
    this.quizForm.get('answer').reset();
    if(this.questionsArr.length == 10){
      this.currentStatus=false;
    }
  }
  resetClick(){
    this.quizForm.get('question').reset();
    this.quizForm.get('option1').reset();
    this.quizForm.get('option2').reset();
    this.quizForm.get('option3').reset();
    this.quizForm.get('option4').reset();
    this.quizForm.get('answer').reset();
  }

  cancelClick() {
    localStorage.clear();
    this.router.navigateByUrl('/home');
  }

  deleteQuestion(i) {
    this.questionsArr.splice(i, 1);
  }

 
saveDbms(){
  this.showForm = false;
  localStorage.setItem('subject', 'DBMS');
  this.currentSubject=localStorage.getItem('subject')
  this.subInt=1001;
  this.quizForm.patchValue({ subject: this.subInt });
}
saveJava(){
  this.showForm = false;
  localStorage.setItem('subject', 'JAVA');
  this.currentSubject=localStorage.getItem('subject')
  this.subInt=1002;
  this.quizForm.patchValue({ subject: this.subInt });
}
saveAngular(){
  this.showForm = false;
  localStorage.setItem('subject', 'ANGULAR');
  this.currentSubject=localStorage.getItem('subject')
  this.subInt=1003;
  this.quizForm.patchValue({ subject: this.subInt });
}
saveC(){
  this.showForm = false;
  localStorage.setItem('subject', 'C');
  this.currentSubject=localStorage.getItem('subject')
  this.subInt=1004;
  this.quizForm.patchValue({ subject: this.subInt });
}

}
