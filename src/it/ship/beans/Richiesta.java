package it.ship.beans;

public class Richiesta {
	
	private int id;
	private String nomeAlbum;
	private String nomeArtista;
	
	public Richiesta(){
		
	}
	
	public Richiesta(int id, String nomeAlbum, String nomeArtista) {
		
		this.id = id;
		this.nomeAlbum = nomeAlbum;
		this.nomeArtista = nomeArtista;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeAlbum() {
		return nomeAlbum;
	}
	public void setNomeAlbum(String nomeAlbum) {
		this.nomeAlbum = nomeAlbum;
	}
	public String getNomeArtista() {
		return nomeArtista;
	}
	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}
	
	
}
