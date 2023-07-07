package prova;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Prova {

	private static File prova = new File("prova.txt");
	private static Logger log = LoggerFactory.getLogger(Prova.class);
	
	public static void main(String[] args) {
		
		
		try {
			saveOnDisk("Hello World");
			System.out.println("File salvato con successo!");
			
			log.info("\nEcco il contenuto del file");
			System.out.println(readFromDisk());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
		
		public static void saveOnDisk(String testo) throws IOException {
			
			FileUtils.writeStringToFile(prova, testo + System.lineSeparator(), "UTF-8", true);

		}
		
		public static String readFromDisk() throws IOException {
			String content = FileUtils.readFileToString(prova, "UTF-8");
			return content;
		}
		
	}


