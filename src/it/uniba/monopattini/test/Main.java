package it.uniba.monopattini.test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import it.uniba.monopattini.business.Cliente;
import it.uniba.monopattini.business.Dipendente;
import it.uniba.monopattini.business.Monopattino;
import it.uniba.monopattini.business.MonopattinoAvanzato;
import it.uniba.monopattini.business.MonopattinoMedio;
import it.uniba.monopattini.business.Noleggio;
import it.uniba.monopattini.business.Vendita;
import it.uniba.monopattini.utils.FunzioniClienti;
import it.uniba.monopattini.utils.FunzioniDipendente;
import it.uniba.monopattini.utils.FunzioniMonopattini;
import it.uniba.monopattini.utils.FunzioniNoleggio;
import it.uniba.monopattini.utils.FunzioniVendita;
import it.uniba.monopattini.utils.Initializator;

/**
 * Esecuzione del caso di studio.
 * @author Donato Corbacio
 *
 */
public class Main {
		
	private static Scanner scanner = new Scanner(System.in);
	private static List<Dipendente> listaDipendenti;
	private static List<MonopattinoMedio> listaMonopattiniMedi;
	private static List<MonopattinoAvanzato> listaMonopattiniAvanzati;
	private static List<Monopattino> listaMonopattiniBase;
	private static List<Cliente> listaClienti;
	private static List<Noleggio> listaNoleggio;
	private static List<Vendita> listaVendita;
	
	
	
	private static void init() {
		try {
			listaDipendenti = Initializator.getListaDipendenti();
			listaMonopattiniMedi = Initializator.getListaMonopattiniMedi();
			listaMonopattiniAvanzati = Initializator.getListaMonopattiniAvanzati();
			listaMonopattiniBase = Initializator.getListaMonopattiniBase();
			listaClienti = Initializator.getListaClienti();
			listaNoleggio = Initializator.getListaNoleggio();
			listaVendita = Initializator.getListaVendita();
		} catch (Exception e) {
			System.err.println("Errore durante inizializzazione " + e.getMessage());
		}
		
	}

