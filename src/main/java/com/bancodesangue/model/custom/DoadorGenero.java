package com.bancodesangue.model.custom;

public class DoadorGenero {

	
	String sexo;
	Long quantidadeDeDoadores;
	
	
	public DoadorGenero(String sexo, Long quantidadeDeDoadores) {	
		this.sexo = sexo;
		this.quantidadeDeDoadores = quantidadeDeDoadores;
		
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public Long getQuantidadeDeDoadores() {
		return quantidadeDeDoadores;
	}


	public void setQuantidadeDeDoadores(Long quantidadeDeDoadores) {
		this.quantidadeDeDoadores = quantidadeDeDoadores;
	}
	
}
