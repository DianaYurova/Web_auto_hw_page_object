package test.java.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import test.java.configuration.ConfigProperties;

import java.time.Duration;

@Listeners(test.java.Listener.class)

public abstract class BaseTest {

    public static WebDriver driver;
    public static Actions act;

    @BeforeMethod(alwaysRun = true)
    public static void BeforeEachTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(ConfigProperties.getProperty("mainPage"));
        act = new Actions(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void AfterTest() {
        driver.close();
    }

}