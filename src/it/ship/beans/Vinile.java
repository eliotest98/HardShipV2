package it.ship.beans;

public class Vinile {

	private int id;
	private int numCopie;
	private int prezzo;
	/**
	 * costruttore della classe
	 */
	public Vinile(){
		
	}
	public Vinile(int id, int numCopie, int prezzo) {
		this.id = id;
		this.numCopie = numCopie;
		this.prezzo = prezzo;
	}
	/**
	 * il metodo restituisce l'identificatore del vinile.
	 * 
	 * @return id l'identificatore del vinile.
	 */
	public int getId(){
		return this.id;
	}
	/**
	 * il metodo restituisce il numero di copie disponibili del vinile.
	 * 
	 * @return numCopie il numero di copie disponibili del vinile.
	 */
	public int getNumCopie(){
		return this.numCopie;
	}
	/**
	 * il metodo restituisce il prezzo del vinile.
	 * 
	 * @return prezzo il prezzo del vinile.
	 */
	public int getPrezzo(){
		return this.prezzo;
	}
	/**
	 * il metodo setta l'identificatore del vinile.
	 * 
	 * @param id l'identificatore del vinile.
	 */
	public void setId(int id){
		this.id= id;
	}
	/**
	 * il metodo setta il numero di copie disponibili del vinile.
	 * 
	 * @param i il numero di copie disponibili del vinile.
	 */
	public void setNumCopie(int i){
		this.numCopie = i;
	}
	/**
	 * il metodo setta il prezzo del vinile.
	 * @param i il prezo del vinile.
	 */
	public void setPrezzo(int i){
		this.prezzo= i;
	}
}
