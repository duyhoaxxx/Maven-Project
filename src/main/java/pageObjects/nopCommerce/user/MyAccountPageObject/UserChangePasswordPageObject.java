package pageObjects.nopCommerce.user.MyAccountPageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.MyAccountPageUI.ChangePasswordPageUI;

public class UserChangePasswordPageObject extends BasePage {
    private WebDriver driver;

    public UserChangePasswordPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void changePasswordForm(String oldPassword, String newPassword) {
        senkeyToElement(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, oldPassword);
        senkeyToElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
        senkeyToElement(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, newPassword);

        clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
    }
}
