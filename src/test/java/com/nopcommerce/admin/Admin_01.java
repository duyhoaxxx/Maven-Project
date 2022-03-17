package com.nopcommerce.admin;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.admin.ADCustomersPageObject;
import pageObjects.nopCommerce.admin.ADDashboardPageObject;
import pageObjects.nopCommerce.admin.ADLoginPageObject;
import pageObjects.nopCommerce.admin.ADProductsPageObject;

import java.util.Random;

public class Admin_01 extends BaseTest {
    private ADLoginPageObject loginPage;
    private ADDashboardPageObject homePage;
    private ADProductsPageObject productsPage;
    private ADCustomersPageObject customersPage;

    String productName;
    String adminUser, adminPassword;
    GlobalConstants.CustomerInfo customerInfo = new GlobalConstants.CustomerInfo();
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
        productsPage.ClickToButtonByText(driver, "Search");

        Assert.assertFalse(productsPage.isNoResultDataSearch());
        Assert.assertEquals(productsPage.getAllResultSearch(), "1");
        Assert.assertTrue(productsPage.verifyAllResult(productName));
    }
/*

    @Test
    public void TC_02_Search_with_Product_Name_Category_uncheck() {
        log.info("TC:02 Search with Product Name + Category: Computer + Search subcate: uncheck");
        log.info("Step1: input Product Name" + productName);
        productsPage.inputProductNameToSearch(productName);

        log.info("Step2: select Category: " + "Computers");
        productsPage.selectCategoryDropdownByText("Computers");

        log.info("Step3: Search subcategories: uncheck");
        productsPage.checkboxSearchSubcategories(false);

        log.info("Step4: Click Search");
        productsPage.clickToButtonByText(driver, "Search");

        Assert.assertTrue(productsPage.isNoResultDataSearch());
        Assert.assertEquals(productsPage.getMessageNoResultDataSearch(), "No data available in table");
    }

    @Test
    public void TC_03_Search_with_Product_Name_Category_check() {
        log.info("TC:03 Search with Product Name + Category: Computer + Search subcate: check");
        log.info("Step1: input Product Name" + productName);
        productsPage.inputProductNameToSearch(productName);

        log.info("Step2: select Category: " + "Computers");
        productsPage.selectCategoryDropdownByText("Computers");

        log.info("Step3: Search subcategories: uncheck");
        productsPage.checkboxSearchSubcategories(true);

        log.info("Step4: Click Search");
        productsPage.clickToButtonByText(driver, "Search");

        productsPage.sleepInSecond(2);
        Assert.assertFalse(productsPage.isNoResultDataSearch());
        Assert.assertEquals(productsPage.getAllResultSearch(), "1");
        Assert.assertTrue(productsPage.verifyAllResult(productName));
    }

    @Test
    public void TC_04_Search_with_Product_Name_Child_Category() {
        log.info("TC:04 Search with Product Name + Category: Computers >> Desktops + Search subcate: uncheck");
        log.info("Step1: input Product Name" + productName);
        productsPage.inputProductNameToSearch(productName);

        log.info("Step2: select Category: " + "Computers >> Desktops");
        productsPage.selectCategoryDropdownByText("Computers >> Desktops");

        log.info("Step3: Search subcategories: uncheck");
        productsPage.checkboxSearchSubcategories(false);

        log.info("Step4: Click Search");
        productsPage.clickToButtonByText(driver, "Search");

        Assert.assertFalse(productsPage.isNoResultDataSearch());
        Assert.assertEquals(productsPage.getAllResultSearch(), "1");
        Assert.assertTrue(productsPage.verifyAllResult(productName));
    }

    @Test
    public void TC_05_Search_with_Product_Name_Manufacturer() {
        log.info("TC:05 Search with Product Name + Manufacturer");
        log.info("Step1: input Product Name" + productName);
        productsPage.inputProductNameToSearch(productName);

        log.info("Step2: select Category: " + "All");
        productsPage.selectCategoryDropdownByText("All");

        log.info("Step3: Search subcategories: uncheck");
        productsPage.checkboxSearchSubcategories(false);

        log.info("Step4: select Manufacturer: " + "Apple");
        productsPage.selectManufacturerDropdownByText("Apple");

        log.info("Step5: Click Search");
        productsPage.clickToButtonByText(driver, "Search");

        Assert.assertTrue(productsPage.isNoResultDataSearch());
        Assert.assertEquals(productsPage.getMessageNoResultDataSearch(), "No data available in table");
    }

    @Test
    public void TC_06_Go_directly_to_Product_SKU() {
        log.info("TC:06 Go directly to Product SKU");
        log.info(("Step1: click Products in Left Menu"));
        productsPage.clickLeftMenuByName(driver, "Products");

        log.info("Step2: input Go Directly To Product SKU: LE_IC_600");
        productsPage.inputGoDirectlyToProductSKU("LE_IC_600");

        log.info("Step3: click Go button");
        productsPage.clickToButtonByText(driver, "Go");

        Assert.assertTrue(productsPage.getFloatLeftHeaderPage(driver).contains("product details"));
        Assert.assertTrue(productsPage.getFloatLeftHeaderPage(driver).contains(productName));
    }
*/

    @Test
    public void TC_07_Create_New_Customer() {
        log.info("TC:07 Create New Customer");
        log.info("Step1: click Customers left menu");
        productsPage.clickCustomersLeftMenuDropdown(driver);

        log.info("Step2: click Customers left menu sub");
        customersPage = productsPage.clickCustomersLeftMenuPage(driver);

        log.info("Step3: click Add New button");
        customersPage.clickToAddNewButton();

        Assert.assertTrue(productsPage.getFloatLeftHeaderPage(driver).contains("Add a new customer"));

        customersPage.inputNewCustomerInfoForm(driver, customerInfo);

        log.info("Step4: click to Save and Continue Edit");
        customersPage.ClickToButtonByText(driver, "Save and Continue Edit");

        Assert.assertTrue(customersPage.getMessageNewCustomerAddSuccess().contains("The new customer has been added successfully."));
        Assert.assertTrue(customersPage.verifyNewCustomerInfo(customerInfo));

        log.info("Step5: click back to customer list");
        customersPage.clickToBackCustomerList();

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

        customerInfo.email = fakeEmail();
        customerInfo.password = "123123";
        customerInfo.fname = "Yua";
        customerInfo.lname = "Mikami";
        customerInfo.gender = "Female";
        customerInfo.DOB = "12/12/2000";
        customerInfo.companyName = "KYAuto";
        customerInfo.isTaxExempt = false;
        customerInfo.newsletter = "Your store name";
        customerInfo.customerRoles = "Guests";
        customerInfo.managerVender = "Vendor 1";
        customerInfo.isActive = true;
        customerInfo.adminComment = "Add new Customer (Guest)";
    }

    private String fakeEmail() {
        return "AutoTest" + String.valueOf((new Random().nextInt(999999))) + "@gmail.com";
    }
}
