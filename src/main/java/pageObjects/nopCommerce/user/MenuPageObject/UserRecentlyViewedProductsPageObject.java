package pageObjects.nopCommerce.user.MenuPageObject;

import pageObjects.nopCommerce.user.BasePageUser;
import org.openqa.selenium.WebDriver;

public class UserRecentlyViewedProductsPageObject extends BasePageUser {
    private WebDriver driver;

    public UserRecentlyViewedProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
