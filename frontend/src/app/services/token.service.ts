import { Injectable } from '@angular/core';
import { UserAuthResponse } from '../model/userAuthResponse';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor(private http: HttpClient, private router: Router) {
  }
  
  private apiUrl:string = 'http://localhost:8080';

  public login(username: string, password: string): Observable<UserAuthResponse> {
    let headers = new HttpHeaders();
    headers = headers.append('Authorization', 'BASIC ' + btoa(username + ":" + password));
    return this.http.get<UserAuthResponse>(this.apiUrl+'/auth/token', {headers: headers, withCredentials: true});
  }
  


}
