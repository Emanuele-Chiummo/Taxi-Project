import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { RouteGuardService } from './services/route-guard.service';
import { AdminUserComponent } from './admin-user/admin-user.component';
import { AdminCourseComponent } from './admin-course/admin-course.component';
import { AdminTaxiComponent } from './admin-taxi/admin-taxi.component';
import { AdminAnalyticsComponent } from './admin-analytics/admin-analytics.component';
import { TassistaPendingRequestComponent } from './tassista-pending-request/tassista-pending-request.component';
import { TassistaMyRequestComponent } from './tassista-my-request/tassista-my-request.component';
import { TassistaEmailRequestComponent } from './tassista-email-request/tassista-email-request.component';

const routes : Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'welcome', component: WelcomeComponent, canActivate : [RouteGuardService]},
  { path: 'user', component: AdminUserComponent, canActivate : [RouteGuardService]},
  {path: 'course', component: AdminCourseComponent, canActivate : [RouteGuardService]},
  {path: 'taxi', component: AdminTaxiComponent, canActivate : [RouteGuardService]},
  {path:'analytics', component: AdminAnalyticsComponent, canActivate : [RouteGuardService]},
  {path: 'pending-request', component: TassistaPendingRequestComponent, canActivate : [RouteGuardService]},
  {path: 'my-request', component: TassistaMyRequestComponent, canActivate : [RouteGuardService]},
  {path: 'email-request', component: TassistaEmailRequestComponent, canActivate : [RouteGuardService]},
 
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})


export class AppRoutingModule { }
