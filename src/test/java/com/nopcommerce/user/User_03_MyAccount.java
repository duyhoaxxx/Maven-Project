package com.nopcommerce.user;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.*;
import pageObjects.nopCommerce.user.MyAccountPageObject.*;
import pageObjects.nopCommerce.user.MenuPageObject.*;

import java.util.Random;

public class User_03_MyAccount extends BaseTest {
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserAddressPageObject addressPage;
    private UserCustomerInfoPageObject customerInfoPage;
    private UserChangePasswordPageObject changePasswordPage;
    private UserMenuComputersPageObiect computerMenuPage;
    private UserProductReviewsPageObiect productReviewsPage;
    private UserMyProductReviewsPageObject myProductReviewsPage;

    private String fNameEdit, lNameEdit, emailEdit, password, newPassword;
    CustomerInfo customer = new CustomerInfo();
    public GlobalConstants.AddressInfo addressInfo = new GlobalConstants.AddressInfo();
    WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    private void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);

        SetData();
    }

    @Test
    public void Account_01_Update_Info() {
        log.info("Account_TC:01 Update Info");
        log.info("Step1: Open My Account link");
        homePage.openHeaderPageByName(driver, "My account");
        customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
        verifyTrue(customerInfoPage.isMyAccountPageTitleDisplayedByName(driver, "Customer info"));

        log.info("Step2: Select Gender: Female");
        customerInfoPage.clickToGenderFemale();

        log.info("Step3: Edit First Name: " + customer.fName);
        customerInfoPage.inputToFirstNameTextbox(customer.fName);

        log.info("Step4: Edit Last Name: Phammm" + customer.lName);
        customerInfoPage.inputToLastNameTextbox(customer.lName);

        log.info("Step5: Edit DOB: 14/September/1997");
        customerInfoPage.selectDOB(customer.DOBDay, customer.DOBMonth, customer.DOBYear);

        log.info("Step6: Edit Email: " + customer.email);
        customerInfoPage.inputToEmailTextbox(customer.email);

        log.info("Step7: Edit Company name: " + customer.companyName);
        customerInfoPage.inputToCompanyNameTextbox(customer.companyName);

        log.info("Step8: click to Save button");
        customerInfoPage.clickToSaveButton();

        Assert.assertFalse(customerInfoPage.isGenderMale());
        Assert.assertEquals(customerInfoPage.getFirstName(), customer.fName);
        Assert.assertEquals(customerInfoPage.getLastName(), customer.lName);
        Assert.assertEquals(customerInfoPage.getDayDopdownDisplay(), customer.DOBDay);
        Assert.assertEquals(customerInfoPage.getMonthDopdownDisplay(), customer.DOBMonth);
        Assert.assertEquals(customerInfoPage.getYearDopdownDisplay(), customer.DOBYear);
        Assert.assertEquals(customerInfoPage.getEmail(), customer.email);
        Assert.assertEquals(customerInfoPage.getCompanyName(), customer.companyName);
    }

    @Test
    public void Account_02_Add_Address_Info() {
        log.info("Account_TC:02 Add Address Info");
        log.info("Step1: Open Address page");
        customerInfoPage.openMyAccountPageByName(driver, "Addresses");
        addressPage = PageGeneratorManager.getUserAddressPage(driver);
        verifyTrue(addressPage.isMyAccountPageTitleDisplayedByName(driver, "Addresses"));

        log.info("Step2: Add new button");
        addressPage.clickToAddNewButton();
        verifyTrue(addressPage.isMyAccountPageTitleDisplayedByName(driver, "Add new address"));

        log.info("Step3: input First Name: " + addressInfo.fName);
        addressPage.inputToFirstNameTextbox(addressInfo.fName);

        log.info("Step4: input Last Name: " + addressInfo.lName);
        addressPage.inputToLastNameTextbox(addressInfo.lName);

        log.info("Step5: input Email: " + addressInfo.email);
        addressPage.inputToEmailTextbox(addressInfo.email);

        log.info("Step6: input Company: " + addressInfo.companyName);
        addressPage.inputToCompanyTextbox(addressInfo.companyName);

        log.info("Step7: input Country: " + addressInfo.country);
        addressPage.selectCountryInDropdown(addressInfo.country);

        log.info("Step8: input State: " + addressInfo.state);
        addressPage.selectStateInDropdown(addressInfo.state);

        log.info("Step9: input City: " + addressInfo.city);
        addressPage.inputToCityTextbox(addressInfo.city);

        log.info("Step10: input Address1: " + addressInfo.address1);
        addressPage.inputToAddress1Textbox(addressInfo.address1);

        log.info("Step11: input Address2: " + addressInfo.address2);
        addressPage.inputToAddress2Textbox(addressInfo.address2);

        log.info("Step12: input Postal Code: " + addressInfo.postalCode);
        addressPage.inputToPostalCodeTextbox(addressInfo.postalCode);

        log.info("Step13: input Phone Number: " + addressInfo.phoneNumber);
        addressPage.inputToPhoneNumberTextbox(addressInfo.phoneNumber);

        log.info("Step14: input Fax Number: " + addressInfo.faxNumber);
        addressPage.inputToFaxNumber(addressInfo.faxNumber);

        log.info("Step15: click to Save button");
        addressPage.clickToSaveButton();

        Assert.assertEquals(addressPage.getAddressInfo("name"), addressInfo.fName + " " + addressInfo.lName);
        Assert.assertEquals(addressPage.getAddressInfo("email"), "Email: " + addressInfo.email);
        Assert.assertEquals(addressPage.getAddressInfo("phone"), "Phone number: " + addressInfo.phoneNumber);
        Assert.assertEquals(addressPage.getAddressInfo("fax"), "Fax number: " + addressInfo.faxNumber);
        Assert.assertEquals(addressPage.getAddressInfo("company"), addressInfo.companyName);
        Assert.assertEquals(addressPage.getAddressInfo("address1"), addressInfo.address1);
        Assert.assertEquals(addressPage.getAddressInfo("address2"), addressInfo.address2);
        Assert.assertEquals(addressPage.getAddressInfo("city-state-zip"), addressInfo.city + ", " + addressInfo.postalCode);
        Assert.assertEquals(addressPage.getAddressInfo("country"), addressInfo.country);
    }

    @Test
    public void Account_03_Change_Password() {
        log.info("Account_TC:03 Change Password");
        log.info("Step1: Open Change password page");
        addressPage.openMyAccountPageByName(driver, "Change password");
        changePasswordPage = PageGeneratorManager.getUserChangePasswordPage(driver);
        verifyTrue(changePasswordPage.isMyAccountPageTitleDisplayedByName(driver, "Change password"));

        log.info("Step2: Change old password: " + password + " to new password: " + newPassword);
        changePasswordPage.changePasswordForm(password, newPassword);

        verifyEquals(changePasswordPage.getBarNotificationSuccess(driver), "Password was changed");
        changePasswordPage.clickCLoseButtonBarNotification(driver);

        log.info("Step3: Logout ");
        homePage = changePasswordPage.ClickToLogoutLinkAtUserPage(driver);
        loginPage = homePage.clickToLoginLink();

        log.info("Login Fail with email: " + customer.email + "   Pass: " + password);
        loginPage.inputToEmailTextbox(customer.email);
        loginPage.inputToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        verifyEquals(loginPage.getErrorMessageLoginUnsuccessful(),
                "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");


        log.info("Login Success with email: " + customer.email + "   Pass: " + newPassword);
        homePage = loginPage.LoginAsUser(customer.email, newPassword);
        User_02_Login.LoginPageCookie = homePage.getAllCookies(driver);
        Assert.assertEquals(homePage.getTopicBlockTitle(), "Welcome to our store");
    }

    @Test
    public void Account_04_Add_Review() {
        String rvTitle = "Exp", rvText = "I think so Good!", rating = "3";

        log.info("Account_TC:04 Add Review");
        log.info("Step1: Open Menu Computers page");
        homePage.openTopMenuByName(driver, "computers");
        computerMenuPage = PageGeneratorManager.getUserMenuComputersPage(driver);
        verifyTrue(changePasswordPage.isPageTitleDisplayedByName(driver, "Computers"));

        log.info("Step2: Open Menu Computers>Desktops page");
        computerMenuPage.clickToSubCategoryByName("Desktops");
        verifyTrue(computerMenuPage.isPageTitleDisplayedByName(driver, "Desktops"));

        log.info("Step3: Click to product: Digital Storm VANQUISH 3 Custom Performance PC");
        computerMenuPage.clickToProductByName("Digital Storm VANQUISH 3 Custom Performance PC");

        log.info("Step4: Click Add your Review");
        productReviewsPage = computerMenuPage.clickToAddYourReviewLink();

        log.info("Step5: Add Review");
        productReviewsPage.addReviewForm(rvTitle, rvText, rating);

        verifyEquals(productReviewsPage.getResultAddProductReviews(), "Product review is successfully added.");

        log.info("Step6: Open My Account Link");
        productReviewsPage.openHeaderPageByName(driver, "My account");
        customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
        verifyTrue(customerInfoPage.isMyAccountPageTitleDisplayedByName(driver, "Customer info"));

        log.info("Step7: Open My Product Review");
        customerInfoPage.openMyAccountPageByName(driver, "My product reviews");
        myProductReviewsPage = PageGeneratorManager.getUserMyProductReviewsPage(driver);
        Assert.assertTrue(myProductReviewsPage.isMyAccountPageTitleDisplayedByName(driver, "My product reviews"));

        Assert.assertTrue(myProductReviewsPage.isMyProductReviewTitleDisplayed(rvTitle));
        Assert.assertTrue(myProductReviewsPage.isMyProductReviewTextDisplayed(rvText));
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

    private void RegisterNewAccountAndLogin(String tEmail) {
        registerPage = homePage.clickToResgisterLink();

        log.info("Register with email: " + tEmail + "   Pass: 123456");
        registerPage.RegiserAccountForm(fNameEdit, lNameEdit, tEmail, password);
        homePage = registerPage.ClickToLogoutLinkAtUserPage(driver);
        loginPage = homePage.clickToLoginLink();

        log.info("Login with email: " + tEmail + "   Pass: " + password);
        homePage = loginPage.LoginAsUser(emailEdit, password);
    }

    private void SetData() {
        homePage.zoomMax(driver);

        fNameEdit = "Kaneee";
        lNameEdit = "Phammm";
        emailEdit = fakeEmail();
        password = "123456";
        newPassword = "123123";
        RegisterNewAccountAndLogin(emailEdit);

        customer.fName = "Kane";
        customer.lName = "Pham";
        customer.email = fakeEmail();
        customer.companyName = "KYAutomation";
        customer.DOBDay = "14";
        customer.DOBMonth = "September";
        customer.DOBYear = "1997";

        addressInfo.fName = "Pham";
        addressInfo.lName = "Kane";
        addressInfo.email = "kane.pham123@gmail.com";
        addressInfo.companyName = "KYAutomation";
        addressInfo.country = "Viet Nam";
        addressInfo.state = "Other";
        addressInfo.city = "Ha Noi";
        addressInfo.address1 = "404 Tran Duy Hung";
        addressInfo.address2 = "404 Nguyen Khanh Toan";
        addressInfo.postalCode = "100000";
        addressInfo.phoneNumber = "0986966969";
        addressInfo.faxNumber = "0989699696";
    }

    private class CustomerInfo {
        String fName;
        String lName;
        String DOBDay;
        String DOBMonth;
        String DOBYear;
        String email;
        String companyName;
    }

    ;
}
