package test.java.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import test.java.configuration.ConfigProperties;
import test.java.context.SearchContext;
import test.java.page.MainPage;
import test.java.page.SearchResultsPage;
import test.resources.DataProviderClass;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsString;

public class MainPageTest extends BaseTest{

    @Test(groups = {"Positives"})
    public void FirstDou() {
        String inputText = "QA вакансии";
        SearchContext.search(inputText);
        SearchContext.checkResult();
        assertThat(SearchContext.checkResult(),anyOf(containsString("QA"), containsString("вакансии"), containsString("Вакансии")));
    }

    @Test(groups = {"Positives"}, dataProvider = "InputData", dataProviderClass = DataProviderClass.class)
    public void FirstDouWithDataProvider(String keyword) {
        SearchContext.search(keyword);
        SearchContext.checkIfResultboxIsDisplayed();
    }

//    @Test (groups = {"Positives"})
//    public void SecondDou() {
//        SearchContext.searchFromClipboard();
//        SearchContext.search(MainPage.clipboard);
//        SearchContext.waiter();
//        SearchContext.checkAmountOfResults();
//    }
}
