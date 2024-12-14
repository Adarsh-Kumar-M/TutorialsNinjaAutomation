package com.tutorialsninja.qa.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
public class Login {

    @Test
    public void verifyLoginWithValidCredentials(){

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("deadp1136@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
        driver.quit();
    }
    @Test
    public void verifyLoginWithInvalidCredentials(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys( generateTimeStapEmail());
        driver.findElement(By.id("input-password")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText();
        Assert.assertEquals(actualWarningMessage,"Warning: No match for E-Mail Address and/or Password.");
        driver.quit();
    }

    @Test
    public void verifyLoginWithInvaliEmailAndValidPassword(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys( generateTimeStapEmail());
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText();
        Assert.assertEquals(actualWarningMessage,"Warning: No match for E-Mail Address and/or Password.");
        driver.quit();
    }

    @Test
    public void verifyLoginWithValidEmailAndInvalidPassword(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys( generateTimeStapEmail());
        driver.findElement(By.id("input-password")).sendKeys("12345634");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText();
        Assert.assertEquals(actualWarningMessage,"Warning: No match for E-Mail Address and/or Password.");
        driver.quit();
    }


     public String generateTimeStapEmail(){
        Date date=new Date();
        String timestampEmail= date.toString().replace(" ","").replace("-","");
        String Email="deadpool"+timestampEmail+"@gmail.com";
        return Email;
    }
}
