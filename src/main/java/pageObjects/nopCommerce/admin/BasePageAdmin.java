package pageObjects.nopCommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.admin.BasePageAdminUI;

public class BasePageAdmin extends BasePage {
    public void clickLeftMenuByName(WebDriver driver, String name) {
        clickToElement(driver, BasePageAdminUI.DYNAMIC_LEFT_MENU_BY_NAME, name);
    }
}
