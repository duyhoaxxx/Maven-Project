package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import pageUIs.nopCommerce.admin.ADDashboardPageUI;

public class ADDashboardPageObject extends BasePageAdmin {
    private WebDriver driver;

    public ADDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
