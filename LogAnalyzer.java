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
     
     /**
      * 
      * @param 	inputMap that maps an IP address to the number of times
				that IP address appears in the web log file
      * @return the maximum number of
				visits to this website by a single IP address.
      */
     public int mostNumberVisitsByIP(HashMap<String, Integer> inputMap){
    	 int top = 0;
    	 for(String n : inputMap.keySet()){
    		 if(top < inputMap.get(n)){
    			 top = inputMap.get(n);
    		 }
    	 }
    	 
    	 
    	 return top;
     }
     
     /**
      * 
      * @param 	inputMap that maps an IP address to the number of times that IP
				address appears in the web log file.
      * @return an ArrayList of Strings of IP
	  *			addresses that all have the maximum number of visits to this website
      */
     public ArrayList<String> iPsMostVisits(HashMap<String, Integer> inputMap){
    	 ArrayList<String> output = new ArrayList<String>();
    	 int top = mostNumberVisitsByIP(inputMap);
    	 for(String n : inputMap.keySet()){
    		 if(top == inputMap.get(n)){
    			 output.add(n);
    		 }
    		 
    	 }
    	 System.out.println("The biggist occurance of IP is " + top +" times.");
    	 
    	 return output;
     }
     
     /**
      * 
      * @return	HashMap<String, ArrayList<String>> that uses records and maps
				days from web logs to an ArrayList of IP addresses that occurred on that day.
      */
     public HashMap<String, ArrayList<String>> iPsForDays(){
    	 HashMap<String,ArrayList<String>> output = new HashMap<String,ArrayList<String>>();
    	 ArrayList<String> days = new ArrayList<String>();
    	 for(LogEntry n : records){
    		 String temp = n.getAccessTime().toString().substring(4, 10);
    		 days.add(temp);
    	 }
    	 for(String n : days){
    		 ArrayList<String> list = new ArrayList<String>();
    		 
    		 /*
    		  *adding IP by IP 
    		  *it is not unique addres
    		  */
    		 
    		for(LogEntry i : records){
        		 String temp = i.getAccessTime().toString().substring(4, 10);
        		 if(temp.equals(n)){
        			 list.add(i.getIpAddress());
        		 }
    		} 
    		output.put(n, list);
    	 }
    	 return output;
     }
     
     /**
      * 
      * @param input
      * @return days from web logs to an ArrayList of IP addresses that occurred on that day. This
      			method returns the day that has the most IP address visits. If there is a tie, then return
      */
     public String dayWithMostIPVisits(HashMap <String,ArrayList<String>> input){
    	 int size = 0;
    	 String name = "";
    	 for(String n : input.keySet()){
    		 ArrayList<String> temp = input.get(n);
    		 if(temp.size() > size){
    			 size = temp.size();
    			 name = n;
    		 } 
    	 }
    	 return name;
     }
     
     
     /**
      * 
      * @param 	inputMap
      * 		HashMap<String, ArrayList<String>> that uses records
				and maps days from web logs to an ArrayList of IP addresses that occurred on that day
      * @param 	day
      * 		String representing a day in the format “MMM DD”
      * @return	ArrayList<String> of IP addresses that had the
				most accesses on the given day
      */
     public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> inputMap,String day){
    	 int top = 0;
    	 ArrayList<String> output = new ArrayList<String>();    	 
    	 HashMap<String,Integer> rating = new HashMap<String,Integer>();
    	 
    	 for(String n : inputMap.get(day)){
    		 if(rating.containsKey(n)){
    			rating.put(n, rating.get(n)+1); 
    		 }
    		 else{
    			rating.put(n, 1); 
    		 }
    	 }    	 
    	 for(String n : rating.keySet()){
    		 int temp = rating.get(n);
    		 if(top< temp){
    			 top = temp;
    		 } 
    	 }
    	 
    	 for(String n : rating.keySet()){
    		 if(rating.get(n) == top){
    			 output.add(n);
    		 }
    	 }
    	 
    	 
    	 return output;
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
}