package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Modalidad;
import com.empresa.repository.ModalidadRepository;

@Service
public class ModalidadServiceImpl implements ModalidadService{

	@Autowired
	private ModalidadRepository repository;
	
	@Override
	public List<Modalidad> listaModalidad() {
		return repository.findAll();
	}

	@Override
	public Modalidad insertarModalidad(Modalidad obj) {
		Modalidad objSalida = repository.save(obj);
		return objSalida;
	}

}
