package com.nopcommerce.admin;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;

public class Admin_01 extends BaseTest {
    private AdminLoginPageObject loginPage;
    private AdminDashboardPageObject homePage;

    String adminUser, adminPassword;
    WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    private void beforeClass(String browserName) {
        driver = getAdminBrowserDriver(browserName);
        loginPage = PageGeneratorManager.getAdminLoginPage(driver);

        SetData();
    }

    @Test
    public void TC_01() {

    }

    @Test
    public void TC_02() {

    }

    @Test
    public void TC_03() {

    }

    @Test
    public void TC_04() {

    }

    @Test
    public void TC_05() {

    }

    @Test
    public void TC_06() {

    }

    @Test
    public void TC_07() {

    }

    @Test
    public void TC_08() {

    }

    @Test
    public void TC_09() {

    }

    @Test
    public void TC_10() {

    }

    @Test
    public void TC_11() {

    }

    @Test
    public void TC_12() {

    }

    @Test
    public void TC_13() {

    }

    @Test
    public void TC_14() {

    }

    @Test
    public void TC_15() {

    }

    @Parameters("browser")
    @AfterClass(alwaysRun = true)
    private void afterClass(String browserName) {
        log.info("Post-Condition: Close browser " + browserName);
        cleanBrowserAndDriver();
    }

    private void SetData() {
        loginPage.zoomMax(driver);
        adminUser = GlobalConstants.ADMIN_EMAIL;
        adminPassword = GlobalConstants.ADMIN_PASSWORD;
        homePage = loginPage.LoginAsUser(adminUser, adminPassword);
    }
}
