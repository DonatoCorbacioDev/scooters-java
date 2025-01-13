package it.uniba.monopattini.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import it.uniba.monopattini.business.Cliente;

public class FunzioniClienti {

	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Aggiunge un cliente nuovo alla lista dei clienti registrati.
	 * @param listaClienti
	 * @throws ParseException
	 */
	public static void aggiungiCliente(List<Cliente> listaClienti) throws ParseException  {
		Cliente c = new Cliente();
		
		System.out.println("Inserire Cognome");
		String cognome = scanner.nextLine();
		System.out.println("Inserire Nome");
		String nome = scanner.nextLine();
		System.out.println("Inserire Sesso");
		String sesso= scanner.nextLine();
		System.out.println("Inserire Luogo di Nascita");
		String luogoNascita = scanner.nextLine();
		System.out.println("Inserire Provincia");
		String provincia = scanner.nextLine();
		System.out.println("Inserire Data di Nascita");
		String dataNascita = scanner.nextLine();
		Date dataNascitaCliente = DateUtils.parseDate(dataNascita);
		
		c.setCognome(cognome);
		c.setNome(nome);
		c.setSesso(sesso);
		c.setLuogoNascita(luogoNascita);
		c.setProvincia(provincia);
		c.setDataNascita(dataNascitaCliente);
		
		boolean inserimentoCodiceCorretto = false;
		
		while(!inserimentoCodiceCorretto) {
			try {
				System.out.println("Inserire codice Fiscale");
				String codiceFiscalePersona = scanner.nextLine();
				c.setCodiceFiscalePersona(codiceFiscalePersona);
				inserimentoCodiceCorretto = true;
			} catch (Exception e) {
				//e.printStackTrace();
				inserimentoCodiceCorretto = false;
				System.err.println("Errore " + e.getMessage());
			}
		}
		
		listaClienti.add(c);
	}
	
	
	/**
	 * Elimina un cliente dalla lista dei clienti registrati, se non presente non fa nulla.
	 * @param listaClienti
	 * @param cliente
	 */
	public static void eliminaCliente(List<Cliente> listaClienti, Cliente cliente) {	
		for(int i = 0; i < listaClienti.size(); i++) {
			if(listaClienti.get(i).compareTo(cliente) == 0) {
				listaClienti.remove(i);
			}
		}
	}
	

	/**
	 * Elimina un cliente dalla lista dei clienti registrati, se non presente non fa nulla.
	 * @param listaClienti
	 * @param codiceFiscalePersona
	 */
	public static void eliminaCliente(List<Cliente> listaClienti, String codiceFiscalePersona) {
		for(int i = 0; i < listaClienti.size(); i++) {
			if(listaClienti.get(i).getCodiceFiscalePersona().equalsIgnoreCase(codiceFiscalePersona)) {
				listaClienti.remove(i);
			}
		}
	}
	
	
	/**
	 * Modifica le informazioni di un cliente, chiedendone l'inserimento.
	 * @param listaClienti
	 * @param cliente
	 * @throws ParseException
	 */
	public static void modificaCliente(List<Cliente> listaClienti, Cliente cliente) throws ParseException {
		System.out.println("Cliente da modificare: " + cliente.toString());
		eliminaCliente(listaClienti, cliente);
		aggiungiCliente(listaClienti);		 
	}
	
	
	/**
	 * Modifica le informazioni di un cliente, chiedendone l'inserimento.
	 * @param listaClienti
	 * @param codiceFiscalePersona
	 */
	public static void modificaCliente(List<Cliente> listaClienti, String codiceFiscalePersona) {
		try {
			
			Cliente cliente = getClienteByCodice(listaClienti, codiceFiscalePersona);
			System.out.println("Cliente da modificare: " + cliente.toString());
			eliminaCliente(listaClienti, codiceFiscalePersona);
			aggiungiCliente(listaClienti);	
		
		} catch (Exception e) {
			System.err.println("Errore " + e.getMessage());
		}		 
	}
	
	
	/**
	 * Visualizza le informazioni dei clienti registrati.
	 * @param listaClienti
	 */
	public static void visualizzaClientiRegistrati(List<Cliente> listaClienti) {
		for(Cliente cliente : listaClienti) {
			System.out.println(cliente.toString());
		}
		
		System.out.print("\nORDINATO PER COGNOME\n");
		Collections.sort(listaClienti);
		
		for(Cliente cliente : listaClienti) {
			System.out.println(cliente.toString());
		}
		
	}
	
	
	/**
	 * Visualizza le informazioni di un cliente registrato.
	 * @param listaClienti
	 * @param codiceFiscalePersona
	 */
	public static void visualizzaClienteRegistrato(List<Cliente> listaClienti, String codiceFiscalePersona) {
		Cliente c;
		try {
			c = getClienteByCodice(listaClienti, codiceFiscalePersona);
			System.out.println(c.toString());
		} catch (Exception e) {
			System.err.println("Errore " + e.getMessage());
		}
		
	}
	
