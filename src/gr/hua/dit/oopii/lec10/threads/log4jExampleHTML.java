package gr.hua.dit.oopii.lec10.threads;


import org.apache.log4j.Logger;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class log4jExampleHTML{
   /* Get actual class name to be printed on */
   static Logger log = Logger.getLogger(log4jExampleHTML.class.getName());
   
   public static void main(String[] args)throws IOException,SQLException{
      log.debug("Hello this is an debug message");
      log.info("Hello this is an info message");
   }
}