package it.uniba.monopattini.business;

import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.uniba.monopattini.utils.DateUtils;
import it.uniba.monopattini.utils.DoubleUtils;


/**
 * Creazione di classe Noleggio con la costruzione dell'oggetto e che viene implementata con l'uso del Comparable. L'Utilizzo del Comparable
 * è servito per sistemare la lista dei noleggi in ordine alfabetico per cognome del Cliente che ha effettuato il noleggio.
 * 
 * Ogni noleggio deve riportare delle informazioni richieste.
 * 
 * 
 * 
 * 
 * @author Donato Corbacio
 *
 */
public class Noleggio implements Comparable<Noleggio> {

	private String codiceNoleggio;
	private String monopattinoNoleggiato;
	private String tipoMonopattino;
	private String clienteNoleggio;
	private Date dataInizioNoleggio;
	private Date dataFineNoleggio;
	private Double prezzoNoleggio;
	private Double penale;
	private String dipendenteNoleggio;
	
	
	public Noleggio(String codiceNoleggio,String monopattinoNoleggiato, String tipoMonopattino, String clienteNoleggio,
			String dataInizioNoleggio, String dataFineNoleggio,
			String prezzoNoleggio, String penale, String dipendenteNoleggio) throws Exception {
		
		if(checkCodiceNoleggio(codiceNoleggio)) {
			this.codiceNoleggio = codiceNoleggio;
			
		} else {
			throw new Exception("Il codice noleggio presenta dei caratteri non validi!");
		}
	
		this.monopattinoNoleggiato = monopattinoNoleggiato;
		this.tipoMonopattino = tipoMonopattino;
		this.clienteNoleggio = clienteNoleggio;
		
		try {
			this.dataInizioNoleggio = DateUtils.parseDate(dataInizioNoleggio);
		}
		catch (Exception e) {
			System.err.println("Errore durante inizializzazione " + e.getMessage());
		}
		
		try {
			this.dataFineNoleggio = DateUtils.parseDate(dataFineNoleggio);
		}
		catch (Exception e) {
			System.err.println("Errore durante inizializzazione " + e.getMessage());
		}
		
		
		
		try {
			this.prezzoNoleggio = DoubleUtils.parseDouble(prezzoNoleggio);
		}
		catch (Exception e) {
			System.err.println("Errore durante inizializzazione " + e.getMessage());
		}
		
		try {
			this.penale = DoubleUtils.parseDouble(penale);
		}
		catch (Exception e) {
			System.err.println("Errore durante inizializzazione " + e.getMessage());
		}
		
		
		this.dipendenteNoleggio = dipendenteNoleggio;
	}
	
	public Noleggio() {
	}
	
	public String getCodiceNoleggio() {
		return codiceNoleggio;
	}
	
	public void setCodiceNoleggio(String codiceNoleggio) throws Exception {
		if(checkCodiceNoleggio(codiceNoleggio)) {
			this.codiceNoleggio = codiceNoleggio;
		} else {
			throw new Exception("Il codice noleggio presenta dei caratteri non validi!");
		}
	}
	
	public String getMonopattinoNoleggiato() {
		return monopattinoNoleggiato;
	}
	
	public void setMonopattinoNoleggiato(String monopattinoNoleggiato) {
		this.monopattinoNoleggiato = monopattinoNoleggiato;
	}
	
	public String getClienteNoleggio() {
		return clienteNoleggio;
	}

	public void setClienteNoleggio(String clienteNoleggio) {
		this.clienteNoleggio = clienteNoleggio;
	}
	
		
	public Date getDataInizioNoleggio() {
		return dataInizioNoleggio;
	}
	
	public void setDataInizioNoleggio(Date dataInizioNoleggio) {
		this.dataInizioNoleggio = dataInizioNoleggio;
	}
	
	public Date getDataFineNoleggio() {
		return dataFineNoleggio;
	}
	
	public void setDataFineNoleggio(Date dataFineNoleggio) {
		this.dataFineNoleggio = dataFineNoleggio;
	}
	
	public Double getPrezzoNoleggio() {
		return prezzoNoleggio;
	}
	
	public void setPrezzoNoleggio(Double prezzoNoleggio) {
		this.prezzoNoleggio = prezzoNoleggio;
	}
	
	public Double getPenale() {
		return penale;
	}
	
	public void setPenale(Double penale) {
		this.penale = penale;
	}
	

	public String getDipendenteNoleggio() {
		return dipendenteNoleggio;
	}
	
	public void setDipendenteNoleggio(String dipendenteNoleggio) {
		this.dipendenteNoleggio = dipendenteNoleggio;
	}
	
	public String getTipoMonopattino() {
		return tipoMonopattino;
	}
	
	public void setTipoMonopattino(String tipoMonopattino) {
		this.tipoMonopattino = tipoMonopattino;
	}
	
	private boolean checkCodiceNoleggio(String codiceNoleggio) {
		String regex ="^[a-zA-Z0-9]{6}";
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(codiceNoleggio);
		return matcher.matches();
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(clienteNoleggio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Noleggio other = (Noleggio) obj;
		return Objects.equals(clienteNoleggio, other.clienteNoleggio);
	}

	@Override
	public int compareTo(Noleggio o) {
		return clienteNoleggio.compareTo(o.getClienteNoleggio());
	}
	
	

	@Override
	public String toString() {
		return "" + "Noleggio [Codice Noleggio = " + codiceNoleggio + ", Monopattino Noleggiato = " + monopattinoNoleggiato +
				 ", Tipo Monopattino = " +tipoMonopattino+ ", Cliente = " + clienteNoleggio
				+ ", Data Inizio = " + dataInizioNoleggio + ", Data Fine = " + dataFineNoleggio
				+ ", Prezzo = " + prezzoNoleggio + "€" + ", Penale = " + penale + "€" + ", Dipendente che effettua il noleggio = "
				+ dipendenteNoleggio + "]";
	}

	
	
}
