package com.bancodesangue.model.custom;

public class DoadorPossivel {

	
	String tipoSanguineo;
	Long quantidadeDeDoadores;
	
	public DoadorPossivel(String tipoSanguineo, Long quantidadeDeDoadores) {
		
		this.tipoSanguineo = tipoSanguineo;
		this.quantidadeDeDoadores = quantidadeDeDoadores;
		
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public Long getQuantidadeDeDoadores() {
		return quantidadeDeDoadores;
	}

	public void setQuantidadeDeDoadores(Long quantidadeDeDoadores) {
		this.quantidadeDeDoadores = quantidadeDeDoadores;
	}
	
	
	
	
	
	
}
