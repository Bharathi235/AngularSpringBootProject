import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PatientsListComponent } from './patients-list/patients-list.component';
import { CreatePatientsComponent } from './create-patients/create-patients.component';
import { FormsModule} from '@angular/forms';
import { UpdatePatientsComponent } from './update-patients/update-patients.component';
import { PatientsDetailsComponent } from './patients-details/patients-details.component';
import { DoctorsListComponent } from './doctors-list/doctors-list.component';


@NgModule({
  declarations: [
    AppComponent,
    PatientsListComponent,
    CreatePatientsComponent,
    UpdatePatientsComponent,
    PatientsDetailsComponent,
    DoctorsListComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
