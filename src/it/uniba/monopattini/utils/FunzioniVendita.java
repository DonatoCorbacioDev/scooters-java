package it.uniba.monopattini.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import it.uniba.monopattini.business.Vendita;

public class FunzioniVendita {

	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Aggiunge una vendita nuova alla lista delle vendite registrate.
	 * @param listaVendita
	 * @throws ParseException
	 */
	public static void aggiungiVendita(List<Vendita> listaVendita) throws ParseException {
		Vendita v = new Vendita();
		System.out.println("Inserire Monopattino venduto");
		String monopattinoVenduto = scanner.nextLine();
		System.out.println("Inserire Tipo Monopattino");
		String tipoMonopattino = scanner.nextLine();
		System.out.println("Inserire Cliente");
		String clienteAcquirente = scanner.nextLine();
		System.out.println("Inserire data vendita");
		String dataVendita = scanner.nextLine();
		Date dataVenditaMono = DateUtils.parseDate(dataVendita);
		
		
		System.out.println("Inserire prezzo vendita");
		String prezzoVendita = scanner.nextLine();
		Double prezzoVenditaMono = DoubleUtils.parseDouble(prezzoVendita);
		
		
		
		System.out.println("Inserire dipendente che effettua la vendita");
		String dipendenteVendita = scanner.nextLine();

		v.setMonopattinoVenduto(monopattinoVenduto);
		v.setTipoMonopattino(tipoMonopattino);
		v.setClienteAcquirente(clienteAcquirente);
		v.setDataVendita(dataVenditaMono);
		v.setPrezzoVendita(prezzoVenditaMono);
		v.setDipendenteVendita(dipendenteVendita);
		
		
		
		boolean inserimentoCodiceCorretto = false;
		
		while(!inserimentoCodiceCorretto) {
			try {
				System.out.println("Inserire codice vendita");
				String codiceVendita = scanner.nextLine();
				v.setCodiceVendita(codiceVendita);
				inserimentoCodiceCorretto = true;
			} catch (Exception e) {
				//e.printStackTrace();
				inserimentoCodiceCorretto = false;
				System.err.println("Errore " + e.getMessage());
			}
		}
		
		listaVendita.add(v);
	}
	
	
	/**
	 * Elimina una vendita dalla lista delle vendite registrate, se non presente non fa nulla.
	 * @param listaVendita
	 * @param vendita
	 */
	public static void eliminaVendita(List<Vendita> listaVendita, Vendita vendita) {	
		for(int i = 0; i < listaVendita.size(); i++) {
			if(listaVendita.get(i).compareTo(vendita) == 0) {
				listaVendita.remove(i);
			}
		}
	}
	
	
	/**
	 * Elimina una vendita dalla lista delle vendite registrate, se non presente non fa nulla.
	 * @param listaVendita
	 * @param codiceVendita
	 */
	public static void eliminaVendita(List<Vendita> listaVendita, String codiceVendita) {
		for(int i = 0; i < listaVendita.size(); i++) {
			if(listaVendita.get(i).getCodiceVendita().equalsIgnoreCase(codiceVendita)) {
				listaVendita.remove(i);
			}
		}
	}
	
	
	/**
	 * Modifica le informazioni di una vendita, chiedendone l'inserimento.
	 * @param listaVendita
	 * @param vendita
	 * @throws ParseException
	 */
	public static void modificaVendita(List<Vendita> listaVendita, Vendita vendita) throws ParseException {
		System.out.println("Vendita da modificare: " + vendita.toString());
		eliminaVendita(listaVendita, vendita);
		aggiungiVendita(listaVendita);		 
	}
	
	
	
	
	/**
	 * Modifica le informazioni di una vendita, chiedendone l'inserimento.
	 * @param listaVendita
	 * @param codiceVendita
	 */
	public static void modificaVendita(List<Vendita> listaVendita, String codiceVendita) {
		try {
			
			Vendita vendita = getVenditaByCodice(listaVendita, codiceVendita);
			System.out.println("Vendita da modificare: " + vendita.toString());
			eliminaVendita(listaVendita, codiceVendita);
			aggiungiVendita(listaVendita);	
		
		} catch (Exception e) {
			System.err.println("Errore " + e.getMessage());
		}		 
	}
	
	
	/**
	 * Visualizza le informazioni delle vendite registrate.
	 * @param listaVendita
	 */
	public static void visualizzaVenditeRegistrate(List<Vendita> listaVendita) {
		for(Vendita vendita : listaVendita) {
			System.out.println(vendita.toString());
		}
		
		Collections.sort(listaVendita);
		Collections.sort(listaVendita, new prezzoVenditaComparator());
		
		System.out.print("\nORDINATO PER TIPO MONOPATTINO E PREZZO VENDITA PIU' BASSO\n");
		Collections.sort(listaVendita);
		
		for(Vendita vendita : listaVendita) {
			System.out.println(vendita.toString());
		}
		
		
		
	}
	
	
	/**
	 * Visualizza le informazioni di una vendita registrata.
	 * @param listaVendita
	 * @param codiceVendita
	 */
	public static void visualizzaVenditaRegistrata(List<Vendita> listaVendita, String codiceVendita) {
		Vendita v;
		try {
			v = getVenditaByCodice(listaVendita, codiceVendita);
			System.out.println(v.toString());
		} catch (Exception e) {
			System.err.println("Errore " + e.getMessage());
		}
		
	}
	
	
	
	/**
	 * Restituisce la vendita dato il codice.
	 * @param listaVendita
	 * @param codiceVendita
	 * @return
	 * @throws Exception
	 */
	public static Vendita getVenditaByCodice(List<Vendita> listaVendita, String codiceVendita) throws Exception {
		for(int i = 0; i < listaVendita.size(); i++) {
			if(listaVendita.get(i).getCodiceVendita().equalsIgnoreCase(codiceVendita)) {
				return listaVendita.get(i);
			}
		}	
		throw new Exception("Vendita " + codiceVendita + " non trovata");
	}
	
	
	
	/**
	 * Salva la lista di ogni vendita.
	 * @param listaVendita
	 * @throws IOException
	 */
    public static void salvaListaVendita(List<Vendita> listaVendita) throws IOException {
    	
    	try {
    		FileWriter writer = new FileWriter("Lista Vendita.csv");
    		PrintWriter out = new PrintWriter(writer);
    		
    		out.print("CODICE VENDITA");
			out.append(';');
    		out.print("MONOPATTINO VENDUTO");
			out.append(';');
			out.print("TIPO MONOPATTINO");
			out.append(';');
			out.print("CLIENTE");
			out.append(';');
			out.print("DATA VENDITA");
			out.append(';');
			out.print("PREZZO");
			out.append(';');
			out.println("DIPENDENTE CHE EFFETTUA LA VENDITA");
			
			Collections.sort(listaVendita);
			Collections.sort(listaVendita, new prezzoVenditaComparator());
			Collections.sort(listaVendita);
			
    		
    		for(Vendita vendita : listaVendita) {
    			
    			out.print(vendita.getCodiceVendita());
    			out.append(';');
    			out.print(vendita.getMonopattinoVenduto());
    			out.append(';');
    			out.print(vendita.getTipoMonopattino());
    			out.append(';');
    			out.print(vendita.getClienteAcquirente());
    			out.append(';');
    			out.print(vendita.getDataVendita());
    			out.append(';');
    			out.print(vendita.getPrezzoVendita());
    			out.append(';');
    			out.println(vendita.getDipendenteVendita());
    			
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
