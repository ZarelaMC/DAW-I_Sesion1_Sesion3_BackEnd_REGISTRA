package com.empresa.controller;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Modalidad;
import com.empresa.service.ModalidadService;

@RestController
@RequestMapping("/url/modalidad")
public class ModalidadController {

	@Autowired
	private ModalidadService service;
	
	
	@GetMapping
	public List<Modalidad> lista(){
		List<Modalidad> lstSalida = service.listaModalidad();
		return lstSalida;
	}
	
	
	
	//? - cualquier tipo de dato  //ResponseBody - va recibir un JSON
	@PostMapping
	public ResponseEntity<?> inserta(@RequestBody Modalidad obj){
		List<String> lstMensaje = new ArrayList<String>();
		//Por convención
			// Al registrar el estado es 1
			// La fecha de registro es la misma del sistema
			// La fecha de actualización es la misma del sistema
		obj.setEstado(1);
		obj.setFechaRegistro(new Date());
		obj.setFechaActualizacion(new Date());
		
		Modalidad objSalida = service.insertarModalidad(obj);
		if (objSalida == null) {
			lstMensaje.add("Error en el registro");
		}else {
			lstMensaje.add("Se registró la modalidad de id = " + obj.getIdModalidad());	
		}
		return ResponseEntity.ok(lstMensaje);
	}
	
	
	
}