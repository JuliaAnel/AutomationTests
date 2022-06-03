import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumTest extends BaseUtils{

    @Test
    public void seleniumTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
//        driver.getTitle(); // => "Google"
//        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.name("btnK"));

        searchBox.sendKeys("Selenium");
        Thread.sleep(1000);
        searchButton.click();

        searchBox = driver.findElement(By.name("q"));
        Assert.assertEquals(searchBox.getAttribute("value"), "Selenium"); // => "Selenium"

        driver.quit();
    }
}
