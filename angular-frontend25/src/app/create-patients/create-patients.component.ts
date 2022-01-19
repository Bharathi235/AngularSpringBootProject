import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patients } from '../patients';
import { PatientsService } from '../patients.service';

@Component({
  selector: 'app-create-patients',
  templateUrl: './create-patients.component.html',
  styleUrls: ['./create-patients.component.css']
})
export class CreatePatientsComponent implements OnInit {

  patients:Patients =new Patients();
  constructor( private patientsService: PatientsService ,private router: Router) { }

  ngOnInit(): void {
  }
  savePatients(){
    this.patientsService.createPatients(this.patients).subscribe( data =>{
      console.log(data);
      this.goToPatientsList();
    },
    error => console.log(error));
  }

  goToPatientsList(){
    this.router.navigate(['/patients']);
  }
  
  onSubmit(){
    console.log(this.patients);
    this.savePatients();
  }
}
