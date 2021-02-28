package com.processalistadedoadores.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.processalistadedoadores.entity.Doador;

@Service
public class DoacaoUtil {

	private static final Integer IDADE_MAXIMA_DOACAO = 69;
	private static final Integer IDADE_MINIMA_DOACAO = 16;
	private static final Integer PESO_MINIMO = 50;

	public Boolean validaIdadeParaDoacao(Doador doador) {

		Integer dataNascimentoDate = doador.getDataNascimentoLocalDate().getYear();
		Integer anoAtual = LocalDate.now().getYear();
		Integer idade = anoAtual - dataNascimentoDate;

		return idade <= IDADE_MAXIMA_DOACAO && idade >= IDADE_MINIMA_DOACAO;
	}

	public Boolean validaPesoMinimoParaDoacao(Doador doador) {
		BigDecimal pesoDoador = doador.getPeso();
		return pesoDoador.compareTo(new BigDecimal(PESO_MINIMO)) == 1;
	}

}
