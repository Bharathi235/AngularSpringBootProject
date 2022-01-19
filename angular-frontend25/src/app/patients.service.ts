import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Patients } from './patients';

@Injectable({
  providedIn: 'root'
})
export class PatientsService {
  
  private baseURL="http://localhost:8080/api/v1/PatientsList";

  constructor(private httpClient : HttpClient) { }
  
  getPatientsList(): Observable<Patients[]>{
    return this.httpClient.get<Patients[]>(`${this.baseURL}`);
  }

  createPatients(patients: Patients): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, patients);
  }
  getPatientsById(id: number): Observable<Patients>{
    return this.httpClient.get<Patients>(`${this.baseURL}/${id}`);
  }

  updatePatients(id: number, patients: Patients): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, patients);
  }

  deletePatients(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

  
  
}
