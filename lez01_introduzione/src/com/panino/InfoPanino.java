package com.panino;

public class InfoPanino {
	
	private int id;
	private String nome;
	private String cod;
	private String descr;
	private Float prezzo;
	private boolean isVeg;

	public InfoPanino(int id, String nome, String cod, String descr, Float prezzo, boolean isVeg) {
		
		this.id = id;
		this.nome = nome;
		this.cod = cod;
		this.descr = descr;
		this.prezzo = prezzo;
		this.isVeg = isVeg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public boolean isVeg() {
		return isVeg;
	}

	public void setVeg(boolean isVeg) {
		this.isVeg = isVeg;
	}

	@Override
	public String toString() {
		return "InfoPanino [id=" + id + ", nome=" + nome + ", cod=" + cod + ", descr=" + descr + ", prezzo=" + prezzo
				+ ", isVeg=" + isVeg + "]";
	}

	public String stampaDettaglio() {
		return "Nome: " + nome + "\n"
				+ "Descrizione: " + descr  + "\n"
				+ "Vegano: " + (isVeg ? "SI" : "NO")  + "\n";
	}
	
	
}