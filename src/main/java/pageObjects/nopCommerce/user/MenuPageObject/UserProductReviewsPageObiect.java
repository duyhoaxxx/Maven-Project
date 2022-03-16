package pageObjects.nopCommerce.user.MenuPageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.TopMenuPageUI.ProductReviewsPageUI;

public class UserProductReviewsPageObiect extends BasePage {
    private WebDriver driver;

    public UserProductReviewsPageObiect(WebDriver driver) {
        this.driver = driver;
    }

    public void addReviewForm(String rvTitle, String rvText, String rating) {
        try {
            senkeyToElement(driver, ProductReviewsPageUI.ADD_REVIEW_TITLE_TEXTBOX, rvTitle);
            senkeyToElement(driver, ProductReviewsPageUI.ADD_REVIEW_TEXT_TEXTBOX, rvText);
            clickToElement(driver, ProductReviewsPageUI.ADD_RATING_RADIO_BY_VALUE, rating);
        } catch (Exception e) {
            clickToElement(driver, ProductReviewsPageUI.ADD_RATING_RADIO_BY_VALUE, "5");
            System.out.println(e.getMessage());
        }
        clickToElement(driver, ProductReviewsPageUI.SUBMIT_REVIEW_BUTTON);
    }

    public String getResultAddProductReviews() {
        return getElementText(driver, ProductReviewsPageUI.RESULT_ADD_REVIEW_MSG);
    }
}
