package it.ship.beans;
/**
 * 
 * @author 
 *
 */
public class Cd {
	
	private int id;
	private int prezzo;
	private int numCopie;
	/**
	 * costruttore della classe
	 */
	public Cd(){
		
	}
	/**
	 * il medoto setta l'identificatore del CD.
	 * 
	 * @param id l'identificatore del CD.
	 */
	public void setId(int id){
		this.id = id;
	}
	public Cd(int id, int prezzo, int numCopie) {
		this.id = id;
		this.prezzo = prezzo;
		this.numCopie = numCopie;
	}
	/**
	 * il metodo setta il prezzo del CD.
	 * 
	 * @param i il prezzo del CD.
	 */
	public void setPrezzo(int  i){
		this.prezzo = i;
	}
	/**
	 * il metodo setta il numero di copie disponibili del CD.
	 * 
	 * @param c il numero di copie disponibili per il CD.
	 */
	public void setNumCopie(int c){
		this.numCopie = c;
	}
	/**
	 * il metodo restituisce l'identificatore del CD.
	 * 
	 * @return id l'identificatore del CD.
	 */
	public int getId(){
		return this.id;
	}
	/**
	 * il metodo restituisce il prezzo del CD.
	 * 
	 * @return prezzo il prezzo del CD.
	 */
	public int getPrezzo(){
		return this.prezzo;
	}
	/**
	 * il metodo restituisce il numero di copie disponibili del CD.
	 * 
	 * @return numCopie il numero di copie disponibili del CD.
	 */
	public int getNumCopie(){
		return this.numCopie;
	}

}
