package com.processalistadedoadores;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.processalistadedoadores.DTO.GetImcMedioPorFaixaDeIdadeDTO;
import com.processalistadedoadores.DTO.GetMediaIdadePorTipoSanguinioDTO;
import com.processalistadedoadores.DTO.ListaDoadoresSeparadosPorEstadoDTO;
import com.processalistadedoadores.entity.Doador;
import com.processalistadedoadores.service.DoacaoServicos;

@ContextConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProcessarListaDoadoresTest {

	@Autowired
	DoacaoServicos doacaoServicos;
	private RestTemplate restTemplate = new RestTemplate();

	@LocalServerPort
	private int port;

	@Test
	public void calculaIMCTest() {
		Doador doador = new Doador();
		doador.setAltura(new BigDecimal(2));
		doador.setBairro("Santo Antônio de Lisboa");
		doador.setCelular("38 3323 - 2232");
		doador.setCep("33366336");
		doador.setCidade("Uberlandia");
		doador.setCpf("095.000.036.19");
		doador.setDataNascimentoString("02/07/1991");
		doador.setEmail("cleitonmoc02@gmail.com");
		doador.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador.setEstado("MG");
		doador.setMae("cristina aparecida Cardoso");
		doador.setNome("Cleiton Cardoso Silva");
		doador.setNumero(1138);
		doador.setPai("Cilso Santos Silva");
		doador.setPeso(new BigDecimal(53));
		doador.setRg("MG 16.701.394");
		doador.setSexo("Masculino");
		doador.setTelefoneFixo("38 33232323");
		doador.setTipoSanguineo("O+");

		BigDecimal imc = doacaoServicos.calculaIMC(doador);

		Assertions.assertThat(imc.toString()).isEqualTo("13");

	}

	@Test
	public void getDoadoresObesesTest() {

		Doador doador1 = new Doador();

		doador1.setAltura(new BigDecimal(2));
		doador1.setBairro("Santo Antônio de Lisboa");
		doador1.setCelular("38 3323 - 2232");
		doador1.setCep("33366336");
		doador1.setCidade("Uberlandia");
		doador1.setCpf("095.000.036.19");
		doador1.setDataNascimentoString("02/07/1991");
		doador1.setEmail("cleitonmoc02@gmail.com");
		doador1.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador1.setEstado("MG");
		doador1.setMae("cristina aparecida Cardoso");
		doador1.setNome("Cleiton Cardoso Silva");
		doador1.setNumero(1138);
		doador1.setPai("Cilso Santos Silva");
		doador1.setPeso(new BigDecimal(53));
		doador1.setRg("MG 16.701.394");
		doador1.setSexo("Masculino");
		doador1.setTelefoneFixo("38 33232323");
		doador1.setTipoSanguineo("O+");

		Doador doador2 = new Doador();

		doador2.setAltura(new BigDecimal(2));
		doador2.setBairro("Santo Antônio de Lisboa");
		doador2.setCelular("38 3323 - 2232");
		doador2.setCep("33366336");
		doador2.setCidade("Uberlandia");
		doador2.setCpf("095.000.036.19");
		doador2.setDataNascimentoString("02/07/1991");
		doador2.setEmail("cleitonmoc02@gmail.com");
		doador2.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador2.setEstado("MG");
		doador2.setMae("cristina aparecida Cardoso");
		doador2.setNome("Cleiton Cardoso Silva");
		doador2.setNumero(1138);
		doador2.setPai("Cilso Santos Silva");
		doador2.setPeso(new BigDecimal(200));
		doador2.setRg("MG 16.701.394");
		doador2.setSexo("Masculino");
		doador2.setTelefoneFixo("38 33232323");
		doador2.setTipoSanguineo("O+");

		List<Doador> doadorList = new ArrayList<Doador>();

		doadorList.add(doador2);
		doadorList.add(doador1);

		List<Doador> doadorListObesos = doacaoServicos.getDoadoresObesos(doadorList);
		Assertions.assertThat(doadorListObesos.size() + "").isEqualTo("1");

	}

	@Test
	public void getDoadoresPorGrupoSanguinioTest() {

		Doador doador1 = new Doador();

		doador1.setAltura(new BigDecimal(2));
		doador1.setBairro("Santo Antônio de Lisboa");
		doador1.setCelular("38 3323 - 2232");
		doador1.setCep("33366336");
		doador1.setCidade("Uberlandia");
		doador1.setCpf("095.000.036.19");
		doador1.setDataNascimentoString("02/07/1991");
		doador1.setEmail("cleitonmoc02@gmail.com");
		doador1.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador1.setEstado("MG");
		doador1.setMae("cristina aparecida Cardoso");
		doador1.setNome("Cleiton Cardoso Silva");
		doador1.setNumero(1138);
		doador1.setPai("Cilso Santos Silva");
		doador1.setPeso(new BigDecimal(53));
		doador1.setRg("MG 16.701.394");
		doador1.setSexo("Masculino");
		doador1.setTelefoneFixo("38 33232323");
		doador1.setTipoSanguineo("O+");

		Doador doador2 = new Doador();

		doador2.setAltura(new BigDecimal(2));
		doador2.setBairro("Santo Antônio de Lisboa");
		doador2.setCelular("38 3323 - 2232");
		doador2.setCep("33366336");
		doador2.setCidade("Uberlandia");
		doador2.setCpf("095.000.036.19");
		doador2.setDataNascimentoString("02/07/1991");
		doador2.setEmail("cleitonmoc02@gmail.com");
		doador2.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador2.setEstado("MG");
		doador2.setMae("cristina aparecida Cardoso");
		doador2.setNome("Cleiton Cardoso Silva");
		doador2.setNumero(1138);
		doador2.setPai("Cilso Santos Silva");
		doador2.setPeso(new BigDecimal(200));
		doador2.setRg("MG 16.701.394");
		doador2.setSexo("Masculino");
		doador2.setTelefoneFixo("38 33232323");
		doador2.setTipoSanguineo("O+");

		List<Doador> doadorList = new ArrayList<Doador>();

		doadorList.add(doador2);
		doadorList.add(doador1);

		List<Doador> doadorListObesos = doacaoServicos.getDoadoresPorGrupoSanguinio(doadorList, "O+");
		Assertions.assertThat(doadorListObesos.size() + "").isEqualTo("2");

	}

	@Test
	public void getDoadoresPorGrupoSanguinioTestPassandoTipoSanguinioInvalido() {

		Doador doador1 = new Doador();

		doador1.setAltura(new BigDecimal(2));
		doador1.setBairro("Santo Antônio de Lisboa");
		doador1.setCelular("38 3323 - 2232");
		doador1.setCep("33366336");
		doador1.setCidade("Uberlandia");
		doador1.setCpf("095.000.036.19");
		doador1.setDataNascimentoString("02/07/1991");
		doador1.setEmail("cleitonmoc02@gmail.com");
		doador1.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador1.setEstado("MG");
		doador1.setMae("cristina aparecida Cardoso");
		doador1.setNome("Cleiton Cardoso Silva");
		doador1.setNumero(1138);
		doador1.setPai("Cilso Santos Silva");
		doador1.setPeso(new BigDecimal(53));
		doador1.setRg("MG 16.701.394");
		doador1.setSexo("Masculino");
		doador1.setTelefoneFixo("38 33232323");
		doador1.setTipoSanguineo("O+");

		Doador doador2 = new Doador();

		doador2.setAltura(new BigDecimal(2));
		doador2.setBairro("Santo Antônio de Lisboa");
		doador2.setCelular("38 3323 - 2232");
		doador2.setCep("33366336");
		doador2.setCidade("Uberlandia");
		doador2.setCpf("095.000.036.19");
		doador2.setDataNascimentoString("02/07/1991");
		doador2.setEmail("cleitonmoc02@gmail.com");
		doador2.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador2.setEstado("MG");
		doador2.setMae("cristina aparecida Cardoso");
		doador2.setNome("Cleiton Cardoso Silva");
		doador2.setNumero(1138);
		doador2.setPai("Cilso Santos Silva");
		doador2.setPeso(new BigDecimal(200));
		doador2.setRg("MG 16.701.394");
		doador2.setSexo("Masculino");
		doador2.setTelefoneFixo("38 33232323");
		doador2.setTipoSanguineo("O+");

		List<Doador> doadorList = new ArrayList<Doador>();

		doadorList.add(doador2);
		doadorList.add(doador1);

		List<Doador> doadorListObesos = doacaoServicos.getDoadoresPorGrupoSanguinio(doadorList, "Z");

		Assertions.assertThat(doadorListObesos.isEmpty());

	}

	@Test
	public void getDoadoresPorTipoSanguinioTest() {

		Doador doador1 = new Doador();

		doador1.setAltura(new BigDecimal(2));
		doador1.setBairro("Santo Antônio de Lisboa");
		doador1.setCelular("38 3323 - 2232");
		doador1.setCep("33366336");
		doador1.setCidade("Uberlandia");
		doador1.setCpf("095.000.036.19");
		doador1.setDataNascimentoString("02/07/1991");
		doador1.setEmail("cleitonmoc02@gmail.com");
		doador1.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador1.setEstado("MG");
		doador1.setMae("cristina aparecida Cardoso");
		doador1.setNome("Cleiton Cardoso Silva");
		doador1.setNumero(1138);
		doador1.setPai("Cilso Santos Silva");
		doador1.setPeso(new BigDecimal(53));
		doador1.setRg("MG 16.701.394");
		doador1.setSexo("Masculino");
		doador1.setTelefoneFixo("38 33232323");
		doador1.setTipoSanguineo("O+");

		Doador doador2 = new Doador();

		doador2.setAltura(new BigDecimal(2));
		doador2.setBairro("Santo Antônio de Lisboa");
		doador2.setCelular("38 3323 - 2232");
		doador2.setCep("33366336");
		doador2.setCidade("Uberlandia");
		doador2.setCpf("095.000.036.19");
		doador2.setDataNascimentoString("02/07/1991");
		doador2.setEmail("cleitonmoc02@gmail.com");
		doador2.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador2.setEstado("MG");
		doador2.setMae("cristina aparecida Cardoso");
		doador2.setNome("Cleiton Cardoso Silva");
		doador2.setNumero(1138);
		doador2.setPai("Cilso Santos Silva");
		doador2.setPeso(new BigDecimal(200));
		doador2.setRg("MG 16.701.394");
		doador2.setSexo("Masculino");
		doador2.setTelefoneFixo("38 33232323");
		doador2.setTipoSanguineo("O+");

		List<Doador> doadorList = new ArrayList<Doador>();

		doadorList.add(doador2);
		doadorList.add(doador1);

		List<Doador> doadorListObesos = doacaoServicos.getDoadoresPorTipoSanguino(doadorList, "O+");

		Assertions.assertThat(doadorListObesos.isEmpty());

	}

	@Test
	public void getDoadoresPorEstadoTest() {

		Doador doador1 = new Doador();

		doador1.setAltura(new BigDecimal(2));
		doador1.setBairro("Santo Antônio de Lisboa");
		doador1.setCelular("38 3323 - 2232");
		doador1.setCep("33366336");
		doador1.setCidade("Uberlandia");
		doador1.setCpf("095.000.036.19");
		doador1.setDataNascimentoString("02/07/1991");
		doador1.setEmail("cleitonmoc02@gmail.com");
		doador1.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador1.setEstado("MG");
		doador1.setMae("cristina aparecida Cardoso");
		doador1.setNome("Cleiton Cardoso Silva");
		doador1.setNumero(1138);
		doador1.setPai("Cilso Santos Silva");
		doador1.setPeso(new BigDecimal(53));
		doador1.setRg("MG 16.701.394");
		doador1.setSexo("Masculino");
		doador1.setTelefoneFixo("38 33232323");
		doador1.setTipoSanguineo("O+");

		Doador doador2 = new Doador();

		doador2.setAltura(new BigDecimal(2));
		doador2.setBairro("Santo Antônio de Lisboa");
		doador2.setCelular("38 3323 - 2232");
		doador2.setCep("33366336");
		doador2.setCidade("Uberlandia");
		doador2.setCpf("095.000.036.19");
		doador2.setDataNascimentoString("02/07/1991");
		doador2.setEmail("cleitonmoc02@gmail.com");
		doador2.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador2.setEstado("SC");
		doador2.setMae("cristina aparecida Cardoso");
		doador2.setNome("Cleiton Cardoso Silva");
		doador2.setNumero(1138);
		doador2.setPai("Cilso Santos Silva");
		doador2.setPeso(new BigDecimal(200));
		doador2.setRg("MG 16.701.394");
		doador2.setSexo("Masculino");
		doador2.setTelefoneFixo("38 33232323");
		doador2.setTipoSanguineo("O+");

		List<Doador> doadorList = new ArrayList<Doador>();

		doadorList.add(doador2);
		doadorList.add(doador1);

		ListaDoadoresSeparadosPorEstadoDTO ListaDoadoresSeparadosPorEstadoDTO = doacaoServicos
				.getDoadoresPorEstado(doadorList);
		Assertions.assertThat(ListaDoadoresSeparadosPorEstadoDTO.getDoadoresSC().size() + "").isEqualTo("1");
		Assertions.assertThat(ListaDoadoresSeparadosPorEstadoDTO.getDoadoresMG().size() + "").isEqualTo("1");

	}

	@Test
	public void getImcMedioPorFaixaDeIdadeTest() {

		Doador doador1 = new Doador();

		doador1.setAltura(new BigDecimal(2));
		doador1.setBairro("Santo Antônio de Lisboa");
		doador1.setCelular("38 3323 - 2232");
		doador1.setCep("33366336");
		doador1.setCidade("Uberlandia");
		doador1.setCpf("095.000.036.19");
		doador1.setDataNascimentoString("02/07/1991");
		doador1.setEmail("cleitonmoc02@gmail.com");
		doador1.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador1.setEstado("MG");
		doador1.setMae("cristina aparecida Cardoso");
		doador1.setNome("Cleiton Cardoso Silva");
		doador1.setNumero(1138);
		doador1.setPai("Cilso Santos Silva");
		doador1.setPeso(new BigDecimal(53));
		doador1.setRg("MG 16.701.394");
		doador1.setSexo("Masculino");
		doador1.setTelefoneFixo("38 33232323");
		doador1.setTipoSanguineo("O+");

		Doador doador2 = new Doador();

		doador2.setAltura(new BigDecimal(2));
		doador2.setBairro("Santo Antônio de Lisboa");
		doador2.setCelular("38 3323 - 2232");
		doador2.setCep("33366336");
		doador2.setCidade("Uberlandia");
		doador2.setCpf("095.000.036.19");
		doador2.setDataNascimentoString("02/07/1991");
		doador2.setEmail("cleitonmoc02@gmail.com");
		doador2.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador2.setEstado("SC");
		doador2.setMae("cristina aparecida Cardoso");
		doador2.setNome("Cleiton Cardoso Silva");
		doador2.setNumero(1138);
		doador2.setPai("Cilso Santos Silva");
		doador2.setPeso(new BigDecimal(200));
		doador2.setRg("MG 16.701.394");
		doador2.setSexo("Masculino");
		doador2.setTelefoneFixo("38 33232323");
		doador2.setTipoSanguineo("O+");

		List<Doador> doadorList = new ArrayList<Doador>();

		doadorList.add(doador2);
		doadorList.add(doador1);

		GetImcMedioPorFaixaDeIdadeDTO getImcMedioPorFaixaDeIdadeDTO = doacaoServicos
				.getImcMedioPorFaixaDeIdade(doadorList, "0,70");
		Assertions.assertThat(getImcMedioPorFaixaDeIdadeDTO.getMediaImcPorFaixaDeIdade() + "").isEqualTo("32");

	}

	@Test
	public void getImcMedioPorFaixaDeIdadeFaixaInvalidaTest() {

		Doador doador1 = new Doador();

		doador1.setAltura(new BigDecimal(2));
		doador1.setBairro("Santo Antônio de Lisboa");
		doador1.setCelular("38 3323 - 2232");
		doador1.setCep("33366336");
		doador1.setCidade("Uberlandia");
		doador1.setCpf("095.000.036.19");
		doador1.setDataNascimentoString("02/07/1991");
		doador1.setEmail("cleitonmoc02@gmail.com");
		doador1.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador1.setEstado("MG");
		doador1.setMae("cristina aparecida Cardoso");
		doador1.setNome("Cleiton Cardoso Silva");
		doador1.setNumero(1138);
		doador1.setPai("Cilso Santos Silva");
		doador1.setPeso(new BigDecimal(53));
		doador1.setRg("MG 16.701.394");
		doador1.setSexo("Masculino");
		doador1.setTelefoneFixo("38 33232323");
		doador1.setTipoSanguineo("O+");

		Doador doador2 = new Doador();

		doador2.setAltura(new BigDecimal(2));
		doador2.setBairro("Santo Antônio de Lisboa");
		doador2.setCelular("38 3323 - 2232");
		doador2.setCep("33366336");
		doador2.setCidade("Uberlandia");
		doador2.setCpf("095.000.036.19");
		doador2.setDataNascimentoString("02/07/1991");
		doador2.setEmail("cleitonmoc02@gmail.com");
		doador2.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador2.setEstado("SC");
		doador2.setMae("cristina aparecida Cardoso");
		doador2.setNome("Cleiton Cardoso Silva");
		doador2.setNumero(1138);
		doador2.setPai("Cilso Santos Silva");
		doador2.setPeso(new BigDecimal(200));
		doador2.setRg("MG 16.701.394");
		doador2.setSexo("Masculino");
		doador2.setTelefoneFixo("38 33232323");
		doador2.setTipoSanguineo("O+");

		List<Doador> doadorList = new ArrayList<Doador>();

		doadorList.add(doador2);
		doadorList.add(doador1);

		GetImcMedioPorFaixaDeIdadeDTO getImcMedioPorFaixaDeIdadeDTO = doacaoServicos
				.getImcMedioPorFaixaDeIdade(doadorList, "0,10");
		Assertions.assertThat(getImcMedioPorFaixaDeIdadeDTO.getMediaImcPorFaixaDeIdade() + "").isEqualTo("0");

	}

	@Test
	public void getImcMedioPorFaixaPorTipoSanguinioTest() {

		Doador doador1 = new Doador();

		doador1.setAltura(new BigDecimal(2));
		doador1.setBairro("Santo Antônio de Lisboa");
		doador1.setCelular("38 3323 - 2232");
		doador1.setCep("33366336");
		doador1.setCidade("Uberlandia");
		doador1.setCpf("095.000.036.19");
		doador1.setDataNascimentoString("02/07/1991");
		doador1.setEmail("cleitonmoc02@gmail.com");
		doador1.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador1.setEstado("MG");
		doador1.setMae("cristina aparecida Cardoso");
		doador1.setNome("Cleiton Cardoso Silva");
		doador1.setNumero(1138);
		doador1.setPai("Cilso Santos Silva");
		doador1.setPeso(new BigDecimal(53));
		doador1.setRg("MG 16.701.394");
		doador1.setSexo("Masculino");
		doador1.setTelefoneFixo("38 33232323");
		doador1.setTipoSanguineo("O+");

		Doador doador2 = new Doador();

		doador2.setAltura(new BigDecimal(2));
		doador2.setBairro("Santo Antônio de Lisboa");
		doador2.setCelular("38 3323 - 2232");
		doador2.setCep("33366336");
		doador2.setCidade("Uberlandia");
		doador2.setCpf("095.000.036.19");
		doador2.setDataNascimentoString("02/07/1991");
		doador2.setEmail("cleitonmoc02@gmail.com");
		doador2.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador2.setEstado("SC");
		doador2.setMae("cristina aparecida Cardoso");
		doador2.setNome("Cleiton Cardoso Silva");
		doador2.setNumero(1138);
		doador2.setPai("Cilso Santos Silva");
		doador2.setPeso(new BigDecimal(200));
		doador2.setRg("MG 16.701.394");
		doador2.setSexo("Masculino");
		doador2.setTelefoneFixo("38 33232323");
		doador2.setTipoSanguineo("O+");

		List<Doador> doadorList = new ArrayList<Doador>();

		doadorList.add(doador2);
		doadorList.add(doador1);

		GetMediaIdadePorTipoSanguinioDTO getMediaIdadePorTipoSanguinioDTO = doacaoServicos
				.getMediaIdadePorTipoSanguinio(doadorList, "O+");
		Assertions.assertThat(getMediaIdadePorTipoSanguinioDTO.getMediaIdade() + "").isEqualTo("30");

	}

	@Test
	public void getImcMedioPorFaixaPorTipoSanguinioPasandoTipoSanguinioInvalidoTest() {

		Doador doador1 = new Doador();

		doador1.setAltura(new BigDecimal(2));
		doador1.setBairro("Santo Antônio de Lisboa");
		doador1.setCelular("38 3323 - 2232");
		doador1.setCep("33366336");
		doador1.setCidade("Uberlandia");
		doador1.setCpf("095.000.036.19");
		doador1.setDataNascimentoString("02/07/1991");
		doador1.setEmail("cleitonmoc02@gmail.com");
		doador1.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador1.setEstado("MG");
		doador1.setMae("cristina aparecida Cardoso");
		doador1.setNome("Cleiton Cardoso Silva");
		doador1.setNumero(1138);
		doador1.setPai("Cilso Santos Silva");
		doador1.setPeso(new BigDecimal(53));
		doador1.setRg("MG 16.701.394");
		doador1.setSexo("Masculino");
		doador1.setTelefoneFixo("38 33232323");
		doador1.setTipoSanguineo("O+");

		Doador doador2 = new Doador();

		doador2.setAltura(new BigDecimal(2));
		doador2.setBairro("Santo Antônio de Lisboa");
		doador2.setCelular("38 3323 - 2232");
		doador2.setCep("33366336");
		doador2.setCidade("Uberlandia");
		doador2.setCpf("095.000.036.19");
		doador2.setDataNascimentoString("02/07/1991");
		doador2.setEmail("cleitonmoc02@gmail.com");
		doador2.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador2.setEstado("SC");
		doador2.setMae("cristina aparecida Cardoso");
		doador2.setNome("Cleiton Cardoso Silva");
		doador2.setNumero(1138);
		doador2.setPai("Cilso Santos Silva");
		doador2.setPeso(new BigDecimal(200));
		doador2.setRg("MG 16.701.394");
		doador2.setSexo("Masculino");
		doador2.setTelefoneFixo("38 33232323");
		doador2.setTipoSanguineo("O+");

		List<Doador> doadorList = new ArrayList<Doador>();

		doadorList.add(doador2);
		doadorList.add(doador1);

		GetMediaIdadePorTipoSanguinioDTO getMediaIdadePorTipoSanguinioDTO = doacaoServicos
				.getMediaIdadePorTipoSanguinio(doadorList, "Z");
		Assertions.assertThat(getMediaIdadePorTipoSanguinioDTO.getMediaIdade() + "").isEqualTo("0");
	}
	

	@Test
	public void getDoadoresObesosRestTest() {
		Doador doador1 = new Doador();

		doador1.setAltura(new BigDecimal(2));
		doador1.setBairro("Santo Antônio de Lisboa");
		doador1.setCelular("38 3323 - 2232");
		doador1.setCep("33366336");
		doador1.setCidade("Uberlandia");
		doador1.setCpf("095.000.036.19");
		doador1.setDataNascimentoString("02/07/1991");
		doador1.setEmail("cleitonmoc02@gmail.com");
		doador1.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador1.setEstado("MG");
		doador1.setMae("cristina aparecida Cardoso");
		doador1.setNome("Cleiton Cardoso Silva");
		doador1.setNumero(1138);
		doador1.setPai("Cilso Santos Silva");
		doador1.setPeso(new BigDecimal(53));
		doador1.setRg("MG 16.701.394");
		doador1.setSexo("Masculino");
		doador1.setTelefoneFixo("38 33232323");
		doador1.setTipoSanguineo("O+");

		Doador doador2 = new Doador();

		doador2.setAltura(new BigDecimal(2));
		doador2.setBairro("Santo Antônio de Lisboa");
		doador2.setCelular("38 3323 - 2232");
		doador2.setCep("33366336");
		doador2.setCidade("Uberlandia");
		doador2.setCpf("095.000.036.19");
		doador2.setDataNascimentoString("02/07/1991");
		doador2.setEmail("cleitonmoc02@gmail.com");
		doador2.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador2.setEstado("MG");
		doador2.setMae("cristina aparecida Cardoso");
		doador2.setNome("Cleiton Cardoso Silva");
		doador2.setNumero(1138);
		doador2.setPai("Cilso Santos Silva");
		doador2.setPeso(new BigDecimal(200));
		doador2.setRg("MG 16.701.394");
		doador2.setSexo("Masculino");
		doador2.setTelefoneFixo("38 33232323");
		doador2.setTipoSanguineo("O+");

		List<Doador> doadorList = new ArrayList<Doador>();

		doadorList.add(doador2);
		doadorList.add(doador1);

		Map<String, String> params = new HashMap<String, String>();
		params.put("tipoSanquinioList ", "A+");

		ResponseEntity<?> response = restTemplate.postForEntity(
				"http://localhost:" + port + "/doador/getDoadoresObesos/", doadorList, List.class, "application/json");
		Assertions.assertThat(response.getStatusCodeValue() + "").isEqualTo("200");
	}

	@Test
	public void getDoadoresPorEstadoRestTest() {
		Doador doador1 = new Doador();

		doador1.setAltura(new BigDecimal(2));
		doador1.setBairro("Santo Antônio de Lisboa");
		doador1.setCelular("38 3323 - 2232");
		doador1.setCep("33366336");
		doador1.setCidade("Uberlandia");
		doador1.setCpf("095.000.036.19");
		doador1.setDataNascimentoString("02/07/1991");
		doador1.setEmail("cleitonmoc02@gmail.com");
		doador1.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador1.setEstado("MG");
		doador1.setMae("cristina aparecida Cardoso");
		doador1.setNome("Cleiton Cardoso Silva");
		doador1.setNumero(1138);
		doador1.setPai("Cilso Santos Silva");
		doador1.setPeso(new BigDecimal(53));
		doador1.setRg("MG 16.701.394");
		doador1.setSexo("Masculino");
		doador1.setTelefoneFixo("38 33232323");
		doador1.setTipoSanguineo("O+");

		Doador doador2 = new Doador();

		doador2.setAltura(new BigDecimal(2));
		doador2.setBairro("Santo Antônio de Lisboa");
		doador2.setCelular("38 3323 - 2232");
		doador2.setCep("33366336");
		doador2.setCidade("Uberlandia");
		doador2.setCpf("095.000.036.19");
		doador2.setDataNascimentoString("02/07/1991");
		doador2.setEmail("cleitonmoc02@gmail.com");
		doador2.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador2.setEstado("MG");
		doador2.setMae("cristina aparecida Cardoso");
		doador2.setNome("Cleiton Cardoso Silva");
		doador2.setNumero(1138);
		doador2.setPai("Cilso Santos Silva");
		doador2.setPeso(new BigDecimal(200));
		doador2.setRg("MG 16.701.394");
		doador2.setSexo("Masculino");
		doador2.setTelefoneFixo("38 33232323");
		doador2.setTipoSanguineo("O+");

		List<Doador> doadorList = new ArrayList<Doador>();

		doadorList.add(doador2);
		doadorList.add(doador1);

		Map<String, String> params = new HashMap<String, String>();
		params.put("tipoSanquinioList ", "A+");

		ResponseEntity<?> response = restTemplate.postForEntity(
				"http://localhost:" + port + "/doador/getDoadoresPorEstado/", doadorList, ListaDoadoresSeparadosPorEstadoDTO.class, "application/json");
		Assertions.assertThat(response.getStatusCodeValue() + "").isEqualTo("200");
	}

	
	
	
	@Test
	public void getDoadoresPorGrupoSanguinioRestTest() {
		Doador doador1 = new Doador();

		doador1.setAltura(new BigDecimal(2));
		doador1.setBairro("Santo Antônio de Lisboa");
		doador1.setCelular("38 3323 - 2232");
		doador1.setCep("33366336");
		doador1.setCidade("Uberlandia");
		doador1.setCpf("095.000.036.19");
		doador1.setDataNascimentoString("02/07/1991");
		doador1.setEmail("cleitonmoc02@gmail.com");
		doador1.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador1.setEstado("MG");
		doador1.setMae("cristina aparecida Cardoso");
		doador1.setNome("Cleiton Cardoso Silva");
		doador1.setNumero(1138);
		doador1.setPai("Cilso Santos Silva");
		doador1.setPeso(new BigDecimal(53));
		doador1.setRg("MG 16.701.394");
		doador1.setSexo("Masculino");
		doador1.setTelefoneFixo("38 33232323");
		doador1.setTipoSanguineo("O+");

		Doador doador2 = new Doador();

		doador2.setAltura(new BigDecimal(2));
		doador2.setBairro("Santo Antônio de Lisboa");
		doador2.setCelular("38 3323 - 2232");
		doador2.setCep("33366336");
		doador2.setCidade("Uberlandia");
		doador2.setCpf("095.000.036.19");
		doador2.setDataNascimentoString("02/07/1991");
		doador2.setEmail("cleitonmoc02@gmail.com");
		doador2.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador2.setEstado("MG");
		doador2.setMae("cristina aparecida Cardoso");
		doador2.setNome("Cleiton Cardoso Silva");
		doador2.setNumero(1138);
		doador2.setPai("Cilso Santos Silva");
		doador2.setPeso(new BigDecimal(200));
		doador2.setRg("MG 16.701.394");
		doador2.setSexo("Masculino");
		doador2.setTelefoneFixo("38 33232323");
		doador2.setTipoSanguineo("O+");

		List<Doador> doadorList = new ArrayList<Doador>();

		doadorList.add(doador2);
		doadorList.add(doador1);

		ResponseEntity<?> response = restTemplate.postForEntity(
				"http://localhost:" + port + "/doador/getDoadoresPorTiposSanquinios?tipoSanquinioList={A+}/", doadorList,
				List.class, "application/json");
		Assertions.assertThat(response.getStatusCodeValue() + "").isEqualTo("200");

	}

	@Test
	public void getMediaImcPorFaixaIdadeTest() {
		Doador doador1 = new Doador();

		doador1.setAltura(new BigDecimal(2));
		doador1.setBairro("Santo Antônio de Lisboa");
		doador1.setCelular("38 3323 - 2232");
		doador1.setCep("33366336");
		doador1.setCidade("Uberlandia");
		doador1.setCpf("095.000.036.19");
		doador1.setDataNascimentoString("02/07/1991");
		doador1.setEmail("cleitonmoc02@gmail.com");
		doador1.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador1.setEstado("MG");
		doador1.setMae("cristina aparecida Cardoso");
		doador1.setNome("Cleiton Cardoso Silva");
		doador1.setNumero(1138);
		doador1.setPai("Cilso Santos Silva");
		doador1.setPeso(new BigDecimal(53));
		doador1.setRg("MG 16.701.394");
		doador1.setSexo("Masculino");
		doador1.setTelefoneFixo("38 33232323");
		doador1.setTipoSanguineo("O+");

		Doador doador2 = new Doador();

		doador2.setAltura(new BigDecimal(2));
		doador2.setBairro("Santo Antônio de Lisboa");
		doador2.setCelular("38 3323 - 2232");
		doador2.setCep("33366336");
		doador2.setCidade("Uberlandia");
		doador2.setCpf("095.000.036.19");
		doador2.setDataNascimentoString("02/07/1991");
		doador2.setEmail("cleitonmoc02@gmail.com");
		doador2.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador2.setEstado("MG");
		doador2.setMae("cristina aparecida Cardoso");
		doador2.setNome("Cleiton Cardoso Silva");
		doador2.setNumero(1138);
		doador2.setPai("Cilso Santos Silva");
		doador2.setPeso(new BigDecimal(200));
		doador2.setRg("MG 16.701.394");
		doador2.setSexo("Masculino");
		doador2.setTelefoneFixo("38 33232323");
		doador2.setTipoSanguineo("O+");

		List<Doador> doadorList = new ArrayList<Doador>();

		doadorList.add(doador2);
		doadorList.add(doador1);

		ResponseEntity<?> response = restTemplate.postForEntity(
				"http://localhost:" + port + "/doador/getMediaImcPorFaixaIdade?faixaIdade={21,31}/", doadorList,
				GetImcMedioPorFaixaDeIdadeDTO.class, MediaType.APPLICATION_JSON);
		
		Assertions.assertThat(response.getStatusCodeValue() + "").isEqualTo("200");

	}
	
	@Test
	public void getMediaIdadePorTipoSanguinioTest() {
		Doador doador1 = new Doador();

		doador1.setAltura(new BigDecimal(2));
		doador1.setBairro("Santo Antônio de Lisboa");
		doador1.setCelular("38 3323 - 2232");
		doador1.setCep("33366336");
		doador1.setCidade("Uberlandia");
		doador1.setCpf("095.000.036.19");
		doador1.setDataNascimentoString("02/07/1991");
		doador1.setEmail("cleitonmoc02@gmail.com");
		doador1.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador1.setEstado("MG");
		doador1.setMae("cristina aparecida Cardoso");
		doador1.setNome("Cleiton Cardoso Silva");
		doador1.setNumero(1138);
		doador1.setPai("Cilso Santos Silva");
		doador1.setPeso(new BigDecimal(53));
		doador1.setRg("MG 16.701.394");
		doador1.setSexo("Masculino");
		doador1.setTelefoneFixo("38 33232323");
		doador1.setTipoSanguineo("O+");

		Doador doador2 = new Doador();

		doador2.setAltura(new BigDecimal(2));
		doador2.setBairro("Santo Antônio de Lisboa");
		doador2.setCelular("38 3323 - 2232");
		doador2.setCep("33366336");
		doador2.setCidade("Uberlandia");
		doador2.setCpf("095.000.036.19");
		doador2.setDataNascimentoString("02/07/1991");
		doador2.setEmail("cleitonmoc02@gmail.com");
		doador2.setEndereco("Alameda Jose de Oliveira Guimarães");
		doador2.setEstado("MG");
		doador2.setMae("cristina aparecida Cardoso");
		doador2.setNome("Cleiton Cardoso Silva");
		doador2.setNumero(1138);
		doador2.setPai("Cilso Santos Silva");
		doador2.setPeso(new BigDecimal(200));
		doador2.setRg("MG 16.701.394");
		doador2.setSexo("Masculino");
		doador2.setTelefoneFixo("38 33232323");
		doador2.setTipoSanguineo("O+");

		List<Doador> doadorList = new ArrayList<Doador>();

		doadorList.add(doador2);
		doadorList.add(doador1);

		ResponseEntity<?> response = restTemplate.postForEntity(
				"http://localhost:" + port + "/doador/getMediaIdadePorTipoSanguinio?tipoSanguinio={21,31}/", doadorList,
				GetImcMedioPorFaixaDeIdadeDTO.class, MediaType.APPLICATION_JSON);
		
		Assertions.assertThat(response.getStatusCodeValue() + "").isEqualTo("200");

	}

	
	
	
	
}
