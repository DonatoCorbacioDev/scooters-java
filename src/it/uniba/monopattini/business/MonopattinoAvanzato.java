package it.uniba.monopattini.business;


/**
 * Creazione di classe MonopattinoAvanzato con l'uso dell'ereditarietà astratta dalla Classe Monopattino (in questo caso
 * è stato messo dalla classe MonopattinoMedio nonostante le diversità degli oggetti, serve per aggiungere più variabili
 * o per avere una costruzione dell'oggetto più avanzato).
 * 
 * Vengono inseriti degli attributi (con aggiunta di freno a disco ed il contachilometri) e ogni Monopattino viene 
 * identificato con il proprio codice denominato numero di serie rappresentato da una stringa di 8 caratteri 
 * in formato numerico.
 * 
 * Il codice identificativo del Monopattino viene generato automaticamente dal sistema.
 * 
 * 
 * 
 * 
 * @author Donato Corbacio
 *
 */
public class MonopattinoAvanzato extends MonopattinoMedio implements Comparable<Monopattino> {

	private String contachilometri;
	
	public MonopattinoAvanzato(String marca, String modello, String freniDisco, 
			String contachilometri) {
		super(marca, modello, freniDisco);
		this.contachilometri = contachilometri;
	}
	
	public MonopattinoAvanzato() {
	}

	public String getContachilometri() {
		return contachilometri;
	}
	
	public void setContachilometri(String contachilometri) {
		this.contachilometri = contachilometri;
	}

	@Override
	public String toString() {
		return super.toString()+ "  [Contachilometri = " + contachilometri + "]";
	}
	
	public int compareTo(MonopattinoAvanzato o) {
		MonopattinoAvanzato ma = (MonopattinoAvanzato)o;
		return this.codice.compareTo(ma.generateNextCodice());
	}
	
	
	
}
