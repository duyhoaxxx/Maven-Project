package pageObjects.nopCommerce.user.MyAccountPageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.MyAccountPageUI.CustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {
    private WebDriver driver;

    public UserCustomerInfoPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToGenderFemale() {
        clickToElement(driver, CustomerInfoPageUI.RADIO_GENDER_FEMALE);
    }

    public void clickToGenderMale() {
        clickToElement(driver, CustomerInfoPageUI.RADIO_GENDER_MALE);
    }

    public void inputToFirstNameTextbox(String fName) {
        senkeyToElement(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, fName);
    }

    public void inputToLastNameTextbox(String lName) {
        senkeyToElement(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, lName);
    }

    public void selectDOB(String sDay, String sMonth, String sYear) {
        selectItemInDefaultDropdown(driver, CustomerInfoPageUI.SELECT_DOBDAY, sDay);
        selectItemInDefaultDropdown(driver, CustomerInfoPageUI.SELECT_DOBMONTH, sMonth);
        selectItemInDefaultDropdown(driver, CustomerInfoPageUI.SELECT_DOBYEAR, sYear);
    }

    public void inputToEmailTextbox(String email) {
        senkeyToElement(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToCompanyNameTextbox(String companyName) {
        senkeyToElement(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX, companyName);
    }

    public void clickToSaveButton() {
        clickToElement(driver, CustomerInfoPageUI.SAVE_INFO_BUTTON);
    }

    public boolean isGenderMale() {
        return isElementSelected(driver, CustomerInfoPageUI.RADIO_GENDER_MALE);
    }

    public String getFirstName() {
        return getElementAttribute(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    public String getLastName() {
        return getElementAttribute(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
    }

    public String getDayDopdownDisplay() {
        return getFirstSelectedItemDefaultDropdown(driver, CustomerInfoPageUI.SELECT_DOBDAY);
    }

    public String getMonthDopdownDisplay() {
        return getFirstSelectedItemDefaultDropdown(driver, CustomerInfoPageUI.SELECT_DOBMONTH);
    }

    public String getYearDopdownDisplay() {
        return getFirstSelectedItemDefaultDropdown(driver, CustomerInfoPageUI.SELECT_DOBYEAR);
    }

    public String getEmail() {
        return getElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

    public String getCompanyName() {
        return getElementAttribute(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX, "value");
    }
}
