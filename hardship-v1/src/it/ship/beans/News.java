package it.ship.beans;

public class News {
	
	private int id;
	private String contenuto;
	private String data;
	private String autore;
	private String titolo;
	private String copertina;
	private String categoria;
	
	public News(){
		
	}
	public News(int id, String contenuto, String data, String autore, String titolo, String copertina,
			String categoria) {
		
		this.id = id;
		this.contenuto = contenuto;
		this.data = data;
		this.autore = autore;
		this.titolo = titolo;
		this.copertina = copertina;
		this.categoria = categoria;
	}
	public void setCategoria(String g){
		this.categoria =g;
	}
	public String getCategoria(){
		return this.categoria;
	}
	public void setId(int id){
		this.id = id;
	}
	public void setContenuto(String con){
		this.contenuto = con;
	}
	public void setData(String data){
		this.data = data;
	}
	public void setAutore(String autore){
		this.autore = autore;
	}
	public void setTitolo(String titolo){
		this.titolo = titolo;
	}
	public void setCopertina(String cop){
		this.copertina = cop;
	}
	public int getId(){
		return this.id;
	}
	public String getContenuto(){
		return this.contenuto;
	}
	public String getData(){
		return this.data;
	}
	public String getAutore(){
		return this.autore;
	}
	public String getTitolo(){
		return this.titolo;
	}
	public String getCopertina(){
		return this.copertina;
	}

}
