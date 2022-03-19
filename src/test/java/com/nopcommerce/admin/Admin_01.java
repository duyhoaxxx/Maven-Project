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
    GlobalConstants.AddressInfo addressInfo = new GlobalConstants.AddressInfo();
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
        homePage.Loaded(driver);
        homePage.ClickLeftMenuByName(driver, "Catalog");

        log.info("Step2: Click Products");
        homePage.ClickLeftMenuByName(driver, "Products");
        productsPage = PageGeneratorManager.getAdminProductsPage(driver);

        log.info("Step3: input Product Name" + productName);
        productsPage.openTabSearchEachPage(driver);
        productsPage.EnterToTextboxByID(driver, "SearchProductName", productName);

        log.info("Step4: Click Search");
        productsPage.ClickToButtonByText(driver, "Search");
        productsPage.Loaded(driver);

        Assert.assertFalse(productsPage.isNoDataInTableByID(driver, "products-grid_wrapper"));
        Assert.assertEquals(productsPage.getAllResultSearch(driver), "1");
        Assert.assertTrue(productsPage.verifyAllResult(productName));
    }

    @Test
    public void TC_02_Search_with_Product_Name_Category_uncheck() {
        log.info("TC:02 Search with Product Name + Category: Computer + Search subcate: uncheck");
        log.info("Step1: input Product Name" + productName);
        productsPage.EnterToTextboxByID(driver, "SearchProductName", productName);

        log.info("Step2: select Category: " + "Computers");
        productsPage.SelectDropdownByID(driver, "SearchCategoryId", "Computers");

        log.info("Step3: Search subcategories: uncheck");
        productsPage.ClickToCheckboxButtonByID(driver, "SearchIncludeSubCategories", false);

        log.info("Step4: Click Search");
        productsPage.ClickToButtonByText(driver, "Search");
        productsPage.Loaded(driver);

        Assert.assertTrue(productsPage.isNoDataInTableByID(driver, "products-grid_wrapper"));
        Assert.assertEquals(productsPage.getMessageNoDataInTableByID(driver, "products-grid_wrapper"), "No data available in table");
    }

    @Test
    public void TC_03_Search_with_Product_Name_Category_check() {
        log.info("TC:03 Search with Product Name + Category: Computer + Search subcate: check");
        log.info("Step1: input Product Name" + productName);
        productsPage.EnterToTextboxByID(driver, "SearchProductName", productName);

        log.info("Step2: select Category: " + "Computers");
        productsPage.SelectDropdownByID(driver, "SearchCategoryId", "Computers");

        log.info("Step3: Search subcategories: check");
        productsPage.ClickToCheckboxButtonByID(driver, "SearchIncludeSubCategories", true);

        log.info("Step4: Click Search");
        productsPage.ClickToButtonByText(driver, "Search");
        productsPage.Loaded(driver);

        Assert.assertFalse(productsPage.isNoDataInTableByID(driver, "products-grid_wrapper"));
        Assert.assertEquals(productsPage.getAllResultSearch(driver), "1");
        Assert.assertTrue(productsPage.verifyAllResult(productName));
    }

    @Test
    public void TC_04_Search_with_Product_Name_Child_Category() {
        log.info("TC:04 Search with Product Name + Category: Computers >> Desktops + Search subcate: uncheck");
        log.info("Step1: input Product Name" + productName);
        productsPage.EnterToTextboxByID(driver, "SearchProductName", productName);

        log.info("Step2: select Category: " + "Computers >> Desktops");
        productsPage.SelectDropdownByID(driver, "SearchCategoryId", "Computers >> Desktops");

        log.info("Step3: Search subcategories: uncheck");
        productsPage.ClickToCheckboxButtonByID(driver, "SearchIncludeSubCategories", false);

        log.info("Step4: Click Search");
        productsPage.ClickToButtonByText(driver, "Search");
        productsPage.Loaded(driver);

        Assert.assertFalse(productsPage.isNoDataInTableByID(driver, "products-grid_wrapper"));
        Assert.assertEquals(productsPage.getAllResultSearch(driver), "1");
        Assert.assertTrue(productsPage.verifyAllResult(productName));
    }

    @Test
    public void TC_05_Search_with_Product_Name_Manufacturer() {
        log.info("TC:05 Search with Product Name + Manufacturer");
        log.info("Step1: input Product Name" + productName);
        productsPage.EnterToTextboxByID(driver, "SearchProductName", productName);

        log.info("Step2: select Category: " + "All");
        productsPage.SelectDropdownByID(driver, "SearchCategoryId", "All");

        log.info("Step3: Search subcategories: uncheck");
        productsPage.ClickToCheckboxButtonByID(driver, "SearchIncludeSubCategories", false);

        log.info("Step4: select Manufacturer: " + "Apple");
        productsPage.SelectDropdownByID(driver, "SearchManufacturerId", "Apple");

        log.info("Step5: Click Search");
        productsPage.ClickToButtonByText(driver, "Search");
        productsPage.Loaded(driver);

        Assert.assertTrue(productsPage.isNoDataInTableByID(driver, "products-grid_wrapper"));
        Assert.assertEquals(productsPage.getMessageNoDataInTableByID(driver, "products-grid_wrapper"), "No data available in table");
    }

    @Test
    public void TC_06_Go_directly_to_Product_SKU() {
        log.info("TC:06 Go directly to Product SKU");
        log.info(("Step1: Click Products in Left Menu"));
        productsPage.ClickLeftMenuByName(driver, "Products");

        log.info("Step2: Search Go Directly To Product SKU: LE_IC_600");
        productsPage.searchGoDirectlyToProductSKUByText("LE_IC_600");

        productsPage.waitLoadedPageByHeaderName(driver, "Edit product details");
        Assert.assertTrue(productsPage.getFloatLeftHeaderPage(driver).contains("Edit product details"));
        Assert.assertTrue(productsPage.getFloatLeftHeaderPage(driver).contains(productName));

        productsPage.ClickToLinkByText(driver, "back to product list");
        productsPage.waitLoadedPageByHeaderName(driver, "Products");
    }

    @Test
    public void TC_07_Create_New_Customer() {
        log.info("TC:07 Create New Customer");
        log.info("Step1: click Customers left menu");
        productsPage.clickCustomersLeftMenuDropdown(driver);

        log.info("Step2: click Customers left menu sub");
        customersPage = productsPage.clickCustomersLeftMenuPage(driver);

        customersPage.waitLoadedPageByHeaderName(driver, "Customers");
        verifyTrue(customersPage.getFloatLeftHeaderPage(driver).contains("Customers"));

        log.info("Step3: click Add New button");
        customersPage.clickToAddNewButton();
        customersPage.Loaded(driver);

        customersPage.waitLoadedPageByHeaderName(driver, "Add a new customer");
        verifyTrue(customersPage.getFloatLeftHeaderPage(driver).contains("Add a new customer"));

        log.info("Step4: Remove all Customer Role ");
        customersPage.RemoveAllCustomerRoles();

        log.info("Step5: Input Customer Info Form ");
        customersPage.inputCustomerInfoForm(customerInfo);

        log.info("Step6: click to Save and Continue Edit");
        customersPage.ClickToButtonByText(driver, "Save and Continue Edit");

        verifyTrue(customersPage.getMessageSuccess(driver).contains("The new customer has been added successfully."));
        verifyTrue(customersPage.verifyCustomerInfo(customerInfo));

        log.info("Step7: click back to customer list link");
        customersPage.ClickToLinkByText(driver, "back to customer list");
        customersPage.openTabSearchEachPage(driver);

        customersPage.waitLoadedPageByHeaderName(driver, "Customers");
        log.info("Step8: Remove all Customer Role ");
        customersPage.RemoveAllCustomerRoles();

        log.info("Step9: chose Customer Role = " + customerInfo.customerRoles);
        customersPage.SelectItemInCustomerRoleByText(customerInfo.customerRoles);

        log.info("Step10: Click Search");
        customersPage.ClickToButtonByText(driver, "Search");
        customersPage.Loaded(driver);

        Assert.assertTrue(customersPage.isResultSearchByCustemerRole(customerInfo.customerRoles));
        Assert.assertTrue(customersPage.isNameDisplayedInResultCustemerSearch(customerInfo.fname + " " + customerInfo.lname));
    }

    @Test
    public void TC_08_Search_Customer_with_Email() {
        log.info("TC:08 Search Customer with Email");
        log.info("Step1: click Customers left menu sub");
        customersPage = customersPage.clickCustomersLeftMenuPage(driver);
        customersPage.openTabSearchEachPage(driver);

        log.info("Step2: Remove all Customer Role ");
        customersPage.RemoveAllCustomerRoles();

        log.info("Step3: input Email textbox: " + customerInfo.email);
        customersPage.EnterToTextboxByID(driver, "SearchEmail", customerInfo.email);

        log.info("Step4: chose Customer Role = " + customerInfo.customerRoles);
        customersPage.SelectItemInCustomerRoleByText(customerInfo.customerRoles);

        log.info("Step5: Click Search");
        customersPage.ClickToButtonByText(driver, "Search");
        customersPage.Loaded(driver);

        Assert.assertFalse(customersPage.isNoDataInTableByID(driver, "customers-grid_wrapper"));
        Assert.assertEquals(customersPage.getAllResultSearch(driver), "1");
    }

    @Test
    public void TC_09_Search_Customer_with_fname_lname() {
        log.info("TC:09 Search Customer with fname and lname");
        log.info("Step1: click Customers left menu sub");
        customersPage = customersPage.clickCustomersLeftMenuPage(driver);
        customersPage.openTabSearchEachPage(driver);

        log.info("Step2: input first name textbox: " + customerInfo.fname);
        customersPage.EnterToTextboxByID(driver, "SearchFirstName", customerInfo.fname);

        log.info("Step3: input last name textbox: " + customerInfo.lname);
        customersPage.EnterToTextboxByID(driver, "SearchLastName", customerInfo.lname);

        log.info("Step4: Remove all Customer Role ");
        customersPage.RemoveAllCustomerRoles();

        log.info("Step5: chose Customer Role = " + customerInfo.customerRoles);
        customersPage.SelectItemInCustomerRoleByText(customerInfo.customerRoles);

        log.info("Step6: Click Search");
        customersPage.ClickToButtonByText(driver, "Search");
        customersPage.Loaded(driver);

        Assert.assertFalse(customersPage.isNoDataInTableByID(driver, "customers-grid_wrapper"));
        Assert.assertEquals(customersPage.getAllResultSearch(driver), "1");
    }

    @Test
    public void TC_10_Search_Customer_with_Company() {
        log.info("TC:10 Search Customer with Company");
        log.info("Step1: click Customers left menu sub");
        customersPage = customersPage.clickCustomersLeftMenuPage(driver);
        customersPage.openTabSearchEachPage(driver);

        log.info("Step2: input Company name textbox: " + customerInfo.companyName);
        customersPage.EnterToTextboxByID(driver, "SearchCompany", customerInfo.companyName);

        log.info("Step3: Remove all Customer Role ");
        customersPage.RemoveAllCustomerRoles();

        log.info("Step4: chose Customer Role = " + customerInfo.customerRoles);
        customersPage.SelectItemInCustomerRoleByText(customerInfo.customerRoles);

        log.info("Step5: Click Search");
        customersPage.ClickToButtonByText(driver, "Search");
        customersPage.Loaded(driver);

        Assert.assertFalse(customersPage.isNoDataInTableByID(driver, "customers-grid_wrapper"));
        Assert.assertEquals(customersPage.getAllResultSearch(driver), "1");
    }

    @Test
    public void TC_11_Search_Customer_with_Full() {
        log.info("TC:11 Search Customer with full data");
        log.info("Step1: click Customers left menu sub");
        customersPage = customersPage.clickCustomersLeftMenuPage(driver);
        customersPage.openTabSearchEachPage(driver);

        log.info("Step2: input Email textbox: " + customerInfo.email);
        customersPage.EnterToTextboxByID(driver, "SearchEmail", customerInfo.email);

        log.info("Step3: input first name textbox: " + customerInfo.fname);
        customersPage.EnterToTextboxByID(driver, "SearchFirstName", customerInfo.fname);

        log.info("Step4: input last name textbox: " + customerInfo.lname);
        customersPage.EnterToTextboxByID(driver, "SearchLastName", customerInfo.lname);

        log.info("Step5: input Company name textbox: " + customerInfo.companyName);
        customersPage.EnterToTextboxByID(driver, "SearchCompany", customerInfo.companyName);

        log.info("Step6: Remove all Customer Role ");
        customersPage.RemoveAllCustomerRoles();

        log.info("Step7: chose Customer Role = " + customerInfo.customerRoles);
        customersPage.SelectItemInCustomerRoleByText(customerInfo.customerRoles);

        log.info("Step8: Click Date of Birth " + customerInfo.DOB);
        customersPage.SelectDropdownByID(driver, "SearchMonthOfBirth", "12");
        customersPage.SelectDropdownByID(driver, "SearchDayOfBirth", "12");

        log.info("Step9: Click Search");
        customersPage.ClickToButtonByText(driver, "Search");
        customersPage.sleepInSecond(2);

        Assert.assertFalse(customersPage.isNoDataInTableByID(driver, "customers-grid_wrapper"));
        Assert.assertEquals(customersPage.getAllResultSearch(driver), "1");
    }

    @Test
    public void TC_12_Edit_Customer() {
        customerInfo.email = fakeEmail();
        customerInfo.password = "123123";
        customerInfo.fname = "ARINA " + String.valueOf((new Random().nextInt(99)));
        customerInfo.lname = "HASHIMOTO " + String.valueOf((new Random().nextInt(99)));
        customerInfo.gender = "Female";
        customerInfo.DOB = "11/11/2002";
        customerInfo.companyName = "JVAuto " + String.valueOf((new Random().nextInt(99)));
        customerInfo.isTaxExempt = false;
        customerInfo.newsletter = "Your store name";
        customerInfo.customerRoles = "Guests";
        customerInfo.managerVender = "Vendor 1";
        customerInfo.isActive = true;
        customerInfo.adminComment = "Edit Customer (Guest)";

        log.info("TC:12 Edit Customer");
        log.info("TC:11 Search result 1customer with full data input");
        log.info("Step1: Click Edit button");
        customersPage.clickToEditButtonInFirstResultSearchCustomer();

        log.info("Step2: Input Edit info");
        customersPage.waitLoadedPageByHeaderName(driver, "Edit customer details");
        customersPage.RemoveAllCustomerRoles();
        customersPage.inputCustomerInfoForm(customerInfo);

        log.info("Step3: Click Save button");
        customersPage.ClickToButtonByText(driver, "Save");

        verifyTrue(customersPage.getMessageSuccess(driver).contains("The customer has been updated successfully."));

        log.info("Step4: input Email textbox: " + customerInfo.email);
        customersPage.EnterToTextboxByID(driver, "SearchEmail", customerInfo.email);

        log.info("Step5: input first name textbox: " + customerInfo.fname);
        customersPage.EnterToTextboxByID(driver, "SearchFirstName", customerInfo.fname);

        log.info("Step6: input last name textbox: " + customerInfo.lname);
        customersPage.EnterToTextboxByID(driver, "SearchLastName", customerInfo.lname);

        log.info("Step7: input Company name textbox: " + customerInfo.companyName);
        customersPage.EnterToTextboxByID(driver, "SearchCompany", customerInfo.companyName);

        log.info("Step8: Remove all Customer Role ");
        customersPage.RemoveAllCustomerRoles();

        log.info("Step9: chose Customer Role = " + customerInfo.customerRoles);
        customersPage.SelectItemInCustomerRoleByText(customerInfo.customerRoles);

        log.info("Step10: Click Date of Birth " + customerInfo.DOB);
        customersPage.SelectDropdownByID(driver, "SearchMonthOfBirth", "11");
        customersPage.SelectDropdownByID(driver, "SearchDayOfBirth", "11");

        log.info("Step11: Click Search");
        customersPage.ClickToButtonByText(driver, "Search");
        customersPage.sleepInSecond(2);

        Assert.assertFalse(customersPage.isNoDataInTableByID(driver, "customers-grid_wrapper"));
        Assert.assertEquals(customersPage.getAllResultSearch(driver), "1");
    }

    @Test
    public void TC_13_Add_New_Address() {
        log.info("TC:13 Add new Address");
        log.info("Step1: click Customers left menu sub");
        customersPage = customersPage.clickCustomersLeftMenuPage(driver);
        customersPage.openTabSearchEachPage(driver);

        log.info("Step2: input Email textbox: " + customerInfo.email);
        customersPage.EnterToTextboxByID(driver, "SearchEmail", customerInfo.email);

        log.info("Step3: input first name textbox: " + customerInfo.fname);
        customersPage.EnterToTextboxByID(driver, "SearchFirstName", customerInfo.fname);

        log.info("Step4: input last name textbox: " + customerInfo.lname);
        customersPage.EnterToTextboxByID(driver, "SearchLastName", customerInfo.lname);

        log.info("Step5: input Company name textbox: " + customerInfo.companyName);
        customersPage.EnterToTextboxByID(driver, "SearchCompany", customerInfo.companyName);

        log.info("Step6: Remove all Customer Role ");
        customersPage.RemoveAllCustomerRoles();

        log.info("Step7: chose Customer Role = " + customerInfo.customerRoles);
        customersPage.SelectItemInCustomerRoleByText(customerInfo.customerRoles);

        log.info("Step8: Click Date of Birth " + customerInfo.DOB);
        customersPage.SelectDropdownByID(driver, "SearchMonthOfBirth", "11");
        customersPage.SelectDropdownByID(driver, "SearchDayOfBirth", "11");

        log.info("Step9: Click Search");
        customersPage.ClickToButtonByText(driver, "Search");
        customersPage.Loaded(driver);

        log.info("Step10: Click Edit button");
        customersPage.clickToEditButtonInFirstResultSearchCustomer();

        log.info("Step11: Click to Address tab");
        customersPage.waitLoadedPageByHeaderName(driver, "Edit customer details");
        customersPage.clickToTabByText(driver, "Addresses");

        log.info("Step12: Click to Add new Address");
        customersPage.ClickToButtonByText(driver, "Add new address");

        log.info("Step13: Input Address info");
        customersPage.waitLoadedPageByHeaderName(driver, "Add a new address");
        customersPage.inputAddressInfoForm(addressInfo);

        verifyTrue(customersPage.getMessageSuccess(driver).contains("The new address has been added successfully."));
        verifyTrue(customersPage.verifyAddressInfo(addressInfo));

        log.info("Step14: Click Back to Customer Details");
        customersPage.ClickToLinkByText(driver, "back to customer details");

        log.info("Step15: Click to Address tab");
        customersPage.waitLoadedPageByHeaderName(driver, "Edit customer details");
        customersPage.clickToTabByText(driver, "Addresses");

        Assert.assertFalse(customersPage.isNoDataInTableByID(driver, "customer-address"));
        Assert.assertTrue(customersPage.verifyAddressInfoInCustomerByEmail(addressInfo));
    }

    @Test
    public void TC_14_Edit_Address() {

        String oldAddressEmail = addressInfo.email;

        addressInfo.fName = "Akari " + String.valueOf((new Random().nextInt(99)));
        addressInfo.lName = "Mitani " + String.valueOf((new Random().nextInt(99)));
        addressInfo.email = fakeEmail();
        addressInfo.companyName = "JVAuto " + String.valueOf((new Random().nextInt(99)));
        addressInfo.country = "Viet Nam";
        addressInfo.state = "Other";
        addressInfo.city = "Ha Noi";
        addressInfo.address1 = "69 Tran Duy Hung";
        addressInfo.address2 = "96 Nguyen Khanh Toan";
        addressInfo.postalCode = "100000";
        addressInfo.phoneNumber = "0386966969";
        addressInfo.faxNumber = "0389699669";

        log.info("TC:14: Edit Address");
        log.info("Step1: click Customers left menu sub");
        customersPage = customersPage.clickCustomersLeftMenuPage(driver);
        customersPage.openTabSearchEachPage(driver);

        log.info("Step2: input Email textbox: " + customerInfo.email);
        customersPage.EnterToTextboxByID(driver, "SearchEmail", customerInfo.email);

        log.info("Step3: input first name textbox: " + customerInfo.fname);
        customersPage.EnterToTextboxByID(driver, "SearchFirstName", customerInfo.fname);

        log.info("Step4: input last name textbox: " + customerInfo.lname);
        customersPage.EnterToTextboxByID(driver, "SearchLastName", customerInfo.lname);

        log.info("Step5: input Company name textbox: " + customerInfo.companyName);
        customersPage.EnterToTextboxByID(driver, "SearchCompany", customerInfo.companyName);

        log.info("Step6: Remove all Customer Role ");
        customersPage.RemoveAllCustomerRoles();

        log.info("Step7: chose Customer Role = " + customerInfo.customerRoles);
        customersPage.SelectItemInCustomerRoleByText(customerInfo.customerRoles);

        log.info("Step8: Click Date of Birth " + customerInfo.DOB);
        customersPage.SelectDropdownByID(driver, "SearchMonthOfBirth", "11");
        customersPage.SelectDropdownByID(driver, "SearchDayOfBirth", "11");

        log.info("Step9: Click Search");
        customersPage.ClickToButtonByText(driver, "Search");
        customersPage.Loaded(driver);

        log.info("Step10: Click Edit button");
        customersPage.clickToEditButtonInFirstResultSearchCustomer();

        log.info("Step11: Click to Address tab");
        customersPage.waitLoadedPageByHeaderName(driver, "Edit customer details");
        customersPage.clickToTabByText(driver, "Addresses");

        log.info("Step12: Click button Edit Address in Email: " + oldAddressEmail);
        customersPage.clickToEditButtonByEmail(oldAddressEmail);

        log.info("Step13: Input Address info");
        customersPage.waitLoadedPageByHeaderName(driver, "Edit address");
        verifyTrue(productsPage.getFloatLeftHeaderPage(driver).contains("Edit address"));
        customersPage.inputAddressInfoForm(addressInfo);

        verifyTrue(customersPage.getMessageSuccess(driver).contains("The address has been updated successfully."));
        verifyTrue(customersPage.verifyAddressInfo(addressInfo));

        log.info("Step14: Click Back to Customer Details");
        customersPage.ClickToLinkByText(driver, "back to customer details");

        customersPage.waitLoadedPageByHeaderName(driver, "Edit customer details");
        verifyTrue(productsPage.getFloatLeftHeaderPage(driver).contains("Edit customer details"));

        log.info("Step15: Click to Address tab");
        customersPage.clickToTabByText(driver, "Addresses");

        Assert.assertFalse(customersPage.isNoDataInTableByID(driver, "customer-address"));
        Assert.assertTrue(customersPage.verifyAddressInfoInCustomerByEmail(addressInfo));
    }

    @Test
    public void TC_15_Delete_Address() {
        log.info("TC:15 Delete Address");
        log.info("Step1: click Customers left menu sub");
        customersPage = customersPage.clickCustomersLeftMenuPage(driver);
        customersPage.openTabSearchEachPage(driver);

        log.info("Step2: input Email textbox: " + customerInfo.email);
        customersPage.EnterToTextboxByID(driver, "SearchEmail", customerInfo.email);

        log.info("Step3: input first name textbox: " + customerInfo.fname);
        customersPage.EnterToTextboxByID(driver, "SearchFirstName", customerInfo.fname);

        log.info("Step4: input last name textbox: " + customerInfo.lname);
        customersPage.EnterToTextboxByID(driver, "SearchLastName", customerInfo.lname);

        log.info("Step5: input Company name textbox: " + customerInfo.companyName);
        customersPage.EnterToTextboxByID(driver, "SearchCompany", customerInfo.companyName);

        log.info("Step6: Remove all Customer Role ");
        customersPage.RemoveAllCustomerRoles();

        log.info("Step7: chose Customer Role = " + customerInfo.customerRoles);
        customersPage.SelectItemInCustomerRoleByText(customerInfo.customerRoles);

        log.info("Step8: Click Date of Birth " + customerInfo.DOB);
        customersPage.SelectDropdownByID(driver, "SearchMonthOfBirth", "11");
        customersPage.SelectDropdownByID(driver, "SearchDayOfBirth", "11");

        log.info("Step9: Click Search");
        customersPage.ClickToButtonByText(driver, "Search");
        customersPage.Loaded(driver);

        log.info("Step10: Click Edit button");
        customersPage.clickToEditButtonInFirstResultSearchCustomer();

        log.info("Step11: Click to Address tab");
        customersPage.waitLoadedPageByHeaderName(driver, "Edit customer details");
        customersPage.clickToTabByText(driver, "Addresses");

        log.info("Step12: Click button Delete in Email: " + addressInfo.email);
        customersPage.clickToDeleteButtonByEmail(addressInfo.email);

        log.info("Step13: Click OK in Alert");
        customersPage.acceptAlert(driver);

        customersPage.clickToTabByText(driver, "Addresses");

        Assert.assertTrue(customersPage.isNoDataInTableByID(driver, "customer-address"));
        Assert.assertEquals(customersPage.getMessageNoDataInTableByID(driver, "customer-address"), "No data available in table");
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
        customerInfo.fname = "Yua " + String.valueOf((new Random().nextInt(99)));
        customerInfo.lname = "Mikami " + String.valueOf((new Random().nextInt(99)));
        customerInfo.gender = "Female";
        customerInfo.DOB = "12/12/2000";
        customerInfo.companyName = "KYAuto " + String.valueOf((new Random().nextInt(99)));
        customerInfo.isTaxExempt = false;
        customerInfo.newsletter = "Your store name";
        customerInfo.customerRoles = "Guests";
        customerInfo.managerVender = "Vendor 1";
        customerInfo.isActive = true;
        customerInfo.adminComment = "Add new Customer (Guest)";

        addressInfo.fName = "Miku " + String.valueOf((new Random().nextInt(99)));
        addressInfo.lName = "Ohashi " + String.valueOf((new Random().nextInt(99)));
        addressInfo.email = fakeEmail();
        addressInfo.companyName = "JVAuto " + String.valueOf((new Random().nextInt(99)));
        addressInfo.country = "Viet Nam";
        addressInfo.state = "Other";
        addressInfo.city = "Ho Chi Minh";
        addressInfo.address1 = "66 Tran Duy Hung";
        addressInfo.address2 = "99 Nguyen Khanh Toan";
        addressInfo.postalCode = "100000";
        addressInfo.phoneNumber = "0686966969";
        addressInfo.faxNumber = "0689699669";
    }

    private String fakeEmail() {
        return "AutoTest" + String.valueOf((new Random().nextInt(999999))) + "@gmail.com";
    }
}