package turing;

import java.util.ArrayList;

public class Maquina {
	private String fita;
	private String inicioFita;
	private String finalFita;
	private String estadoIncial;
	private String estadoFinal;
	private ArrayList<Transicao> transicao;
	
	public Maquina(){
		fita = "";
		inicioFita = "";
		finalFita = "";
		estadoIncial = "";
		estadoFinal = "";
		transicao = new ArrayList<>();
	}

	public String getFita() {
		return fita;
	}

	public void setFita(String fita) {
		this.fita = getInicioFita()+fita+getFinalFita();
	}

	public String getInicioFita() {
		return inicioFita;
	}

	public void setInicioFita(String inicioFita) {
		this.inicioFita = inicioFita;
	}

	public String getFinalFita() {
		return finalFita;
	}

	public void setFinalFita(String finalFita) {
		this.finalFita = finalFita;
	}

	public String getEstadoIncial() {
		return estadoIncial;
	}

	public void setEstadoIncial(String simboloIncial) {
		this.estadoIncial = simboloIncial;
	}

	public String getEstadoFinal() {
		return estadoFinal;
	}

	public void setEstadoFinal(String simboloFinal) {
		this.estadoFinal = simboloFinal;
	}

	public ArrayList<Transicao> getTransicao() {
		return transicao;
	}

	public void setTransicao(ArrayList<Transicao> transicao) {
		this.transicao = transicao;
	}
}
