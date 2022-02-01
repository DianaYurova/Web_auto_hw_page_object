package test.java.context;

import org.testng.Assert;
import test.java.configuration.ConfigProperties;
import test.java.page.MainPage;
import test.java.page.SearchResultsPage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static test.java.test.BaseTest.driver;

public class SearchContext {

    public static MainPage mainPage = new MainPage(driver);
    public static SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

    public static void search(String value) {
        mainPage.inputBaseSearchField(value);
    }

    public static String checkResult() {
        return searchResultsPage.getNameOfResultHeader();
    }

    public static void checkIfResultboxIsDisplayed() {
        searchResultsPage.searchForResultsBox();
    }

    public static void searchFromClipboard() { mainPage.copyText();  }

    public static void waiter() { searchResultsPage.waiter(); }

    public static String getResultsInfo() { searchResultsPage.resultsInfo();
        return getResultsInfo();
    }
    public static void checkAmountOfResults() {
        ConfigProperties.out.println(SearchContext.getResultsInfo());
        String textResult = SearchContext.getResultsInfo();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(textResult);
        int start = 0;
        int numResult = 0;
        while (matcher.find(start)) {
            String value = textResult.substring(matcher.start(), matcher.end());
            numResult = Integer.parseInt(value);
            System.out.println(numResult);
            start = matcher.end();
            break;
        };
        Assert.assertNotEquals(numResult, 0);
    }
}
