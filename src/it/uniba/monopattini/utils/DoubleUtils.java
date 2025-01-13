package it.uniba.monopattini.utils;

import java.text.ParseException;


/**
 * 
 * Creazione di classe DoubleUtils, converte un numero decimale con la virgola fornita come String, che richiede come parametro,
 * in un oggetto di tipo Double, che restituisce al chiamante.
 * 
 * @author Donato Corbacio
 *
 */
public class DoubleUtils {

	
	public static Double parseDouble(String prezzo) throws ParseException{
		
		Double prezzoVN = Double.parseDouble(prezzo);
		return prezzoVN;
    }
}
