import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestAutomationJUnit {

    public WebDriver driver;

    @Before
    public void browserSetup(){
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void targetSite(){
        driver.get("https://demoqa.com");
    }

    @Test
    public void getTitle(){
        driver.get("https://demoqa.com");
        String titleActual = driver.getTitle();
        String titleExpected = "DEMOQA";

        Assert.assertEquals(titleExpected, titleActual);

    }

    @Test
    public void getTitleImg(){
        driver.get("https://demoqa.com");
        driver.findElement(By.cssSelector("img[src='/images/Toolsqa.jpg']"));
    }


}

