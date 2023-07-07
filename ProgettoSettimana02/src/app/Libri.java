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
	
//	@Override
//	public String
	
}
