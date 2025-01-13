package it.uniba.monopattini.business;

import java.util.Objects;

/**
 * 
 * Creazione di classe Monopattino con la costruzione dell'oggetto e che viene implementata con l'uso del Comparable.
 * 
 * Vengono inseriti degli attributi e ogni Monopattino viene identificato con il proprio codice denominato numero di
 * serie rappresentato da una stringa di 8 caratteri in formato numerico.
 * 
 * Il codice identificativo del Monopattino viene generato automaticamente dal sistema.
 * 
 * 
 * 
 * 
 * @author Donato Corbacio
 *
 */
public class Monopattino implements Comparable<Monopattino> {

	private String marca;
	private String modello;
	protected String codice;
	
	private static int counter = 0;
	
	public Monopattino(String marca, String modello) {
		counter++;
		this.codice = generateNextCodice();
		this.marca = marca;
		this.modello = modello;
	}
	
	public Monopattino() {
		counter++;
		this.codice = generateNextCodice();
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModello() {
		return modello;
	}
	
	public void setModello(String modello) {
		this.modello = modello;
	}
		
	public String getCodice() {
		return codice;
	}
	
	public void setCodice(String codice) {
		this.codice = generateNextCodice();
	}
	
	
	public String generateNextCodice() {
		int lunghezzaCodice = 8;
		String codice = "" + counter;
		
		while(codice.length() < lunghezzaCodice) {
			codice = "0" + codice;
		}
		
		return codice;
	}

	@Override
	public String toString() {
		return "Monopattino [Codice = " +codice+ ", Marca = " +marca+ ", Modello = " +modello+ "]";
	}

	@Override
	public int compareTo(Monopattino o) {
		Monopattino mb = (Monopattino)o;
		return this.codice.compareTo(mb.generateNextCodice());
	}

	@Override
	public int hashCode() {
		return Objects.hash(codice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monopattino other = (Monopattino) obj;
		return Objects.equals(codice, other.codice);
	}

	
	
	
}
