package it.ship.beans;

public class Etichetta {
	
	private int id;
	private String nome;
	private int feed; 
	public Etichetta(){
		
	}
	public Etichetta(int id, String nome, int feed) {
		
		this.id = id;
		this.nome = nome;
		this.feed = feed;
	}
	public void setId(int id){
		this.id= id;
	}
	public void setNome(String nome){
		this.nome= nome;
	}
	public void setFeed(int f){
		this.feed= f;
	}
	public int getId(){
		return this.id;
	}
	public String getNome(){
		return this.nome;
	}
	public int getFeed(){
		return this.feed;
	}
	

}
