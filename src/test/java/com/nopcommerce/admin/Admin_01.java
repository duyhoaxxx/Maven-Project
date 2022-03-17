package com.nopcommerce.admin;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.admin.ADDashboardPageObject;
import pageObjects.nopCommerce.admin.ADLoginPageObject;
import pageObjects.nopCommerce.admin.ADProductsPageObject;

public class Admin_01 extends BaseTest {
    private ADLoginPageObject loginPage;
    private ADDashboardPageObject homePage;
    private ADProductsPageObject productsPage;

    String productName;
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
    public void TC_01_Search_with_Product_Name() {
        log.info("TC:01 Search witch Product Name");
        log.info("Step1: Click Catalog");
        homePage.clickLeftMenuByName(driver, "Catalog");

        log.info("Step2: Click Products");
        homePage.clickLeftMenuByName(driver, "Products");
        productsPage = PageGeneratorManager.getAdminProductsPage(driver);

        log.info("Step3: input Product Name" + productName);
        productsPage.inputProductNameToSearch(productName);

        log.info("Step4: Click Search");
        productsPage.clickToButtonByText(driver, "Search");
        productsPage.sleepInSecond(10);

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
        log.info("Open Dashboard Admin: " + GlobalConstants.ADMIN_PAGE_URL);
        log.info("Login Success with ID: " + adminUser + " /Pass: " + adminPassword);
        homePage = loginPage.LoginAsUser(adminUser, adminPassword);

        productName = "Lenovo IdeaCentre 600 All-in-One PC";
    }
}
