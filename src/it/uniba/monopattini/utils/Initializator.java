package it.uniba.monopattini.utils;

import java.util.ArrayList;
import java.util.List;

import it.uniba.monopattini.business.Cliente;
import it.uniba.monopattini.business.Dipendente;
import it.uniba.monopattini.business.Monopattino;
import it.uniba.monopattini.business.MonopattinoAvanzato;
import it.uniba.monopattini.business.MonopattinoMedio;
import it.uniba.monopattini.business.Noleggio;
import it.uniba.monopattini.business.Vendita;

public class Initializator {
		
	/**
	 * Crea la lista di ogni dipendente.
	 * @return listaDipendenti
	 * @throws Exception
	 */
	public static List<Dipendente> getListaDipendenti() throws Exception {

		List<Dipendente> listaDipendenti = new ArrayList<Dipendente>();
		Dipendente dipendente1 = new Dipendente("DP475698", "Ferrari", "Giuseppe" );
		Dipendente dipendente2 = new Dipendente("DP478901", "Villa", "Francesco");
		Dipendente dipendente3 = new Dipendente("DP479054", "D'amico", "Giacomo");
		
		listaDipendenti.add(dipendente1);
		listaDipendenti.add(dipendente2);
		listaDipendenti.add(dipendente3);

		return listaDipendenti;
		
	}
	
	
	/**
	 * Crea la lista di ogni monopattino base.
	 * @return listaMonopattiniBase
	 */
	public static List<Monopattino> getListaMonopattiniBase() {	
		
		List<Monopattino> listaMonopattiniBase = new ArrayList<Monopattino>();
		Monopattino monopattino1 = new Monopattino("Ninebot","E25E");
		Monopattino monopattino2 = new Monopattino("Xiaomi","Mi M365");
		Monopattino monopattino3 = new Monopattino("Ninebot","F25E");
		
		listaMonopattiniBase.add(monopattino1);
		listaMonopattiniBase.add(monopattino2);
		listaMonopattiniBase.add(monopattino3);
		
		return listaMonopattiniBase;
	}
	
	
	/**
	 * Crea la lista di ogni monopattino medio.
	 * @return listaMonopattiniMedi
	 */
	public static List<MonopattinoMedio> getListaMonopattiniMedi() {	
		
		List<MonopattinoMedio> listaMonopattiniMedi = new ArrayList<MonopattinoMedio>();
		
		MonopattinoMedio monopattino4 = new MonopattinoMedio("Ninebot","E45E", "Posteriore");
		MonopattinoMedio monopattino5 = new MonopattinoMedio("Xiaomi","Mi M365 Pro", "Posteriore");
		MonopattinoMedio monopattino6 = new MonopattinoMedio("Xiaomi","Mi Electric Scooter Pro 2", "Posteriore");
		MonopattinoMedio monopattino7 = new MonopattinoMedio("Ducati","City CROSS-E", "Posteriore");
		
		listaMonopattiniMedi.add(monopattino4);
		listaMonopattiniMedi.add(monopattino5);
		listaMonopattiniMedi.add(monopattino6);
		listaMonopattiniMedi.add(monopattino7);
		
		return listaMonopattiniMedi;
		
	}
	
	
	/**
	 * Crea la lista di ogni monopattino avanzato.
	 * @return listaMonopattiniAvanzati
	 */
	public static List<MonopattinoAvanzato> getListaMonopattiniAvanzati() {	
		
		List<MonopattinoAvanzato> listaMonopattiniAvanzati = new ArrayList<MonopattinoAvanzato>();
		
		MonopattinoAvanzato monopattino8 = new MonopattinoAvanzato("Ninebot", "Max G30", "Anteriore e Posteriore", "Digitale");
		MonopattinoAvanzato monopattino9 = new MonopattinoAvanzato("Ninebot","Max G30LE", "Anteriore e Posteriore", "Digitale");
		MonopattinoAvanzato monopattino10 = new MonopattinoAvanzato("Ducati","PRO-III", "Anteriore e Posteriore", "Digitale");
		
		listaMonopattiniAvanzati.add(monopattino8);
		listaMonopattiniAvanzati.add(monopattino9);
		listaMonopattiniAvanzati.add(monopattino10);
		
		return listaMonopattiniAvanzati;
		
	}
	
	
	/**
	 * Crea la lista di ogni cliente.
	 * @return listaClienti
	 * @throws Exception
	 */
	public static List<Cliente> getListaClienti() throws Exception {
		List<Cliente> listaClienti = new ArrayList<Cliente>();
		
		Cliente cliente1 = new Cliente("DNLBTL85M06A149C", "Bartolini", "Daniele", "M", "Alberobello", "BA", "06/08/1985");
		Cliente cliente2 = new Cliente("PRRCNT95E26H643Y", "Conte", "Pierarmando", "M", "Rutigliano", "BA", "26/05/1995");
		Cliente cliente3 = new Cliente("TSTSRN93P61E047O", "Testa", "Serena", "F", "Giovinazzo", "BA", "21/09/1993");
		Cliente cliente4 = new Cliente("NNACBN91R54F280I", "Carbone", "Anna", "F", "Mola di Bari", "BA", "14/10/1991");
		Cliente cliente5 = new Cliente("VLRFRR89D43A662B", "Ferri", "Valeria", "F", "Bari", "BA", "03/04/1989");
		Cliente cliente6 = new Cliente("DNLBNC97S01F376R", "Bianco", "Daniele", "M", "Monopoli", "BA", "01/11/1997");
		Cliente cliente7 = new Cliente("FRNVTL93H45F376G", "Vitali", "Federica", "F", "Monopoli", "BA", "05/06/1993");
		Cliente cliente8 = new Cliente("NCLMTN89E27F376Z", "Martino", "Nicolas", "M", "Monopoli", "BA", "27/05/1989");
		Cliente cliente9 = new Cliente("CSMRGR94T43A225E", "Ruggiero", "Cosima", "F", "Altamura", "BA", "03/12/1994");
		Cliente cliente10 = new Cliente("PTRCST82C10L419D", "Costa", "Pietro", "M", "Tricase", "LE", "10/03/1982");

		listaClienti.add(cliente1);
		listaClienti.add(cliente2);
		listaClienti.add(cliente3);
		listaClienti.add(cliente4);
		listaClienti.add(cliente5);
		listaClienti.add(cliente6);
		listaClienti.add(cliente7);
		listaClienti.add(cliente8);
		listaClienti.add(cliente9);
		listaClienti.add(cliente10);
		
		
		return listaClienti;
		
		
	}
	
	
	/**
	 * Crea la lista di ogni noleggio.
	 * @return listaNoleggio
	 * @throws Exception 
	 */
	public static List<Noleggio> getListaNoleggio() throws Exception {
		
		List<Noleggio> listaNoleggio = new ArrayList<Noleggio>();
		
		Noleggio noleggio1 = new Noleggio("NOL001" ,"Xiaomi Mi M365 Pro", "1 - Medio", "Conte Pierarmando", "01/06/2022", "05/06/2022", "35.49", "5.48", "Ferrari Giuseppe");
		Noleggio noleggio2 = new Noleggio("NOL002", "Ninebot Max G30", "2 - Avanzato", "Testa Serena",  "01/06/2022", "07/06/2022", "40.99", "10.98", "Ferrari Giuseppe");
		Noleggio noleggio3 = new Noleggio("NOL003", "Xiaomi Mi Electric Scooter Pro 2", "1 - Medio",  "Bartolini Daniele", "15/06/2022", "24/06/2022", "70.49" , "16.48", "Villa Francesco");
		Noleggio noleggio4 = new Noleggio("NOL004" , "Ninebot E45E", "1 - Medio", "Carbone Anna", "18/06/2022", "28/06/2022", "70.99", "10.98", "D'amico Giacomo");
	
		
		listaNoleggio.add(noleggio1);
		listaNoleggio.add(noleggio2);
		listaNoleggio.add(noleggio3);
		listaNoleggio.add(noleggio4);
		
		return listaNoleggio;
	}
	
	

	
	/**
	 * Crea la lista di ogni vendita.
	 * @return listaVendita
	 * @throws Exception 
	 */
	public static List<Vendita> getListaVendita() throws Exception {
		
		List<Vendita> listaVendita = new ArrayList<Vendita>();
		
		Vendita vendita1 = new Vendita("VEN001", "Xiaomi Mi M365", "3 - Base", "Vitali Federica", "08/06/2022", "398.99", "D'amico Giacomo");
		Vendita vendita2 = new Vendita("VEN002", "Ducati City CROSS-E", "1 - Medio", "Martino Nicolas", "24/06/2022", "448.99", "Ferrari Giuseppe");
		Vendita vendita3 = new Vendita("VEN003", "Ninebot Max G30LE", "2 - Avanzato", "Ruggiero Cosima", "16/06/2022", "544.99", "D'amico Giacomo");
		Vendita vendita4 = new Vendita("VEN004", "Ducati PRO-III", "2 - Avanzato",  "Costa Pietro", "05/06/2022",  "781.17", "Villa Francesco");
		Vendita vendita5 = new Vendita("VEN005", "Ninebot F25E", "3 - Base", "Bianco Daniele","01/06/2022", "344.99", "Villa Francesco");
		Vendita vendita6 = new Vendita("VEN006", "Ninebot E25E", "3 - Base", "Ferri Valeria", "30/06/2022", "493.83", "D'amico Giacomo");
		
		listaVendita.add(vendita1);
		listaVendita.add(vendita2);
		listaVendita.add(vendita3);
		listaVendita.add(vendita4);
		listaVendita.add(vendita5);
		listaVendita.add(vendita6);
		
		return listaVendita;
	}
	
	
	
	
	
}
