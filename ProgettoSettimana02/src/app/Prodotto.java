package app;

public abstract class Prodotto {
	
	private Long isbnCode;
	private String titolo;
	private int annoPubblicazione;
	private int numPagine;
	
	public Prodotto(Long isbnCode, String titolo, int annoPubblicazione, int numPagine) {
		setTitolo(titolo);
		setAnnoPubblicazione(annoPubblicazione);
		setNumPagine(numPagine);
		setIsbnCode(isbnCode);
	}

	public Long getIsbnCode() {
		return isbnCode;
	}

	public void setIsbnCode(Long isbnCode) {
		this.isbnCode = isbnCode;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public int getNumPagine() {
		return numPagine;
	}

	public void setNumPagine(int numPagine) {
		this.numPagine = numPagine;
	}
	
	public abstract void printInfos();
	
}
