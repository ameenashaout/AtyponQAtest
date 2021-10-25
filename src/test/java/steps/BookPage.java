package steps;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class BookPage extends BaseClass {
    public static void navigateToBook(){
        driver.get("http://localhost:8080/books");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public static void deleteBookA(String id){
        String part1="a[href='/books/"+id+"/delete']";
        driver.findElement(By.cssSelector(part1)).click();
    }
    public static void editBook(){

        driver.get("http://localhost:8080/books/1/edit");
    }
    public static void creatBook(){

        driver.get("http://localhost:8080/books/create");
    }
    public static void addTitle(String title){

        driver.findElement(By.cssSelector("input[id='title']")).sendKeys(title);
    }
    public static void addYear(String year){
        driver.findElement(
                By.cssSelector("input[id='year']")).sendKeys(year);
    }
    public static void saveBook(){

        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
}
