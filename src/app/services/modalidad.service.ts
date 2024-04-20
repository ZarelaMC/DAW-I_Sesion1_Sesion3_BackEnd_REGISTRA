import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppSettings } from '../app.settings';
import { Modalidad } from '../models/modalidad.model';
import { Observable } from 'rxjs';


const baseUrlModalidad  = AppSettings.API_ENDPOINT + "/modalidad"


@Injectable({
  providedIn: 'root'
})
export class ModalidadService {

  constructor(private http: HttpClient) {
   }


   registraModalidad(obj:Modalidad): Observable<any>{
    return this.http.post(baseUrlModalidad, obj);
}

}
