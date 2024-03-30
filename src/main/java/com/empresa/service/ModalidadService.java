package com.empresa.service;

import java.util.List;

import com.empresa.entity.Modalidad;

public interface ModalidadService {
	public abstract List<Modalidad> listaModalidad();
	public abstract Modalidad insertarModalidad(Modalidad obj);
}
