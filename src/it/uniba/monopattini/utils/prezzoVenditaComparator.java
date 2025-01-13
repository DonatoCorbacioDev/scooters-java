package it.uniba.monopattini.utils;

import java.util.Comparator;

import it.uniba.monopattini.business.Vendita;

   
/**
 * Creazione di classe prezzoVenditaComparator con l'interfaccia Comparator che fornisce le sequenza multiple di ordinamento. E' capace 
 * di confrontare due oggetti differenti.
 * L'utilizzo è servito per ordinare la lista delle vendite in base alla coppia di parametri: Tipo di monopattino
 * (medio, poi avanzato ed infine base) e costo di vendita più basso.
 * In questo caso con l'implementazione del Comparator ho gestito l'ordinamento per prezzo di vendita, facendo dei confronti con i valori per 
 * ordinarli dal prezzo più basso al prezzo più alto.
 *    
 * @author Donato Corbacio
 *
 */
public class prezzoVenditaComparator implements Comparator<Vendita> {




	@Override
	public int compare(Vendita o1, Vendita o2) {
		
		 if (o1.getPrezzoVendita() == o2.getPrezzoVendita()) {
	            return 0;
		 } else if (o1.getPrezzoVendita() > o2.getPrezzoVendita()) {
	            return 1;
		 } else {
	            return -1;
	        }
	
	
  }
	
}
