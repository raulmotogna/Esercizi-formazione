package ristorante;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	
	private List<Prodotto> menu = new ArrayList<>();
	
	public List<Prodotto> getMenu(){
		return this.menu;
	}
	
	public void setMenu(List<Prodotto> menu) {
		this.menu = menu;
	}
	
	public void aggiungiMenu(Prodotto prodotto) {
		menu.add(prodotto);
	}
	
//	public boolean contiene(String string) {
//		return menu.contains(string);
//	}
	
//	public boolean contiene(Prodotto prod) {
//		return menu.contains(prod);
//	}
//	
//	public Prodotto cercaProdotto(String scelta) {
//		if(scelta == prod.getNome())
//	}
	
	@Override
	public String toString() {
		return menu + "menu";
	}
}
