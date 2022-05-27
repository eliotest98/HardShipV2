package it.ship.beans;

/**
 * 
 * @author 
 *
 */
public class Brano {
	
	private int id;
	private String titolo;
	private String anno;
	private String durata;
	/**
	 * costruttore della classe.
	 */
	public Brano(){
		
	}
	public Brano(int id, String titolo, String anno, String durata) {
		
		this.id = id;
		this.titolo = titolo;
		this.anno = anno;
		this.durata = durata;
	}
	/**
	 * il metodo setta l'identificatore del brano.
	 * 
	 * @param id l'identificatore del brano.
	 */
	public void setId(int id){
		this.id = id;
	}
	/**
	 * il metodo restituisce l'identificatore del brano.
	 * 
	 * @return id l'identificatore del brano.
	 */
	public int getId(){
		return this.id;
	}
	/**
	 * il metodo setta il titolo del brano.
	 * 
	 * @param titolo il titolo del brano.
	 */
	public void setTitolo(String titolo){
		this.titolo = titolo;
	}
	/**
	 * il metodo restituisce il titolo del brano.
	 * 
	 * @return titolo il titolo del brano.
	 */
	public String getTitolo(){
		return this.titolo;
	}
	/**
	 * il metodo setta l'anno di uscita del brano.
	 * 
	 * @param anno l'anno di uscita del brano.
	 */
	public void setAnno(String anno){
		this.anno= anno;
	}
	/**
	 * il metodo restituisce l'anno di uscita del brano.
	 * 
	 * @return anno l'anno di uscita del brano.
	 */
	public String getAnno(){
		return this.anno;
	}
	/**
	 * il metodo restituisce la durata del brano.
	 * 
	 * @return durata la duata del brano.
	 */
	public String getDurata(){
		return this.durata;
	}
	/**
	 * il metodo setta la durata del brano.
	 * 
	 * @param durata la durata del brano.
	 */
	public void setDurata(String durata){
		this.durata= durata;
	}
	

}