	/**
	 * Serializza i dati dei clienti in un unico file.
	 * @param listaDipendenti
	 * @throws IOException
	 */
	public static void serializzazioneClientiRegistrati(List<Cliente> listaClienti) throws IOException {
		
		Collections.sort(listaClienti);
		FileOutputStream outFile;
		outFile = new FileOutputStream("Lista Clienti.dat");
		ObjectOutputStream outStream = new ObjectOutputStream(outFile);
		outStream.writeObject(listaClienti);
		outFile.close();
		outStream.close();
	}
	
	
	/**
	 * Salva tutti i dati dei clienti registrati.
	 * @param listaDipendenti
	 * @throws IOException
	 */
    public static void salvaClientiRegistrati(List<Cliente> listaClienti) throws IOException {
    	
    	try {
    		FileWriter writer = new FileWriter("Lista Clienti.csv");
    		PrintWriter out = new PrintWriter(writer);
    		
    		out.print("CODICE FISCALE");
			out.append(';');
			out.print("COGNOME");
			out.append(';');
			out.print("NOME");
			out.append(';');
			out.print("SESSO");
			out.append(';');
			out.print("LUOGO DI NASCITA");
			out.append(';');
			out.print("PROVINCIA");
			out.append(';');
			out.println("DATA DI NASCITA");
			
			Collections.sort(listaClienti);
    		
    		for(Cliente cliente : listaClienti) {
    			
    			out.print(cliente.getCodiceFiscalePersona());
    			out.append(';');
    			out.print(cliente.getCognome());
    			out.append(';');
    			out.print(cliente.getNome());
    			out.append(';');
    			out.print(cliente.getSesso());
    			out.append(';');
    			out.print(cliente.getLuogoNascita());
    			out.append(';');
    			out.print(cliente.getProvincia());
    			out.append(';');
    			out.println(cliente.getDataNascita());
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
     * Carica tutti i dati dei clienti registrati da un unico file.
     * @param listaClienti
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void caricaClientiRegistrati(List<Cliente> listaClienti) throws FileNotFoundException, IOException, ClassNotFoundException {
   	 FileInputStream inFile;
   	 inFile = new FileInputStream("Lista Clienti.dat");
   	 ObjectInputStream inStream = new ObjectInputStream(inFile);
        inStream.readObject();
        inStream.close();
       }
    
	
	
	/**
	 * Restituisce il cliente dato il suo codice fiscale.
	 * @param listaClienti
	 * @param codiceFiscalePersona
	 * @return cliente trovato
	 * @throws Exception
	 */
	public static Cliente getClienteByCodice(List<Cliente> listaClienti, String codiceFiscalePersona) throws Exception {
		for(int i = 0; i < listaClienti.size(); i++) {
			if(listaClienti.get(i).getCodiceFiscalePersona().equalsIgnoreCase(codiceFiscalePersona)) {
				return listaClienti.get(i);
			}
		}	
		throw new Exception("Cliente " + codiceFiscalePersona + " non trovato");
	}
	
	
	//----------------------------------------------------------------------------------------------
	
}
