package pageObjects.nopCommerce.user.MyAccountPageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.MyAccountPageUI.OrdersPageUI;

public class UserOrdersPageObject extends BasePage {
    private WebDriver driver;

    public UserOrdersPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderNumberDisplay(String orderNumber) {
        System.out.println(OrdersPageUI.ORDER_NUMBER + orderNumber);
        return isElementDisplay(driver, OrdersPageUI.ORDER_NUMBER, orderNumber);
    }
}
