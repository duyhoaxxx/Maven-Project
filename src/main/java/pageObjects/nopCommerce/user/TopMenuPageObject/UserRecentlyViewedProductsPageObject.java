package pageObjects.nopCommerce.user.TopMenuPageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserRecentlyViewedProductsPageObject extends BasePage {
    private WebDriver driver;

    public UserRecentlyViewedProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
