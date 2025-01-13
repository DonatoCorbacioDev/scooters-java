package it.uniba.monopattini.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Creazione di classe DateUtils per la formattazione di Date, converte una data fornita come String, che richiede come parametro,
 * in un oggetto di tipo Date, che restituisce al chiamante, consente di definire dei pattern personalizzati per l'output e visualizza
 * il parsing in una modalità locale-sensitive che è adeguata al formato temporale in uso nell'area geografica del sistema.
 * 
 * @author Donato Corbacio
 *
 */
public class DateUtils {

	
	
	public static Date parseDate(String data) throws ParseException{
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		formatter.setLenient(false);
		Date date = formatter.parse(data);
		return date;
    }
	
}
