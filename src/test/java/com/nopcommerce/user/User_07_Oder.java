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
import pageObjects.nopCommerce.user.MenuPageObject.UserCheckoutPageObject;
import pageObjects.nopCommerce.user.MenuPageObject.UserMenuComputersPageObiect;
import pageObjects.nopCommerce.user.MenuPageObject.UserShoppingCartPageObject;
import pageObjects.nopCommerce.user.MyAccountPageObject.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.MyAccountPageObject.UserOrdersPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class User_07_Oder extends BaseTest {
    private UserHomePageObject homePage;
    private UserLoginPageObject loginPage;
    private UserMenuComputersPageObiect computerMenuPage;
    private UserShoppingCartPageObject shoppingCartPage;
    private UserCheckoutPageObject checkoutPage;
    private UserCustomerInfoPageObject customerInfoPage;
    private UserOrdersPageObject ordersPage;

    String productName, opProcessor, opRAM, opHDD, opOS, opSoftware, numberBuy;
    WebDriver driver;
    GlobalConstants.AddressInformation addressInfo = new GlobalConstants.AddressInformation();

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
        Assert.assertEquals(computerMenuPage.getBarNotificationSuccess(driver), "The product has been added to your shopping cart");
        computerMenuPage.clickCLoseButtonBarNotification(driver);
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

        Assert.assertEquals(computerMenuPage.getPriceProduct(), "$1,320.00");

        log.info("Step3: Click Update button");
        computerMenuPage.clickToUpdateButton();

        Assert.assertEquals(computerMenuPage.getBarNotificationSuccess(driver), "The product has been added to your shopping cart");
        computerMenuPage.clickCLoseButtonBarNotification(driver);

        log.info("Step4: Go to Shopping cart page");
        shoppingCartPage = computerMenuPage.ClickToShoppingCartLinkAtUserPage(driver);

        Assert.assertTrue(shoppingCartPage.isPageTitleDisplayedByName(driver, "Shopping cart"));
        Assert.assertTrue(shoppingCartPage.isProductNameDisplay(productName));
        Assert.assertEquals(shoppingCartPage.getNumberQuantityByProductName(productName), "2");
        Assert.assertTrue(shoppingCartPage.isInfomationProduct(productName, opProcessor, opRAM, opHDD, opOS, opSoftware));
        Assert.assertTrue(shoppingCartPage.isTotalPriceProduct(productName, numberBuy));
    }

    @Test
    public void Order_03_Remove_form_Cart() {
        log.info("TC:03 Remove form Cart");
        log.info("Step1: Click button Remove");
        shoppingCartPage.clickToRemoveButtonByNameProduct(productName);

        log.info("Step2: Click Update Shopping Cart Button");
        shoppingCartPage.clickToUpdateShoppingCartButton();

        Assert.assertEquals(shoppingCartPage.getResultMessage(), "Your Shopping Cart is empty!");
        Assert.assertEquals(shoppingCartPage.getNumberProductInShoppingCart(), 0);
    }

    @Test
    public void Order_04_Update_Shopping_Cart() {
        productName = "Lenovo IdeaCentre 600 All-in-One PC";
        log.info("TC:04 Update Shopping Cart");
        log.info("Step1: Open Computer page");
        shoppingCartPage.openTopMenuByName(driver, "computers");
        computerMenuPage = PageGeneratorManager.getUserMenuComputersPage(driver);

        log.info("Step2: Open Menu Computers>Notebooks page");
        computerMenuPage.clickToSubCategoryByName("Desktops");

        log.info("Step3: Click to product: " + productName);
        computerMenuPage.clickToProductByName(productName);

        log.info("Step4: Click Add to Cart button");
        computerMenuPage.clickToAddToCartButton();
        Assert.assertEquals(computerMenuPage.getBarNotificationSuccess(driver), "The product has been added to your shopping cart");
        computerMenuPage.clickCLoseButtonBarNotification(driver);
        Assert.assertTrue(computerMenuPage.isProductNameInMiniShoppingCart(driver, productName));

        log.info("Step5: Go to Shopping Cart page");
        shoppingCartPage = computerMenuPage.ClickToShoppingCartLinkAtUserPage(driver);
        Assert.assertTrue(shoppingCartPage.isPageTitleDisplayedByName(driver, "Shopping cart"));
        Assert.assertTrue(shoppingCartPage.isProductNameDisplay(productName));

        log.info("Step6: Edit Qty of Product to 5");
        shoppingCartPage.inputToQuantityByProductName(productName, "5");

        log.info("Step7: Click Update Shopping Cart Button");
        shoppingCartPage.clickToUpdateShoppingCartButton();

        Assert.assertTrue(shoppingCartPage.isTotalPriceProduct(productName, "5"));

        log.info("Step8: Click Remove Product");
        shoppingCartPage.clickToRemoveButtonByNameProduct(productName);

        log.info("Step9: Click Update Shopping Cart Button");
        shoppingCartPage.clickToUpdateShoppingCartButton();

        Assert.assertEquals(shoppingCartPage.getResultMessage(), "Your Shopping Cart is empty!");
    }

    @Test
    public void Order_05_Checkout_Payment_By_Cheque() {
        productName = "Apple MacBook Pro 13-inch";
        String unitPrice, numberQty, totalPrice;

        log.info("TC:05 Checkout Payment By Cheque");
        log.info("Step1: Open Computer page");
        shoppingCartPage.openTopMenuByName(driver, "computers");
        computerMenuPage = PageGeneratorManager.getUserMenuComputersPage(driver);

        log.info("Step2: Open Menu Computers>Notebooks page");
        computerMenuPage.clickToSubCategoryByName("Notebooks");

        log.info("Step3: Click to product: " + productName);
        computerMenuPage.clickToProductByName(productName);

        log.info("Step4: Click Add to Cart button");
        computerMenuPage.clickToAddToCartButton();
        Assert.assertEquals(computerMenuPage.getBarNotificationSuccess(driver), "The product has been added to your shopping cart");
        computerMenuPage.clickCLoseButtonBarNotification(driver);
        Assert.assertTrue(computerMenuPage.isProductNameInMiniShoppingCart(driver, productName));

        log.info("Step5: Go to Shopping Cart page");
        shoppingCartPage = computerMenuPage.ClickToShoppingCartLinkAtUserPage(driver);
        Assert.assertTrue(shoppingCartPage.isPageTitleDisplayedByName(driver, "Shopping cart"));
        Assert.assertTrue(shoppingCartPage.isProductNameDisplay(productName));

        unitPrice = shoppingCartPage.getUnitPriceByProductName(productName);
        numberQty = shoppingCartPage.getNumberQuantityByProductName(productName);
        totalPrice = shoppingCartPage.getTotalPriceByProductName(productName);
        log.info("Get unitPrice = " + unitPrice + ". Qty = " + numberQty + ". totalPrice = " + totalPrice);

        log.info("Step6: Click checkbox I agree with the terms of services ....");
        shoppingCartPage.clickToAgreeWithTermsOfServices(true);

        log.info("Step7: Click Checkout button");
        checkoutPage = shoppingCartPage.clickToCheckoutButton();
        Assert.assertTrue(checkoutPage.isPageTitleDisplayedByName(driver, "Checkout"));

        log.info("Step8: Click checkbox Ship to the same address");
        checkoutPage.clickToShipSameAddressCheckbox(true);

        log.info(("Step9: Click Continue button at Billing Adress"));
        checkoutPage.clickToContinueButtonBillingAddress();

        log.info(("Step10: Click Continue button at Shipping Method"));
        checkoutPage.clickToContinueButtonShippingMethod();

        log.info(("Step11: Click Payment method By Cheque"));
        checkoutPage.clickToPayByCheque();

        log.info(("Step12: Click Continue button at Payment Adress"));
        checkoutPage.clickToContinueButtonPaymentMethod();

        log.info(("Step13: Click Continue button at Payment Info"));
        checkoutPage.clickToContinueButtonPaymentInfo();

        Assert.assertTrue(checkoutPage.isCheckInformationBillingAdr(addressInfo));
        Assert.assertTrue(checkoutPage.isCheckInformationShippingAdr(addressInfo));
        Assert.assertTrue(checkoutPage.isCheckPaymentMethod("Check / Money Order"));
        Assert.assertTrue(checkoutPage.isCheckProductNameDisplay(productName));
        Assert.assertTrue(checkoutPage.isConfirmUnitPriceByName(productName, unitPrice));
        Assert.assertTrue(checkoutPage.isConfirmQtyByName(productName, numberQty));
        Assert.assertTrue(checkoutPage.isConfirmTotalPriceByName(productName, totalPrice));

        log.info(("Step14: Click Confirm button "));
        checkoutPage.clickToConfirmButton();

        log.info("Step15: Check message success");
        Assert.assertEquals(checkoutPage.getMessageOrderSuccess(), "Your order has been successfully processed!");

        String orderNumber = checkoutPage.getOrderNumber();
        checkoutPage.clickToDetailsLink();
        String orderDate = checkoutPage.getOrderDate();
        String orderTotal = checkoutPage.getOrderTotal();
        log.info("Step16: Check orderNumber " + orderNumber);
        log.info("        Check orderDate " + orderDate);
        log.info("        Check orderTotal " + orderTotal);


        log.info("Step17: Open MyAccount Link");
        checkoutPage.openHeaderPageByName(driver, "My account");
        customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);

        log.info("Step17: Open Order page");
        customerInfoPage.openMyAccountPageByName(driver, "Orders");
        ordersPage = PageGeneratorManager.getUserOrdersPage(driver);

        Assert.assertTrue(ordersPage.isOrderNumberDisplay(orderNumber));

        log.info("Step18: Click Details button in Order Number " + orderNumber);
        ordersPage.clickToDetailsButtonByOrderNumber(orderNumber);

        Assert.assertTrue(ordersPage.isPageTitleDisplayedByName(driver, "Order information"));
        Assert.assertTrue(ordersPage.isOpenDetailsOrderByNumber(orderNumber));
        Assert.assertTrue(ordersPage.isOrderDateVerify(orderDate));
        Assert.assertTrue(ordersPage.isOrderTotalVerify(orderTotal));

        Assert.assertTrue(ordersPage.isCheckInformationBillingAdr(addressInfo));
        Assert.assertTrue(ordersPage.isCheckInformationShippingAdr(addressInfo));
        Assert.assertTrue(ordersPage.isCheckPaymentMethod("Check / Money Order"));
        Assert.assertTrue(ordersPage.isCheckProductNameDisplay(productName));
        Assert.assertTrue(ordersPage.isConfirmUnitPriceByName(productName, unitPrice));
        Assert.assertTrue(ordersPage.isConfirmQtyByName(productName, numberQty));
        Assert.assertTrue(ordersPage.isConfirmTotalPriceByName(productName, totalPrice));

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

    private void LoginByCookies() {
        loginPage = homePage.clickToLoginLink();
        loginPage.setAllCookies(driver, User_02_Login.LoginPageCookie);
        loginPage.sleepInSecond(5);
        loginPage.refreshCurrentPage(driver);
        homePage = loginPage.closeResultNotificalLoginByCookies();
    }
}
