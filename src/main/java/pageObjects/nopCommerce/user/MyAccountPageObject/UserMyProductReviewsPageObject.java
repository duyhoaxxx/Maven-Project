package pageObjects.nopCommerce.user.MyAccountPageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import org.openqa.selenium.WebElement;
import pageUIs.nopCommerce.user.MyAccountPageUI.MyProductReviewsPageUI;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class UserMyProductReviewsPageObject extends BasePage {
    private WebDriver driver;

    public UserMyProductReviewsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isMyProductReviewTitleDisplayed(String rvTitle) {
        List<WebElement> allTitle = getListWebElement(driver, MyProductReviewsPageUI.ALL_TITLE_MY_PRODUCT_REVIEWS);
        for (WebElement element : allTitle) {
            if(element.getText().equals(rvTitle))
                return true;
        }
        return false;
    }

    public boolean isMyProductReviewTextDisplayed(String rvText) {
        List<WebElement> allText = getListWebElement(driver, MyProductReviewsPageUI.ALL_TEXT_MY_PRODUCT_REVIEWS);
        for (WebElement element : allText) {
            if(element.getText().equals(rvText))
                return true;
        }
        return false;
    }
}
