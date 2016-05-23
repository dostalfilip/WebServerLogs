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
     
     
}