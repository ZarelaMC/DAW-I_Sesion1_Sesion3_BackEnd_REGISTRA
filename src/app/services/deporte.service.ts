import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppSettings } from '../app.settings';
import { Observable } from 'rxjs';
import { Deporte } from '../models/deporte.model';

const baseUrlUtil  = AppSettings.API_ENDPOINT + "/util"

@Injectable({
  providedIn: 'root'
})
export class DeporteService {

  constructor(private http: HttpClient) { 

  }

  listaDeporte(): Observable<Deporte[]>{
    return this.http.get<Deporte[]>(baseUrlUtil+"/deporte")
  }

}
