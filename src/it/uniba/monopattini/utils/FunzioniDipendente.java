package it.uniba.monopattini.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import it.uniba.monopattini.business.Dipendente;

public class FunzioniDipendente {
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Aggiunge un dipendente nuovo alla lista dei dipendenti registrati.
	 * @param listaDipendenti
	 */
	public static void aggiungiDipendente(List<Dipendente> listaDipendenti) {
		Dipendente d = new Dipendente();
		System.out.println("Inserire Cognome");
		String cognome = scanner.nextLine();
		System.out.println("Inserire Nome");
		String nome = scanner.nextLine();
		
		d.setCognome(cognome);
		d.setNome(nome);
		
		
		boolean inserimentoCodiceCorretto = false;
		
		while(!inserimentoCodiceCorretto) {
			try {
				System.out.println("Inserire codice univoco");
				String codice = scanner.nextLine();
				d.setCodiceDipendente(codice);
				inserimentoCodiceCorretto = true;
			} catch (Exception e) {
				//e.printStackTrace();
				inserimentoCodiceCorretto = false;
				System.err.println("Errore " + e.getMessage());
			}
		}
		
		listaDipendenti.add(d);
	}
	
	
	/**
	 * Elimina un dipendente dalla lista dei dipendenti registrati, se non presente non fa nulla.
	 * @param listaDipendenti
	 * @param dipendente
	 */
	public static void eliminaDipendente(List<Dipendente> listaDipendenti, Dipendente dipendente) {	
		for(int i = 0; i < listaDipendenti.size(); i++) {
			if(listaDipendenti.get(i).compareTo(dipendente) == 0) {
				listaDipendenti.remove(i);
			}
		}
	}
	
	
	
	/**
	 * Elimina un dipendente dalla lista dei dipendenti registrati, se non presente non fa nulla.
	 * @param listaDipendenti
	 * @param codiceDipendente
	 */
	public static void eliminaDipendente(List<Dipendente> listaDipendenti, String codiceDipendente) {
		for(int i = 0; i < listaDipendenti.size(); i++) {
			if(listaDipendenti.get(i).getCodiceDipendente().equalsIgnoreCase(codiceDipendente)) {
				listaDipendenti.remove(i);
			}
		}
	}
	
	
	/**
	 * Modifica le informazioni di un dipendente, chiedendone l'inserimento.
	 * @param listaDipendenti
	 * @param dipendente
	 */
	public static void modificaDipendente(List<Dipendente> listaDipendenti, Dipendente dipendente) {
		System.out.println("Dipendente da modificare: " + dipendente.toString());
		eliminaDipendente(listaDipendenti, dipendente);
		aggiungiDipendente(listaDipendenti);		 
	}
	
	
	/**
	 * Modifica le informazioni di un dipendente, chiedendone l'inserimento.
	 * @param listaDipendenti
	 * @param dipendente
	 */
	public static void modificaDipendente(List<Dipendente> listaDipendenti, String codiceDipendente) {
		try {
			
			Dipendente dipendente = getDipendenteByCodice(listaDipendenti, codiceDipendente);
			System.out.println("Dipendente da modificare: " + dipendente.toString());
			eliminaDipendente(listaDipendenti, codiceDipendente);
			aggiungiDipendente(listaDipendenti);	
		
		} catch (Exception e) {
			System.err.println("Errore " + e.getMessage());
		}		 
	}
	
	
	/**
	 * Visualizza le informazioni dei dipendenti registrati.
	 * @param listaDipendenti
	 */
	public static void visualizzaDipendentiRegistrati(List<Dipendente> listaDipendenti) {
		
		Collections.sort(listaDipendenti);
		
		for(Dipendente dipendente : listaDipendenti) {
			System.out.println(dipendente.toString());
		}
	}
	
	/**
	 * Visualizza le informazioni di un dipendente registrato.
	 * @param listaDipendenti
	 */
	public static void visualizzaDipendenteRegistrato(List<Dipendente> listaDipendenti, String codiceDipendente) {
		Dipendente d;
		try {
			d = getDipendenteByCodice(listaDipendenti, codiceDipendente);
			System.out.println(d.toString());
		} catch (Exception e) {
			System.err.println("Errore " + e.getMessage());
		}
		
	}
	
	/**
	 * Serializza i dati dei dipendenti o venditori in un unico file.
	 * @param listaDipendenti
	 * @throws IOException
	 */
	public static void serializzazioneDipendentiRegistrati(List<Dipendente> listaDipendenti) throws IOException {
		
		FileOutputStream outFile;
		outFile = new FileOutputStream("Lista Dipendenti.dat");
		ObjectOutputStream outStream = new ObjectOutputStream(outFile);
		outStream.writeObject(listaDipendenti);
		outFile.close();
		outStream.close();
	}
	
	
	/**
	 * Salva tutti i dati dei dipendenti registrati.
	 * @param listaDipendenti
	 * @throws IOException
	 */
    public static void salvaDipendentiRegistrati(List<Dipendente> listaDipendenti) throws IOException {
    	
    	try {
    		FileWriter writer = new FileWriter("Lista Dipendenti.csv");
    		PrintWriter out = new PrintWriter(writer);
    		
    		out.print("CODICE DIPENDENTE");
			out.append(';');
			out.print("COGNOME");
			out.append(';');
			out.println("NOME");
			
			Collections.sort(listaDipendenti);
    		
    		for(Dipendente dipendente : listaDipendenti) {
    			
    			out.print(dipendente.getCodiceDipendente());
    			out.append(';');
    			out.print(dipendente.getCognome());
    			out.append(';');
    			out.println(dipendente.getNome());
    		}
    		
    		out.flush();
        	out.close();
        	writer.close();
    			
    	}
        	catch(Exception e) {
    		System.err.println("Errore " + e.getMessage());
    	}
	}
    
    
    /**
     * Carica tutti i dati dei dipendenti registrati da un unico file.
     * @param listaDipendenti
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void caricaDipendentiRegistrati(List<Dipendente> listaDipendenti) throws FileNotFoundException, IOException, ClassNotFoundException {
	 FileInputStream inFile;
	 inFile = new FileInputStream("Lista Dipendenti.dat");
	 ObjectInputStream inStream = new ObjectInputStream(inFile);
     inStream.readObject();
     inStream.close();
    }
	
	
	/**
	 * Restituisce il dipendente dato il suo codice.
	 * @param listaDipendenti
	 * @param codiceDipendente
	 * @return dipendente trovato
	 * @throws Exception
	 */
	public static Dipendente getDipendenteByCodice(List<Dipendente> listaDipendenti, String codiceDipendente) throws Exception {
		for(int i = 0; i < listaDipendenti.size(); i++) {
			if(listaDipendenti.get(i).getCodiceDipendente().equalsIgnoreCase(codiceDipendente)) {
				return listaDipendenti.get(i);
			}
		}	
		throw new Exception("Dipendente " + codiceDipendente + " non trovato");
	}


	
	
	//----------------------------------------------------------------------------------------------
	
	
	
	
	
}
