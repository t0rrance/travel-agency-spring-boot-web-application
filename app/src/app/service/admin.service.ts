import { Injectable } from '@angular/core';
import {User} from "../auth/model/user";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {TravelRequest} from "../travel/travelRequest";
import {Observable} from "rxjs";

let API_URL = "http://localhost:8080/api/admin/";

@Injectable({
  providedIn: 'root'
})

export class AdminService {

  currentUser: User;
  headers: HttpHeaders;

  constructor(private http: HttpClient) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.headers = new HttpHeaders({
      authorization:'Bearer ' + this.currentUser.token,
      "Content-Type":"application/json; charset=UTF-8"
    });
  }

  findAllUsers(): Observable<any> {
    return this.http.get(API_URL + "all", {headers: this.headers});
  }

  createTravel(travelRequest: TravelRequest): Observable<any> {
    return this.http.post("http://localhost:8080/api/admin/travels", travelRequest, {headers: this.headers});
  }

  getAllTravels(): Observable<any> {
    return this.http.get( "http://localhost:8080/api/admin/travels", {headers: this.headers});
  }
  
  
}
