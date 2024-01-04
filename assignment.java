package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;


public class assignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
       Wait<WebDriver> EX_Wait = new WebDriverWait(driver, Duration.ofSeconds(7));



        // go to url
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        //maximize  screen
        driver.manage().window().maximize();
        //adding values
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("learning");
        //radio button
        driver.findElement(By.xpath("//*[@value='user']")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id='okayBtn']")).getText());
        EX_Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='okayBtn']")));

        driver.findElement(By.xpath("//*[@id='okayBtn']")).click();

        //dropdown
      WebElement list =  driver.findElement(By.xpath("//*[@data-style='btn-info']"));
      Select drops = new Select(list);
        drops.selectByValue("consult");

        //checkbox
        driver.findElement(By.xpath("//*[@id='terms']")).click();

        //signIn button
        driver.findElement(By.xpath("//*[@id='signInBtn']")).click();
        //move to next page
        EX_Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='nav-link btn btn-primary']")));
        List<WebElement> cards = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
      // add all items to cart
        for (WebElement card : cards) {
            card.click();
        }

        // go to check out
        driver.findElement(By.xpath("//*[@class='nav-link btn btn-primary']")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-success']")).click();
        // add location

        driver.findElement(By.xpath("//input[@class='validate filter-input form-control ng-untouched ng-pristine ng-valid']")).sendKeys("in");
        EX_Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='suggestions']")));
        List<WebElement> city = driver.findElements(By.xpath("//*[@class='suggestions']//child::ul"));
        for (WebElement cont : city) {
            if (cont.getText().equals("India")) {
                cont.click();
                break;
            }
        }

        //accept terms
        driver.findElement(By.xpath("//*[@for='checkbox2']")).click();
        driver.findElement(By.xpath("//input[@class='btn btn-success btn-lg']")).click();

        //final result

        WebElement result = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("×\n" +
                "Success! Thank you! Your order will be delivered in next few weeks :-).",result.getText() );

        driver.quit();


    }
}
