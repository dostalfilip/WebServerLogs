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
       /* LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
        */ 
        testLogAnalyzer();
    }
    
    private static void testLogAnalyzer() {
        LogAnalyzer test = new LogAnalyzer();
        test.readFile("./Data/short-test_log");
        test.printAll();
        
    }
}
