package kiteshop.test;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;





public class ProjectLog {

	public static void main(String[] args) throws SecurityException, IOException {
		
		
	
		// test logger in another class.
     
		
		/*
		 * 
		 * Printing to console is de ROOTLOGGER, daar hebben we geen invloed op
		 * severe
		 * warning
		 * info
		 * config
		 * fine
		 * finer
		 * finest
		 */

	}

	public static Logger getLogger(){

		Logger logr = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);  // zodat hij in het hele project gebruikt kan worden
		LogManager.getLogManager().reset();

		logr.setLevel(Level.ALL);

		// De logger heeft standaard een console handler, we zetten deze op level severe, zodat alleen info van de hooogste categorie richting console wordt geprint
		ConsoleHandler ch = new ConsoleHandler();
		ch.setLevel(Level.SEVERE);  
		logr.addHandler(ch);

		try {
			//We voegen een filehandler toe zodat naar file wordt gelogd, we zetten deze op een fijner niveau (naar wens door de programmeur tijdelijk aan te passen)
			FileHandler fh = new FileHandler("src/kiteshop/test/ProjectLog.log", true);
			fh.setLevel(Level.FINE);
			fh.setFormatter(new SimpleFormatter());

			logr.addHandler(fh);

		} catch (IOException e){
			logr.log(Level.SEVERE, "File logger not working", e);
		}

		return logr;
	}
}
