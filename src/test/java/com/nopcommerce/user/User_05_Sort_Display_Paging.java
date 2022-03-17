package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.MenuPageObject.UserMenuComputersPageObiect;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class User_05_Sort_Display_Paging extends BaseTest {
    private UserHomePageObject homePage;
    private UserLoginPageObject loginPage;
    private UserMenuComputersPageObiect computerMenuPage;

    WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    private void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);

        SetData();
    }

    @Test
    public void TC_01_Sort_Name_AtoZ() {
        log.info("TC:01 Sort Name AtoZ");
        log.info("Click Sort by Name: A to Z");
        computerMenuPage.clickToSortByDropdown(driver, "Name: A to Z");

        Assert.assertTrue(computerMenuPage.isSortedNameAscending(driver));
    }

    @Test
    public void TC_02_Sort_Name_ZtoA() {
        log.info("TC:02 Sort Name ZtoA");
        log.info("Click Sort by Name: Z to A");
        computerMenuPage.clickToSortByDropdown(driver, "Name: Z to A");

        Assert.assertTrue(computerMenuPage.isSortedNameDescending(driver));
    }

    @Test
    public void TC_03_Sort_Price_Low_to_High() {
        log.info("TC:03 Sort Price Low to High");
        log.info("Click Sort by Price Low to High");
        computerMenuPage.clickToSortByDropdown(driver, "Price: Low to High");

        Assert.assertTrue(computerMenuPage.isSortedPriceAscending(driver));
    }

    @Test
    public void TC_04_Sort_Price_High_to_Low() {
        log.info("TC:04 Sort Price High to Low");
        log.info("Click Sort by Price High to Low");
        computerMenuPage.clickToSortByDropdown(driver, "Price: High to Low");

        Assert.assertTrue(computerMenuPage.isSortedPriceDescending(driver));
    }

    @Test
    public void TC_05_Display_with_Page_Size3() {
        log.info("TC:05 Display with Page Size = 3");
        log.info("Click Page Size button 3");
        computerMenuPage.clickToPageSizeButton(driver, "3");

        Assert.assertTrue(computerMenuPage.isNumberProductDisplay(driver, 3));
        Assert.assertTrue(computerMenuPage.isPagingButtonDisplay(driver));
        Assert.assertTrue(computerMenuPage.isNextPageButtonDisplay(driver));

        log.info("Click next page");
        computerMenuPage.clickToNextPageButton(driver);
        Assert.assertFalse(computerMenuPage.isNextPageButtonDisplay(driver));
        Assert.assertTrue(computerMenuPage.isPreviousPageButtonDisplay(driver));
    }

    @Test
    public void TC_06_Display_with_Page_Siz6() {
        log.info("TC:06 Display with Page Size = 6");
        log.info("Click Page Size button 6");
        computerMenuPage.clickToPageSizeButton(driver, "6");

        Assert.assertTrue(computerMenuPage.isNumberProductDisplay(driver, 6));
        Assert.assertFalse(computerMenuPage.isPagingButtonDisplay(driver));
    }

    @Test
    public void TC_07_Display_with_Page_Siz9() {
        log.info("TC:07 Display with Page Size = 9");
        log.info("Click Page Size button 9");
        computerMenuPage.clickToPageSizeButton(driver, "9");

        Assert.assertTrue(computerMenuPage.isNumberProductDisplay(driver, 9));
        Assert.assertFalse(computerMenuPage.isPagingButtonDisplay(driver));
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

        log.info("Open Menu Computers page");
        homePage.openTopMenuByName(driver, "computers");
        computerMenuPage = PageGeneratorManager.getUserMenuComputersPage(driver);

        log.info("Open Menu Computers>Notebooks page");
        computerMenuPage.clickToSubCategoryByName("Notebooks");
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
