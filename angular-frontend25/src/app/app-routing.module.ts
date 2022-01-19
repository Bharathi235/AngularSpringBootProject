import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreatePatientsComponent } from './create-patients/create-patients.component';
import { DoctorsListComponent } from './doctors-list/doctors-list.component';
import { PatientsDetailsComponent } from './patients-details/patients-details.component';
import { PatientsListComponent } from './patients-list/patients-list.component';
import { UpdatePatientsComponent } from './update-patients/update-patients.component';

const routes: Routes = [
  {path: 'patients', component: PatientsListComponent},  
  {path: 'create-patients', component: CreatePatientsComponent},
  {path: '', redirectTo: 'patients', pathMatch: 'full'},
  {path: 'update-patients/:id', component: UpdatePatientsComponent},
  {path: 'doctors', component: DoctorsListComponent},  
  {path: 'patients-details/:id', component: PatientsDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
