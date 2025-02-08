import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

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
    @Test
    public void clickme() {
        driver.get("https://demoqa.com/buttons");
        Actions actions = new Actions(driver);
        WebElement button = driver.findElements(By.xpath("//button[contains(text(),'Click Me')]")).get(2);
        actions.click(button).perform();

    }
    @Test
    public void clickMultipleButtons(){
        driver.get("https://demoqa.com/buttons");
        Actions action = new Actions(driver);

        List<WebElement> list = driver.findElements(By.cssSelector("button"));

        action.doubleClick(list.get(1)).perform();
        String text = driver.findElement(By.id("doubleClickMessage")).getText();
        Assert.assertTrue(text.contains("You have done a double click"));

        action.contextClick(list.get(2)).perform();
        String text2 = driver.findElement(By.id("rightClickMessage")).getText();
        Assert.assertTrue(text2.contains("You have done a right click"));


//        action.click(list.get(3)).perform();
//        list.get(3).click();
//        String text3 = driver.findElement(By.id("dynamicClickMessage")).getText();
//        Assert.assertTrue(text3.contains("You have done a dynamic click"));
    }

//
    @Test
    public void handleAlerts() throws InterruptedException {
    driver.get("https://demoqa.com/alerts");

    // Set an implicit wait (use Duration instead of int)
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.findElement(By.id("alertButton")).click();
    driver.switchTo().alert().accept();

    WebElement promtButton = driver.findElement(By.id("promtButton"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", promtButton);

    WebElement iframe = driver.findElement(By.cssSelector("iframe[id^='google_ads_iframe']"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", iframe);

    promtButton.click();
    driver.switchTo().alert().sendKeys("Arifin");
    driver.switchTo().alert().accept();

    String text = driver.findElement(By.id("promptResult")).getText();
    Assert.assertTrue(text.contains("Arifin"));
    }

    @Test
    public void datepicker() {
        driver.get("https://demoqa.com/date-picker");
        driver.findElement(By.id("datePickerMonthYearInput")).click();
        driver.findElement(By.id("datePickerMonthYearInput")).sendKeys(Keys.CONTROL + "A" + Keys.BACK_SPACE);
        driver.findElement(By.id("datePickerMonthYearInput")).sendKeys("01/09/1998", Keys.ENTER);
//        driver.findElement(By.id("datePickerMonthYearInput")).sendKeys(Keys.ENTER);
    }




}

