package pageObjects.nopCommerce.user.TopMenuPageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.nopCommerce.user.MyAccountPageUI.CompareProductsPageUI;

import java.util.List;

public class UserCompareProductsPageObject extends BasePage {
    private WebDriver driver;

    public UserCompareProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductNameDisplay(String productName) {
        if (isElementUndisplayed(driver, CompareProductsPageUI.ALL_PRODUCT_NAME))
            return false;
        List<WebElement> result = getListWebElement(driver, CompareProductsPageUI.ALL_PRODUCT_NAME);
        for (WebElement element : result) {
            if (element.getText().equals(productName))
                return true;
        }
        return false;
    }

    public void clickToClearListButton() {
        clickToElement(driver, CompareProductsPageUI.CLEAR_LIST_BUTTON);
    }

    public String getResultMessage() {
        return getElementText(driver, CompareProductsPageUI.NO_DATA_MESSAGE);
    }
}
