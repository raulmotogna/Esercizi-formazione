package ristorante;

import java.util.ArrayList;
import java.util.List;

public class Tavolo {
	
	private int numeroTavolo;
	private int numeroCoperti;
	private List<Prodotto> ordine = new ArrayList<>();
	
	public Tavolo(int numeroTavolo, int numeroCoperti) {
		this.numeroTavolo = numeroTavolo;
		this.numeroCoperti = numeroCoperti;
	}
	
	public int getNumeroTavolo() {
		return this.numeroTavolo;
	}
	
	public void setNumeroTavolo(int numeroTavolo) {
		this.numeroTavolo = numeroTavolo;
	}
	
	public int getNumeroCoperti() {
		return this.numeroCoperti;
	}
	
	public void setNumeroCoperti(int numeroCoperti) {
		this.numeroCoperti = numeroCoperti;
	}
	
	public List<Prodotto> getOrdine() {
		return this.ordine;
	}

	public void setOrdine(List<Prodotto> ordine) {
		this.ordine = ordine;
	}
	
    public void aggiungiAOrdine(Prodotto prodotto) {
    	ordine.add(prodotto);
    }
    
	public double calcolaconto() {
		double conto = 0.0;
		for(Prodotto p : ordine) {
			conto += p.getPrezzo();	
		}
		return conto;
	}
	
	@Override
	public String toString() {
		return "Tavolo [numeroTavolo=" + numeroTavolo +", numeroCoperti=" + numeroCoperti +" ,  ordine=" + ordine +"]";
	} 
	

	

}
