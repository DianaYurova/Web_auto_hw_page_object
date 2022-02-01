package test.java.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {

    public boolean isDisplayed(WebElement webElement) {return webElement.isDisplayed();}

}
