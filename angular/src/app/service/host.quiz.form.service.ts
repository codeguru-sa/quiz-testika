import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Quiz } from '../model/quiz.model';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
  })
export class HostQuizService {
  constructor(private http: HttpClient) { }
  hostQuestion(value: any): Observable<any> {
    console.log('going through here', value)
    return this.http.post<any>(environment.api+'/hostform', JSON.stringify(value));
  }
}
