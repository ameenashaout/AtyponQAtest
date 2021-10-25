package steps;

import org.openqa.selenium.By;

import static steps.BaseClass.driver;

public class AuthorsPage {
    public static void authorsButton(){

        driver.findElement(By.cssSelector("a[href='/authors']")).click();
    }

}
