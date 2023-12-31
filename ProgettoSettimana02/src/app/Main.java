package app;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

public class Main {

	private static final String file = "file.txt";
	private static List<Prodotto> catalogo = new ArrayList<>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int opzione = -1;

		while (opzione != 0) {
			System.out.println("Digita il numero corrispondente a le seguenti operazioni:");
			System.out.println("1) Aggiungi un libro");
			System.out.println("2) Aggiungi una rivista");
			System.out.println("3) Rimuovi un prodotto");
			System.out.println("4) Cerca con codice univoco IBSN");
			System.out.println("5) Cerca per anno di pubblicazione del prodotto");
			System.out.println("6) Cerca per Autore del prodotto");
			System.out.println("7) Salva su disco dell'archivio");
			System.out.println("8) Carica dal disco dell'archivio");

			opzione = input.nextInt();
			input.nextLine();

			switch (opzione) {

			case 1:

				try {
					System.out.println("Inserisci il codice ISBN del libro che vuoi salvare:");
					Long isbnBookCode = input.nextLong();
					input.nextLine();

					System.out.println("--------------------------------------------------------");

					System.out.println("Inserisci il titolo del libro che vuoi salvare:");
					String bookTitle = input.nextLine();

					System.out.println("--------------------------------------------------------");

					System.out.println("Inserisci l'anno di pubblicazione del libro:");
					int bookPubblicationYear = input.nextInt();
					input.nextLine();

					System.out.println("--------------------------------------------------------");

					System.out.println("Inserisci il numero di pagine del libro:");
					int numPage = input.nextInt();
					input.nextLine();

					System.out.println("--------------------------------------------------------");

					System.out.println("Inserisci l'autore del libro:");
					String bookAuthor = input.nextLine();

					System.out.println("--------------------------------------------------------");

					System.out.println("Inserisci il genere del libro:");
					String bookGenre = input.nextLine();

					Libri libro = new Libri(isbnBookCode, bookTitle, numPage, bookPubblicationYear, bookAuthor,
							bookGenre);

					catalogo.add(libro);

				} catch (Exception e) {
					System.out.println("Errore durante l'aggiunta del libro: " + e.getMessage());
				}

				break;

			case 2:

				try {
					System.out.println("Inserisci il codice ISBN della rivista che vuoi salvare:");
					Long isbnmagazineCode = input.nextLong();
					input.nextLine();

					System.out.println("--------------------------------------------------------");

					System.out.println("Inserisci il titolo della rivista che vuoi salvare");
					String magazineTitle = input.nextLine();

					System.out.println("--------------------------------------------------------");

					System.out.println("Inserisci l'anno di pubblicazione della rivista che vuoi salvare");
					int magazinePubblicationYear = input.nextInt();
					input.nextLine();

					System.out.println("--------------------------------------------------------");

					System.out.println("Inserisci il numero di pagine della rivista che vuoi salvare");
					int numPage = input.nextInt();
					input.nextLine();

					System.out.println("--------------------------------------------------------");

					System.out
							.println("Inserisci la periodicita' della rivista tra SETTIMANALE - MENSILE - SEMESTRALE:");
					String periodicitaStringa = input.nextLine();
					Periodicita magazineType = Periodicita.valueOf(periodicitaStringa);

					Riviste rivista = new Riviste(isbnmagazineCode, magazineTitle, numPage, magazinePubblicationYear,
							magazineType);

					catalogo.add(rivista);

				} catch (Exception e) {
					System.out.println("Errore durante l'aggiunta della rivista: " + e.getMessage());
				}

				break;

			case 3:

				try {
					System.out.println("Inserisci il codice univoco ISBN del prodotto che vuoi cancellare:");
					Long removeIsbnCode = input.nextLong();

					catalogo.removeIf(prodotto -> prodotto.getIsbnCode() == removeIsbnCode);

				} catch (Exception e) {
					System.out.println("Errore durante l'eliminazione dell' elemento: " + e.getMessage());
				}

				break;

			case 4:

				System.out.println("Inserisci il codice ISBN da cercare:");
				String findIsbnCode = input.nextLine();

				List<Prodotto> filteredProducts = catalogo.stream().filter(prodotto -> prodotto.getIsbnCode().equals(findIsbnCode)).collect(Collectors.toList());

				if (filteredProducts.isEmpty()) {

					System.out.println("Nessun elemento trovato con il codice ISBN: " + findIsbnCode);

				} else {

					filteredProducts.forEach(Prodotto::printInfos);

				}

				break;

			case 5:

				try {
					System.out.println("Inserisci l'anno di pubblicazione da cercare:");
					int annoPubblicazioneDaTrovare = input.nextInt();
					input.nextLine();

					List<Prodotto> elementiPerAnno = catalogo.stream()
							.filter(elemento -> elemento.getAnnoPubblicazione() == annoPubblicazioneDaTrovare)
							.collect(Collectors.toList());

					if (elementiPerAnno.isEmpty()) {
						System.out.println(
								"Nessun elemento trovato per l'anno di pubblicazione: " + annoPubblicazioneDaTrovare);
					} else {
						elementiPerAnno.forEach(Prodotto::printInfos);
					}
				} catch (InputMismatchException e) {
					System.out.println("Errore: devi inserire un numero per l'anno di pubblicazione.");
					input.nextLine();
				}
				break;

			case 6:

				System.out.println("Inserisci l'autore da cercare:");
				String autoreDaTrovare = input.nextLine();

				List<Libri> libriFiltrati = catalogo.stream().filter(elemento -> elemento instanceof Libri)
						.map(elemento -> (Libri) elemento)
						
						.filter(librofilter -> librofilter.getAutore().equalsIgnoreCase(autoreDaTrovare))
						
						.collect(Collectors.toList());

				if (libriFiltrati.isEmpty()) {
					
					System.out.println("Nessun libro trovato con l'autore: " + autoreDaTrovare);
					
				} else {
					
					libriFiltrati.forEach(libroFiltrato -> libroFiltrato.printInfos());
				}

				break;

//			case 7:
//
//				try {
//					write(file);
//					System.out.println("Salvataggio su disco completato.");
//				} catch (IOException e) {
//					System.out.println("Errore durante il salvataggio su disco: " + e.getMessage());
//				}
//				break;
//
//			case 8:
//				try {
//					read(file);
//					System.out.println("Caricamento da disco completato.");
//				} catch (IOException e) {
//					System.out.println("Errore durante il caricamento da disco: " + e.getMessage());
//				}
//				break;

			default:
				System.out.println("Opzione non valida.");
				break;

			}
			
			System.out.println();
		}

		input.close();
	}

	public static void write(String file) {
		
	}

	public static void read(String file) {
		
	}
}
