package it.ship.beans;
/**
 * 
 * @author 
 *
 */
public class Cliente {
	
	private int id;
	public Cliente(int id, String nome, String cognome, String data, String username, String password,
			String codiceFiscale, String email) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.data = data;
		this.username = username;
		this.password = password;
		this.codiceFiscale = codiceFiscale;
		this.email = email;
	}
	private String nome;
	private String cognome;
	private String data;
	private String username;
	private String password;
	private String codiceFiscale;
	private String email;
	/**
	 * costruttore della classe.
	 */
	public Cliente(){
		
	}
	/**
	 * il metodo restituisce l'identificatore del cliente.
	 * 
	 * @return id l'identificatore del cliente.
	 */
	public int getID(){
		return this.id;
	}
	/**
	 * il metodo setta l'identificatore del cliente.
	 * 
	 * @param id l'identificatore del cliente. 
	 */
	public void setID(int id){
		this.id = id;
	}
	/**
	 * il metodo restituisce il nome del cliente. 
	 * 
	 * @return nome il nome del cliente. 
	 */
	public String getNome(){
		return nome;
	}
	/**
	 * il metodo restituisce il cognome del cliente. 
	 * 
	 * @return cognome il cognome del cliente. 
	 */
	public String getCognome(){
		return cognome;
	}
	/**
	 * il metodo restituisce la data di nascita del cliente.
	 * 
	 * @return data la data di nascita del cliente. 
	 */
	public String getData(){
		return data;
	}
	/**
	 * il metodo restituisce
	 * 
	 * @return username l'username del cliente.
	 */
	public String getUser(){
		return username;
	}
	/**
	 * il metodo restituisce la password del cliente. 
	 * 
	 * @return password la password del cliente. 
	 */
	public String getPass(){
		return password;
	}
	/**
	 * il metodo restituisce il codice fiscale del cliente. 
	 * 
	 * @return codiceFiscale il codice fiscale del cliente.  
	 */
	public String getCF(){
		return codiceFiscale;
	}
	/**
	 * il metodo restituisce l'email del cliente. 
	 * 
	 * @return email l'email del cliente. 
	 */
	public String getEmail(){
		return email;
	}
	/**
	 * il metodo setta il nome del cliente.
	 * 
	 * @param i il nome del cliente. 
	 */
	public void setNome(String i){
		this.nome = i;
	}
	/**
	 * il metodo setta il cognome del cliente.
	 * 
	 * @param c il cognome del cliente. 
	 */
	public void setCognome(String c){
		this.cognome= c;
	}
	/**
	 * il metodo setta la data di nascita del cliente. 
	 * 
	 * @param d la data di nascita del cliente. 
	 */
	public void setData(String d){
		this.data= d;
	}
	/**
	 * il metodo setta l'username del cliente.
	 * 
	 * @param u l'username del cliente. 
	 */
	public void setUser(String u){
		this.username= u;
	}
	/**
	 * il metodo setta la password del cliente. 
	 * 
	 * @param p la password del cliente. 
	 */
	public void setPass(String p){
		this.password = p;
	}
	/**
	 * il metodo setta il codice fiscale del cliente.
	 * 
	 * @param c il codice fiscale del cliente. 
	 */
	public void setCF(String c){
		this.codiceFiscale = c;
	}
	/**
	 * il metodo setta l'email del cliente. 
	 * 
	 * @param e email del cliente.
	 */
	public void setEmail(String e){
		this.email= e;
	}

}
