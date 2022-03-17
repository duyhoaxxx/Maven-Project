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

    public void inputProductNameToSearch(String productName) {
        senkeyToElement(driver, ADProductsPageUI.PRODUCT_NAME_SEARCH_TEXTBOX, productName);
    }

    public boolean isNoResultDataSearch() {
        return (!isElementUndisplayed(driver, ADProductsPageUI.NO_RESULT_DATA_SEARCH_MESSAGE));
    }


    public String getMessageNoResultDataSearch() {
        return getElementText(driver, ADProductsPageUI.NO_RESULT_DATA_SEARCH_MESSAGE);
    }

    public String getAllResultSearch() {
        return String.valueOf(getElementSize(driver, ADProductsPageUI.ALL_RESULT_DATA_SEARCH));
    }

    public boolean verifyAllResult(String keySearch) {
        List<WebElement> listElements = getListWebElement(driver, ADProductsPageUI.ALL_RESULT_DATA_SEARCH_BY_NAME);
        for (WebElement elements : listElements) {
            if (!elements.getText().contains(keySearch))
                return false;
        }
        return true;
    }

    public void selectCategoryDropdownByText(String value) {
        selectItemInDefaultDropdown(driver, ADProductsPageUI.CATEGORY_DROPDOWN, value);
    }

    public void checkboxSearchSubcategories(boolean status) {
        if (isElementSelected(driver, ADProductsPageUI.SEARCH_SUBCATEGORIES_CHECKBOX) != status)
            clickToElement(driver, ADProductsPageUI.SEARCH_SUBCATEGORIES_CHECKBOX);
    }

    public void selectManufacturerDropdownByText(String value) {
        selectItemInDefaultDropdown(driver, ADProductsPageUI.MANUFACTURER_DROPDOWN, value);
    }

    public void inputGoDirectlyToProductSKU(String value) {
        senkeyToElement(driver, ADProductsPageUI.GO_DIRECTLY_TO_SKU_TEXTBOX, value);
    }

}
