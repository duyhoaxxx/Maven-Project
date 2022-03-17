package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.user.BasePageUser;
import pageUIs.nopCommerce.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePageAdmin {
    private WebDriver driver;

    public AdminDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardPageDisplayed() {
        return isElementDisplay(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
    }
}
