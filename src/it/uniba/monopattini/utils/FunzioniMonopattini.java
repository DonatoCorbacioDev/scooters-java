package it.uniba.monopattini.utils;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import it.uniba.monopattini.business.Monopattino;
import it.uniba.monopattini.business.MonopattinoAvanzato;
import it.uniba.monopattini.business.MonopattinoMedio;

public class FunzioniMonopattini {
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * 
	 * Aggiunge un monopattino base nuovo alla lista dei monopattini registrati.
	 * @param listaMonopattiniBase
	 */
	public static void aggiungiMonopattinoBase(List<Monopattino> listaMonopattiniBase) {
		Monopattino mb = new Monopattino();
		System.out.println("Inserire Marca");
		String marca = scanner.nextLine();
		System.out.println("Inserire Modello");
		String cognome = scanner.nextLine();
		String codice = mb.getCodice();
		
		mb.setMarca(marca);
		mb.setModello(cognome);
		mb.setCodice(codice);
		
		
		listaMonopattiniBase.add(mb);
	}
 
	
	/**
	 * 
	 * Aggiunge un monopattino medio alla lista dei monopattini registrati.
	 * @param listaMonopattiniMedi
	 */
	public static void aggiungiMonopattinoMedio(List<MonopattinoMedio> listaMonopattiniMedi) {
		MonopattinoMedio mm = new MonopattinoMedio();
		System.out.println("Inserire Marca");
		String marca = scanner.nextLine();
		System.out.println("Inserire Modello");
		String cognome = scanner.nextLine();
		System.out.println("Inserire Posizione Freni a Disco");
		String freniDisco = scanner.nextLine();
		String codice = mm.getCodice();
		
		mm.setCodice(codice);
		mm.setMarca(marca);
		mm.setModello(cognome);
		mm.setFreniDisco(freniDisco);
		
        
		listaMonopattiniMedi.add(mm);	
	}
	
	
	
	/**
	 * 
	 * Aggiunge un monopattino avanzato nuovo alla lista dei monopattini registrati.
	 * @param listaMonopattiniAvanzati
	 */
	public static void aggiungiMonopattinoAvanzato(List<MonopattinoAvanzato> listaMonopattiniAvanzati) {
		MonopattinoAvanzato ma = new MonopattinoAvanzato();
		System.out.println("Inserire Marca");
		String marca = scanner.nextLine();
		System.out.println("Inserire Modello");
		String cognome = scanner.nextLine();
		System.out.println("Inserire Posizione Freni a Disco");
		String freniDisco = scanner.nextLine();
		System.out.println("Inserire Tipo Contachilometri");
		String contachilometri = scanner.nextLine();
		String codice = ma.getCodice();
		
		ma.setCodice(codice);
		ma.setMarca(marca);
		ma.setModello(cognome);
		ma.setFreniDisco(freniDisco);
		ma.setContachilometri(contachilometri);
		
		
       
		
		listaMonopattiniAvanzati.add(ma);
	}
	
