package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.TopMenuPageObject.UserMenuComputersPageObiect;
import pageObjects.nopCommerce.user.TopMenuPageObject.UserShoppingCartPageObject;
import pageObjects.nopCommerce.user.TopMenuPageObject.UserWishlistPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class User_06_Wishlist_Compare extends BaseTest {
    private UserHomePageObject homePage;
    private UserLoginPageObject loginPage;
    private UserMenuComputersPageObiect computerMenuPage;
    private UserWishlistPageObject wishlistPage;
    private UserShoppingCartPageObject shoppingCartPage;

    String productName;
    WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    private void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);

        SetData();
    }

    @Test
    public void TC_01_Add_to_Wishlist() {
        log.info("TC:01 Add to Wishlist");
        log.info("Step1: Click to product: " + productName);
        computerMenuPage.clickToProductByName(productName);

        log.info("Step2: Click to Add to wishlist button");
        computerMenuPage.clickToAddToWishlistButton();

        Assert.assertEquals(computerMenuPage.getMessageResult(), "The product has been added to your wishlist");

        log.info("Step3: Open Wishlist");
        wishlistPage = computerMenuPage.ClickToWishlistLinkAtUserPage(driver);
        Assert.assertTrue(wishlistPage.isProductNameDisplay(productName));

        log.info("Step4: Click Wishlist URL Share");
        wishlistPage.clickToURLForSharing();

        Assert.assertTrue(wishlistPage.isPageTitleDisplayedByName(driver, "Wishlist of Kane Pham"));
        wishlistPage.backToPage(driver);
    }

    @Test
    public void TC_02_Add_Product_to_Cart_from_Wishlist() {
        log.info("TC:02 Add Product to Cart from Wishlist ");
        log.info("Step1: Add to cart product " + productName);
        wishlistPage.clickAddToCartByName(productName);

        log.info("Step2: Click Add to cart button");
        shoppingCartPage = wishlistPage.clickAddToCartButton();
        Assert.assertTrue(shoppingCartPage.isProductNameDisplay(productName));

        log.info("Step3: Click wishlist page");
        wishlistPage = shoppingCartPage.ClickToWishlistLinkAtUserPage(driver);
        Assert.assertFalse(wishlistPage.isProductNameDisplay(productName));
    }

    @Test
    public void TC_03_Remove_Product_in_Wishlist() {
        log.info("TC:03 Remove Product in Wishlist");
        log.info("Step1: Open Computer menu page");
        wishlistPage.openTopMenuByName(driver, "Computers ");
        computerMenuPage = PageGeneratorManager.getUserMenuComputersPage(driver);

        log.info("Step2: Open Menu Computers>Notebooks page ");
        computerMenuPage.clickToSubCategoryByName("Notebooks");

        log.info("Step3: Click to product: " + productName);
        computerMenuPage.clickToProductByName(productName);

        log.info("Step4: Click to Add to wishlist button");
        computerMenuPage.clickToAddToWishlistButton();

        log.info("Step5: Open Wishlist ");
        wishlistPage = computerMenuPage.ClickToWishlistLinkAtUserPage(driver);

        log.info("Step6: Remove item in Wishlist: " + productName);
        wishlistPage.clickToRemoveByName(productName);
        wishlistPage.clickToUpdateWishlistButton();

        Assert.assertEquals(wishlistPage.getMessageWishlistEmpty(), "The wishlist is empty!");
        Assert.assertTrue(wishlistPage.isNoProductDisplayed());

    }

    @Test
    public void TC_04_Add_Product_to_Compare() {
        log.info("TC:04 Add Product to Compare");
    }

    @Test
    public void TC_05_Recently_view_Products() {
        log.info("TC:05 Recently view Products");
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
        homePage.openTopMenuByName(driver, "Computers ");
        computerMenuPage = PageGeneratorManager.getUserMenuComputersPage(driver);

        log.info("Open Menu Computers>Notebooks page");
        computerMenuPage.clickToSubCategoryByName("Notebooks");

        productName = "Asus N551JK-XO076H Laptop";
    }

    private void LoginByCookies() {
        loginPage = homePage.clickToLoginLink();
        loginPage.setAllCookies(driver, User_02_Login.LoginPageCookie);
        loginPage.sleepInSecond(5);
        loginPage.refreshCurrentPage(driver);
        homePage = loginPage.closeResultNotificalLoginByCookies();
    }
}
