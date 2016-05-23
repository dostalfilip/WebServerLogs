package WebServerLogs;

/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (Filip Dostal) 
 * @version (23.5.2016)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
    	 records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         FileResource resource = new FileResource(filename);
         for(String n : resource.lines()){
        	 LogEntry entry = WebLogParser.parseEntry(n);
        	 records.add(entry);
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     /**
      * 
	  *	should also assume that the instance variable records already has its ArrayList of
	  *	Strings read in from a file, and should access records in computing this value. For help,
	  *	refer to the lectures in this lesson on the unique IP algorithm and code.
      * 
      * @return an integer representing the number of unique IP addresses
      */
     public int countUniqueIPs(){
    	 ArrayList<String> ipAdress = new ArrayList<String>();
    	 for(LogEntry n : records){
    		 if(!ipAdress.contains(n.getIpAddress())){
    			 ipAdress.add(n.getIpAddress());
    		 }
    	 }
    	 
    	 return ipAdress.size();
     }
     
     
}