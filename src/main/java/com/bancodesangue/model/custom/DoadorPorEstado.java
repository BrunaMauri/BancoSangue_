package com.bancodesangue.model.custom;

public class DoadorPorEstado {

	String nomeDoEstado;
	Long quantidadeDeDoadores;
	
	public DoadorPorEstado(String nomeDoEstado, Long quantidadeDeDoadores) {
		
		this.nomeDoEstado = nomeDoEstado;
		this.quantidadeDeDoadores = quantidadeDeDoadores;
		
	}
	
	
	
	
	public String getNomeDoEstado() {
		return nomeDoEstado;
	}
	public void setNomeDoEstado(String nomeDoEstado) {
		this.nomeDoEstado = nomeDoEstado;
	}
	public Long getQuantidadeDeDoadores() {
		return quantidadeDeDoadores;
	}
	public void setQuantidadeDeDoadores(Long quantidadeDeDoadores) {
		this.quantidadeDeDoadores = quantidadeDeDoadores;
	}
	
}
