package it.uniba.monopattini.business;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Creazione di classe Dipendente con la costruzione dell'oggetto, che viene implementata con l'uso del Comparable
 * e del Serializable.
 * 
 * Vengono inseriti degli attributi e ogni Dipendente viene identificato con il proprio codice rappresentato da una
 * stringa di 8 caratteri in formato alfanumerico.
 * 
 * Il codice del Dipendente viene controllato dal sistema e se il sistema si accorge che è stato inserito
 * dei caratteri non validi, viene generato una eccezione.
 * 
 * I Dati dei Dipendenti o Venditori devono essere serializzati come è stato richiesto nella traccia del caso di studio.
 * 
 * 
 * 
 * 
 * @author Donato Corbacio
 *
 */
public class Dipendente implements Comparable<Dipendente>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8753655899853736680L;
	private String codiceDipendente;
	private String cognome;
	private String nome;
	
	
	public Dipendente(String codiceDipendente, String cognome, String nome) throws Exception {
		
		if(checkCodiceDipendente(codiceDipendente)) {
			this.codiceDipendente = codiceDipendente;
		} else {
			throw new Exception("Il codice dipendente presenta dei caratteri non validi!");
		}
		
		this.cognome = cognome;
		this.nome = nome;
		
	}
		
	public Dipendente() {
	}

	public String getCodiceDipendente() {
		return codiceDipendente;
	}
	
	public void setCodiceDipendente(String codiceDipendente) throws Exception {
		if(checkCodiceDipendente(codiceDipendente)) {
			this.codiceDipendente = codiceDipendente;
		} else {
			throw new Exception("Il codice dipendente presenta dei caratteri non validi!");
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	
	private boolean checkCodiceDipendente(String codiceDipendente) {
		String regex ="^[a-zA-Z0-9]{8}";
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(codiceDipendente);
		return matcher.matches();
	}
	
	public String toString() {
		return "Dipendente [Codice Dipendente = " +codiceDipendente+ ", Cognome = " +cognome+ ", Nome = " +nome+ "]"; 
	}

	@Override
	public int compareTo(Dipendente o) {
		return codiceDipendente.compareTo(o.getCodiceDipendente());
	}

	@Override
	public int hashCode() {
		return Objects.hash(codiceDipendente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dipendente other = (Dipendente) obj;
		return Objects.equals(codiceDipendente, other.codiceDipendente);
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
