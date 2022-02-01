package test.java.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import test.java.configuration.ConfigProperties;
import test.java.context.SearchContext;
import test.java.test.MainPageTest;
import test.resources.DataProviderClass;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainPage extends BasePage{

    public static String clipboard;
    public WebDriver driver;
    public Actions act;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(id = "txtGlobalSearch")
    private WebElement baseSearchField;

    @FindBy(xpath = "//span[@class = 'link-title']")
    private WebElement announce;

    public void inputBaseSearchField(String value) {
//        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(30)).
//                until(ExpectedConditions.presenceOfElementLocated((By) baseSearchField)));
        baseSearchField.sendKeys(value);
        baseSearchField.sendKeys(Keys.ENTER);
    }

    public void copyText() {
        clipboard = announce.getText().replace("&nbsp;", " ");
    }

}
