package it.ship.beans;
/**
 * 
 * @author 
 *
 */
public class Artista {
	
	private int id;
	private String nome;
	/**
	 * costruttore della classe.
	 */
	public Artista(){
		
	}
	/**
	 * il metodo setta l'identificatore dell'artista.
	 * 
	 * @param id l'identificatore dell'artista.
	 */
	public void setId(int id){
		this.id=id;
	}
	/**
	 * il metodo setta il nome dell'artista.
	 * 
	 * @param n il nome dell'artista.
	 */
	public void setNome(String n){
		this.nome = n;
	}
	public Artista(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	/**
	 * il metodo restituisce l'identificatore dell'artista.
	 * 
	 * @return id l'identificatore dell'artista.
	 */
	public int getId(){
		return this.id;
	}
	/**
	 * il metodo restituisce il nome dell'artista.
	 * 
	 * @return nome il nome dell'artista.
	 */
	public String getNome(){
		return this.nome;
	}

}
