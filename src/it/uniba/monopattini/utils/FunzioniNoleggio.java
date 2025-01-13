package it.uniba.monopattini.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import it.uniba.monopattini.business.Noleggio;

public class FunzioniNoleggio {

	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Aggiunge un noleggio nuovo alla lista dei noleggi registrati.
	 * @param listaDipendenti
	 * @throws ParseException 
	 */
	public static void aggiungiNoleggio(List<Noleggio> listaNoleggio) throws ParseException {
		Noleggio n = new Noleggio();
		System.out.println("Inserire Monopattino noleggiato");
		String monopattinoNoleggiato = scanner.nextLine();
		System.out.println("Inserire Tipo Monopattino");
		String tipoMonopattino = scanner.nextLine();
		System.out.println("Inserire Cliente");
		String clienteNoleggio = scanner.nextLine();
		System.out.println("Inserire data inizio noleggio");
		String dataInizioNoleggio = scanner.nextLine();
		Date dataInizioNoleggioMono = DateUtils.parseDate(dataInizioNoleggio);
		System.out.println("Inserire data fine noleggio");
		String dataFineNoleggio = scanner.nextLine();
		Date dataFineNoleggioMono = DateUtils.parseDate(dataFineNoleggio);
		
		
		System.out.println("Inserire prezzo noleggio");
		String prezzoNoleggio = scanner.nextLine();
		Double prezzoNoleggioMono = DoubleUtils.parseDouble(prezzoNoleggio);
		
		
		System.out.println("Inserire penale");
		String penale = scanner.nextLine();
		Double penaleMono = DoubleUtils.parseDouble(penale);
		
		
		System.out.println("Inserire dipendente che effettua il noleggio");
		String dipendenteNoleggio = scanner.nextLine();

		n.setMonopattinoNoleggiato(monopattinoNoleggiato);
		n.setTipoMonopattino(tipoMonopattino);
		n.setClienteNoleggio(clienteNoleggio);
		n.setDataInizioNoleggio(dataInizioNoleggioMono);
		n.setDataFineNoleggio(dataFineNoleggioMono);
		n.setPrezzoNoleggio(prezzoNoleggioMono);
		n.setPenale(penaleMono);
		n.setDipendenteNoleggio(dipendenteNoleggio);
		
		
		
		boolean inserimentoCodiceCorretto = false;
		
		while(!inserimentoCodiceCorretto) {
			try {
				System.out.println("Inserire codice noleggio");
				String codiceNoleggio = scanner.nextLine();
				n.setCodiceNoleggio(codiceNoleggio);
				inserimentoCodiceCorretto = true;
			} catch (Exception e) {
				//e.printStackTrace();
				inserimentoCodiceCorretto = false;
				System.err.println("Errore " + e.getMessage());
			}
		}
		
		listaNoleggio.add(n);
	}
	
	
	
	/**
	 * Elimina un noleggio dalla lista dei noleggi registrati, se non presente non fa nulla.
	 * @param listaNoleggio
	 * @param noleggio
	 */
	public static void eliminaNoleggio(List<Noleggio> listaNoleggio, Noleggio noleggio) {	
		for(int i = 0; i < listaNoleggio.size(); i++) {
			if(listaNoleggio.get(i).compareTo(noleggio) == 0) {
				listaNoleggio.remove(i);
			}
		}
	}
	
	
	
	/**
	 * Elimina un noleggio dalla lista dei noleggi registrati, se non presente non fa nulla.
	 * @param listaNoleggio
	 * @param codiceNoleggio
	 */
	public static void eliminaNoleggio(List<Noleggio> listaNoleggio, String codiceNoleggio) {
		for(int i = 0; i < listaNoleggio.size(); i++) {
			if(listaNoleggio.get(i).getCodiceNoleggio().equalsIgnoreCase(codiceNoleggio)) {
				listaNoleggio.remove(i);
			}
		}
	}
	
	
	
	/**
	 * Modifica le informazioni del noleggio, chiedendone l'inserimento.
	 * @param listaNoleggio
	 * @param noleggio
	 * @throws ParseException
	 */
	public static void modificaNoleggio(List<Noleggio> listaNoleggio, Noleggio noleggio) throws ParseException {
		System.out.println("Noleggio da modificare: " + noleggio.toString());
		eliminaNoleggio(listaNoleggio, noleggio);
		aggiungiNoleggio(listaNoleggio);		 
	}
	
	
	
