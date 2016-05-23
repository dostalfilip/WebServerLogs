package WebServerLogs;

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
        test.readFile("./Data/short-test_log");

    
      //  HashMap<String,Integer> myMap = test.countVisitsPerIP();
      //  for(String n : myMap.keySet()){
      //  	System.out.println(n+" Zobrazeno: "+myMap.get(n));
      //  }
    
        
        
        
    
    }  
}