	/**
	 * 
	 * Elimina un monopattino base dalla lista dei monopattini registrati, se non presente non fa nulla.
	 * @param listaMonopattiniBase
	 * @param monopattino
	 */
	public static void eliminaMonopattinoBase(List<Monopattino> listaMonopattiniBase, Monopattino monopattino) {
		for(int i = 0; i < listaMonopattiniBase.size(); i++) {
			if(listaMonopattiniBase.get(i).compareTo(monopattino) == 0) {
				listaMonopattiniBase.remove(i);
			}
		}
	}
	
	
	/**
	 * 
	 * Elimina un monopattino base dalla lista dei monopattini registrati, se non presente non fa nulla.
	 * @param listaMonopattiniBase
	 * @param codice
	 */
	public static void eliminaMonopattinoBase(List<Monopattino> listaMonopattiniBase, String codice) {
		for(int i = 0; i < listaMonopattiniBase.size(); i++) {
			if(listaMonopattiniBase.get(i).getCodice().equalsIgnoreCase(codice)) {
				listaMonopattiniBase.remove(i);
			}
		}
	}
	
	
	/**
	 * 
	 * Elimina un monopattino medio dalla lista dei monopattini registrati, se non presente non fa nulla.
	 * @param listaMonopattiniMedi
	 * @param monopattinoMedio
	 */
	public static void eliminaMonopattinoMedio(List<MonopattinoMedio> listaMonopattiniMedi, MonopattinoMedio monopattinoMedio) {
		for(int i = 0; i < listaMonopattiniMedi.size(); i++) {
			if(listaMonopattiniMedi.get(i).compareTo(monopattinoMedio) == 0) {
				listaMonopattiniMedi.remove(i);
			}
		}
	}
	
	
	/**
	 * 
	 * Elimina un monopattino medio dalla lista dei monopattini registrati, se non presente non fa nulla.
	 * @param listaMonopattiniMedi
	 * @param codice
	 */
    public static void eliminaMonopattinoMedio(List<MonopattinoMedio> listaMonopattiniMedi, String codice) {
    	for(int i = 0; i < listaMonopattiniMedi.size(); i++) {
			if(listaMonopattiniMedi.get(i).getCodice().equalsIgnoreCase(codice)) {
				listaMonopattiniMedi.remove(i);
			}
		}
	}
    
    
    /**
     * 
     * Elimina un monopattino avanzato dalla lista dei monopattini registrati, se non presente non fa nulla.
     * @param listaMonopattiniAvanzati
     * @param monopattinoAvanzato
     */
    public static void eliminaMonopattinoAvanzato(List<MonopattinoAvanzato> listaMonopattiniAvanzati, MonopattinoAvanzato 
    		monopattinoAvanzato) {
    	for(int i = 0; i < listaMonopattiniAvanzati.size(); i++) {
			if(listaMonopattiniAvanzati.get(i).compareTo(monopattinoAvanzato) == 0) {
				listaMonopattiniAvanzati.remove(i);
			}
		}
    }
    
    
    /**
     * 
     * Elimina un monopattino avanzato dalla lista dei monopattini registrati, se non presente non fa nulla.
     * @param listaMonopattiniAvanzati
     * @param codice
     */
    public static void eliminaMonopattinoAvanzato(List<MonopattinoAvanzato> listaMonopattiniAvanzati, String codice) {
    	for(int i = 0; i < listaMonopattiniAvanzati.size(); i++) {
			if(listaMonopattiniAvanzati.get(i).getCodice().equalsIgnoreCase(codice)) {
				listaMonopattiniAvanzati.remove(i);
			}
		}
	}
    
    /**
     * 
     *Modifica le informazioni di un monopattino base, chiedendone l'inserimento.
     * @param listaMonopattiniBase
     * @param monopattino
     */
    public static void modificaMonopattinoBase(List<Monopattino> listaMonopattiniBase, Monopattino monopattino) {
    	System.out.println("Monopattino Base da modificare: " + monopattino.toString());
    	eliminaMonopattinoBase(listaMonopattiniBase, monopattino);
    	aggiungiMonopattinoBase(listaMonopattiniBase);
    }
	
    
    /**
     * 
     * Modifica le informazioni di un monopattino base, chiedendone l'inserimento.
     * @param listaMonopattiniBase
     * @param codice
     */
    public static void modificaMonopattinoBase(List<Monopattino> listaMonopattiniBase, String codice) {
		try {
			
			Monopattino monopattino = getMonopattinoBaseByCodice(listaMonopattiniBase, codice);
			System.out.println("Monopattino Base da modificare: " + monopattino.toString());
			eliminaMonopattinoBase(listaMonopattiniBase, monopattino);
	    	aggiungiMonopattinoBase(listaMonopattiniBase);
			
		
		} catch (Exception e) {
			System.err.println("Errore " + e.getMessage());
		}		 
	}
    
    
    /**
     * 
     * Restituisce il monopattino base dato il suo codice.
     * @param listaMonopattiniBase
     * @param codice
     * @return
     * @throws Exception
     */
    public static Monopattino getMonopattinoBaseByCodice(List<Monopattino> listaMonopattiniBase, String codice) throws Exception {
		for(int i = 0; i < listaMonopattiniBase.size(); i++) {
			if(listaMonopattiniBase.get(i).getCodice().equalsIgnoreCase(codice)) {
				return listaMonopattiniBase.get(i);
			}
		}	
		throw new Exception("Monopattino Base " + codice+ " non trovato");
	}
    
    
    /**
     * 
     * Modifica le informazioni di un monopattino medio, chiedendone l'inserimento.
     * @param listaMonopattiniMedi
     * @param monopattinoMedio
     */
    public static void modificaMonopattinoMedio(List<MonopattinoMedio> listaMonopattiniMedi, MonopattinoMedio monopattinoMedio) {
    	System.out.println("Monopattino Medio da modificare: " + monopattinoMedio.toString());
    	eliminaMonopattinoMedio(listaMonopattiniMedi, monopattinoMedio);
    	aggiungiMonopattinoMedio(listaMonopattiniMedi);
    }
    
    
    
