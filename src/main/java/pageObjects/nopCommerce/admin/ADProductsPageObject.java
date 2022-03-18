package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.nopCommerce.admin.ADProductsPageUI;

import java.util.List;

public class ADProductsPageObject extends BasePageAdmin {
    private WebDriver driver;

    public ADProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyAllResult(String keySearch) {
        List<WebElement> listElements = getListWebElement(driver, ADProductsPageUI.ALL_RESULT_DATA_SEARCH_BY_NAME);
        for (WebElement elements : listElements) {
            if (!elements.getText().contains(keySearch))
                return false;
        }
        return true;
    }

    public void searchGoDirectlyToProductSKUByText(String value) {
        senkeyToElement(driver, ADProductsPageUI.GO_DIRECTLY_SKU_TEXTBOX, value);
        clickToElementByJS(driver, ADProductsPageUI.GO_DIRECTLY_SKU_BUTTON);
    }
}
