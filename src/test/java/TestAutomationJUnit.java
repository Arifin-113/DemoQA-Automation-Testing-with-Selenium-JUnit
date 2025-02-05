import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestAutomationJUnit {
    public WebDriver driver;
    @Before
    public void browserSetup(){
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
    public void targetsite(){
        driver.get("https://demoqa.com");
    }
}

