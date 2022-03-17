package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.LoginPageUI;

public class UserLoginPageObject extends BasePageUser {
    private WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserHomePageObject clickToLoginButton() {
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    public String getErrorMessageAtEmailTextbox() {
        return getElementText(driver, LoginPageUI.EMAIL_EMPTY_ERR_MESSAGE);
    }

    public void inputToEmailTextbox(String invalidEmail) {
        senkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, invalidEmail);
    }

    public String getErrorMessageLoginUnsuccessful() {
        return getElementText(driver, LoginPageUI.LOGIN_ERR_MESSAGE);
    }

    public void inputToPasswordTextbox(String password) {
        senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public UserHomePageObject LoginAsUser(String email, String password) {
        inputToEmailTextbox(email);
        inputToPasswordTextbox(password);

        return clickToLoginButton();
    }

    public UserHomePageObject closeResultNotificalLoginByCookies() {
        clickToElement(driver,LoginPageUI.CLOSE_RESULT_MESSAGE_LOGGIN_COOKIES_BUTTON);
        clickToElement(driver,LoginPageUI.HEADER_LOGO);
        return PageGeneratorManager.getUserHomePage(driver);
    }
}
