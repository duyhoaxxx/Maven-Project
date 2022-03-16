package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.MenuPageObject.UserMenuComputersPageObiect;
import pageObjects.nopCommerce.user.MenuPageObject.UserShoppingCartPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

import java.util.List;

public class User_07_Oder extends BaseTest {
    private UserHomePageObject homePage;
    private UserLoginPageObject loginPage;
    private UserMenuComputersPageObiect computerMenuPage;
    private UserShoppingCartPageObject shoppingCartPage;

    String productName, opProcessor, opRAM, opHDD, opOS, opSoftware, numberBuy;
    WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    private void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);

        SetData();
    }

    @Test
    public void Order_01_Add_Product_to_Cart() {
        log.info("TC:01 Add Product to Cart");
        log.info("Step1: Click to product: " + productName);
        computerMenuPage.clickToProductByName(productName);

        log.info("Step2: Click option");
        computerMenuPage.clickOptionBuildYourOwnComputer(opProcessor, opRAM, opHDD, opOS, opSoftware, numberBuy);

        log.info("Step3: Click Add to Cart button");
        computerMenuPage.clickToAddToCartButton();
        Assert.assertEquals(computerMenuPage.getMessageResult(), "The product has been added to your shopping cart");
        Assert.assertTrue(computerMenuPage.isProductNameInMiniShoppingCart(driver, productName));
    }

    @Test
    public void Order_02_Edit_Product_in_Shopping_Cart() {
        log.info("TC:02 Edit Product in Shopping Cart");
        log.info("Step1: Go to Shopping cart page");
        shoppingCartPage = computerMenuPage.ClickToShoppingCartLinkAtUserPage(driver);

        Assert.assertTrue(shoppingCartPage.isPageTitleDisplayedByName(driver, "Shopping cart"));
        Assert.assertTrue(shoppingCartPage.isProductNameDisplay(productName));

        log.info("Step2: Edit");
        computerMenuPage = shoppingCartPage.clickEditButtonInProductBuildComputer();

        opProcessor = "2.2 GHz Intel Pentium Dual-Core E2200";
        opRAM = "4GB [+$20.00]";
        opHDD = "320 GB";
        opOS = "Vista Home [+$50.00]";
        opSoftware = "Microsoft Office [+$50.00]";
        numberBuy = "2";
        computerMenuPage.clickOptionBuildYourOwnComputer(opProcessor, opRAM, opHDD, opOS, opSoftware, numberBuy);

        Assert.assertEquals(computerMenuPage.getPriceProduct(),"$1,320.00");

        log.info("Step3: Click Update button");
        computerMenuPage.clickToUpdateButton();

        Assert.assertEquals(computerMenuPage.getMessageResult(), "The product has been added to your shopping cart");

        log.info("Step4: Go to Shopping cart page");
        shoppingCartPage = computerMenuPage.ClickToShoppingCartLinkAtUserPage(driver);

        Assert.assertTrue(shoppingCartPage.isPageTitleDisplayedByName(driver, "Shopping cart"));
        Assert.assertTrue(shoppingCartPage.isProductNameDisplay(productName));
        Assert.assertTrue(shoppingCartPage.isNumberQuantityDisplayByProductName(productName,numberBuy));

    }

    @Test
    public void Order_03_Remove_form_Cart() {

    }

    @Test
    public void Order_04_Update_Shopping_Cart() {

    }

    @Test
    public void Order_05_Checkout_Payment_By_Cheque() {

    }

    @Test
    public void Order_06_Checkout_Payment_By_Visa() {

    }

    @Test
    public void Order_07_Re_Oder() {

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
        computerMenuPage.clickToSubCategoryByName("Desktops");

        productName = "Build your own computer";
        opProcessor = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
        opRAM = "2 GB";
        opHDD = "320 GB";
        opOS = "Vista Home [+$50.00]";
        opSoftware = "Microsoft Office [+$50.00]";
        numberBuy = "1";
    }

    private void LoginByCookies() {
        loginPage = homePage.clickToLoginLink();
        loginPage.setAllCookies(driver, User_02_Login.LoginPageCookie);
        loginPage.sleepInSecond(5);
        loginPage.refreshCurrentPage(driver);
        homePage = loginPage.closeResultNotificalLoginByCookies();
    }
}
