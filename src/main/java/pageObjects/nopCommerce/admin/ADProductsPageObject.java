package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.admin.ADProductsPageUI;

public class ADProductsPageObject extends BasePageAdmin {
    private WebDriver driver;

    public ADProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputProductNameToSearch(String productName) {
        senkeyToElement(driver, ADProductsPageUI.PRODUCT_NAME_SEARCH_TEXTBOX,productName);
    }
}
