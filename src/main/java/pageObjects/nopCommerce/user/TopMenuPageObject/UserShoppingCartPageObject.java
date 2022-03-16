package pageObjects.nopCommerce.user.TopMenuPageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.nopCommerce.user.TopMenuPageUI.ShoppingCartPageUI;

import java.util.List;

public class UserShoppingCartPageObject extends BasePage {
    private WebDriver driver;

    public UserShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductNameDisplay(String productName) {
        if (isElementUndisplayed(driver, ShoppingCartPageUI.ALL_PRODUCT_IN_WISHLIST))
            return false;
        List<WebElement> listElement = getListWebElement(driver, ShoppingCartPageUI.ALL_PRODUCT_IN_WISHLIST);
        for (WebElement element : listElement) {
            if (element.getText().equals(productName))
                return true;
        }
        return false;
    }
}
