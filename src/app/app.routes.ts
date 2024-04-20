import { Routes } from '@angular/router';
import { AddAlumnoComponent } from './components/add-alumno/add-alumno.component';
import { AddEmpleadoComponent } from './components/add-empleado/add-empleado.component';

export const routes: Routes = [

    {   path: "addModalidad", component: AddAlumnoComponent  },
    {   path: "addEmpleado", component: AddEmpleadoComponent  }
]; 