package com.empresa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Empleado;
import com.empresa.service.EmpleadoService;
import com.empresa.util.AppSettings;

@RestController
@RequestMapping("/url/empleado")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;	

	@GetMapping
	public List<Empleado> listaEmpleado(){
		List<Empleado> lstSalida = empleadoService.listaEmpleado();
		return lstSalida;
	}
	
	@PostMapping
	public ResponseEntity<?> insertaEmpleado(@RequestBody Empleado obj){
		 List<String> lstMensajes = new ArrayList<String>();	
		 obj.setEstado(1);
		 obj.setFechaRegistro(new Date());
		 obj.setFechaActualizacion(new Date());
		 Empleado objSalida = empleadoService.insertaEmpleado(obj);
		 if (objSalida == null) {
			 lstMensajes.add("Error en el registro empleado");
		 }else {
			 lstMensajes.add("Se registró el empleado de id : " + objSalida.getIdEmpleado());
		 }
		return ResponseEntity.ok(lstMensajes);
	}
	
}
