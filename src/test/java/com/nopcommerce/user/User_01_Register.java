package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class User_01_Register extends BaseTest {

    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private String firstName, lastName, email, password, existEmail;
    WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    private void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);
        // https://docs.google.com/document/d/16N5CVHwX4tVhtgvsKAggNCN6COeZSz2Onlfv8wDFo8E/edit

        SetData();
    }

    @Test
    public void Register_01_Empty_Data() {
        registerPage = homePage.clickToResgisterLink();

        log.info("Register TC:01 with empty data");
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(), "First name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
    }

    @Test
    public void Register_02_Invalid_Email() {
        registerPage = homePage.clickToResgisterLink();

        log.info("Register TC:02 with Invalid Email");
        registerPage.RegiserAccountForm(firstName, lastName, "123@123!@", password);

        Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
    }

    @Test
    public void Register_03_Email_Exist() {
        registerPage = homePage.clickToResgisterLink();

        log.info("Register TC:03 with Exist Email");
        registerPage.RegiserAccountForm(firstName, lastName, existEmail, password);

        Assert.assertEquals(registerPage.getSummaryErrorMessage(), "The specified email already exists");
    }

    @Test
    public void Register_04_Password_Less_6Characters() {
        registerPage = homePage.clickToResgisterLink();

        log.info("Register TC:04 with Password Less 6Char");
        registerPage.RegiserAccountForm(firstName, lastName, existEmail, "123");

        Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),
                "Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void Register_05_Password_NotMatch_ConfirmPassword() {
        registerPage = homePage.clickToResgisterLink();

        log.info("Register TC:05 with password not match");
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(email);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox("123578");
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),
                "The password and confirmation password do not match.");
    }

    @Test
    public void Register_06_Valid() {
        registerPage = homePage.clickToResgisterLink();

        log.info("Register TC:06 Valid");
        log.info("Register with email: " + email + "   Pass: 123456");
        registerPage.RegiserAccountForm(firstName, lastName, email, password);

        Assert.assertEquals(registerPage.getSuccessRegisterMessage(), "Your registration completed");

        log.info("Logout with email: " + email + "   Pass: 123456");
        homePage = registerPage.ClickToLogoutLinkAtUserPage(driver);
    }

    @Parameters("browser")
    @AfterClass(alwaysRun = true)
    private void afterClass(String browserName) {
        log.info("Post-Condition: Close browser " + browserName);
        cleanBrowserAndDriver();
    }

    private void SetData() {
        homePage.zoomMax(driver);

        firstName = "Kane";
        lastName = "Pham";
        email = fakeEmail();
        existEmail = fakeEmail();
        password = "123456";
        RegisterNewAccount(existEmail);
    }

    private String fakeEmail() {
        return "AutoTest" + String.valueOf((new Random().nextInt(999999))) + "@gmail.com";
    }

    private void RegisterNewAccount(String tEmail) {
        registerPage = homePage.clickToResgisterLink();

        log.info("Register with email: " + tEmail + "   Pass: 123456");
        registerPage.RegiserAccountForm(firstName, lastName, tEmail, password);
        homePage = registerPage.ClickToLogoutLinkAtUserPage(driver);
        log.info("Logout with email: " + tEmail + "   Pass: 123456");
    }

}
