package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.ADLoginPageUI;

public class ADLoginPageObject extends BasePageAdmin {
    private WebDriver driver;

    public ADLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToEmailTextbox(String email) {
        senkeyToElement(driver, ADLoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToPasswordTextbox(String password) {
        senkeyToElement(driver, ADLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public ADDashboardPageObject clickToLoginButton() {
        clickToElement(driver, ADLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getAdminDashboardPage(driver);
    }

    public ADDashboardPageObject LoginAsUser(String email, String password) {
        inputToEmailTextbox(email);
        inputToPasswordTextbox(password);
        return clickToLoginButton();
    }
}
