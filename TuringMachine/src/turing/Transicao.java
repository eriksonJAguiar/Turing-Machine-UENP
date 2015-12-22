package turing;

public class Transicao {

	private String to;
	private String from;
	private String lido;
	private String grava;
	private String direcao;

	public Transicao() {
		to = "";
		from = "";
		lido = "";
		grava = "";
		direcao = "";
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getLido() {
		return lido;
	}

	public void setLido(String lido) {
		this.lido = lido;
	}

	public String getGrava() {
		return grava;
	}

	public void setGrava(String grava) {
		this.grava = grava;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

}
