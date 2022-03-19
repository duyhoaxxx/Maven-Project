package com.nopcommerce.user;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class User_02_Login extends BaseTest {

    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;

    WebDriver driver;
    public static Set<Cookie> LoginPageCookie;
    private String firstName, lastName, email, password, invalidEmail, notFoundEmail;

    @Parameters("browser")
    @BeforeClass
    private void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);

        SetData();
    }

    @Test
    public void Login_01_Empty_Data() {
        loginPage = homePage.clickToLoginLink();

        log.info("Login TC:01 with empty data");
        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
    }

    @Test
    public void Login_02_Invalid_Email() {
        loginPage = homePage.clickToLoginLink();

        log.info("Login TC:02 with Invalid email");
        loginPage.inputToEmailTextbox(invalidEmail);
        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
    }

    @Test
    public void Login_03_Email_not_Register() {
        loginPage = homePage.clickToLoginLink();

        log.info("Login TC:03 with Email not register");
        loginPage.LoginAsUser(notFoundEmail, password);

        Assert.assertEquals(loginPage.getErrorMessageLoginUnsuccessful(),
                "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }

    @Test
    public void Login_04_Empty_Password() {
        loginPage = homePage.clickToLoginLink();

        log.info("Login TC:04 with empty password");
        loginPage.inputToEmailTextbox(email);
        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageLoginUnsuccessful(),
                "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void Login_05_Wrong_Password() {
        loginPage = homePage.clickToLoginLink();

        log.info("Login TC:05 with wrong password");
        loginPage.LoginAsUser(email, "123123123");

        Assert.assertEquals(loginPage.getErrorMessageLoginUnsuccessful(),
                "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void Login_06_Success() {
        loginPage = homePage.clickToLoginLink();

        log.info("Login TC:06 Success");
        log.info("Login with email: " + email + "   Pass: " + password);
        loginPage.LoginAsUser(email, password);
        LoginPageCookie = homePage.getAllCookies(driver);

        Assert.assertEquals(homePage.getTopicBlockTitle(), "Welcome to our store");

        log.info("Logout with email: " + email + "   Pass: " + password);
        homePage.ClickToLogoutLinkAtUserPage(driver);
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
        password = "123456";
        invalidEmail = "123@#$";
        notFoundEmail = "abc123@gmail.com";
        RegisterNewAccount(email);
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
