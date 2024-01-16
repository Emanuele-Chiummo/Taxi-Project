import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from './auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate {

  constructor(private basicAuth: AuthService, private route: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state:  RouterStateSnapshot)  {

    if (!this.basicAuth.isLogged()) {
      this.route.navigate(['home']);
      return false;
    } else {
      return true;
    }
  }
}