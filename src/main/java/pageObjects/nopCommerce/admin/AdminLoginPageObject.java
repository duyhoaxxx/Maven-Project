package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.user.BasePageUser;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePageAdmin {
    private WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToEmailTextbox(String email) {
        senkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToPasswordTextbox(String password) {
        senkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public AdminDashboardPageObject clickToLoginButton() {
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getAdminDashboardPage(driver);
    }

    public AdminDashboardPageObject LoginAsUser(String email, String password) {
        inputToEmailTextbox(email);
        inputToPasswordTextbox(password);
        return clickToLoginButton();
    }
}