	/**
	 * Modifica le informazioni del noleggio, chiedendone l'inserimento.
	 * @param listaNoleggio
	 * @param codiceNoleggio
	 */
	public static void modificaNoleggio(List<Noleggio> listaNoleggio, String codiceNoleggio) {
		try {
			
			Noleggio noleggio = getNoleggioByCodice(listaNoleggio, codiceNoleggio);
			System.out.println("Noleggio da modificare: " + noleggio.toString());
			eliminaNoleggio(listaNoleggio, codiceNoleggio);
			aggiungiNoleggio(listaNoleggio);	
		
		} catch (Exception e) {
			System.err.println("Errore " + e.getMessage());
		}		 
	}
	
	
	
	/**
	 * Visualizza le informazioni dei noleggi registrati.
	 * @param listaNoleggio
	 */
	public static void visualizzaNoleggiRegistrati(List<Noleggio> listaNoleggio) {
		
		for(Noleggio noleggio : listaNoleggio) {
			System.out.println(noleggio.toString());
		}
		
		System.out.print("\nORDINATO PER COGNOME DEL CLIENTE\n");
		Collections.sort(listaNoleggio);
		
		
		
		for(Noleggio noleggio : listaNoleggio) {
			System.out.println(noleggio.toString());
		}
	}
	
	
	/**
	 * Visualizza le informazioni di un noleggio registrato.
	 * @param listaNoleggio
	 * @param codiceNoleggio
	 */
	public static void visualizzaNoleggioRegistrato(List<Noleggio> listaNoleggio, String codiceNoleggio) {
		Noleggio n;
		try {
			n = getNoleggioByCodice(listaNoleggio, codiceNoleggio);
			System.out.println(n.toString());
		} catch (Exception e) {
			System.err.println("Errore " + e.getMessage());
		}
		
	}
	
	
	
	/**
	 * Restituisce il noleggio dato il codice.
	 * @param listaNoleggio
	 * @param codiceNoleggio
	 * @return noleggio trovato
	 * @throws Exception
	 */
	public static Noleggio getNoleggioByCodice(List<Noleggio> listaNoleggio, String codiceNoleggio) throws Exception {
		for(int i = 0; i < listaNoleggio.size(); i++) {
			if(listaNoleggio.get(i).getCodiceNoleggio().equalsIgnoreCase(codiceNoleggio)) {
				return listaNoleggio.get(i);
			}
		}	
		throw new Exception("Noleggio " + codiceNoleggio + " non trovato");
	}
	
	
	
	
	
	
	/**
	 * Salva la lista di ogni noleggio.
	 * @param listaNoleggio
	 * @throws IOException
	 */
    public static void salvaListaNoleggio(List<Noleggio> listaNoleggio) throws IOException {
    	
    	try {
    		FileWriter writer = new FileWriter("Lista Noleggio.csv");
    		PrintWriter out = new PrintWriter(writer);
    		
    		out.print("CODICE NOLEGGIO");
			out.append(';');
    		out.print("MONOPATTINO NOLEGGIATO");
			out.append(';');
			out.print("TIPO MONOPATTINO");
			out.append(';');
			out.print("CLIENTE");
			out.append(';');
			out.print("DATA INIZIO NOLEGGIO");
			out.append(';');
			out.print("DATA FINE NOLEGGIO");
			out.append(';');
			out.print("COSTO");
			out.append(';');
			out.print("PENALE PER RITARDO RESTITUZIONE");
			out.append(';');
			out.println("DIPENDENTE CHE EFFETTUA IL NOLEGGIO");
			
			Collections.sort(listaNoleggio);
    		
    		for(Noleggio noleggio : listaNoleggio) {
    			
    			out.print(noleggio.getCodiceNoleggio());
    			out.append(';');
    			out.print(noleggio.getMonopattinoNoleggiato());
    			out.append(';');
    			out.print(noleggio.getTipoMonopattino());
    			out.append(';');
    			out.print(noleggio.getClienteNoleggio());
    			out.append(';');
    			out.print(noleggio.getDataInizioNoleggio());
    			out.append(';');
    			out.print(noleggio.getDataFineNoleggio());
    			out.append(';');
    			out.print(noleggio.getPrezzoNoleggio());
    			out.append(';');
    			out.print(noleggio.getPenale());
    			out.append(';');
    			out.println(noleggio.getDipendenteNoleggio());
    			
    		}
    		
    		out.flush();
        	out.close();
        	writer.close();
    			
    	}
        	catch(Exception e) {
    		System.err.println("Errore " + e.getMessage());
    	}
	}
    
    
  //----------------------------------------------------------------------------------------------
	
}
