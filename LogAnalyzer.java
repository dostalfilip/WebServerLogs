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
     /**
      * This method should examine all the web log entries in records
	  *	and print those LogEntrys that have a status code greater than num .
      * 
      * @param num
      */
     public void printAllHigherThanNum(int num){
    	 for(LogEntry n : records){
    		 if(n.getStatusCode() > num){
    			 System.out.println(n);
    		 }
    	 }
     }
     
     /**
      * 
      * @param someday in the format “MMM DD” where MMM is the first three
	  *			characters of the month name with the first letter capitalized and the others in lowercase,
	  *			and DD is the day in two digits (examples are “Dec 05” and “Apr 22”)
      * @return an ArrayList of Strings of unique IP addresses that had access on the given day.		
      */
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
    	 ArrayList<String> output = new ArrayList<String>();
    	 for(LogEntry n : records){
    		 String temp = n.getAccessTime().toString().substring(4, 10);
    		 if(someday.equals(temp) && !output.contains(n.getIpAddress())){
    			 output.add(n.getIpAddress());
    		 }
    	 }
    	 
    	 return output;
     }
     
     /**
      * 
      * @param low
      * @param high
      * @return This method returns the number of unique IP
	  *			addresses in records that have a status code in the range from low to high , inclusive.
      */
     public int countUniqueIPsInRange(int low, int high){
    	 ArrayList<String> uniqueIP = new ArrayList<String>();
    	 for(LogEntry n : records){
    		 
    		 if(!uniqueIP.contains(n.getIpAddress()) &&
    				 n.getStatusCode() >= low && n.getStatusCode() <= high ){
    			 uniqueIP.add(n.getIpAddress());
    		 }
    	 }
    	 
    	 return uniqueIP.size();
     }
     
     /**
      * 
      * @return HashMap<String, Integer> that maps an IP address
		to the number of times that IP address appears in records , meaning the number of
		times this IP address visited the website
      */
     public HashMap<String,Integer> countVisitsPerIP(){
    	 HashMap<String,Integer> myMap = new HashMap<String,Integer>();
    	 for(LogEntry n : records){
    		 if(myMap.containsKey(n.getIpAddress())){
    			 myMap.put(n.getIpAddress(), myMap.get(n.getIpAddress())+1);
    		 }
    		 else{
    			 myMap.put(n.getIpAddress(),1);
    		 }
    	 }
    	 
    	 return myMap;
     }
     
     
     
}