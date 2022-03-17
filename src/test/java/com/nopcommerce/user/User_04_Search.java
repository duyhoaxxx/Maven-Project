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
import pageObjects.nopCommerce.user.MenuPageObject.UserSearchPageObject;

public class User_04_Search extends BaseTest {
    private UserHomePageObject homePage;
    private UserLoginPageObject loginPage;
    private UserSearchPageObject searchPage;

    WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    private void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);

        SetData();
    }

    @Test
    public void Search_01_Empty_Data() {
        log.info("Search_TC:01 with Empty data");
        log.info("Step1: click Search in footer");
        homePage.openFooterPageByName(driver, "Search");
        searchPage = PageGeneratorManager.getUserSearchPage(driver);
        Assert.assertTrue(searchPage.isPageTitleDisplayedByName(driver, "Search"));

        log.info("Step2: click Search button");
        searchPage.clickToSearchButton();

        Assert.assertEquals(searchPage.getErrMessage(), "Search term minimum length is 3 characters");
    }

    @Test
    public void Search_02_Data_Not_Exist() {
        log.info("Search_TC:02 with Data Not Exist");
        log.info("Step1: search keyword: Macbook Pro 2222");
        log.info("Step2: Advanced Search: false");
        searchPage.searchKeywordBasicForm("Macbook Pro 2222");

        Assert.assertEquals(searchPage.getResultMessage(), "No products were found that matched your criteria.");

    }

    @Test
    public void Search_03_with_Product_Name() {
        log.info("Search_TC:03 with Product Name");
        log.info("Step1: search keyword: Lenovo");
        log.info("Step2: Advanced Search: false");
        searchPage.searchKeywordBasicForm("Lenovo");

        Assert.assertEquals(searchPage.getNumberResult(), 2);
        Assert.assertTrue(searchPage.isProductSearchDisplay("Lenovo IdeaCentre 600 All-in-One PC"));
        Assert.assertTrue(searchPage.isProductSearchDisplay("Lenovo Thinkpad X1 Carbon Laptop"));
    }

    @Test
    public void Search_04_with_Product_Name() {
        log.info("Search_TC:04 with Product Name");
        log.info("Step1: search keyword: Lenovo Thinkpad X1 Carbon");
        log.info("Step2: Advanced Search: false");
        searchPage.searchKeywordBasicForm("Lenovo Thinkpad X1 Carbon");

        Assert.assertEquals(searchPage.getNumberResult(), 1);
        Assert.assertTrue(searchPage.isProductSearchDisplay("Lenovo Thinkpad X1 Carbon Laptop"));
    }

    @Test
    public void Search_05_Advanced_with_Parent_Categories() {
        log.info("Search_TC:05 Advanced with Parent Categories");
        log.info("Step1: Search keyword: Apple MacBook Pro");
        log.info("Step2: Advanced Search: true");
        log.info("Step3: Category: Computer");
        log.info("Step4: Automatically Search SubCategories: false");
        log.info("Step5: Manufacturer: All");
        log.info("Step5: Search In Product Descriptions: false");
        searchPage.searchKeywordAdvancedForm("Apple MacBook Pro", "Computers", false, "All", false);

        Assert.assertEquals(searchPage.getResultMessage(), "No products were found that matched your criteria.");
    }

    @Test
    public void Search_06_Advanced_with_Sub_Categories() {
        log.info("Search_TC:06 Advanced with Sub Categories");
        log.info("Step1: Search keyword: Apple MacBook Pro");
        log.info("Step2: Advanced Search: true");
        log.info("Step3: Category: Computer");
        log.info("Step4: Automatically Search SubCategories: true");
        log.info("Step5: Manufacturer: All");
        log.info("Step5: Search In Product Descriptions: false");
        searchPage.searchKeywordAdvancedForm("Apple MacBook Pro", "Computers", true, "All", false);

        Assert.assertEquals(searchPage.getNumberResult(), 1);
        Assert.assertTrue(searchPage.isProductSearchDisplay("Apple MacBook Pro 13-inch"));
    }

    @Test
    public void Search_07_Advanced_with_Incorret_Manufacturer() {
        log.info("Search_TC:07 Advanced with Incorret Manufacturer");
        log.info("Step1: Search keyword: Apple MacBook Pro");
        log.info("Step2: Advanced Search: true");
        log.info("Step3: Category: Computer");
        log.info("Step4: Automatically Search SubCategories: true");
        log.info("Step5: Manufacturer: HP");
        log.info("Step5: Search In Product Descriptions: false");
        searchPage.searchKeywordAdvancedForm("Apple MacBook Pro", "Computers", true, "HP", false);

        Assert.assertEquals(searchPage.getResultMessage(), "No products were found that matched your criteria.");
    }

    @Test
    public void Search_08_Advanced_with_Corret_Manufacturer() {
        log.info("Search_TC:08 Advanced with Corret Manufacturer");
        log.info("Step1: Search keyword: Apple MacBook Pro");
        log.info("Step2: Advanced Search: true");
        log.info("Step3: Category: Computer");
        log.info("Step4: Automatically Search SubCategories: true");
        log.info("Step5: Manufacturer: Apple");
        log.info("Step5: Search In Product Descriptions: false");

        searchPage.searchKeywordAdvancedForm("Apple MacBook Pro", "Computers", true, "Apple", false);

        Assert.assertEquals(searchPage.getNumberResult(), 1);
        Assert.assertTrue(searchPage.isProductSearchDisplay("Apple MacBook Pro 13-inch"));
    }

    @Parameters("browser")
    @AfterClass(alwaysRun = true)
    private void afterClass(String browserName) {
        log.info("Post-Condition: Close browser " + browserName);
        cleanBrowserAndDriver();
    }

    private void SetData() {
        homePage.zoomMax(driver);
        LoginByCookies();
    }

    private void LoginByCookies() {
        loginPage = homePage.clickToLoginLink();
        loginPage.setAllCookies(driver, User_02_Login.LoginPageCookie);
        loginPage.sleepInSecond(5);
        loginPage.refreshCurrentPage(driver);
        loginPage.clickCLoseButtonBarNotification(driver);
        homePage = loginPage.clickLOGOIMAGE(driver);
    }
}
