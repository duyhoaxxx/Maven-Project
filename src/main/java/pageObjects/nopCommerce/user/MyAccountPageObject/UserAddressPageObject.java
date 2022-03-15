package pageObjects.nopCommerce.user.MyAccountPageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.MyAccountPageUI.AddressesPageUI;

public class UserAddressPageObject extends BasePage {
    private WebDriver driver;

    public UserAddressPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAddNewButton() {
        clickToElement(driver, AddressesPageUI.ADD_NEW_BUTTON);
    }

    public void inputToFirstNameTextbox(String fName) {
        senkeyToElement(driver, AddressesPageUI.DYNAMIC_ADDRESS_TEXTBOX, fName, "FirstName");
    }

    public void inputToLastNameTextbox(String lName) {
        senkeyToElement(driver, AddressesPageUI.DYNAMIC_ADDRESS_TEXTBOX, lName, "LastName");
    }

    public void inputToEmailTextbox(String email) {
        senkeyToElement(driver, AddressesPageUI.DYNAMIC_ADDRESS_TEXTBOX, email, "Email");
    }

    public void inputToCompanyTextbox(String company) {
        senkeyToElement(driver, AddressesPageUI.DYNAMIC_ADDRESS_TEXTBOX, company, "Company");
    }

    public void selectCountryInDropdown(String country) {
        selectItemInDefaultDropdown(driver, AddressesPageUI.SELECT_COUNTRY, country);
    }

    public void selectStateInDropdown(String state) {
        selectItemInDefaultDropdown(driver, AddressesPageUI.SELECT_STATE, state);
    }

    public void inputToCityTextbox(String city) {
        senkeyToElement(driver, AddressesPageUI.DYNAMIC_ADDRESS_TEXTBOX, city, "City");
    }

    public void inputToAddress1Textbox(String address) {
        senkeyToElement(driver, AddressesPageUI.DYNAMIC_ADDRESS_TEXTBOX, address, "Address1");
    }

    public void inputToAddress2Textbox(String address) {
        senkeyToElement(driver, AddressesPageUI.DYNAMIC_ADDRESS_TEXTBOX, address, "Address2");
    }

    public void inputToPostalCodeTextbox(String postalCode) {
        senkeyToElement(driver, AddressesPageUI.DYNAMIC_ADDRESS_TEXTBOX, postalCode, "ZipPostalCode");
    }

    public void inputToPhoneNumberTextbox(String phoneNumber) {
        senkeyToElement(driver, AddressesPageUI.DYNAMIC_ADDRESS_TEXTBOX, phoneNumber, "PhoneNumber");
    }

    public void inputToFaxNumber(String faxNumber) {
        senkeyToElement(driver, AddressesPageUI.DYNAMIC_ADDRESS_TEXTBOX, faxNumber, "FaxNumber");
    }

    public void clickToSaveButton() {
        clickToElement(driver, AddressesPageUI.SAVE_BUTTON);
    }

    public String getAddressInfo(String value) {
        return getElementText(driver, AddressesPageUI.DYNAMIC_ADDRESS_INFO, value);
    }
}
