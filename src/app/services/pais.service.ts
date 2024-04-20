import { Injectable } from '@angular/core';
import { AppSettings } from '../app.settings';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pais } from '../models/pais.model';


const baseUrlUtil  = AppSettings.API_ENDPOINT + "/util"
@Injectable({
  providedIn: 'root'
})
export class PaisService {

  constructor(private http: HttpClient) { }

  listaPais(): Observable<Pais[]>{
    return this.http.get<Pais[]>(baseUrlUtil+"/pais")
  }
}
