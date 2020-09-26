import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';



@Injectable({
    providedIn: 'root'
  })

export class takeQuizService{
    constructor(private http: HttpClient) { }
  takeQuestion(value: any): Observable<any> {
    console.log("Take service"+ value)
    return this.http.post<any>(environment.api+'/takeQuiz', JSON.stringify(value));
  }
}