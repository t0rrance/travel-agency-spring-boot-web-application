import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TravelRequest} from "../travel/travelRequest";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  // createTeam(travelRequest: Object): Observable<Object>{
  createTeam(travel: TravelRequest): Observable<any> {
    return this.http.post("http://localhost:8080/travels", travel);
  }

  getTravel(id: number): Observable<any> {
    return this.http.get("http://localhost:8080/travels/" + id);
  }

}
