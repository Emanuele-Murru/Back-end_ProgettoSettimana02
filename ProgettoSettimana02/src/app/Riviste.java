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
	
	
}
