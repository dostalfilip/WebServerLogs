package WebServerLogs;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Write a description of class Tester here.
 * 
 * @author (Filip Dostal) 
 * @version (23.5.2016)
 */


public class Tester
{
    public static void main(String[] args) {
    	testUniqueIPAnalyzer();
    }
    
    private static void testUniqueIPAnalyzer() {
        LogAnalyzer test = new LogAnalyzer();
        //test.readFile("./Data/short-test_log");
        //test.readFile("./Data/weblog3-short_log");
        test.readFile("./Data/weblog2_log");
        //System.out.print(test.countUniqueIPs());
        //System.out.print(test.uniqueIPVisitsOnDay("Sep 27").size());
        //System.out.print(test.countUniqueIPsInRange(400,499) );
        
       /* 
        HashMap<String,Integer> myMap = test.countVisitsPerIP();
       for(String n : myMap.keySet()){
        	System.out.println(n+" Zobrazeno: "+myMap.get(n));
        }
       System.out.print(test.mostNumberVisitsByIP(myMap) );
    */
      /*  HashMap<String,Integer> myMap = test.countVisitsPerIP();
          System.out.print(test.iPsMostVisits (myMap) );
      */  
        
      //  HashMap<String,ArrayList<String>> myMap = test.iPsForDays();
       // System.out.print(test.dayWithMostIPVisits(myMap) );
        
        
      //  System.out.println(test.mostNumberVisitsByIP(test.countVisitsPerIP()));
        
        
       // for(String n : test.iPsMostVisits(test.countVisitsPerIP())){
       // 	System.out.println(n);
       // }
        
        
        /*HashMap<String,ArrayList<String>> myMap = test.iPsForDays();
        for(String n : myMap.keySet()){
        	System.out.println("***"+n+"***");
        	for(String i : myMap.get(n)){
        		System.out.println(i);
        	}
        }
        */
        
        System.out.print(test.dayWithMostIPVisits(test.iPsForDays()));
        
        
        /*
         * Test last method iPsWithMostVisitsOnDay
         */
        
       // for (String n : test.iPsWithMostVisitsOnDay(test.iPsForDays(), "Sep 30")){
      //  	System.out.println(n);
       // }
        
        
        
        
        
        
        
        
        
    
    }  
}
