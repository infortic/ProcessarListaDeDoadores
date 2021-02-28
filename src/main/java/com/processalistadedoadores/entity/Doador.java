package com.processalistadedoadores.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.processalistadedoadores.abstractEntity.AbstractPessoa;

public class Doador extends AbstractPessoa{
	
	@CPF
	private String cpf;
	private String rg;
	private String sexo;
	private String mae;
	private String pai;
	private  BigDecimal altura;
	private  BigDecimal peso;
	@JsonAlias(value = "tipo_sanguineo")
	private String tipoSanguineo;

	public Doador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doador(String nome, String dataNascimentoString, LocalDate dataNascimentoLocalDate, @Email String email,
			String cep, String endereco, Integer numero, String bairro, String cidade, String estado,
			String telefoneFixo, String celular) {
		super(nome, dataNascimentoString, dataNascimentoLocalDate, email, cep, endereco, numero, bairro, cidade, estado,
				telefoneFixo, celular);
	}

	public Doador(@CPF String cpf, String rg, String sexo, String mae, String pai, BigDecimal altura, BigDecimal peso,
			String tipoSanguineo) {
		super();
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.mae = mae;
		this.pai = pai;
		this.altura = altura;
		this.peso = peso;
		this.tipoSanguineo = tipoSanguineo;
	}

	@Override
	public String toString() {
		return "Doador [cpf=" + cpf + ", rg=" + rg + ", sexo=" + sexo + ", mae=" + mae + ", pai=" + pai + ", altura="
				+ altura + ", peso=" + peso + ", tipoSanguineo=" + tipoSanguineo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((altura == null) ? 0 : altura.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((mae == null) ? 0 : mae.hashCode());
		result = prime * result + ((pai == null) ? 0 : pai.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((tipoSanguineo == null) ? 0 : tipoSanguineo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doador other = (Doador) obj;
		if (altura == null) {
			if (other.altura != null)
				return false;
		} else if (!altura.equals(other.altura))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (mae == null) {
			if (other.mae != null)
				return false;
		} else if (!mae.equals(other.mae))
			return false;
		if (pai == null) {
			if (other.pai != null)
				return false;
		} else if (!pai.equals(other.pai))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (tipoSanguineo == null) {
			if (other.tipoSanguineo != null)
				return false;
		} else if (!tipoSanguineo.equals(other.tipoSanguineo))
			return false;
		return true;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getRg() {
		return rg;
	}



	public void setRg(String rg) {
		this.rg = rg;
	}



	public String getSexo() {
		return sexo;
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	public String getMae() {
		return mae;
	}



	public void setMae(String mae) {
		this.mae = mae;
	}



	public String getPai() {
		return pai;
	}



	public void setPai(String pai) {
		this.pai = pai;
	}



	public BigDecimal getAltura() {
		return altura;
	}



	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}



	public BigDecimal getPeso() {
		return peso;
	}



	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}



	public String getTipoSanguineo() {
		return tipoSanguineo;
	}



	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}



	public Integer getIdade() {
		Integer anoNascimento = this.getDataNascimentoLocalDate().getYear();
		Integer anoAtual = LocalDate.now().getYear();
		return anoAtual - anoNascimento;
	}

}
