import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestAutomationJUnit {

    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void browserSetup() {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void targetSite() {
        driver.get("https://demoqa.com");
    }

    @Test
    public void getTitle() {
        driver.get("https://demoqa.com");
        String titleActual = driver.getTitle();
        String titleExpected = "DEMOQA";

        Assert.assertEquals(titleExpected, titleActual);

    }

    @Test
    public void getTitleImg() {
        driver.get("https://demoqa.com");
        driver.findElement(By.cssSelector("img[src='/images/Toolsqa.jpg']"));
    }

    @Test
    public void write() {
        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.id("userName")).sendKeys("Arifin");
        driver.findElement(By.id("userEmail")).sendKeys("xyz@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("BD");
        driver.findElement(By.id("permanentAddress")).sendKeys("BD");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(By.id("submit")).click();
        String text = driver.findElement(By.id("name")).getText();
        Assert.assertTrue(text.contains("Arifin"));
    }


    public void writeOnTextBox() {
        driver.get("https://demoqa.com/elements");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Text Box')]"))).click();
        driver.findElement(By.cssSelector("#userName")).sendKeys("Mahmud");
        driver.findElement(By.cssSelector("#submit")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#name")).getText().contains("Mahmud"));

    }
    @Test
    public void doubleClickMe() {
        driver.get("https://demoqa.com/buttons");
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
        actions.doubleClick(button).perform();
    }

      public void clickMe() {
          driver.get("https://demoqa.com/buttons");
          driver.findElement(By.xpath("//button[@id='doubleClickBtn']")).click();
}



}

