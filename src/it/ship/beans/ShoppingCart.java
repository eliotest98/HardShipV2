package it.ship.beans;

import java.util.*;

/** A shopping cart data structure used to track orders.
 *  The OrderPage servlet associates one of these carts
 *  with each user session.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages 2nd Edition
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class ShoppingCart {
	private ArrayList<Album> itemsOrdered;
	private ArrayList<Integer> prezzi;
	private ArrayList<Artista> artisti;
	private ArrayList<Etichetta> etichette;

	/** Builds an empty shopping cart. */

	public ShoppingCart() {
		itemsOrdered = new ArrayList<Album>();
		prezzi = new ArrayList<Integer>();
		artisti=new ArrayList<Artista>();
		etichette=new ArrayList<Etichetta>();
	}

	/** Returns List of ItemOrder entries giving
	 *  Item and number ordered. Declared as List instead
	 *  of ArrayList so that underlying implementation
	 *  can be changed later.
	 */

	public ArrayList<Album> getItemsOrdered() {
		return this.itemsOrdered;
	}
	public ArrayList<Integer> getPrezzi(){
		return this.prezzi;
	}
	
	public ArrayList<Artista> getArtisti() {
		return this.artisti;
	}
	public ArrayList<Etichetta> getEtichetta(){
		return this.etichette;
	}

	/** Looks through cart to see if it already contains
	 *  an order entry corresponding to item ID. If it does,
	 *  increments the number ordered. If not, looks up
	 *  Item in catalog and adds an order entry for it.
	 */

	public synchronized void addItem(Album itemID,int p,Artista art , Etichetta y) {
		this.itemsOrdered.add(itemID);
		this.prezzi.add(p);
		this.artisti.add(art);
		this.etichette.add(y);
		return;
	}

	public synchronized void deletItem(int a){
		this.itemsOrdered.remove(a);
		this.prezzi.remove(a);
		this.artisti.remove(a);
		this.etichette.remove(a);
	}

}
