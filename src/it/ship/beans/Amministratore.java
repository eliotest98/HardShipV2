package it.ship.beans;
/**
 * 
 * @author 
 *
 */
public class Amministratore {
	private String username;
	private String password;
	/**
	 * cosruttore della classe.
	 */
	public Amministratore(){
	}
	
	public Amministratore(String username, String password) {
		
		this.username = username;
		this.password = password;
	}

	/**
	 * il metodo restituisce l'username dell'amminitratore.
	 * 
	 * @return username l'username dell'amministratore.
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * il metodo setta l'username dell'amminitratore.
	 * 
	 * @param username l'username dell'amministratore.
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * il metodo restituisce la password dell'amminitratore.
	 * 
	 * @return password la password dell'amminitratore.
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * il metodo setta la password dell'amminitratore.
	 * 
	 * @param password la password dell'amminitratore.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	


}
