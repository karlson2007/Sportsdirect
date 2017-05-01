package Sportsdirect;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * First test fot open page Sportsdirect.com
 */
public class Sportsdirect {

    @Test
    public void starttest() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        // Open page Sportsdirect.com && Check title
        driver.get("http://sportsdirect.com");
        Assert.assertEquals("SportsDirect.com – The UK’s No 1 Sports Retailer", driver.getTitle());

        // WAR WITH MODAL POPUP
        // This code not working
        // driver.findElement(By.className("img-responsive")).click();

        // This Work! I don't now..
        WebElement foo = driver.findElement(By.className("img-responsive"));
        Actions bar = new Actions(driver);
        bar.click(foo).perform();

        // Waiting for page full load && element Sports existing
        WebElement elementx = (new WebDriverWait(driver, 10)) .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"topMenu\"]/ul/li[6]")));

        // Click link Sports && Check title
        driver.findElement(By.xpath("//*[@id=\"topMenu\"]/ul/li[6]")).click();
        Assert.assertEquals("Sports Direct Latvia > Pages > sport", driver.getTitle());

        // Click link Swimming
        driver.findElement(By.xpath("//*[@id=\"dnn_ctr29808065_HtmlModule_lblContent\"]/div/div/div[2]/div[1]/ul/li[32]/a")).click();

        // Click link SwimmSuits
        driver.findElement(By.xpath("//*[@id=\"dnn_ctr29808104_HtmlModule_lblContent\"]/div[2]/div[1]/div/div/div[3]/div[1]/div/div/nav/ul/li[7]/a")).click();

        // Select filter
        driver.findElement(By.xpath("//span[@data-item='AFLOR^Girls']")).click();
        driver.findElement(By.xpath("//span[@data-item='AFLOR^Unisex Adults']")).click();

        // Close browser
        driver.quit();
    }
}


