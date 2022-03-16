package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.*;
import pageObjects.nopCommerce.user.MyAccountPageObject.*;
import pageObjects.nopCommerce.user.MenuPageObject.*;

public class PageGeneratorManager {
    public static UserHomePageObject getUserHomePage(WebDriver driver) {
        return new UserHomePageObject(driver);
    }

    public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
        return new UserLoginPageObject(driver);
    }

    public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
        return new UserRegisterPageObject(driver);
    }

    public static UserCustomerInfoPageObject getUserMyAccountPage(WebDriver driver) {
        return new UserCustomerInfoPageObject(driver);
    }

    public static UserCustomerInfoPageObject getUserCustomerInfoPage(WebDriver driver) {
        return new UserCustomerInfoPageObject(driver);
    }

    public static UserAddressPageObject getUserAddressPage(WebDriver driver) {
        return new UserAddressPageObject(driver);
    }

    public static UserOrdersPageObject getUserOrdersPage(WebDriver driver) {
        return new UserOrdersPageObject(driver);
    }

    public static UserDownloadableProductsPageObject getUserDownloadableProductsPage(WebDriver driver) {
        return new UserDownloadableProductsPageObject(driver);
    }

    public static UserBackInStockSubscriptionsPageObject getUserBackInStockSubsciptionsPage(WebDriver driver) {
        return new UserBackInStockSubscriptionsPageObject(driver);
    }

    public static UserRewardPointsPageObject getUserRewardPointsPage(WebDriver driver) {
        return new UserRewardPointsPageObject(driver);
    }

    public static UserChangePasswordPageObject getUserChangePasswordPage(WebDriver driver) {
        return new UserChangePasswordPageObject(driver);
    }

    public static UserMyProductReviewsPageObject getUserMyProductReviewsPage(WebDriver driver) {
        return new UserMyProductReviewsPageObject(driver);
    }

    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPageObject(driver);
    }

    public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
        return new AdminDashboardPageObject(driver);
    }

    public static UserMenuComputersPageObiect getUserMenuComputersPage(WebDriver driver) {
        return new UserMenuComputersPageObiect(driver);
    }

    public static UserProductReviewsPageObiect getProductReviewsPage(WebDriver driver) {
        return new UserProductReviewsPageObiect(driver);
    }

    public static UserSearchPageObject getUserSearchPage(WebDriver driver) {
        return new UserSearchPageObject(driver);
    }

    public static UserWishlistPageObject getWishlistPage(WebDriver driver) {
        return new UserWishlistPageObject(driver);
    }

    public static UserShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
        return new UserShoppingCartPageObject(driver);
    }

    public static UserCompareProductsPageObject getCompareProductsPage(WebDriver driver) {
        return new UserCompareProductsPageObject(driver);
    }

    public static UserRecentlyViewedProductsPageObject getRecentlyViewedProductsPage(WebDriver driver) {
        return new UserRecentlyViewedProductsPageObject(driver);
    }

    public static UserCheckoutPageObject getCheckoutPage(WebDriver driver) {
        return new UserCheckoutPageObject(driver);
    }
}
