package it.uniba.monopattini.business;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.uniba.monopattini.utils.DateUtils;


/**
 * Creazione di classe Cliente con la costruzione dell'oggetto, che viene implementata con l'uso del Comparable
 * e del Serializable.
 * 
 * Vengono inseriti degli attributi e ogni Cliente viene identificato univocamente mediante il codice fiscale.
 * 
 * Il codice fiscale del Cliente viene controllato dal sistema e se il sistema si accorge che è stato inserito
 * dei caratteri non validi, viene generato una eccezione.
 * 
 * I Dati dei Clienti devono essere serializzati come è stato richiesto nella traccia del caso di studio.
 * 
 * 
 * 
 * 
 * @author Donato Corbacio
 *
 */
public class Cliente implements Comparable<Cliente>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1965499599878112751L;
	private String codiceFiscalePersona;
	private String nome;
	private String cognome;
	private String sesso;
	private String luogoNascita;
	private String provincia;
	private Date dataNascita;
	
	
	public Cliente(String codiceFiscalePersona, String cognome, String nome, String sesso, String luogoNascita, 
			String provincia, String dataNascita) throws Exception {
		
		if(checkCodiceFiscalePersona(codiceFiscalePersona)) {
			this.codiceFiscalePersona = codiceFiscalePersona;
		} else {
			throw new Exception("Il codice cliente presenta dei caratteri non validi!");
		}
		
		this.cognome = cognome;
		this.nome = nome;
		this.setSesso(sesso);
		this.setLuogoNascita(luogoNascita);
		this.setProvincia(provincia);
		try {
			this.setDataNascita(DateUtils.parseDate(dataNascita));
		}
		catch (Exception e) {
			System.err.println("Errore durante inizializzazione " + e.getMessage());
		}
	}
	
    public Cliente() {
		
	}
	
	public String getCodiceFiscalePersona() {
		return codiceFiscalePersona;
	}
	
	public void setCodiceFiscalePersona(String codiceFiscalePersona) throws Exception {
		if(checkCodiceFiscalePersona(codiceFiscalePersona)) {
			this.codiceFiscalePersona = codiceFiscalePersona;
		} else {
			throw new Exception("Il codice cliente presenta dei caratteri non validi!");
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
	
	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	private boolean checkCodiceFiscalePersona(String codiceFiscalePersona) {
		String regex ="^[a-zA-Z0-9]{16}";
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(codiceFiscalePersona);
		return matcher.matches();
	}
	
		
	@Override
	public String toString() {
		return "Cliente [Codice Fiscale = " + codiceFiscalePersona + ", Cognome = " + cognome + ", Nome = " + nome
				+ ", Sesso = " + sesso + ", Luogo di Nascita = " + luogoNascita + ", Provincia = " + provincia + 
				", Data di Nascita = " + dataNascita + "]";
	}

	@Override
	public int compareTo(Cliente o) {
		return cognome.compareTo(o.getCognome());
	}

	@Override
	public int hashCode() {
		return Objects.hash(codiceFiscalePersona);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(codiceFiscalePersona, other.codiceFiscalePersona);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
