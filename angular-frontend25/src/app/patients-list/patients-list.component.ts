import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patients } from '../patients';
import { PatientsService } from '../patients.service';

@Component({
  selector: 'app-patients-list',
  templateUrl: './patients-list.component.html',
  styleUrls: ['./patients-list.component.css']
})
export class PatientsListComponent implements OnInit {

  patients1: Patients[];
  name:String;
  constructor(private patientsService:PatientsService ,private router: Router) { }

  ngOnInit(): void {
    this.getPatients();    
  }
  private getPatients(){
    this.patientsService.getPatientsList().subscribe(data => {
      this.patients1 = data;
    });
  }

  patientsDetails(id: number){
    this.router.navigate(['patients-details', id]);
  } 

  updatePatients(id: number){
    this.router.navigate(['update-patients', id]);
  }
  deletePatients(id: number){
    this.patientsService.deletePatients(id).subscribe( data => {
      console.log(data);
      this.getPatients();
    })
  }

  findPatientsById(id : number){
    this.patientsService.getPatientsById(id).subscribe( data => {
      console.log(data);
      this.getPatients();
    })
  }
}