	public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException {
		
		System.out.println("*****BENVENUTO SUL PORTALE AZIENDALE*****");
		
		System.out.println("\nL'applicazione permette di gestire nativamente i dati dei dipendenti, dei monopattini e dei clienti.");
		
		System.out.println("\nIl nostro scopo è di garantire un servizio efficiente all'azienda per le gestioni delle vendite"
				+ " e dei noleggi.");
		
		init();
		
		boolean exit = false;
		while(!exit) {
			
			System.out.println(
					"\nSeleziona l'operazione che si vuole effettuare."
					+ "\n\n(1) Gestione - Dati Dipendente"
					+ "\n(2) Gestione - Dati Monopattino"
					+ "\n(3) Gestione - Dati Cliente"
					+ "\n(4) Gestione - Vendita Monopattino"
					+ "\n(5) Gestione - Noleggio Monopattino"
					+ "\n(6) Esci"
					);
			
			int comando = scanner.nextInt();
			
			
			switch(comando) {
			
			case 1: 
				//Gestione Dati Dipendente
				
				boolean exit1 = false;
				while(!exit1) {
					
					System.out.println(
							"\n\nSelezione per la Gestione - Dati Dipendente"
							+ "\n\n(1) Inserimento Dipendente"
							+ "\n(2) Modifica Dipendente"
							+ "\n(3) Cancella Dipendente"
							+ "\n(4) Visualizza Dati Dipendente"
							+ "\n(5) Visualizza Dati di tutti i Dipendenti"
							+ "\n(6) Serializza Dati di tutti i Dipendenti"
							+ "\n(7) Carica Dati di tutti i Dipendenti"
							+ "\n(8) Salva Dati di tutti i Dipendenti"
							+ "\n(9) Torna indietro"
							);
					
					String codiceDipendenteInput;
					
					int commando1 = scanner.nextInt();
					
					switch(commando1) {
					
					case 1: 
						//Inserimento dipendente
						FunzioniDipendente.aggiungiDipendente(listaDipendenti);
						System.out.println("I dati del Dipendente sono stati inseriti");
						break;
						
					case 2: 
						//Modifica dipendente
						System.out.println("Inserire codice dipendente");
						scanner.nextLine();
						codiceDipendenteInput = scanner.nextLine();
						FunzioniDipendente.modificaDipendente(listaDipendenti, codiceDipendenteInput);
						System.out.println("I dati del Dipendente sono stati modificati");
						break;
						
					case 3: 
						//Cancella Dipendente
						System.out.println("Inserire codice dipendente");
						scanner.nextLine();
						codiceDipendenteInput = scanner.nextLine();
						FunzioniDipendente.eliminaDipendente(listaDipendenti, codiceDipendenteInput);
						System.out.println("I dati del Dipendente sono stati eliminati");
						break;
						
					case 4: 
						//Visualizza Dati Dipendente
						System.out.println("Inserire codice dipendente");
						scanner.nextLine();
						codiceDipendenteInput = scanner.nextLine();
						FunzioniDipendente.visualizzaDipendenteRegistrato(listaDipendenti, codiceDipendenteInput);
						break;
						
					case 5: 
						//Visualizza Dati di tutti i Dipendenti
						FunzioniDipendente.visualizzaDipendentiRegistrati(listaDipendenti);
						break;
						
					case 6:
						//Serializzazione Dati Dipendente
						FunzioniDipendente.serializzazioneDipendentiRegistrati(listaDipendenti);
						System.out.println("I dati dei Dipendenti sono stati serializzati in un unico file");
						break;
						
					case 7:
						//Carica Dati Dipendente
						FunzioniDipendente.caricaDipendentiRegistrati(listaDipendenti);
						System.out.println("I dati serializzati dei Dipendenti sono stati caricati ");
						break;
						
					case 8:
						//Salva Dati Dipendente
						FunzioniDipendente.salvaDipendentiRegistrati(listaDipendenti);
						System.out.println("I dati dei Dipendenti sono stati salvati in un unico file");
						break;
						
						
					case 9:
						//Torna indietro
						exit1 = true;
						System.out.println("Torna indietro...");
						break;
						
						//Comando di default
					default:
						System.err.println("Comando inserito non trovato");
						break;
					}
					
				}
				break;
					
				
				
				
				
			case 2: 
				//Gestione - Dati Monopattino
				
				boolean exit2 = false;
				while(!exit2) {
					
					System.out.println(
							"\n\nSelezione per la Gestione - Dati Monopattino"
							+ "\n\n(1) Dati Monopattino Base"
							+ "\n(2) Dati Monopattino Medio "
							+ "\n(3) Dati Monopattino Avanzato"
							+ "\n(4) Torna indietro"
							);
					
					
					int comando2 = scanner.nextInt();
					
				
				switch(comando2) {
				
				case 1:
					//Dati Monopattino Base
					
					boolean exit2mb = false;
					while(!exit2mb) {
						
						System.out.println(
								"\n\n** Dati Monopattino Base **"
								+ "\n\n(1) Inserimento Monopattino Base"
								+ "\n(2) Modifica Monopattino Base"
								+ "\n(3) Cancella Monopattino Base"
								+ "\n(4) Visualizza Dati Monopattino Base"
								+ "\n(5) Visualizza Dati di tutti i Monopattini Base"
								+ "\n(6) Salva Dati di tutti i Monopattini Base"
								+ "\n(7) Torna Indietro"
								);
						
						String codiceMonopattinoBaseInput;
						
						int comando2mb = scanner.nextInt();
						
						switch(comando2mb) {
						
						case 1:
							//Inserimento Monopattino Base
							FunzioniMonopattini.aggiungiMonopattinoBase(listaMonopattiniBase);
							System.out.println("I dati del Monopattino Base sono stati inseriti");
							break;
							
						case 2:
							//Modifica Monopattino Base
							System.out.println("Inserire codice monopattino base");
							scanner.nextLine();
							codiceMonopattinoBaseInput = scanner.nextLine();
							FunzioniMonopattini.modificaMonopattinoBase(listaMonopattiniBase, codiceMonopattinoBaseInput);
							System.out.println("I dati del Monopattino Base sono stati modificati");
							break;
							
						case 3:
							//Cancella Monopattino Base
							System.out.println("Inserire codice monopattino base");
							scanner.nextLine();
							codiceMonopattinoBaseInput = scanner.nextLine();
							FunzioniMonopattini.eliminaMonopattinoBase(listaMonopattiniBase, codiceMonopattinoBaseInput);
							System.out.println("I dati del Monopattino Base sono stati eliminati");
							break;
							
						case 4:
							//Visualizza Dati Monopattino Base
							System.out.println("Inserire codice monopattino base");
							scanner.nextLine();
							codiceMonopattinoBaseInput = scanner.nextLine();
							FunzioniMonopattini.visualizzaMonopattinoBaseRegistrato(listaMonopattiniBase, codiceMonopattinoBaseInput);
							break;
							
						case 5:
							//Visualizza Dati di tutti i Monopattini Base
							FunzioniMonopattini.visualizzaMonopattiniBaseRegistrati(listaMonopattiniBase);
							break;
							
						case 6:
							//Salva Dati Monopattino Base
							FunzioniMonopattini.salvaMonopattiniBaseRegistrati(listaMonopattiniBase);
							System.out.println("I dati dei Monopattini Base sono stati salvati in un unico file");
							break;
							
						case 7:
							//Torna indietro
							exit2mb = true;
							System.out.println("Torna indietro...");
							break;
							
						//Comando di default
						default:
							System.err.println("Comando inserito non trovato");
							break;
						}
					}
					break;
					
					
					
				case 2:
					//Dati Monopattino Medio
					
					boolean exit2mm = false;
					while(!exit2mm) {
						
						System.out.println(
								"\n\n** Dati Monopattino Medio **"
								+ "\n\n(1) Inserimento Monopattino Medio"
								+ "\n(2) Modifica Monopattino Medio"
								+ "\n(3) Cancella Monopattino Medio"
								+ "\n(4) Visualizza Dati Monopattino Medio"
								+ "\n(5) Visualizza Dati di tutti i Monopattini Medi"
								+ "\n(6) Salva Dati di tutti i Monopattini Medi"
								+ "\n(7) Torna indietro"
								);
						
						String codiceMonopattinoMedioInput;
						
                        int comando2mm = scanner.nextInt();
						
						switch(comando2mm) {
						
						case 1:
							//Inserimento Monopattino Medio
							FunzioniMonopattini.aggiungiMonopattinoMedio(listaMonopattiniMedi);
							System.out.println("I dati del Monopattino Medio sono stati inseriti");
							break;
							
						
						case 2:
							//Modifica Monopattino Medio
							System.out.println("Inserire codice monopattino medio");
							scanner.nextLine();
							codiceMonopattinoMedioInput = scanner.nextLine();
							FunzioniMonopattini.modificaMonopattinoMedio(listaMonopattiniMedi, codiceMonopattinoMedioInput);
							System.out.println("I dati del Monopattino Medio sono stati modificati");
							break;
							
						
						case 3:
							//Cancella Monopattino Medio
							System.out.println("Inserire codice monopattino medio");
							scanner.nextLine();
							codiceMonopattinoMedioInput = scanner.nextLine();
							FunzioniMonopattini.eliminaMonopattinoMedio(listaMonopattiniMedi, codiceMonopattinoMedioInput);
							System.out.println("I dati del Monopattino Medio sono stati eliminati");
							break;
							
							
						case 4:
							//Visualizza Dati Monopattino Medio
							System.out.println("Inserire codice monopattino medio");
							scanner.nextLine();
							codiceMonopattinoMedioInput = scanner.nextLine();
							FunzioniMonopattini.visualizzaMonopattinoMedioRegistrato(listaMonopattiniMedi, codiceMonopattinoMedioInput);
							break;
							
						case 5:
							//Visualizza Dati di tutti i Monopattini Medi
							FunzioniMonopattini.visualizzaMonopattiniMediRegistrati(listaMonopattiniMedi);
							break;
							
							
						case 6:
							//Salva Dati Monopattino Medio
							FunzioniMonopattini.salvaMonopattiniMediRegistrati(listaMonopattiniMedi);
							System.out.println("I dati dei Monopattini Medi sono stati salvati in un unico file");
							break;
							
						
						case 7:
							//Torna indietro
							exit2mm = true;
							System.out.println("Torna indietro...");
							break;
							
							//Comando di default
						default:
							System.err.println("Comando inserito non trovato");
							break;
						
						}
					}
					break;
					
					
					
				case 3:
					//Dati Monopattino Avanzato
					
					boolean exit2ma = false;
					while(!exit2ma) {
						
						System.out.println(
								"\n\n** Dati Monopattino Avanzato **"
								+ "\n\n(1) Inserimento Monopattino Avanzato"
								+ "\n(2) Modifica Monopattino Avanzato"
								+ "\n(3) Cancella Monopattino Avanzato"
								+ "\n(4) Visualizza Dati Monopattino Avanzato"
								+ "\n(5) Visualizza Dati di tutti i Monopattini Avanzati"
								+ "\n(6) Salva Dati di tutti i Monopattini Avanzati"
								+ "\n(7) Torna indietro"
								);
						
						String codiceMonopattinoAvanzatoInput;
						
                        int comando2ma = scanner.nextInt();
						
						switch(comando2ma) {
						
						case 1:
							//Inserimento Monopattino Avanzato
							FunzioniMonopattini.aggiungiMonopattinoAvanzato(listaMonopattiniAvanzati);
							System.out.println("I dati del Monopattino Avanzato sono stati inseriti");
							break;
							
							
						case 2:
							//Modifica Monopattino Avanzato
							System.out.println("Inserire codice monopattino avanzato");
							scanner.nextLine();
							codiceMonopattinoAvanzatoInput = scanner.nextLine();
							FunzioniMonopattini.modificaMonopattinoAvanzato(listaMonopattiniAvanzati, codiceMonopattinoAvanzatoInput);
							System.out.println("I dati del Monopattino Avanzato sono stati modificati");
							break;
							
							
						case 3:
							//Cancella Monopattino Avanzato
							System.out.println("Inserire codice monopattino avanzato");
							scanner.nextLine();
							codiceMonopattinoAvanzatoInput = scanner.nextLine();
							FunzioniMonopattini.eliminaMonopattinoAvanzato(listaMonopattiniAvanzati, codiceMonopattinoAvanzatoInput);
							System.out.println("I dati del Monopattino Avanzato sono stati eliminati");
							break;
							
							
						case 4:
							//Visualizza Dati Monopattino Avanzato
							System.out.println("Inserire codice monopattino avanzato");
							scanner.nextLine();
							codiceMonopattinoAvanzatoInput = scanner.nextLine();
							FunzioniMonopattini.visualizzaMonopattinoAvanzatoRegistrato(listaMonopattiniAvanzati, codiceMonopattinoAvanzatoInput);
							break;
							
							
						case 5:
							//Visualizza Dati di tutti i Monopattini Avanzati
							FunzioniMonopattini.visualizzaMonopattiniAvanzatiRegistrati(listaMonopattiniAvanzati);
							break;
							
							
						case 6:
							//Salva Dati Monopattino Avanzato
							FunzioniMonopattini.salvaMonopattiniAvanzatiRegistrati(listaMonopattiniAvanzati);
							System.out.println("I dati dei Monopattini Avanzati sono stati salvati in un unico file");
							break;
							
							
						case 7:
							//Torna indietro
							exit2ma = true;
							System.out.println("Torna indietro...");
							break;
							
							
							//Comando di default
						default:
							System.err.println("Comando inserito non trovato");
							break;
							
						}
					}
					break;
					
					
					
				case 4:
					//Torna indietro
					exit2 = true;
					System.out.println("Torna indietro...");
					break;
					
				//Comando di default
				default:
					System.err.println("Comando inserito non trovato");
					break;
				}
			}
				break;
				
			
				
				
				
				
				
			case 3: 
				//Gestione - Dati Cliente
				
				boolean exit3 = false;
				while(!exit3) {
					
					System.out.println(
							"\n\nSelezione per la Gestione - Dati Cliente"
							+ "\n\n(1) Inserimento Cliente"
							+ "\n(2) Modifica Cliente"
							+ "\n(3) Cancella Cliente"
							+ "\n(4) Visualizza Dati Cliente"
							+ "\n(5) Visualizza Dati di tutti i Clienti"
							+ "\n(6) Serializza Dati di tutti i Clienti"
							+ "\n(7) Carica Dati di tutti i Clienti"
							+ "\n(8) Salva Dati di tutti i Clienti"
							+ "\n(9) Torna indietro"
							);
					
					String codiceClienteInput;
					
					int comando3 = scanner.nextInt();
					
					switch(comando3) {
					
					case 1:
						//Inserimento Cliente
						FunzioniClienti.aggiungiCliente(listaClienti);
						System.out.println("I dati del cliente sono stati inseriti");
						break;
						
					case 2: 
						//Modifica Cliente
						System.out.println("Inserire codice fiscale");
						scanner.nextLine();
						codiceClienteInput = scanner.nextLine();
						FunzioniClienti.modificaCliente(listaClienti, codiceClienteInput);
						System.out.println("I dati del cliente sono stati modificati");
						break;
						
					case 3:
						//Cancella Cliente
						System.out.println("Inserire codice fiscale");
						scanner.nextLine();
						codiceClienteInput = scanner.nextLine();
						FunzioniClienti.eliminaCliente(listaClienti, codiceClienteInput);
						System.out.println("I dati del cliente sono stati eliminati");
						break;
					
					case 4:
						//Visualizza Dati Cliente
						System.out.println("Inserire codice fiscale");
						scanner.nextLine();
						codiceClienteInput = scanner.nextLine();
						FunzioniClienti.visualizzaClienteRegistrato(listaClienti, codiceClienteInput);
						break;
						
					case 5:
						//Visualizza Dati di tutti i Clienti
						FunzioniClienti.visualizzaClientiRegistrati(listaClienti);
						break;
						
					case 6:
						//Serializzazione Dati Cliente
						FunzioniClienti.serializzazioneClientiRegistrati(listaClienti);
						System.out.println("I dati dei Clienti sono stati serializzati in un unico file");
						break;
						
					case 7:
						////Carica Dati Cliente
						FunzioniClienti.caricaClientiRegistrati(listaClienti);
						System.out.println("I dati serializzati dei Clienti sono stati caricati ");
						break;
						
						
						
					case 8:
						//Salva Dati Cliente
						FunzioniClienti.salvaClientiRegistrati(listaClienti);
						System.out.println("I dati dei Clienti sono stati salvati in un unico file");
						break;
						
						
						
					case 9:
						//Torna indietro
						exit3 = true;
						System.out.println("Torna indietro...");
						break;
						
					//Comando di default
					default:
						System.err.println("Comando inserito non trovato");
						break;
					
					}
				}
				break;
					
					
					
					
					
				
				
					
					
			case 4: 
				//Gestione - Vendita Monopattino
				boolean exit4 = false;
				while(!exit4) {
					
					System.out.println(
							"\n\nSelezione per la Gestione - Vendita Monopattino"
								+ "\n\n(1) Inserimento Vendita"
								+ "\n(2) Modifica Vendita"
								+ "\n(3) Cancella Vendita"
								+ "\n(4) Visualizza Dati Vendita"
								+ "\n(5) Visualizza Dati di tutte le Vendite"
								+ "\n(6) Salva Dati di tutte le Vendite"
								+ "\n(7) Torna indietro"
								);
					
					String codiceClienteInput;
					
					int comando4 = scanner.nextInt();
					
					switch(comando4) {
					
					case 1:
						//Inserimento Vendita
						FunzioniVendita.aggiungiVendita(listaVendita);
						System.out.println("I dati della vendita sono stati inseriti");
						break;
						
					case 2:
						//Modifica Vendita
						System.out.println("Inserire codice vendita");
						scanner.nextLine();
						codiceClienteInput = scanner.nextLine();
						FunzioniVendita.modificaVendita(listaVendita, codiceClienteInput);
						System.out.println("I dati della vendita sono stati modificati");
						break;
						
					case 3:
						//Cancella Vendita
						System.out.println("Inserire codice vendita");
						scanner.nextLine();
						codiceClienteInput = scanner.nextLine();
						FunzioniVendita.eliminaVendita(listaVendita, codiceClienteInput);
						System.out.println("I dati della vendita sono stati eliminati");
						break;
						
					case 4:
						//Visualizza Dati Vendita
						System.out.println("Inserire codice vendita");
						scanner.nextLine();
						codiceClienteInput = scanner.nextLine();
						FunzioniVendita.visualizzaVenditaRegistrata(listaVendita, codiceClienteInput);
						break;
						
					case 5:
						//Visualizza Dati di tutte le Vendite
						FunzioniVendita.visualizzaVenditeRegistrate(listaVendita);
						break;
						
					case 6:
						//Salva Dati Vendita
						FunzioniVendita.salvaListaVendita(listaVendita);
						System.out.println("I dati delle vendite sono stati salvati in un unico file");
						break;
						
					case 7:	
						//Torna indietro
						exit4 = true;
						System.out.println("Torna indietro...");
						break;
						
					//Comando di default
					default:
						System.err.println("Comando inserito non trovato");
						break;
					
					
				    }
					
				}
			break;
				
					
					
					
					
				
			case 5:
				//Gestione - Noleggio Monopattino
				boolean exit5 = false;
				while(!exit5) {
					
					System.out.println(
							"\n\nSelezione per la Gestione - Noleggio Monopattino"
								+ "\n\n(1) Inserimento Noleggio"
								+ "\n(2) Modifica Noleggio "
								+ "\n(3) Cancella Noleggio"
								+ "\n(4) Visualizza Dati Noleggio"
								+ "\n(5) Visualizza Dati di tutti i Noleggi"
								+ "\n(6) Salva Dati di tutti i Noleggi"
								+ "\n(7) Torna indietro"
								);
					
					String codiceClienteInput;
					
					int comando5 = scanner.nextInt();
					
					switch(comando5) {
					
					case 1:
						//Inserimento Noleggio
						FunzioniNoleggio.aggiungiNoleggio(listaNoleggio);
						System.out.println("I dati del noleggio sono stati inseriti");
						break;
						
					case 2:
						//Modifica Noleggio
						System.out.println("Inserire codice noleggio");
						scanner.nextLine();
						codiceClienteInput = scanner.nextLine();
						FunzioniNoleggio.modificaNoleggio(listaNoleggio, codiceClienteInput);
						System.out.println("I dati del noleggio sono stati modificati");
						break;
						
					case 3:
						//Cancella Noleggio
						System.out.println("Inserire codice noleggio");
						scanner.nextLine();
						codiceClienteInput = scanner.nextLine();
						FunzioniNoleggio.eliminaNoleggio(listaNoleggio, codiceClienteInput);
						System.out.println("I dati del noleggio sono stati eliminati");
						break;
						
					case 4:
						//Visualizza Dati Noleggio
						System.out.println("Inserire codice noleggio");
						scanner.nextLine();
						codiceClienteInput = scanner.nextLine();
						FunzioniNoleggio.visualizzaNoleggioRegistrato(listaNoleggio, codiceClienteInput);
						break;
						
					case 5:
						//Visualizza Dati di tutti i Noleggi
						FunzioniNoleggio.visualizzaNoleggiRegistrati(listaNoleggio);
						break;
						
					case 6:
						//Salva Dati Noleggio
						FunzioniNoleggio.salvaListaNoleggio(listaNoleggio);
						System.out.println("I dati dei noleggi sono stati salvati in un unico file");
						break;
						
					case 7:	
						//Torna indietro
						exit5 = true;
						System.out.println("Torna indietro...");
						break;
						
					//Comando di default
					default:
						System.err.println("Comando inserito non trovato");
						break;
					
					}
					
				}
			break;
				
				
			case 6:
				//Chiusura programma
				exit = true;
				System.out.println("Chiusura programma...");
				System.out.println("\n\nArrivederci e grazie per aver utilizzato l'applicazione.");
				break;
				
				//Comando di default
			default:
				System.err.println("Comando inserito non trovato");
				break;
			}
			
		}
		

	}

