package ristorante;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * -Ho risolto l'esercizio che funziona per ora in modo statico. 
 * -Ho aggiunto a prodotto e menu l'override del metodo toString() per trasformare il mio hashcode dei prodotti nella stringa che volevo
 *  -->(Mi sono studiato il metodo toString() perche ancora non l'avevo usato. 
 * -Mi manca da trasformare il mio esercizio da statico a dinamico(Sto cercando di utilizzare i suggerimenti di andrea)
 * -Una cosa che manca all'esercizio sono le scegliere.close(), 
 *  ma aggiungendole mi segnava delle ecezzioni che vanno gestite quindi una volta finito li aggiungo e 
 *  cerco di gestire le eccezioni(ancora non ho incontrato questa cosa tra gli esercizi, quindi devo capire bene come applicare la teoria)
 *  
 *  -----TEORIA-----
 *  --> Le ECCEZIONI sono di 3 tipi: 1) Error, 2) Checked Exceptions, 3) RuntimeException.
 *      --> 1) Error: Eccezione di tipo hardware quindi non dipende dal nostro codice--> NON dobbiamo e NON possiamo gestirli.
 *      --> 2) Checked Exceptions: Eccezioni che si controllano in fase di compilazione e devono essere dichiarate e gestite esplicitamente.
 *      --> 3) RuntimeException: Eccezioni che non sono controllate in fase di compilazione, sono controllate solo a runtime e in quel momento gestite.
 *  --> Le eccezioni si gestiscono con il costrutto try/catch oppure sollevandole verso l'esterno con trows.
 *  
 *  --> LIST/SET: Struttura che fa parte della Collection Framework, possono contenere SOLO oggetti e NON tipi primitivi e la dimensione viene definita in fase
 *                di inizializzazione, ma può essere modificata anche in un secondo momento aggiungendo elementi o rimuovendone.
 *                è un interfaccia e l'inizializzazione va fatta per tipi concreti come ad esempio ArrayList o LinkedList.
 *                Gli elementi della lista sono oggetti quindi riferimenti a zone di memoria --> due elementi vicini nella lista non è detto che 
 *                                                                                           lo siano anche nella zona di memoria dove sono allocati.
 *                                                                                           
 *                Fino a qua List e Set sono identici come teoria(unica differenza l'inizializzazione va fatta per tipi concreti in questo caso HashSet)
 *                                                                                          
 *                Caratteristiche List: 1) Permettono l'ordinamento dei dati
 *                                      2) Permettono infiniti valori null
 *                                      3) Hanno l'accesso posizionale
 *                                      4) Ammettono duplicati
 *                Caratteristiche Set: 1) Non permettono l'ordinamento dei dati
 *                                     2) Permettono un solo valore null
 *                                     3) Non hanno accesso posizionale
 *                                     4) Non ammettono duplicati(se inseriamo un elemento duplicato, quello precedente viene sovrascritto)
 *                                     
 *  --> MAP: è un interfaccia dalla struttura CHIAVE/VALORE. NON ammette duplicati di chiave, AMMETTE invece due valori duplicati.
 *           Non ha accesso posizionale, ma si usa la chiave per risalire all'elemento che vogliamo.
 *           Esistono: -Due interfacce Map e SortedMap
 *                     -Tre classi concrete HashMap, LinkedMap e TreeMap
 *           
 */


public class Main2 {

	public static void main(String[] args) {

		Prodotto carbonara = new Prodotto("carbonara", 15, EnumProdotto.PIATTO);
		Prodotto caprese = new Prodotto("caprese", 10, EnumProdotto.PIATTO);
		Prodotto coca = new Prodotto("coca", 2.0, EnumProdotto.BEVANDA);
		Prodotto fanta = new Prodotto("fanta", 2.0, EnumProdotto.BEVANDA);

		Menu menu = new Menu();

		menu.aggiungiMenu(carbonara);
		menu.aggiungiMenu(caprese);
		menu.aggiungiMenu(coca);
		menu.aggiungiMenu(fanta);

		List<Tavolo> listaTavoli = new ArrayList<>();

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
					System.out.println(i + "\t" + prodotto.getNome() + "\t" + "\t" + prodotto.getPrezzo());
					i++;
				}
				scegliere.nextLine();
				break;

			case "1":

				System.out.println("Inserisci numero tavolo: ");
				int numeroTavolo = scegliere.nextInt();

				System.out.println("Inserisci numero coperti: ");
				int numeroCoperti = scegliere.nextInt();

				scegliere.nextLine();
				Tavolo tavolo = new Tavolo(numeroTavolo, numeroCoperti);
				listaTavoli.add(tavolo);

				System.out.println("Tavolo: " + "Tavolo numero : " + tavolo.getNumeroTavolo() + " " + "Numero coperti : " + tavolo.getNumeroCoperti());
				scegliere.nextLine();
				break;

			case "2": //metodo alternativo: creare un if(scelta deve appartenere al menu) e nel corpo aggiungere questo prodotto al tavolo. 
				      //Creare un else(scelta non appartiene al menu), nel corpo stampiamo(prodotto non presente sul menu)
				
				System.out.println("Scegli tavolo : ");
				numeroTavolo = scegliere.nextInt();
				tavolo=listaTavoli.get(numeroTavolo);
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
//						
//					}

				}
				
				System.out.println("il tuo ordine è : " + tavolo.getOrdine());
				scegliere.nextLine();
				break;

			case "3":
				
				int y = 0;
				for(Tavolo t : listaTavoli) {
					System.out.println(y + "\t" + t.getNumeroTavolo() + "\t" + t.getNumeroCoperti() + "\t" + t.getOrdine());
					y++;
				}

				System.out.println("Scegli tavolo : ");
				numeroTavolo = scegliere.nextInt();
				tavolo=listaTavoli.get(numeroTavolo);

				System.out.println("Il tuo conto è : ");
				System.out.println(tavolo.calcolaconto());
				scegliere.nextLine();
				break;
				
			}
		}
		scegliere.close();
	}
}



		

		
		

