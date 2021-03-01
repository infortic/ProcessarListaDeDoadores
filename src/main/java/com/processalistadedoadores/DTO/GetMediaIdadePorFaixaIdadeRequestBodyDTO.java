package com.processalistadedoadores.DTO;

import java.util.ArrayList;
import java.util.List;

import com.processalistadedoadores.entity.Doador;

public class GetMediaIdadePorFaixaIdadeRequestBodyDTO {

	private List<Doador> listaDoadores = new ArrayList<>();
	private String faixaIniciaEfinalSeparadosPorVirgula;
	public List<Doador> getListaDoadores() {
		return listaDoadores;
	}
	public void setListaDoadores(List<Doador> listaDoadores) {
		this.listaDoadores = listaDoadores;
	}
	public String getFaixaIniciaEfinalSeparadosPorVirgula() {
		return faixaIniciaEfinalSeparadosPorVirgula;
	}
	public void setFaixaIniciaEfinalSeparadosPorVirgula(String faixaIniciaEfinalSeparadosPorVirgula) {
		this.faixaIniciaEfinalSeparadosPorVirgula = faixaIniciaEfinalSeparadosPorVirgula;
	}
	
}
