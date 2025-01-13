package it.uniba.monopattini.business;


/**
 * Creazione di classe MonopattinoMedio con l'uso dell'ereditarietà astratta dalla Classe Monopattino (nonostante 
 * le diversità degli oggetti, serve per aggiungere più variabili o per avere una costruzione dell'oggetto a livello
 * medio).
 * 
 * Vengono inseriti degli attributi (con aggiunta di freno a disco) e ogni Monopattino viene 
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
public class MonopattinoMedio extends Monopattino implements Comparable<Monopattino> {

	
	
	private String freniDisco;
	
	public MonopattinoMedio(String marca, String modello, String freniDisco) {
		super(marca, modello);
		
		this.freniDisco = freniDisco;
	}

	public MonopattinoMedio() {
		
	}

	public String getFreniDisco() {
		return freniDisco;
	}
	
	public void setFreniDisco(String freniDisco) {
		this.freniDisco = freniDisco;
	}

	@Override
	public String toString() {
		return super.toString() + "  [Freni a Disco = " +freniDisco+ "]";
	}
	
	public int compareTo(MonopattinoMedio o) {
		MonopattinoMedio mm = (MonopattinoMedio)o;
		return this.codice.compareTo(mm.generateNextCodice());
	}

}
