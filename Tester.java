package WebServerLogs;


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
        
        //test.printAll();
        //System.out.print("Unique adress: " + test.countUniqueIPs());
        //test.printAllHigherThanNum(200);
        
       // for(String n :test.uniqueIPVisitsOnDay("Sep 30")){
       // 	System.out.println(n);
       // }
        
        System.out.print(test.countUniqueIPsInRange(300,399));
    }
}
