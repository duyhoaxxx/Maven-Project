package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePageUser {

    private WebDriver driver;

    public UserRegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegisterPageObject clickToRegisterButton() {
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
        return PageGeneratorManager.getUserRegisterPage(driver);
    }

    public String getErrorMessageAtFirstNameTextbox() {
        return getElementText(driver, RegisterPageUI.FIRST_NAME_ERR_MESSAGE);
    }

    public String getErrorMessageAtLastNameTextbox() {
        return getElementText(driver, RegisterPageUI.LAST_NAME_ERR_MESSAGE);

    }

    public String getErrorMessageAtEmailTextbox() {
        return getElementText(driver, RegisterPageUI.EMAIL_ERR_MESSAGE);
    }

    public String getErrorMessageAtPasswordTextbox() {
        return getElementText(driver, RegisterPageUI.PASSWORD_ERR_MESSAGE);
    }

    public String getErrorMessageAtConfirmPasswordTextbox() {
        return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERR_MESSAGE);
    }

    public String getSummaryErrorMessage() {
        return getElementText(driver, RegisterPageUI.SUMMARY_ERR_MESSAGE);
    }

    public void inputToFirstNameTextbox(String firstName) {
        senkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        senkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);

    }

    public void inputToEmailTextbox(String email) {
        senkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);

    }

    public void inputToPasswordTextbox(String password) {
        senkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void inputToConfirmPasswordTextbox(String confirmPassword) {
        senkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    public UserRegisterPageObject RegiserAccountForm(String firstName, String lastName, String email, String password) {
        inputToFirstNameTextbox(firstName);
        inputToLastNameTextbox(lastName);
        inputToEmailTextbox(email);
        inputToPasswordTextbox(password);
        inputToConfirmPasswordTextbox(password);

        return clickToRegisterButton();
    }

    public String getSuccessRegisterMessage() {
        return getElementText(driver, RegisterPageUI.RESGISTER_SUCCESS_MESSAGE);
    }
}
