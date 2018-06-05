import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.Json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Websites {


    public WebDriver make_connection(){

        try{
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        catch(Exception ex){
            System.err.println("Couldn't find the driver");

        }
        WebDriver my_driver = new ChromeDriver();



        return my_driver;
    }

    public  abstract List<String> getLinks(WebDriver driver);

    public abstract HashMap<String,StringBuffer> getContent(List<String> links,WebDriver driver);

    public static void PostNews(WebDriver driver,String title, String content){
        driver.get("http://localhost:3000");
        WebElement username;
        username = driver.findElement(By.id("title"));
        WebElement password;
        password = driver.findElement(By.id("content"));
        username.sendKeys(title);
        password.sendKeys(content);
        WebElement form = driver.findElement(By.id("addForm"));
        form.submit();

    }


}
