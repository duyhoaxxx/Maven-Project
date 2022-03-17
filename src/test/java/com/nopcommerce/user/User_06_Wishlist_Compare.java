package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.MenuPageObject.*;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class User_06_Wishlist_Compare extends BaseTest {
    private UserHomePageObject homePage;
    private UserLoginPageObject loginPage;
    private UserMenuComputersPageObiect computerMenuPage;
    private UserWishlistPageObject wishlistPage;
    private UserShoppingCartPageObject shoppingCartPage;
    private UserCompareProductsPageObject compareProductPage;
    private UserRecentlyViewedProductsPageObject recentlyViewPage;

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

        Assert.assertEquals(computerMenuPage.getBarNotificationSuccess(driver), "The product has been added to your wishlist");
        computerMenuPage.clickCLoseButtonBarNotification(driver);

        log.info("Step3: Open Wishlist");
        wishlistPage = computerMenuPage.ClickToWishlistLinkAtUserPage(driver);
        Assert.assertTrue(wishlistPage.isProductNameDisplay(productName));

        log.info("Step4: Click Wishlist URL Share");
        wishlistPage.clickToURLForSharing();

        Assert.assertTrue(wishlistPage.isPageTitleDisplayedByName(driver, "Wishlist of Kane Pham"));
        log.info("Step5: Back to Page");
        wishlistPage.backToPage(driver);
    }

    @Test
    public void TC_02_Add_Product_to_Cart_from_Wishlist() {
        log.info("TC:02 Add Product to Cart from Wishlist ");
        log.info("Step1: Add to cart product " + productName);
        wishlistPage.clickAddToCartByName(productName);

        log.info("Step2: Click Add to cart button");
        shoppingCartPage = wishlistPage.clickAddToCartButton();

        log.info("       Verify Product display in Shopping Cart");
        Assert.assertTrue(shoppingCartPage.isProductNameDisplay(productName));

        log.info("       Remove Product in Shopping Cart");
        shoppingCartPage.clickToRemoveButtonByNameProduct(productName);
        shoppingCartPage.clickToUpdateShoppingCartButton();

        log.info("       Verify Shopping Cart is empty");
        Assert.assertEquals(shoppingCartPage.getResultMessage(), "Your Shopping Cart is empty!");
        Assert.assertEquals(shoppingCartPage.getNumberProductInShoppingCart(), 0);

        log.info("Step3: Click wishlist page");
        wishlistPage = shoppingCartPage.ClickToWishlistLinkAtUserPage(driver);
        Assert.assertFalse(wishlistPage.isProductNameDisplay(productName));
    }

    @Test
    public void TC_03_Remove_Product_in_Wishlist() {
        log.info("TC:03 Remove Product in Wishlist");
        log.info("Step1: Open Computer menu page");
        wishlistPage.openTopMenuByName(driver, "computers");
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
        String productNameCompare = "Asus N551JK-XO076H Laptop";
        log.info("TC:04 Add Product to Compare");
        log.info("Step1: Open Computer menu page");
        wishlistPage.openTopMenuByName(driver, "computers");
        computerMenuPage = PageGeneratorManager.getUserMenuComputersPage(driver);

        log.info("Step2: Open Menu Computers>Notebooks page ");
        computerMenuPage.clickToSubCategoryByName("Notebooks");

        log.info("Step3: Click to Add to Compare list button: " + productName);
        computerMenuPage.clickToAddToCompareListButtonByName(productName);
        Assert.assertEquals(computerMenuPage.getBarNotificationSuccess(driver), "The product has been added to your product comparison");
        computerMenuPage.clickCLoseButtonBarNotification(driver);

        log.info("Step4: Click to Add to Compare list button: " + productNameCompare);
        computerMenuPage.sleepInSecond(1);
        computerMenuPage.clickToAddToCompareListButtonByName(productNameCompare);
        Assert.assertEquals(computerMenuPage.getBarNotificationSuccess(driver), "The product has been added to your product comparison");
        computerMenuPage.clickCLoseButtonBarNotification(driver);

        log.info("Step5: Click to compare page");
        computerMenuPage.openFooterPageByName(driver, "Compare products list");
        compareProductPage = PageGeneratorManager.getCompareProductsPage(driver);

        Assert.assertTrue(compareProductPage.isPageTitleDisplayedByName(driver, "Compare products"));
        log.info(productName + " ~~~ " + productNameCompare);
        Assert.assertTrue(compareProductPage.isProductNameDisplay(productName));
        Assert.assertTrue(compareProductPage.isProductNameDisplay(productNameCompare));

        log.info("Step6: Click Clear List Button");
        compareProductPage.clickToClearListButton();

        Assert.assertEquals(compareProductPage.getResultMessage(), "You have no items to compare.");
        Assert.assertFalse(compareProductPage.isProductNameDisplay(productName));
        Assert.assertFalse(compareProductPage.isProductNameDisplay(productNameCompare));
    }

    @Test
    public void TC_05_Recently_view_Products() {
        String recentlyProduct1 = "Asus N551JK-XO076H Laptop";
        String recentlyProduct2 = "HP Envy 6-1180ca 15.6-Inch Sleekbook";
        String recentlyProduct3 = "HP Spectre XT Pro UltraBook";
        String recentlyProduct4 = "Lenovo Thinkpad X1 Carbon Laptop";
        log.info("TC:05 Recently view Products");
        log.info("Step1: Open Computer menu page");
        compareProductPage.openTopMenuByName(driver, "computers");
        computerMenuPage = PageGeneratorManager.getUserMenuComputersPage(driver);

        log.info("Step2: Open Menu Computers>Notebooks page ");
        computerMenuPage.clickToSubCategoryByName("Notebooks");

        log.info("Step3: Click to product: " + productName);
        computerMenuPage.clickToProductByName(productName);
        log.info("Step4: Back to Notebooks page");
        computerMenuPage.backToPage(driver);

        log.info("Step5: Click to product: " + recentlyProduct1);
        computerMenuPage.clickToProductByName(recentlyProduct1);
        log.info("Step6: Back to Notebooks page");
        computerMenuPage.backToPage(driver);

        log.info("Step7: Click to product: " + recentlyProduct2);
        computerMenuPage.clickToProductByName(recentlyProduct2);
        log.info("Step8: Back to Notebooks page");
        computerMenuPage.backToPage(driver);

        log.info("Step9: Click to product: " + recentlyProduct3);
        computerMenuPage.clickToProductByName(recentlyProduct3);
        log.info("Step10: Back to Notebooks page");
        computerMenuPage.backToPage(driver);

        log.info("Step11: Click to product: " + recentlyProduct4);
        computerMenuPage.clickToProductByName(recentlyProduct4);
        log.info("Step12: Back to Notebooks page");
        computerMenuPage.backToPage(driver);

        log.info("Step13: Open Recently views products page");
        computerMenuPage.openFooterPageByName(driver, "Recently viewed products");
        recentlyViewPage = PageGeneratorManager.getRecentlyViewedProductsPage(driver);

        Assert.assertTrue(recentlyViewPage.isPageTitleDisplayedByName(driver, "Recently viewed products"));
        Assert.assertTrue(recentlyViewPage.isNumberProductDisplay(driver, 3));
        Assert.assertFalse(recentlyViewPage.isProductNameDisplay(driver, productName));
        Assert.assertFalse(recentlyViewPage.isProductNameDisplay(driver, recentlyProduct1));
        Assert.assertTrue(recentlyViewPage.isProductNameDisplay(driver, recentlyProduct2));
        Assert.assertTrue(recentlyViewPage.isProductNameDisplay(driver, recentlyProduct3));
        Assert.assertTrue(recentlyViewPage.isProductNameDisplay(driver, recentlyProduct4));

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

        productName = "Apple MacBook Pro 13-inch";
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
