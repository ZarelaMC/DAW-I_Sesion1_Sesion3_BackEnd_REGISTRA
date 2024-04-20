import { Component } from '@angular/core';
import { AppMaterialModule } from '../../app.material.module';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Deporte } from '../../models/deporte.model';
import { DeporteService } from '../../services/deporte.service';
import { ModalidadService } from '../../services/modalidad.service';
import { Modalidad } from '../../models/modalidad.model';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-alumno',
  standalone: true,
  imports: [AppMaterialModule, 
            FormsModule, CommonModule],
  templateUrl: './add-alumno.component.html',
  styleUrl: './add-alumno.component.css'
})
export class AddAlumnoComponent {

  lstDeportes: Deporte[] = []; 
  //--
  objModalidad : Modalidad  ={
    nombre : "",
    numHombres : 0,
    numMujeres : 0,
    edadMaxima : 0,
    edadMinima : 0,
    sede : "",
    deporte : {
        idDeporte : -1
    }
}

  constructor(private deporteService: DeporteService,
    private modalidadService: ModalidadService
  ){
        this.deporteService.listaDeporte().subscribe(
            x => this.lstDeportes = x
        );
  }

  registra(){
    this.modalidadService.registraModalidad(this.objModalidad).subscribe(
      x =>  Swal.fire({icon: 'info',
                      title: 'Registro exitoso',
                      text: x}) 
    );
}
}