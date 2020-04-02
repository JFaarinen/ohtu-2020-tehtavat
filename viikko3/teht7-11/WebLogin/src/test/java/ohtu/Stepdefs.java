package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }

    @Given("register new user is selected")
    public void newUserIsSelected() {
        openRegisteration();
    }
    
    @Given("user with username {string} with password {string} is successfully created")
    public void userIsCreated(String username, String password) throws Throwable {
        openRegisteration();
        createUserWith(username, password);
    }
    
    @Given("user with username {string} and password {string} is tried to be created")
    public void failedUserCreation(String username, String password) {
        openRegisteration();
        createUserWith(username, password);
        pageHasContent("password should have at least 8 characters");
        pageHasContent("username should have at least 3 characters");       
    }
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }  
    
    @When("nonexistent username {string} and nonexistent password {string} are given")
    public void nonexistentUsernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }  
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }

    @When("a valid username {string} and password {string} and matching password confirmation are given")
    public void validUsernameAndPasswordAreGiven(String username, String password) throws Throwable {
        createUserWith(username, password);
    }
    
    @When("too short username {string} and password {string} and matching password confirmation are given")
    public void tooShortUsernameGiven(String username, String password) throws Throwable {
        createUserWith(username, password);
    }

    @When("a valid username {string} and too short password {string} and matching password confirmation are given")
    public void tooShortPasswordGiven(String username, String password) throws Throwable {
        createUserWith(username, password);
    }
    
    @When("a valid username {string} and valid password {string} and unmatching password confirmation {string} are given")
    public void confirmationDoesntMatch(String username, String password, String confirmation) throws Throwable {
        createUserWith(username, password, confirmation);
    }
    
    @Then("a new user welcomed to application")
    public void newUserIsAccepted() {
        pageHasContent("Welcome to Ohtu Application!");
    }
    
    @Then("user is not created and error {string} is reported")
    public void userNotCreated(String error) {
        pageHasContent(error);
    }
               
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    }
    
    private void createUserWith(String username, String password) {
        createUserWith(username, password, password);
    }
    
    private void createUserWith(String username, String password, String confirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(confirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();
        
    }
    
    private void openRegisteration(){
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }
}
