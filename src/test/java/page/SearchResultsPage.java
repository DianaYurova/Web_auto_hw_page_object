package test.java.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsString;

public class SearchResultsPage extends BasePage {

    public WebDriver driver;
    public WebElement dynamicElement;

    public SearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id = 'gsc-i-id1']")
    private WebElement searchInputResultsPage;

    @FindBy(xpath = "//button[@class=\\\"gsc-search-button gsc-search-button-v2\\\"]")
    @CacheLookup
    private WebElement loupeButton;

    @FindBy(className = "gsc-resultsbox-visible")
    private WebElement resultsBox;

    @FindBy(xpath = "//div[@class='gsc-wrapper']//div[@class='gs-title']/a[@class='gs-title']")
    private WebElement resultHeader;

    @FindBy(className = "gsc-result-info")
    private WebElement resultsAmount;

    @FindBy(xpath = "//div[@class='gs-snippet']")
    private WebElement nothingFoundBox;

    @FindBy(xpath = "//div[@class='gsc-wrapper']//div[@class='gs-title']/a[@class='gs-title']")
    private List<WebElement> webElementsHeaders;

    public String getNameOfResultHeader() {
        return resultHeader.getText();
 //       assertThat(nameOfResultHeader,anyOf(containsString("QA"), containsString("вакансии"), containsString("Вакансии")));
    }

    public void searchForResultsBox() {
        Assert.assertTrue(resultsBox.isDisplayed());
    }

    public void waiter() {
        dynamicElement = (new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.visibilityOf(resultsBox)));
    }

    public void resultsInfo() {
        resultsAmount.getText();
    }


}