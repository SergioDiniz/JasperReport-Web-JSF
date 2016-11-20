package br.com.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoMBean {

	
	private String nome;
	
	
	public String getMensagem() {
		return "Atualizado em: " + new SimpleDateFormat("hh:mm:ss").format(new Date());
	}


	public String getNome() {
		return nome;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	
}
