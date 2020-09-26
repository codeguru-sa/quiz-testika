import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { HostQuizComponent } from './components/quiz/host-quiz/host-quiz.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { TakeQuizComponent } from './take-quiz/take-quiz.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    HostQuizComponent,
    NavBarComponent,
    TakeQuizComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
  FormsModule  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
