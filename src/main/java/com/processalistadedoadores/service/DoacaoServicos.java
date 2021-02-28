package com.processalistadedoadores.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.processalistadedoadores.DTO.GetImcMedioPorFaixaDeIdadeDTO;
import com.processalistadedoadores.DTO.GetImcMedioPorFaixaDeIdadeDTO.GetImcMedioPorFaixaDeIdadeDTOBuilder;
import com.processalistadedoadores.DTO.GetMediaIdadePorTipoSanguinioDTO;
import com.processalistadedoadores.DTO.GetMediaIdadePorTipoSanguinioDTO.GetMediaIdadePorTipoSanguinioDTOBuilder;
import com.processalistadedoadores.DTO.ListaDoadoresSeparadosPorEstadoDTO;
import com.processalistadedoadores.DTO.ListaDoadoresSeparadosPorEstadoDTO.ListaDoadoresSeparadosPorEstadoDTOBuilder;
import com.processalistadedoadores.Enum.EstadosENUM;
import com.processalistadedoadores.entity.Doador;
import com.processalistadedoadores.util.DoacaoUtil;

@Service
public class DoacaoServicos {

	@Autowired
	private DoacaoUtil doacaoUtil;

	private static final BigDecimal LIMITE_IMC_PARA_OBESIDADE = new BigDecimal(30);
	private static final Integer IDADE_MINIMA = 0;
	private static final Integer IDADE_MAXIMA = 1;

	public Boolean validaDoador(Doador doador) {
		return doacaoUtil.validaIdadeParaDoacao(doador) && doacaoUtil.validaPesoMinimoParaDoacao(doador);
	}

	public BigDecimal calculaIMC(Doador doador) {
		return doador.getPeso().divide(doador.getAltura().multiply(doador.getAltura()), RoundingMode.HALF_UP);
	}

	public List<Doador> getDoadoresObesos(List<Doador> doadorList) {
		List<Doador> doadoresObesos = new ArrayList<>();
		for (Doador doador : doadorList) {
			BigDecimal imc = calculaIMC(doador);
			if (imc.compareTo(LIMITE_IMC_PARA_OBESIDADE) == 1) {
				doadoresObesos.add(doador);
			}
		}
		return doadoresObesos;
	}

	public List<Doador> getDoadoresPorTipoSanguino(List<Doador> doadorList, String tipoSanguino) {
		List<Doador> doadoresPorTipoSanguino = new ArrayList<>();

		for (Doador doador : doadorList) {

			if (doador.getTipoSanguineo().equals(tipoSanguino)) {
				doadoresPorTipoSanguino.add(doador);
			}
		}

		return doadoresPorTipoSanguino;

	}

	public List<Doador> getDoadoresPorGrupoSanguinio(List<Doador> doadorList, String tipoSanquinioList) {
		List<Doador> doadoresParaTipoSanguinioRecebitoComoParametro = new ArrayList<>();
		for (Doador doador : doadorList) {
			if (tipoSanquinioList.contains(doador.getTipoSanguineo()) && this.validaDoador(doador)) {
				doadoresParaTipoSanguinioRecebitoComoParametro.add(doador);
			}
		}
		return doadoresParaTipoSanguinioRecebitoComoParametro;
	}

	public GetImcMedioPorFaixaDeIdadeDTO getImcMedioPorFaixaDeIdade(List<Doador> doadorList, String faixaIdade) {

		BigDecimal mediaImcPorFaixaDeIdade = new BigDecimal(0);
		BigDecimal toalImcFaixaIdade = new BigDecimal(0);
		BigDecimal numeroDeGrandezas = new BigDecimal(0);
		String[] stringArray = faixaIdade.split(",");
		List<Integer> faixaIdadeList = new ArrayList<Integer>();

		if (stringArray.length > 1) {
			for (String string : stringArray) {
				faixaIdadeList.add(Integer.valueOf(string));
			}
			for (Doador doador : doadorList) {
				Integer idadeDoador = doador.getIdade();
				if (idadeDoador > faixaIdadeList.get(IDADE_MINIMA) && idadeDoador <= faixaIdadeList.get(IDADE_MAXIMA)) {
					toalImcFaixaIdade = toalImcFaixaIdade.add(this.calculaIMC(doador));
					numeroDeGrandezas = numeroDeGrandezas.add(new BigDecimal(1));
				}
			}

			if (numeroDeGrandezas.compareTo(new BigDecimal(0)) == 1) {
				mediaImcPorFaixaDeIdade = toalImcFaixaIdade.divide(numeroDeGrandezas, RoundingMode.HALF_UP);
			}

			GetImcMedioPorFaixaDeIdadeDTO retorno = GetImcMedioPorFaixaDeIdadeDTOBuilder.getinstance()
					.faixaDeIdade(faixaIdade).mediaImcPorFaixaDeIdade(mediaImcPorFaixaDeIdade).builder();

			return retorno;

		}

		
 		return GetImcMedioPorFaixaDeIdadeDTOBuilder.getinstance()
				.faixaDeIdade("Faixa invalida por favor envie uma url url parameter string no seguint formato: '10,10' ")
				.builder(); 
		
	}