    /**
     * 
     * Modifica le informazioni di un monopattino medio, chiedendone l'inserimento.
     * @param listaMonopattiniMedi
     * @param codice
     */
    public static void modificaMonopattinoMedio(List<MonopattinoMedio> listaMonopattiniMedi, String codice) {
		try {
			
			MonopattinoMedio monopattinoMedio = (MonopattinoMedio) getMonopattinoMedioByCodice(listaMonopattiniMedi, codice);
			System.out.println("Monopattino Medio da modificare: " + monopattinoMedio.toString());
			eliminaMonopattinoMedio(listaMonopattiniMedi, monopattinoMedio);
	    	aggiungiMonopattinoMedio(listaMonopattiniMedi);
			
		
		} catch (Exception e) {
			System.err.println("Errore " + e.getMessage());
		}		 
	}
    
    
    /**
     * Restituisce il monopattino medio dato il suo codice.
     * @param listaMonopattiniMedi
     * @param codice
     * @return
     * @throws Exception
     */
    public static Monopattino getMonopattinoMedioByCodice(List<MonopattinoMedio> listaMonopattiniMedi, String codice) throws Exception {
		for(int i = 0; i < listaMonopattiniMedi.size(); i++) {
			if(listaMonopattiniMedi.get(i).getCodice().equalsIgnoreCase(codice)) {
				return listaMonopattiniMedi.get(i);
			}
		}	
		throw new Exception("Monopattino Medio " + codice+ " non trovato");
	}
    
    
    /**
     * 
     * Modifica le informazioni di un monopattino avanzato, chiedendone l'inserimento.
     * @param listaMonopattiniAvanzati
     * @param monopattinoAvanzato
     */
    public static void modificaMonopattinoAvanzato(List<MonopattinoAvanzato> listaMonopattiniAvanzati, MonopattinoAvanzato monopattinoAvanzato) {
    	System.out.println("Monopattino Avanzato da modificare: " + monopattinoAvanzato.toString());
    	eliminaMonopattinoAvanzato(listaMonopattiniAvanzati, monopattinoAvanzato);
    	aggiungiMonopattinoAvanzato(listaMonopattiniAvanzati);
    }
    
    
    /**
     * 
     * Modifica le informazioni di un monopattino avanzato, chiedendone l'inserimento.
     * @param listaMonopattiniAvanzati
     * @param codice
     */
    public static void modificaMonopattinoAvanzato(List<MonopattinoAvanzato> listaMonopattiniAvanzati, String codice) {
		try {
			
			MonopattinoAvanzato monopattinoAvanzato = (MonopattinoAvanzato) getMonopattinoAvanzatoByCodice(listaMonopattiniAvanzati, codice);
			System.out.println("Monopattino Avanzato da modificare: " + monopattinoAvanzato.toString());
			eliminaMonopattinoAvanzato(listaMonopattiniAvanzati, monopattinoAvanzato);
	    	aggiungiMonopattinoAvanzato(listaMonopattiniAvanzati);
			
		
		} catch (Exception e) {
			System.err.println("Errore " + e.getMessage());
		}		 
	}
    
    
    /**
     * 
     * Restituisce il monopattino avanzato dato il suo codice.
     * @param listaMonopattiniAvanzati
     * @param codice
     * @return
     * @throws Exception
     */
    public static Monopattino getMonopattinoAvanzatoByCodice(List<MonopattinoAvanzato> listaMonopattiniAvanzati, String codice) throws Exception {
		for(int i = 0; i < listaMonopattiniAvanzati.size(); i++) {
			if(listaMonopattiniAvanzati.get(i).getCodice().equalsIgnoreCase(codice)) {
				return listaMonopattiniAvanzati.get(i);
			}
		}	
		throw new Exception("Monopattino Avanzato " + codice+ " non trovato");
	}
    
    
    /**
     * 
     * Visualizza le informazioni dei monopattini base registrati.
     * @param listaMonopattiniBase
     */
    public static void visualizzaMonopattiniBaseRegistrati(List<Monopattino> listaMonopattiniBase) {
		for(Monopattino monopattino : listaMonopattiniBase) {
			System.out.println(monopattino.toString());
		}
	}
    
    
    /**
     * 
     * Visualizza le informazioni dei monopattini medi registrati.
     * @param listaMonopattiniMedi
     */
    public static void visualizzaMonopattiniMediRegistrati(List<MonopattinoMedio> listaMonopattiniMedi) {
		for(MonopattinoMedio monopattinoMedio : listaMonopattiniMedi) {
			System.out.println(monopattinoMedio.toString());
		}
	}
    
    
    /**
     * 
     * Visualizza le informazioni dei monopattini avanzati registrati.
     * @param listaMonopattiniAvanzati
     */
    public static void visualizzaMonopattiniAvanzatiRegistrati(List<MonopattinoAvanzato> listaMonopattiniAvanzati) {
		for(MonopattinoAvanzato monopattinoAvanzato : listaMonopattiniAvanzati) {
			System.out.println(monopattinoAvanzato.toString());
		}
	}
    
    
    /**
     * 
     * Visualizza le informazioni di un monopattino base registrato.
     * @param listaMonopattiniBase
     * @param codice
     */
    public static void visualizzaMonopattinoBaseRegistrato(List<Monopattino> listaMonopattiniBase, String codice) {
		Monopattino mb;
		try {
			mb = getMonopattinoBaseByCodice(listaMonopattiniBase, codice);
			System.out.println(mb.toString());
		} catch (Exception e) {
			System.err.println("Errore " + e.getMessage());
		}
		
	}
    
    
    /**
     * 
     * Visualizza le informazioni di un monopattino medio registrato.
     * @param listaMonopattiniMedi
     * @param codice
     */
    public static void visualizzaMonopattinoMedioRegistrato(List<MonopattinoMedio> listaMonopattiniMedi, String codice) {
		Monopattino mm;
		try {
			mm = getMonopattinoMedioByCodice(listaMonopattiniMedi, codice);
			System.out.println(mm.toString());
		} catch (Exception e) {
			System.err.println("Errore " + e.getMessage());
		}
		
	}
    
    
    /**
     * 
     * Visualizza le informazioni di un monopattino avanzato registrato.
     * @param listaMonopattiniAvanzati
     * @param codice
     */
    public static void visualizzaMonopattinoAvanzatoRegistrato(List<MonopattinoAvanzato> listaMonopattiniAvanzati, String codice) {
		Monopattino ma;
		try {
			ma = getMonopattinoAvanzatoByCodice(listaMonopattiniAvanzati, codice);
			System.out.println(ma.toString());
		} catch (Exception e) {
			System.err.println("Errore " + e.getMessage());
		}
		
	}
    
    
    /**
     * Salva tutti i dati dei monopattini base registrati.
     * @param listaMonopattiniBase
     * @throws IOException
     */
    public static void salvaMonopattiniBaseRegistrati(List<Monopattino> listaMonopattiniBase) throws IOException {
    	
    	try {
    		FileWriter writer = new FileWriter("Lista Monopattini.csv");
    		PrintWriter out = new PrintWriter(writer);
    		
    		out.print("CODICE");
			out.append(';');
			out.print("MARCA");
			out.append(';');
			out.println("MODELLO");
    		
    		for(Monopattino monopattino : listaMonopattiniBase) {
    			
    			
    			out.print(monopattino.getCodice());
    			out.append(';');
    			out.print(monopattino.getMarca());
    			out.append(';');
    			out.println(monopattino.getModello());
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
     * Salva tutti i dati dei monopattini medi registrati.
     * @param listaMonopattiniMedi
     * @throws IOException
     */
     public static void salvaMonopattiniMediRegistrati(List<MonopattinoMedio> listaMonopattiniMedi) throws IOException {
    	
    	try {
    		FileWriter writer = new FileWriter("Lista Monopattini Medi.csv");
    		PrintWriter out = new PrintWriter(writer);
    		
    		out.print("CODICE");
			out.append(';');
			out.print("MARCA");
			out.append(';');
			out.print("MODELLO");
			out.append(';');
			out.println("POSIZIONE FRENI A DISCO");
			
    		
    		for(MonopattinoMedio monopattinoMedio : listaMonopattiniMedi) {
    			
    			out.print(monopattinoMedio.getCodice());
    			out.append(';');
    			out.print(monopattinoMedio.getMarca());
    			out.append(';');
    			out.print(monopattinoMedio.getModello());
    			out.append(';');
    			out.println(monopattinoMedio.getFreniDisco());
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
      * Salva tutti i dati dei monopattini avanzati registrati.
      * @param listaMonopattiniAvanzati
      * @throws IOException
      */
     public static void salvaMonopattiniAvanzatiRegistrati(List<MonopattinoAvanzato> listaMonopattiniAvanzati)
    		 throws IOException {
     	
     	try {
     		FileWriter writer = new FileWriter("Lista Monopattini Avanzati.csv");
     		PrintWriter out = new PrintWriter(writer);
     		
     		out.print("CODICE");
 			out.append(';');
 			out.print("MARCA");
 			out.append(';');
 			out.print("MODELLO");
 			out.append(';');
 			out.print("POSIZIONE FRENI A DISCO");
 			out.append(';');
 			out.println("TIPO CONTACHILOMETRI");
 			
 			
     		
     		for(MonopattinoAvanzato monopattinoAvanzato : listaMonopattiniAvanzati) {
     			
     			out.print(monopattinoAvanzato.getCodice());
     			out.append(';');
     			out.print(monopattinoAvanzato.getMarca());
     			out.append(';');
     			out.print(monopattinoAvanzato.getModello());
     			out.append(';');
     			out.print(monopattinoAvanzato.getFreniDisco());
     			out.append(';');
     			out.println(monopattinoAvanzato.getContachilometri());
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
