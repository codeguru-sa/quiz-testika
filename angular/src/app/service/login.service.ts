import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user.model';
import { Quiz } from '../model/quiz.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private http: HttpClient) { }

  registerNewUser(value: User): Observable<User> {
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    return this.http.post<User>(environment.api+'/register', JSON.stringify(value),{ headers, responseType: 'text' as 'json' });
  }
  loginUser(value: User): Observable<any> {
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    return this.http.post<any>(environment.api+'/login', JSON.stringify(value), { headers, responseType: 'text' as 'json' });
  }
 
}