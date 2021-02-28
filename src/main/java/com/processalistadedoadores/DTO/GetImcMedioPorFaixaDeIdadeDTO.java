package com.processalistadedoadores.DTO;

import java.math.BigDecimal;

public class GetImcMedioPorFaixaDeIdadeDTO {

	private String faixaDeIdade;
	private BigDecimal mediaImcPorFaixaDeIdade;

	public String getFaixaDeIdade() {
		return faixaDeIdade;
	}

	public void setFaixaDeIdade(String faixaDeIdade) {
		this.faixaDeIdade = faixaDeIdade;
	}

	public BigDecimal getMediaImcPorFaixaDeIdade() {
		return mediaImcPorFaixaDeIdade;
	}

	public void setMediaImcPorFaixaDeIdade(BigDecimal mediaImcPorFaixaDeIdade) {
		this.mediaImcPorFaixaDeIdade = mediaImcPorFaixaDeIdade;
	}

	public GetImcMedioPorFaixaDeIdadeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetImcMedioPorFaixaDeIdadeDTO(String faixaDeIdade, BigDecimal mediaImcPorFaixaDeIdade) {
		super();
		this.faixaDeIdade = faixaDeIdade;
		this.mediaImcPorFaixaDeIdade = mediaImcPorFaixaDeIdade;
	}

	public static final class GetImcMedioPorFaixaDeIdadeDTOBuilder {

		private String faixaDeIdade;
		private BigDecimal mediaImcPorFaixaDeIdade;

		public  String getFaixaDeIdade() {
			return faixaDeIdade;
		}

		public void setFaixaDeIdade(String faixaDeIdade) {
			this.faixaDeIdade = faixaDeIdade;
		}

		public BigDecimal getMediaImcPorFaixaDeIdade() {
			return mediaImcPorFaixaDeIdade;
		}

		public  void setMediaImcPorFaixaDeIdade(BigDecimal mediaImcPorFaixaDeIdade) {
			this.mediaImcPorFaixaDeIdade = mediaImcPorFaixaDeIdade;
		}

		public GetImcMedioPorFaixaDeIdadeDTOBuilder faixaDeIdade(String faixaDeIdade) {
			this.faixaDeIdade = faixaDeIdade;
			return this;
		}
		
		public GetImcMedioPorFaixaDeIdadeDTOBuilder mediaImcPorFaixaDeIdade(BigDecimal mediaImcPorFaixaDeIdade) {
			this.mediaImcPorFaixaDeIdade = mediaImcPorFaixaDeIdade;
			return this;
		}
		
		public GetImcMedioPorFaixaDeIdadeDTO  builder() {
			return new GetImcMedioPorFaixaDeIdadeDTO(faixaDeIdade, mediaImcPorFaixaDeIdade);
		}
		
		public static final	GetImcMedioPorFaixaDeIdadeDTOBuilder getinstance() {
			return new GetImcMedioPorFaixaDeIdadeDTOBuilder();
		}
		
	}
	


}
