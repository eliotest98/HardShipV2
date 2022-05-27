package it.ship.beans;

public class Feedback {
	
	private int ID;
	private String titolo;
	private String testo;
	private String data;
	private String utente;
	
	public Feedback(){
		
	}

	public Feedback(int iD, String titolo, String testo, String data, String utente) {
		
		ID = iD;
		this.titolo = titolo;
		this.testo = testo;
		this.data = data;
		this.utente = utente;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	public String getTitolo(){
		return titolo;
	}
	public void setTitolo(String titolo){
		this.titolo=titolo;
	}
	public String getTesto() {
		return testo;
	}

	public void setTesto(String test) {
		this.testo = test;
	}
	public String getUtente() {
		return utente;
	}

	public void setUtente(String test) {
		this.utente = test;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
