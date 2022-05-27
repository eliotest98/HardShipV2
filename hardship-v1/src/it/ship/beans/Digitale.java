package it.ship.beans;

public class Digitale {

	private int id;
	private int prezzo;
	private int numCopie;
	/**
	 * costruttore della classe
	 */
	public Digitale(){
		
	}
	/**
	 * il metodo setta l'identificatore del digitale.
	 * 
	 * @param i l'identificatore del digitale.
	 */
	public void setId(int i){
		this.id = i;
	}
	public Digitale(int id, int prezzo, int numCopie) {
	
		this.id = id;
		this.prezzo = prezzo;
		this.numCopie = numCopie;
	}
	/**
	 * il metodo setta il prezzo del digitale.
	 * 
	 * @param i il prezzo del digitale.
	 */
	public void setPrezzo(int  i){
		this.prezzo = i;
	}
	/**
	 * il metodo setta il numero di copie disponibili per il digitale.
	 * 
	 * @param c il numero di copie disponibili per il digitale.
	 */
	public void setNumCopie(int c){
		this.numCopie = c;
	}
	/**
	 * il metodo restituisce l'identificatore del digitale.
	 * 
	 * @return id l'identificatore del digitale.
	 */
	public int getId(){
		return this.id;
	}
	/**
	 * il metodo restituisce il prezzo del digitale.
	 * 
	 * @return prezzo il prezzo del digitale.
	 */
	public int getPrezzo(){
		return this.prezzo;
	}
	/**
	 * il metodo restituisce il numero di copie disponibili per il digitale.
	 * 
	 * @return numCopie il numro di copie disponibili per il digitale.
	 */
	public int getNumCopie(){
		return this.numCopie;
	}
	
}
