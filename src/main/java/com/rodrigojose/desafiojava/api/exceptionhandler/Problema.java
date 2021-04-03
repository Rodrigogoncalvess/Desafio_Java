package com.rodrigojose.desafiojava.api.exceptionhandler;

import java.time.OffsetDateTime;

public class Problema {
	
	private Integer status;
	private OffsetDateTime dataHora;
	private String titulo;
	
	
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public OffsetDateTime getData() {
		return dataHora;
	}
	public void setData(OffsetDateTime data) {
		this.dataHora = data;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	

}
