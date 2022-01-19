import { Time } from "@angular/common";

import { Patients } from "./patients";

export class Doctors  {
    Did: number;
    name: String;
    age: number;
    specializedin: string;
    patients: Array<Patients>; 
    isAvailable: string;
    emailId: string;
    avilabletime:Time;

    }
 
