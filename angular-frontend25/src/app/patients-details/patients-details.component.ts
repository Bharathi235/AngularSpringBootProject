import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Patients } from '../patients';
import { PatientsService } from '../patients.service';

@Component({
  selector: 'app-patients-details',
  templateUrl: './patients-details.component.html',
  styleUrls: ['./patients-details.component.css']
})
export class PatientsDetailsComponent implements OnInit {
  id: number
  patients: Patients
  constructor(private route: ActivatedRoute, private patientsService: PatientsService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.patients = new Patients();
    this.patientsService.getPatientsById(this.id).subscribe( data => {
      this.patients = data;
    });
  }


}
