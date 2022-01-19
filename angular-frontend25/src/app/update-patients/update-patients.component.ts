import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patients } from '../patients';
import { PatientsService } from '../patients.service';

@Component({
  selector: 'app-update-patients',
  templateUrl: './update-patients.component.html',
  styleUrls: ['./update-patients.component.css']
})
export class UpdatePatientsComponent implements OnInit {
    id: number;
    patients: Patients = new Patients();
    constructor(private patientsService: PatientsService,
      private route: ActivatedRoute,
      private router: Router) { }
  
    ngOnInit(): void {
      this.id = this.route.snapshot.params['id'];
      this.patientsService.getPatientsById(this.id).subscribe(data => {
        this.patients = data;
      }, error => console.log(error));
    }
  
    onSubmit(){
      this.patientsService.updatePatients(this.id, this.patients).subscribe( data =>{
        this.goToPatientsList();
      }
      , error => console.log(error));
    }
  
    goToPatientsList(){
      this.router.navigate(['/patients']);
    }
  }