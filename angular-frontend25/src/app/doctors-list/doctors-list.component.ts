import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Doctors } from '../doctors';
import { DoctorsService } from '../doctors.service';

@Component({
  selector: 'app-doctors-list',
  templateUrl: './doctors-list.component.html',
  styleUrls: ['./doctors-list.component.css']
})
export class DoctorsListComponent implements OnInit {

  doctors1: Doctors[];
  name:String;
  constructor(private doctorsService:DoctorsService ,private router: Router) { }

  ngOnInit(): void {
    this.getDoctors();    
  }
  private getDoctors(){
    this.doctorsService.getDoctorsList().subscribe(data => {
      this.doctors1 = data;
    });
  }
}
