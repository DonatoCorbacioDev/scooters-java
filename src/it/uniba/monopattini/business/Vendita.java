package it.uniba.monopattini.business;

import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.uniba.monopattini.utils.DateUtils;
import it.uniba.monopattini.utils.DoubleUtils;


/**
 * Creazione di classe Vendita con la costruzione dell'oggetto e che viene implementata con l'uso del Comparable. L'utilizzo del Comparable
 * è servito per sistemare la lista delle vendite per tipo di monopattino. Per l'ordinamento ho utilizzato anche il Comparator tramite
 * un'altra classe in base alla richesta della traccia (Ordinare la lista in base alla coppia di parametri: Tipo di monopattino (medio, 
 * poi avanzato ed infine base) e costo di vendita più basso. 
 *  
 * 
 * Ogni Vendita deve riportare delle informazioni richieste.
 * 
 * 
 * 
 * 
 * @author Donato Corbacio
 *
 */
public class Vendita implements Comparable<Vendita> {

	private String codiceVendita;
	private String monopattinoVenduto;
	private String tipoMonopattino;
	private String clienteAcquirente;
	private Date dataVendita;
	private Double prezzoVendita;
	private String dipendenteVendita;
	
	public Vendita(String codiceVendita, String monopattinoVenduto, String tipoMonopattino,
			String clienteAcquirente, String dataVendita, String prezzoVendita
			, String dipendenteVendita) throws Exception {
		
		if(checkCodiceVendita(codiceVendita)) {
			this.codiceVendita = codiceVendita;
		} else {
			throw new Exception("Il codice vendita presenta dei caratteri non validi!");
		}
		
		this.monopattinoVenduto = monopattinoVenduto;
		this.tipoMonopattino = tipoMonopattino;
		this.clienteAcquirente = clienteAcquirente;
		
		try {
			this.dataVendita = DateUtils.parseDate(dataVendita);
		}
		catch (Exception e) {
			System.err.println("Errore durante inizializzazione " + e.getMessage());
		}
		
		
		
		try {
			this.prezzoVendita = DoubleUtils.parseDouble(prezzoVendita);
		}
		catch (Exception e) {
			System.err.println("Errore durante inizializzazione " + e.getMessage());
		}
		
		this.dipendenteVendita = dipendenteVendita;
		
	}
	
	public Vendita() {
		
	}
	
	public String getCodiceVendita() {
		return codiceVendita;
	}
	
	public void setCodiceVendita(String codiceVendita) throws Exception {
		if(checkCodiceVendita(codiceVendita)) {
			this.codiceVendita = codiceVendita;
		} else {
			throw new Exception("Il codice vendita presenta dei caratteri non validi!");
		}
	}

	public String getMonopattinoVenduto() {
		return monopattinoVenduto;
	}

	public void setMonopattinoVenduto(String monopattinoVenduto) {
		this.monopattinoVenduto = monopattinoVenduto;
	}

	public String getClienteAcquirente() {
		return clienteAcquirente;
	}

	public void setClienteAcquirente(String clienteAcquirente) {
		this.clienteAcquirente = clienteAcquirente;
	}
	

	public Date getDataVendita() {
		return dataVendita;
	}

	public void setDataVendita(Date dataVendita) {
		this.dataVendita = dataVendita;
	}

	public Double getPrezzoVendita() {
		return prezzoVendita;
	}

	public void setPrezzoVendita(Double prezzoVendita) {
		this.prezzoVendita = prezzoVendita;
	}

	public String getDipendenteVendita() {
		return dipendenteVendita;
	}

	public void setDipendenteVendita(String dipendenteVendita) {
		this.dipendenteVendita = dipendenteVendita;
	}
	
	public String getTipoMonopattino() {
		return tipoMonopattino;
	}
	
	public void setTipoMonopattino(String tipoMonopattino) {
		this.tipoMonopattino = tipoMonopattino;
	}
	
	private boolean checkCodiceVendita(String codiceVendita) {
		String regex ="^[a-zA-Z0-9]{6}";
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(codiceVendita);
		return matcher.matches();
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(prezzoVendita);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendita other = (Vendita) obj;
		return Objects.equals(prezzoVendita, other.prezzoVendita);
	}

	@Override
	public String toString() {
		return "Vendita [Codice Vendita = " + codiceVendita + ", Monopattino Venduto = " + monopattinoVenduto + 
				", Tipo Monopattino = " +tipoMonopattino+ ", Cliente = " + clienteAcquirente
				+ ", Data = " + dataVendita + ", Prezzo = " + prezzoVendita + "€" + ", Dipendente che effettua la vendita = "
				+ dipendenteVendita + "]";
	}
	
	@Override
	public int compareTo(Vendita o) {
		return tipoMonopattino.compareTo(o.getTipoMonopattino());
	}
}
