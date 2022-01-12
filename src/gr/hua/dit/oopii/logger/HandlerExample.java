package gr.hua.dit.oopii.lec11.logger;


import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HandlerExample {

   private static final Logger LOGGER = Logger.getLogger(LoggerExample.class.getName());
   public HandlerExample() {

       Handler consoleHandler = null;
       Handler fileHandler  = null;
       try{
           //Creating consoleHandler and fileHandler
           consoleHandler = new ConsoleHandler();
           fileHandler  = new FileHandler("./javacodegeeks.log",true);
            
           //Assigning handlers to LOGGER object
           LOGGER.addHandler(consoleHandler);
           LOGGER.addHandler(fileHandler);
            
           //Setting levels to handlers and LOGGER
           consoleHandler.setLevel(Level.ALL);
           fileHandler.setLevel(Level.ALL);
           LOGGER.setLevel(Level.ALL);
            
           //LOGGER.config("Configuration done.");
            
           //Console handler removed
           LOGGER.removeHandler(consoleHandler);
            
           //LOGGER.log(Level.FINE, "Finer logged");
       }catch(IOException exception){
           LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", exception);
       }
        
       //LOGGER.finer("Finest example on LOGGER handler completed.");
       /*LOGGER.finer("one 4th message.");
       LOGGER.finer("one 5th message.");
       LOGGER.finer("one 6th message.");
       LOGGER.finer("one 7th message.");*/
   }
   
   public  void writeToLog(Level level, String message) {
	   LOGGER.log(level, message);
	   //LOGGER.finer("We write a finer message.");
   }

}