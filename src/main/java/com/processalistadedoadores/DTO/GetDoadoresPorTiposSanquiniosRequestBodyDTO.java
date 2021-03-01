package com.processalistadedoadores.DTO;

import java.util.ArrayList;
import java.util.List;

import com.processalistadedoadores.entity.Doador;

public class GetDoadoresPorTiposSanquiniosRequestBodyDTO {

	private List<Doador> listaDoadores = new ArrayList<>();
	private String tipoSanguinio;
	
	public List<Doador> getListaDoadores() {
		return listaDoadores;
	}
	public void setListaDoadores(List<Doador> listaDoadores) {
		this.listaDoadores = listaDoadores;
	}
	public String getTipoSanguinio() {
		return tipoSanguinio;
	}
	public void setTipoSanguinio(String tipoSanguinio) {
		this.tipoSanguinio = tipoSanguinio;
	}

	
}
