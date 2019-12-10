import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { User } from '../user';
@Injectable({
  providedIn: 'root'
})
export class AuthenticationServiceService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
      return this.http.get<User>('http://localhost:7173/sales/inventory-gateway/inventory/getCustomer/'+username+'/'+password )
          .pipe(map(user => {
              // login successful if there's a jwt token in the response
              if (user && user.firstName) {
                console.log("="+user.firstName);
                  // store user details and jwt token in local storage to keep user logged in between page refreshes
                  localStorage.setItem('currentUser', JSON.stringify(user));
              }

              return user;
          })
          );
  }

  logout() {
      // remove user from local storage to log user out
      localStorage.removeItem('currentUser');
  }
}
