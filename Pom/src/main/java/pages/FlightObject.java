package pages;

import io.qameta.allure.Step;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FlightObject extends BasePage {

    public FlightObject(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Web Elements*********z
    String FindFlights = "//input[@value='Find Flights']";
    String ChooseThisFlight = "//table[@class='table']/tbody/tr[1]/td[1]/input";
    String NameText = "//input[@id='inputName']";
  
  
    
    String usenameId = "email";
    String passwordId = "password";
    String loginButtonId = "loginButton";
    String errorMessageUsernameXpath = "//*[@id='loginForm']/div[1]/div/div";
    String errorMessagePasswordXpath = "//*[@id='loginForm']/div[2]/div/div ";

  //*********Page Variables*********
  //String baseURL = "http://www.n11.com/";
    String baseURL = "http://blazedemo.com/";
    

    //*********Web Elements*********zzz
    String signInButtonClass = "btnSignIn";
    
    //*********Page Methods*********
    @Step("Login Step with username: {0}, password: {1}, for method: {method} step...")
    public void loginToN11 (XSSFRow row){
        //Enter Username(Email)
        writeText(By.id(usenameId),row.getCell(1).toString());
        //Enter Password
        writeText(By.id(passwordId), row.getCell(2).toString());
        //Click Login Button
        click(By.id(loginButtonId));
    }
    
    
    //*********Entering name*********
    
    public void EnterName (XSSFRow row){
        //Enter name
        writeText(By.xpath(NameText),row.getCell(0).toString());
        
    }
  //*********Page Methods*********

    //Go to Homepage
    @Step("Open N11 Step...")
    public void goToN11 (){
        driver.get(baseURL);
        //driver.navigate().to(baseURL)
    }

    //Go to LoginPage
    @Step("Go to Login Page Step...")
    public void goToLoginPage (){
        click(By.className(signInButtonClass));
    }
    
    
    public void FindFlight (){
        click(By.xpath(FindFlights));
    }
    
    public void ChooseThisFlight (){
        click(By.xpath(ChooseThisFlight));
    }
    
    public void NameText (XSSFRow row){
    	writeText(By.xpath(NameText),row.getCell(1).toString());
    }
    
   
    //Verify Username Condition
    @Step("Verify username: {0} step...")
    public void verifyLoginUserName (String expectedUserNameMessage) {
        Assert.assertEquals(readText(By.xpath(errorMessageUsernameXpath)), expectedUserNameMessage);
    }

    //Verify Password Condition
    @Step("Verify verifyLoginPassword: {0} step...")
    public void verifyLoginPassword (String expectedPasswordMessage) {
        Assert.assertEquals(readText(By.xpath(errorMessagePasswordXpath)), expectedPasswordMessage);
    }
}
