package app;

public class Libri extends Prodotto{
	
	private String autore;
	private String genere;
	
	public Libri(Long isbnCode, String titolo, int annoPubblicazione, int numPagine, String autore, String genere) {
		super(isbnCode, titolo, annoPubblicazione, numPagine);
		setAutore(autore);
		setGenere(genere);
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	@Override
	public void printInfos() {
		System.out.println("LIBRO:");
		System.out.println("Codice ISBN, Titolo, Anno, Pagine, Autore, Genere");
		System.out.println(getIsbnCode() + getTitolo() + getAnnoPubblicazione() + getNumPagine() + getAutore() + getGenere());
	}

	@Override
	public String formattaTextFile() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("LIBRO-")
	        .append("Codice ISBN: ").append(getIsbnCode()).append(", ")
	        .append("Titolo: ").append(getTitolo()).append(", ")
	        .append("Anno di Pubblicazione: ").append(getAnnoPubblicazione()).append(", ")
	        .append("Numero Pagine: ").append(getNumPagine()).append(", ")
	        .append("Autore: ").append(getAutore()).append(", ")
	        .append("Genere: ").append(getGenere());
	        
	    return sb.toString();
	}

	
}
