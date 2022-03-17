package commons;

import java.io.File;

public class GlobalConstants {
    public static final int LONG_TIMEOUT = 30;
    public static final int SHORT_TIMEOUT = 4;
    public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
    public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";
    public static final String ADMIN_EMAIL = "admin@yourstore.com";
    public static final String ADMIN_PASSWORD = "admin";
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String PROJECT_PATH = System.getProperty("user.dir");

    public static final String UPLOAD_FILE_TYPE = "//input[@type='file']";
    public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGImage" + File.separator;
    public static final String DOWNLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "downloadFiles";
    public static final String BROWSER_LOG_FOLDER = PROJECT_PATH + File.separator + "browserLogs";

    public static class AddressInfo {
        public String fName;
        public String lName;
        public String email;
        public String companyName;
        public String country;
        public String state;
        public String city;
        public String address1;
        public String address2;
        public String postalCode;
        public String phoneNumber;
        public String faxNumber;

    }

    ;

    public static class CustomerInfo {
        public String email;
        public String password;
        public String fname;
        public String lname;
        public String gender;
        public String DOB;
        public String companyName;
        public boolean isTaxExempt;
        public String newsletter;
        public String customerRoles;
        public String managerVender;
        public boolean isActive;
        public String adminComment;
    }


}