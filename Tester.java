package WebServerLogs;


/**
 * Write a description of class Tester here.
 * 
 * @author (Filip Dostal) 
 * @version (23.5.2016)
 */

import java.util.*;

public class Tester
{
    public static void main(String[] args) {
    	testUniqueIPAnalyzer();
    }
    
    private static void testUniqueIPAnalyzer() {
        LogAnalyzer test = new LogAnalyzer();
        test.readFile("./Data/short-test_log");
        test.printAll();
        System.out.print(test.countUniqueIPs());
        
    }
}
