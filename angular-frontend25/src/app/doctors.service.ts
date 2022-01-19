import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Doctors } from './doctors';
@Injectable({
  providedIn: 'root'
})
export class DoctorsService {
  private baseURL="http://localhost:8080/api/v1/DoctorsList";

  constructor(private httpClient : HttpClient) { }
  
  getDoctorsList(): Observable<Doctors[]>{
    return this.httpClient.get<Doctors[]>(`${this.baseURL}`);
  }
}