import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {



    @Test
    public void firstTest(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys("admin123");
        driver.findElement(By.cssSelector("#btnLogin")).click();
        driver.findElement(By.cssSelector("#menu_admin_viewAdminModule > b")).click();
//      /  driver.findElement(By.cssSelector("#menu_admin_viewJob"));


        Actions act = new Actions(driver);

        act.moveToElement(driver.findElement(By.cssSelector("#menu_admin_Job")))
                .perform();
        driver.findElement(By.cssSelector("#menu_admin_viewJobTitleList")).click();

        String jobTittle = "NAME";
        String jobDescript = "abcd";
        String jobDescript1 = "dbcsa";
        //test


        driver.findElement(By.cssSelector("#btnAdd")).click();
        driver.findElement(By.cssSelector("#jobTitle_jobTitle")).sendKeys(jobTittle);
        driver.findElement(By.cssSelector("#jobTitle_jobDescription")).sendKeys(jobDescript);
        driver.findElement(By.cssSelector("#btnSave")).click();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        List<WebElement> list = driver.findElements(By.xpath("//a[contains( text(),'"+ jobTittle +"')]"));
        /*if(!list.isEmpty()){

        }*/
        driver.findElement(By.xpath("//a[contains( text(),'"+ jobTittle +"')]")).click();
        driver.findElement(By.cssSelector("#btnSave")).click();
        driver.findElement(By.cssSelector("#jobTitle_jobDescription")).clear();
        driver.findElement(By.cssSelector("#jobTitle_jobDescription")).sendKeys(jobDescript1);
        driver.findElement(By.cssSelector("#btnSave")).click();
        driver.findElement(By.xpath("a[contains( text(),'NAME')]/../../td[1]")).click();

        driver.findElement(By.cssSelector("#btnDelete")).click();
        driver.findElement(By.cssSelector("#dialogDeleteBtn")).click();
        List<WebElement> list2 = driver.findElements(By.xpath("//a[contains( text(),'"+ jobTittle +"')]"));
        Assert.assertTrue(!list.isEmpty(),"fail");


        driver.quit();

    }
}