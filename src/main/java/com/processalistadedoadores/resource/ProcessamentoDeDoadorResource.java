package com.processalistadedoadores.resource;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.processalistadedoadores.DTO.GetDoadoresPorTiposSanquiniosRequestBodyDTO;
import com.processalistadedoadores.DTO.GetMediaIdadePorFaixaIdadeRequestBodyDTO;
import com.processalistadedoadores.DTO.GetMediaIdadePorTipoSanguinioRequestBodyDTO;
import com.processalistadedoadores.entity.Doador;
import com.processalistadedoadores.service.DoacaoServicos;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@SuppressWarnings("unused")
@Api(value = "Fornece serviços de emprestimos")
@RestController
@RequestMapping("/doador")
public class ProcessamentoDeDoadorResource {
	
	
	@Autowired
	private DoacaoServicos doacaoServicos;
		
	@ApiOperation(value="Processa Lista de possiveis doadores e retorna os doadores obesos")
	@RequestMapping(method = RequestMethod.POST, path = "/getDoadoresObesos")
	public ResponseEntity<?> getDoadoresObesos(@RequestBody List<Doador> doadorListPayLoad) throws ParseException {
		return new ResponseEntity<>(doacaoServicos.getDoadoresObesos(doadorListPayLoad), HttpStatus.OK);
	}
	
	@ApiOperation(value="Encontra Doadores para um determinado Tipo Sanguinio")
	@RequestMapping(method = RequestMethod.POST, path = "/getDoadoresPorTiposSanquinios")
	public ResponseEntity<?> getDoadoresPorTiposSanquinios(@RequestBody GetDoadoresPorTiposSanquiniosRequestBodyDTO doadorListPayLoad) {
		return new ResponseEntity<>(doacaoServicos.getDoadoresPorGrupoSanguinio(doadorListPayLoad), HttpStatus.OK);
	}
	
	@ApiOperation(value="Retorna media IMC por faixa de idade")
	@RequestMapping(method = RequestMethod.POST, path = "/getMediaImcPorFaixaIdade")
	public ResponseEntity<?> getMediaImcPorFaixaIdade(@RequestBody GetMediaIdadePorFaixaIdadeRequestBodyDTO doadorListPayLoad)  {
		return new ResponseEntity<>(doacaoServicos.getImcMedioPorFaixaDeIdade(doadorListPayLoad), HttpStatus.OK);
	}
	
	@ApiOperation(value="Retorna media de idade por tipo sanguinio")
	@RequestMapping(method = RequestMethod.POST, path = "/getMediaIdadePorTipoSanguinio")
	public ResponseEntity<?> getMediaIdadePorTipoSanguinio(@RequestBody GetMediaIdadePorTipoSanguinioRequestBodyDTO doadorListPayLoad)  {
		return new ResponseEntity<>(doacaoServicos.getMediaIdadePorTipoSanguinio(doadorListPayLoad), HttpStatus.OK);
	}
	

	@ApiOperation(value="Retorna doadores por estado")
	@RequestMapping(method = RequestMethod.POST, path = "/getDoadoresPorEstado")
	public ResponseEntity<?> getDoadoresPorEstado(@RequestBody List<Doador> doadorListPayLoad)  {
		return new ResponseEntity<>(doacaoServicos.getDoadoresPorEstado(doadorListPayLoad), HttpStatus.OK);
	}
	
	
	
}