import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Main {



    public static void main(String[] args){

        GoalEN goal = new GoalEN();
        WebDriver driver = goal.make_connection();
        List<String> links = goal.getLinks(driver);
        Map<String, StringBuffer> cont = goal.getContent(links,driver);
        Iterator t = cont.entrySet().iterator();

        while (t.hasNext()) {
            Map.Entry pair = (Map.Entry)t.next();
            goal.PostNews(driver,pair.getKey().toString(),pair.getValue().toString());
//            System.out.println(pair.getKey() + " = " + pair.getValue());
            t.remove(); // avoids a ConcurrentModificationException
        }


    }




}
