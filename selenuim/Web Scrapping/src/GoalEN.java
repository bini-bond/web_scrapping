import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GoalEN extends Websites{
    private final  String articleClass= "type-article";
    private final  String url = "http://goal.com";
    public ArrayList<String> links = new ArrayList<String>();

    @Override
    public List<String> getLinks(WebDriver driver) {
        driver.get(url);
        List<WebElement> article_card = driver.findElements(By.className(articleClass));
        for(WebElement web_element : article_card){

            WebElement link = web_element.findElement(By.tagName("a"));
            String link_txt =link.getAttribute("href");

            if(link_txt.startsWith("http://www.goal.com/en/news/"))
                links.add(link_txt);

        }



        return links;
    }

    @Override
    public HashMap<String, StringBuffer> getContent(List<String> links,WebDriver driver) {

        HashMap<String,StringBuffer> content = new HashMap<>();

        for(String link:links){

            driver.get(link);
            WebElement article = driver.findElement(By.className("widget-article"));
            WebElement header = article.findElement(By.className("article-header"));
            String header_text = header.getText();
            StringBuffer parag = new StringBuffer();
            List<WebElement> paragraphs = article.findElements(By.tagName("p"));

            for(WebElement ele: paragraphs){
                parag.append(ele.getText()+"\n");
            }


            content.put(header_text,parag);



        }
        return content;
    }


}
