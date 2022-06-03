import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SoundcloudTest extends BaseUtils{

    @Test
    public void testSoundcloud () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.soundcloud.com");
        WebElement accept = driver.findElement(By.id("onetrust-accept-btn-handler"));
        accept.sendKeys(Keys.ENTER);

        WebElement search =  driver.findElement(By.xpath("//span[@class='frontContent__search g-dark']//input[@name='q']"));
        search.sendKeys("Kendrick Lamar");

        Assert.assertEquals(search.getAttribute("value"), "Kendrick Lamar");
        WebElement button = driver.findElement(By.xpath(
                "//span[@class='frontContent__search g-dark']//button[@type='submit'][normalize-space()='Search']"
        ));
        search.sendKeys(Keys.ENTER);
    }
}
