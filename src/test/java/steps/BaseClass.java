package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;

    public static void setDriver(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void navigateToHome(){
        driver.get("http://localhost:8080/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
    }

    public static void closeDriver(){
        driver.quit();
    }

    public static void clickSpecificButton(String btnName){
        if (btnName=="home"){
            driver.findElement(By.cssSelector("a[href='/']")).click();
        }
        else {
            driver.findElement(By.cssSelector("a[href='/\"btnName\"']")).click();
        }}
    public static void homeButton(){

        driver.findElement(By.cssSelector("a[href='/']")).click();
    }
    public static void searchButton(){
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
    public static void addTextS(String text){
        driver.findElement(By.cssSelector("input[id='searchID']")).sendKeys(text);
    }

}
