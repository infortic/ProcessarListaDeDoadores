package com.processalistadedoadores.abstractEntity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.validation.constraints.Email;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class AbstractPessoa implements Serializable {

	private String nome;
	@JsonAlias("data_nasc")
	private String dataNascimentoString;
	@JsonIgnore
	private LocalDate dataNascimentoLocalDate;
	@Email
	private String email;
	private String cep;
	private String endereco;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	@JsonAlias(value = "telefone_fixo")
	private String telefoneFixo;
	private String celular;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimentoString() {
		return dataNascimentoString;
	}
	public void setDataNascimentoString(String dataNascimentoString) {
		this.dataNascimentoString = dataNascimentoString;
	}
	
	public LocalDate getDataNascimentoLocalDate() {
		return LocalDate.parse(this.dataNascimentoString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTelefoneFixo() {
		return telefoneFixo;
	}
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((dataNascimentoLocalDate == null) ? 0 : dataNascimentoLocalDate.hashCode());
		result = prime * result + ((dataNascimentoString == null) ? 0 : dataNascimentoString.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((telefoneFixo == null) ? 0 : telefoneFixo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractPessoa other = (AbstractPessoa) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (dataNascimentoLocalDate == null) {
			if (other.dataNascimentoLocalDate != null)
				return false;
		} else if (!dataNascimentoLocalDate.equals(other.dataNascimentoLocalDate))
			return false;
		if (dataNascimentoString == null) {
			if (other.dataNascimentoString != null)
				return false;
		} else if (!dataNascimentoString.equals(other.dataNascimentoString))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (telefoneFixo == null) {
			if (other.telefoneFixo != null)
				return false;
		} else if (!telefoneFixo.equals(other.telefoneFixo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AbstractPessoa [nome=" + nome + ", dataNascimentoString=" + dataNascimentoString
				+ ", dataNascimentoLocalDate=" + dataNascimentoLocalDate + ", email=" + email + ", cep=" + cep
				+ ", endereco=" + endereco + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", estado=" + estado + ", telefoneFixo=" + telefoneFixo + ", celular=" + celular + "]";
	}
	public AbstractPessoa(String nome, String dataNascimentoString, LocalDate dataNascimentoLocalDate,
			@Email String email, String cep, String endereco, Integer numero, String bairro, String cidade,
			String estado, String telefoneFixo, String celular) {
		super();
		this.nome = nome;
		this.dataNascimentoString = dataNascimentoString;
		this.dataNascimentoLocalDate = dataNascimentoLocalDate;
		this.email = email;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.telefoneFixo = telefoneFixo;
		this.celular = celular;
	}
	public AbstractPessoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		
}
