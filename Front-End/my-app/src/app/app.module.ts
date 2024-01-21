import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { SpinnerComponent } from './spinner/spinner.component';
import { LoadingInterceptor } from './interceptors/loading.interceptor';
import { HeaderComponent } from './header/header.component';
import { AdminUserComponent } from './admin-user/admin-user.component';
import { AdminCourseComponent } from './admin-course/admin-course.component';
import { AdminTaxiComponent } from './admin-taxi/admin-taxi.component';
import { AdminAnalyticsComponent } from './admin-analytics/admin-analytics.component';
import { TassistaPendingRequestComponent } from './tassista-pending-request/tassista-pending-request.component';
import { TassistaMyRequestComponent } from './tassista-my-request/tassista-my-request.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    WelcomeComponent,
    SpinnerComponent,
    HeaderComponent,
    AdminUserComponent,
    AdminCourseComponent,
    AdminTaxiComponent,
    AdminAnalyticsComponent,
    TassistaPendingRequestComponent,
    TassistaMyRequestComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NgbModule,
    ReactiveFormsModule,
    FormsModule,
    FontAwesomeModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS, useClass: LoadingInterceptor, multi: true
    },
    // provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
