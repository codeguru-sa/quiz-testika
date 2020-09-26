import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { HostQuizComponent } from './components/quiz/host-quiz/host-quiz.component';
import { TakeQuizComponent } from './take-quiz/take-quiz.component';


const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'host', component: HostQuizComponent, },
  { path: 'take', component: TakeQuizComponent}
 ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
