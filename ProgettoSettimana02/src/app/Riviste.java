package app;

public class Riviste extends Prodotto{
	private Periodicita periodicita;
	
	public Riviste(Long isbnCode, String titolo, int annoPubblicazione, int numPagine, Periodicita periodicita) {
		super(isbnCode, titolo, annoPubblicazione, numPagine);
		setPeriodicita(periodicita);
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}
	
	@Override
	public void printInfos() {
		System.out.println("RIVISTA:");
		System.out.println("Codice ISBN, Titolo, Anno, Pagine, Autore, Genere");
		System.out.println(getIsbnCode() + getTitolo() + getAnnoPubblicazione() + getNumPagine() + getPeriodicita());
	}
	
	@Override
	public String formattaTextFile() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("RIVISTA:")
	        .append("Codice ISBN: ").append(getIsbnCode()).append(", ")
	        .append("Titolo: ").append(getTitolo()).append(", ")
	        .append("Anno di Pubblicazione: ").append(getAnnoPubblicazione()).append(", ")
	        .append("Numero Pagine: ").append(getNumPagine()).append(", ")
	        .append("Tipo Rivista: ").append(getPeriodicita().toString());
	        
	    return sb.toString();
	}

	}

