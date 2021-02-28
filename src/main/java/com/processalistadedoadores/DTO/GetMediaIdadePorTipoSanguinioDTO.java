package com.processalistadedoadores.DTO;

public class GetMediaIdadePorTipoSanguinioDTO {
	
	private String tipoSanguinio;
	private Integer mediaIdadePorTipoSanguinio;
	
	
	public String getTipoSanguinio() {
		return tipoSanguinio;
	}
	public void setTipoSanguinio(String tipoSanguinio) {
		this.tipoSanguinio = tipoSanguinio;
	}
	
	public Integer getMediaIdade() {
		return mediaIdadePorTipoSanguinio;
	}
	
	public void setMediaIdade(Integer mediaIdadePorTipoSanguinio) {
		this.mediaIdadePorTipoSanguinio = mediaIdadePorTipoSanguinio;
	}
	
	public GetMediaIdadePorTipoSanguinioDTO(String tipoSanguinio, Integer mediaIdadePorTipoSanguinio) {
		super();
		this.tipoSanguinio = tipoSanguinio;
		this.mediaIdadePorTipoSanguinio = mediaIdadePorTipoSanguinio;
	}
	
	public GetMediaIdadePorTipoSanguinioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static final class GetMediaIdadePorTipoSanguinioDTOBuilder {
	
		private String tipoSanguinio;
		private Integer mediaIdadePorTipoSanguinio;
		
		
		public String getTipoSanguinio() {
			return tipoSanguinio;
		}
		public void setTipoSanguinio(String tipoSanguinio) {
			this.tipoSanguinio = tipoSanguinio;
		}
		
		public Integer getMediaIdade() {
			return mediaIdadePorTipoSanguinio;
		}
		
		public void setMediaIdade(Integer mediaIdadePorTipoSanguinio) {
			this.mediaIdadePorTipoSanguinio = mediaIdadePorTipoSanguinio;
		}
		
		public GetMediaIdadePorTipoSanguinioDTOBuilder(String tipoSanguinio, Integer mediaIdadePorTipoSanguinio) {
			super();
			this.tipoSanguinio = tipoSanguinio;
			this.mediaIdadePorTipoSanguinio = mediaIdadePorTipoSanguinio;
		}
		
		public GetMediaIdadePorTipoSanguinioDTOBuilder() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public GetMediaIdadePorTipoSanguinioDTOBuilder tipoSanguinio(String tipoSanguinio) {
			this.tipoSanguinio = tipoSanguinio;
			return this;
		}
		
		public GetMediaIdadePorTipoSanguinioDTOBuilder mediaIdadePorTipoSanguinio(Integer mediaIdadePorTipoSanguinio) {
			this.mediaIdadePorTipoSanguinio = mediaIdadePorTipoSanguinio;
			return this;
		}
		
		public GetMediaIdadePorTipoSanguinioDTO builder() {
			return new GetMediaIdadePorTipoSanguinioDTO(tipoSanguinio, mediaIdadePorTipoSanguinio);
		}
		
		public static final GetMediaIdadePorTipoSanguinioDTOBuilder getInstase() {
			return new GetMediaIdadePorTipoSanguinioDTOBuilder(); 
		}
		
	}

}
