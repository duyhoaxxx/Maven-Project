package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.*;

import java.util.Random;

public class User_03_MyAccount extends BaseTest {
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserAddressPageObject addressPage;
    private UserCustomerInfoPageObject customerInfoPage;
    private String fNameEdit, lNameEdit, emailEdit, password;
    CustomerInfo customer = new CustomerInfo();
    AddressInfo addressInfo = new AddressInfo();
    WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);
        homePage.zoomMax(driver);
        SetupData();
    }

    @Test
    public void Account_01_Update_Info() {
        log.info("Account_TC:01 Update Info");
        log.info("Step1: Open My Account link");
        customerInfoPage = homePage.clickToMyAccountLink();
        Assert.assertTrue(customerInfoPage.isPageTitleDisplayedByName(driver, "Customer info"));

        log.info("Step2: Select Gender: Female");
        customerInfoPage.clickToGenderFemale();

        log.info("Step3: Edit First Name: " + customer.fName);
        customerInfoPage.inputToFirstNameTextbox(customer.fName);

        log.info("Step4: Edit Last Name: Phammm" + customer.lName);
        customerInfoPage.inputToLastNameTextbox(customer.lName);

        log.info("Step5: Edit DOB: 14/September/1997");
        customerInfoPage.selectDOB(customer.DOBDay, customer.DOBMonth, customer.DOBYear);

        log.info("Step6: Edit Email: " + customer.Email);
        customerInfoPage.inputToEmailTextbox(customer.Email);

        log.info("Step7: Edit Company name: " + customer.CompanyName);
        customerInfoPage.inputToCompanyNameTextbox(customer.CompanyName);

        log.info("Step8: click to Save button");
        customerInfoPage.clickToSaveButton();

        Assert.assertFalse(customerInfoPage.isGenderMale());
        Assert.assertEquals(customerInfoPage.getFirstName(), customer.fName);
        Assert.assertEquals(customerInfoPage.getLastName(), customer.lName);
        Assert.assertEquals(customerInfoPage.getDayDopdownDisplay(), customer.DOBDay);
        Assert.assertEquals(customerInfoPage.getMonthDopdownDisplay(), customer.DOBMonth);
        Assert.assertEquals(customerInfoPage.getYearDopdownDisplay(), customer.DOBYear);
        Assert.assertEquals(customerInfoPage.getEmail(), customer.Email);
        Assert.assertEquals(customerInfoPage.getCompanyName(), customer.CompanyName);
    }

    @Test
    public void Account_02_Add_Address_Info() {
        log.info("Account_TC:02 Add Address Info");
        log.info("Step1: Open Address page");
        addressPage = customerInfoPage.openAddressPage(driver);
        Assert.assertTrue(customerInfoPage.isPageTitleDisplayedByName(driver, "Addresses"));

        log.info("Step2: Add new button");
        addressPage.clickToAddNewButton();
        Assert.assertTrue(customerInfoPage.isPageTitleDisplayedByName(driver, "Add new address"));

        log.info("Step3: input First Name: " + addressInfo.fName);
        addressPage.inputToFirstNameTextbox(addressInfo.fName);

        log.info("Step4: input Last Name: " + addressInfo.lName);
        addressPage.inputToLastNameTextbox(addressInfo.lName);

        log.info("Step5: input Email: " + addressInfo.Email);
        addressPage.inputToEmailTextbox(addressInfo.Email);

        log.info("Step6: input Company: " + addressInfo.CompanyName);
        addressPage.inputToCompanyTextbox(addressInfo.CompanyName);

        log.info("Step7: input Country: " + addressInfo.Country);
        addressPage.selectCountryInDropdown(addressInfo.Country);

        log.info("Step8: input State: " + addressInfo.State);
        addressPage.selectStateInDropdown(addressInfo.State);

        log.info("Step9: input City: " + addressInfo.City);
        addressPage.inputToCityTextbox(addressInfo.City);

        log.info("Step10: input Address1: " + addressInfo.Address1);
        addressPage.inputToAddress1Textbox(addressInfo.Address1);

        log.info("Step11: input Address2: " + addressInfo.Address2);
        addressPage.inputToAddress2Textbox(addressInfo.Address2);

        log.info("Step12: input Postal Code: " + addressInfo.PostalCode);
        addressPage.inputToPostalCodeTextbox(addressInfo.PostalCode);

        log.info("Step13: input Phone Number: " + addressInfo.PhoneNumber);
        addressPage.inputToPhoneNumberTextbox(addressInfo.PhoneNumber);

        log.info("Step14: input Fax Number: " + addressInfo.FaxNumber);
        addressPage.inputToFaxNumber(addressInfo.FaxNumber);

        log.info("Step15: click to Save button");
        addressPage.clickToSaveButton();

        Assert.assertEquals(addressPage.getAddressInfo("name"), addressInfo.fName + " " + addressInfo.lName);
        Assert.assertEquals(addressPage.getAddressInfo("email"), "Email: " + addressInfo.Email);
        Assert.assertEquals(addressPage.getAddressInfo("phone"), "Phone number: " + addressInfo.PhoneNumber);
        Assert.assertEquals(addressPage.getAddressInfo("fax"), "Fax number: " + addressInfo.FaxNumber);
        Assert.assertEquals(addressPage.getAddressInfo("company"), addressInfo.CompanyName);
        Assert.assertEquals(addressPage.getAddressInfo("address1"), addressInfo.Address1);
        Assert.assertEquals(addressPage.getAddressInfo("address2"), addressInfo.Address2);
        Assert.assertEquals(addressPage.getAddressInfo("city-state-zip"), addressInfo.City + ", " + addressInfo.PostalCode);
        Assert.assertEquals(addressPage.getAddressInfo("country"), addressInfo.Country);
    }

    @Test
    public void Account_03_Change_Password() {

    }

    @Test
    public void Account_04_Add_Review() {

    }


    @Parameters("browser")
    @AfterClass(alwaysRun = true)
    private void afterClass(String browserName) {
        log.info("Post-Condition: Close browser " + browserName);
        cleanBrowserAndDriver();
    }

    private String fakeEmail() {
        return "AutoTest" + String.valueOf((new Random().nextInt(999999))) + "@gmail.com";
    }

    public void RegisterNewAccountAndLogin(String tEmail) {
        registerPage = homePage.clickToResgisterLink();

        log.info("Register with email: " + tEmail + "   Pass: 123456");
        registerPage.RegiserAccountForm(fNameEdit, lNameEdit, tEmail, password);
        homePage = registerPage.ClickToLogoutLinkAtUserPage(driver);
        loginPage = homePage.clickToLoginLink();

        log.info("Login with email: " + tEmail + "   Pass: " + password);
        homePage = loginPage.LoginAsUser(emailEdit, password);
    }

    public void SetupData() {
        fNameEdit = "Kaneee";
        lNameEdit = "Phammm";
        emailEdit = fakeEmail();
        password = "123456";
        RegisterNewAccountAndLogin(emailEdit);

        customer.fName = "Kane";
        customer.lName = "Pham";
        customer.Email = "kane.pham9x@gmail.com";
        customer.CompanyName = "KYAutomation";
        customer.DOBDay = "14";
        customer.DOBMonth = "September";
        customer.DOBYear = "1997";

        addressInfo.fName = "Pham";
        addressInfo.lName = "Kane";
        addressInfo.Email = "kane.pham123@gmail.com";
        addressInfo.CompanyName = "KYAutomation";
        addressInfo.Country = "Viet Nam";
        addressInfo.State = "Other";
        addressInfo.City = "Ha Noi";
        addressInfo.Address1 = "404 Tran Duy Hung";
        addressInfo.Address2 = "404 Nguyen Khanh Toan";
        addressInfo.PostalCode = "100000";
        addressInfo.PhoneNumber = "0986966969";
        addressInfo.FaxNumber = "0989699696";
    }

    class CustomerInfo {
        String fName;
        String lName;
        String DOBDay;
        String DOBMonth;
        String DOBYear;
        String Email;
        String CompanyName;
    }

    ;

    class AddressInfo {
        String fName;
        String lName;
        String Email;
        String CompanyName;
        String Country;
        String State;
        String City;
        String Address1;
        String Address2;
        String PostalCode;
        String PhoneNumber;
        String FaxNumber;

    }

    ;


}