	public static List<MonopattinoMedio> getListaMonopattiniMedi() {
		return listaMonopattiniMedi;
	}

	public static void setListaMonopattiniMedi(List<MonopattinoMedio> listaMonopattiniMedi) {
		Main.listaMonopattiniMedi = listaMonopattiniMedi;
	}

	public static List<MonopattinoAvanzato> getListaMonopattiniAvanzati() {
		return listaMonopattiniAvanzati;
	}

	public static void setListaMonopattiniAvanzati(List<MonopattinoAvanzato> listaMonopattiniAvanzati) {
		Main.listaMonopattiniAvanzati = listaMonopattiniAvanzati;
	}

	public static List<Monopattino> getListaMonopattiniBase() {
		return listaMonopattiniBase;
	}

	public static void setListaMonopattiniBase(List<Monopattino> listaMonopattiniBase) {
		Main.listaMonopattiniBase = listaMonopattiniBase;
	}

	public static List<Cliente> getListaClienti() {
		return listaClienti;
	}

	public static void setListaClienti(List<Cliente> listaClienti) {
		Main.listaClienti = listaClienti;
	}

	public static List<Noleggio> getListaNoleggio() {
		return listaNoleggio;
	}

	public static void setListaNoleggio(List<Noleggio> listaNoleggio) {
		Main.listaNoleggio = listaNoleggio;
	}

	public static List<Vendita> getListaVendita() {
		return listaVendita;
	}

	public static void setListaVendita(List<Vendita> listaVendita) {
		Main.listaVendita = listaVendita;
	}
	
	
	

}
