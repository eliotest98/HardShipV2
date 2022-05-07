package it.ship.beans;
/**
 * 
 * @author 
 *
 */
public class Album {
	
	private int id;
	private String genere;
	private String titolo;
	private String copertina;
	private int numBrani;
	private String data;
	private String embed;
	private String dettagli;

	/**
	 * costruttore della classe.
	 */
	public Album(){
		
	}
	public Album(int id, String genere, String titolo, String copertina, int numBrani, String data, String embed,
			String dettagli) {
		this.id = id;
		this.genere = genere;
		this.titolo = titolo;
		this.copertina = copertina;
		this.numBrani = numBrani;
		this.data = data;
		this.embed = embed;
		this.dettagli = dettagli;
	}
	/**
	 * il metodo setta l'id dell'album.
	 * 
	 * @param id identificatore dell'album.
	 */
	public void setId(int id){
		this.id = id;
	}
	/**
	 * il metodo restituisce l'identificatore dell'album.
	 * 
	 * @return id l'identificatore dell'album.
	 */
	public int getId(){
		return this.id;
	}
	/**
	 * il metodo setta il genere dell'album.
	 * 
	 * @param gen il genere dell'album.
	 */
	public void setGenere(String gen){
		this.genere = gen;
	}
	/**
	 * il metodo restituisce il genere dell'album.
	 * 
	 * @return genere il genere dell'album.
	 */
	public String getGenere(){
		return this.genere;
	}
	/**
	 * il metodo setta il titolo dell'album.
	 * 
	 * @param titolo il titolo dell'album 
	 */
	public void setTitolo(String titolo){
		this.titolo = titolo;
	}
	/**
	 * il metodo restituisce il titolo dell'album.
	 * 
	 * @return titolo il titolo dell'album.
	 */
	public String getTitolo(){
		return this.titolo;
	}
	/**
	 * il metodo setta la copertina dell'album.
	 * 
	 * @param cop la copertina dell'album.
	 */
	public void setCopertina(String cop){
		this.copertina = cop;
	}
	/**
	 * il metodo restituisce la copertina dell'album.
	 * 
	 * @return copertina la copertina dell'album.
	 */
	public String getCopertina(){
		return this.copertina;
	}
	/**
	 * il metodo setta la data di uscita dell'album.
	 * @param data la data di uscita dell'album.
	 */
	public void setData(String data){
		this.data = data;
	}
	/**
	 * il metodo restituisce la data di uscita dell'album.
	 * 
	 * @return data la data di uscita dell'album.
	 */
	public String getData(){
		return this.data;
	}
	/**
	 * il metodo restituisce il numero di brani contenuti nell'album.
	 * 
	 * @return numBrani il numero di brani contenuti nell'album.
	 */
	public int getNumBrani(){
		return this.numBrani;
	}
	/**
	 * il metodo setta il numero di brani presenti nell'album.
	 * 
	 * @param numBrani il numero di brani presenti nell'album.
	 */
	public void setNumBrani(int numBrani){
		this.numBrani= numBrani;
	}
	/**
	 * il metodo setta la descrizione dell'album.
	 * 
	 * @param dettagli la descrizione dell'album.
	 */
	public void setDettagli(String dettagli){
		this.dettagli =dettagli;
	}
	/**
	 * il metodo restituisce la descrizione dell'album.
	 * 
	 * @return dettagli la descrizione dell'album.
	 */
	public String getDettagli(){
		return this.dettagli;
	}
	/**
	 * il metodo setta l'embed per la riproduzione del album.
	 * 
	 * @param e embed per la riproduzione dell'album.
	 */
	public void setEmbed(String e){
		this.embed = e;
	}
	/**
	 * il metodo restituisce l'embed per la riproduzione dell'album.
	 * 
	 * @return embed l'embed per la riproduzione dell'album.
	 */
	public String getEmbed(){
		return this.embed;
	}
	

}
