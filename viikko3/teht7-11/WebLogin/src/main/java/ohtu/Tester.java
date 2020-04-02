package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {
    private static WebDriver driver = new ChromeDriver();
    private static Random randy = new Random();

    public static void main(String[] args) {
        

        driver.get("http://localhost:4567");
        
        sleep(2);
        //sisaanKirjautuminen();
        //sisaanKirjautuminenfails();
        //uudenKayttajanLuominen();
        uudenKayttajanUloskirjautuminen();

        sleep(2);
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
    
    private static void sisaanKirjautuminen() {
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
    }
    
    private static void sisaanKirjautuminenfails() {
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("okkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
    }
    
    private static void uudenKayttajanLuominen() {
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("Juho" + randy.nextInt(1000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("ohuJ");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("ohuJ");
        
        sleep(2);
        element.submit();

        sleep(3);
    }
    
    private static void uudenKayttajanUloskirjautuminen() {
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("Juho" + randy.nextInt(1000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("FohuJ");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("FohuJ");
        
        sleep(2);
        element.submit();

        sleep(2);
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        
        sleep(2);
        element = driver.findElement(By.linkText("logout"));
        element.click();
    }
}
