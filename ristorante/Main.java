package ristorante;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Prodotto carbonara = new Prodotto("carbonara", 15, EnumProdotto.PIATTO);
		Prodotto coca = new Prodotto("coca", 2.0, EnumProdotto.BEVANDA);
		Prodotto caprese = new Prodotto("caprese", 10, EnumProdotto.PIATTO);
		Prodotto fanta = new Prodotto("fanta", 2.0, EnumProdotto.BEVANDA);
		
		Menu menu = new Menu();
		
		menu.aggiungiMenu(carbonara);
		menu.aggiungiMenu(coca);
		menu.aggiungiMenu(caprese);
		menu.aggiungiMenu(fanta);
		
		Map<Integer,Tavolo> mappaTavoli = new HashMap<>();
		
		Scanner scegliere = new Scanner(System.in);
		String scelta = null;
		
		while (!"4".equals(scelta)) {
			
			System.out.println("Scrivi : \n0 vedi menu \n1 aggiungi un tavolo \n2 crea ordine \n3 vedi conto tavolo n \n4 esci");
			scelta = scegliere.nextLine();
			
			switch(scelta) {
			
			case "0":

				System.out.println("Il mio menu è : ");
				int i = 0;
				for(Prodotto prodotto : menu.getMenu()) {
					System.out.println(i + "\t" + prodotto.getNome() + "\t" + prodotto.getPrezzo());
					i++;
				}
				scegliere.nextLine();
				break;
			
			case "1":
				
				System.out.println("Inserisci numero tavolo: ");
				int numeroTavolo = scegliere.nextInt();
				
				System.out.println("Inserisci numero coperti: ");
				int numeroCoperti = scegliere.nextInt();
				
				Tavolo tavolo = new Tavolo(numeroTavolo, numeroCoperti);
				mappaTavoli.put(numeroTavolo, tavolo);
				
				System.out.println("Tavolo: " + "Tavolo numero : " + tavolo.getNumeroTavolo() + " " + "Numero coperti : " + tavolo.getNumeroCoperti());
				scegliere.nextLine();
			    break;
			
			case "2":
				

				System.out.println("Scegli tavolo : ");
				numeroTavolo = scegliere.nextInt();
				tavolo=mappaTavoli.get(numeroTavolo);
				scegliere.nextLine();
				
				while(!"0".equals(scelta)) {

					System.out.println("Scrivere prodotto desiderato \n0 per chiudere l'ordine");
					System.out.println("Inserisci un prodotto: ");
					scelta = scegliere.nextLine();
					
/*
 * Metodo più generico
 */
										
					for(Prodotto prod : menu.getMenu()) {
						if(scelta.equals(prod.getNome())) {
							tavolo.aggiungiAOrdine(prod);
						} else {
							System.out.println("Prodotto non presente sul menu");
						} 
					}
					
					
/*
 * Metodo con switch-case
 */
					
					
//					switch(scelta) {
//
//					case "carbonara":
//						tavolo.aggiungiAOrdine(carbonara);
//						break;
//
//					case "caprese":
//						tavolo.aggiungiAOrdine(caprese);
//						break;
//
//					case "coca":
//						tavolo.aggiungiAOrdine(coca);
//						break;
//
//					case "fanta":
//						tavolo.aggiungiAOrdine(fanta);
//						break;
//					}
				}
				System.out.println("il tuo ordine è : " + tavolo.getOrdine());
				break;
				
			case "3":
				
				System.out.println("Scegli tavolo : ");
				numeroTavolo = scegliere.nextInt();
				tavolo=mappaTavoli.get(numeroTavolo);

				System.out.println("Il tuo conto è : ");
				System.out.println(tavolo.calcolaconto());
				scegliere.nextLine();
				break;
			}
		}
		scegliere.close();
	}
}

		

		
		