	public GetMediaIdadePorTipoSanguinioDTO getMediaIdadePorTipoSanguinio(List<Doador> doadorList,
			String tipoSanguinio) {
		Integer somaIdadeDoadoresPorTipoSanguinio = 0;
		Integer numeroGrandezas = 0;
		Integer mediaIdade = 0;
		for (Doador doador : doadorList) {
			if (doador.getTipoSanguineo().equals(tipoSanguinio)) {
				somaIdadeDoadoresPorTipoSanguinio = somaIdadeDoadoresPorTipoSanguinio + doador.getIdade();
				numeroGrandezas++;

			}
		}

		if (numeroGrandezas > 0) {
			mediaIdade = somaIdadeDoadoresPorTipoSanguinio / numeroGrandezas;
		}

		return GetMediaIdadePorTipoSanguinioDTOBuilder.getInstase().mediaIdadePorTipoSanguinio(mediaIdade)
				.tipoSanguinio(tipoSanguinio).builder();
	}

	public ListaDoadoresSeparadosPorEstadoDTO getDoadoresPorEstado(List<Doador> doadorList) {

		List<Doador> doadoresAC = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.AC.toString());
		List<Doador> doadoresAL = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.AL.toString());
		List<Doador> doadoresAP = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.AP.toString());
		List<Doador> doadoresAM = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.AM.toString());
		List<Doador> doadoresBA = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.BA.toString());
		List<Doador> doadoresCE = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.CE.toString());
		List<Doador> doadoresDF = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.DF.toString());
		List<Doador> doadoresES = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.ES.toString());
		List<Doador> doadoresGO = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.GO.toString());
		List<Doador> doadoresMA = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.MA.toString());
		List<Doador> doadoresMT = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.MT.toString());
		List<Doador> doadoresMS = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.MS.toString());
		List<Doador> doadoresMG = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.MG.toString());
		List<Doador> doadoresPA = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.PA.toString());
		List<Doador> doadoresPB = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.PB.toString());
		List<Doador> doadoresPR = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.PR.toString());
		List<Doador> doadoresPE = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.PE.toString());
		List<Doador> doadoresPI = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.PI.toString());
		List<Doador> doadoresRJ = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.RJ.toString());
		List<Doador> doadoresRN = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.RN.toString());
		List<Doador> doadoresRS = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.RS.toString());
		List<Doador> doadoresRO = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.RO.toString());
		List<Doador> doadoresRR = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.RR.toString());
		List<Doador> doadoresSC = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.SC.toString());
		List<Doador> doadoresSP = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.SP.toString());
		List<Doador> doadoresSE = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.SE.toString());
		List<Doador> doadoresTO = ListaDoadoresSeparadosPorEstadoDTOBuilder.getDoadoresPorEstado(doadorList,
				EstadosENUM.TO.toString());

		return ListaDoadoresSeparadosPorEstadoDTOBuilder.getInstance().doadoresAC(doadoresAC).doadoresAL(doadoresAL)
				.doadoresAM(doadoresAM).doadoresAP(doadoresAP).doadoresBA(doadoresBA).doadoresCE(doadoresCE)
				.doadoresDF(doadoresDF).doadoresES(doadoresES).doadoresGO(doadoresGO).doadoresMA(doadoresMA)
				.doadoresMG(doadoresMG).doadoresMS(doadoresMS).doadoresMT(doadoresMT).doadoresPA(doadoresPA)
				.doadoresPB(doadoresPB).doadoresPE(doadoresPE).doadoresPI(doadoresPI).doadoresPR(doadoresPR)
				.doadoresRJ(doadoresRJ).doadoresRN(doadoresRN).doadoresRO(doadoresRO).doadoresRR(doadoresRR)
				.doadoresRS(doadoresRS).doadoresSC(doadoresSC).doadoresSE(doadoresSE).doadoresSP(doadoresSP)
				.doadoresTO(doadoresTO).builder();
	}

}
