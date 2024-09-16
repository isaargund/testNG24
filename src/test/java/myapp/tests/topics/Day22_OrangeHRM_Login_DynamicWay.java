package myapp.tests.topics;

import myapp.pages.OrangeHRM_DashboardPage;
import myapp.pages.OrangeHRM_LoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day22_OrangeHRM_Login_DynamicWay {
    @Test
    public void testLoginDynamic() {
        // Automate login functionality, using page object model
// https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        Driver.getDriver().get(ConfigReader.getProperty("orangeHRM_url"));
// Given user is the application login page

// Then enter the credentials
        //in order to access the web element we need to create Page object
        OrangeHRM_LoginPage orangeHRM_loginPage = new OrangeHRM_LoginPage();
        OrangeHRM_DashboardPage orangeHRM_dashboardPage = new OrangeHRM_DashboardPage();

        /*
        orangeHRM_loginPage.username.sendKeys("Admin");
        WaitUtils.waitFor(3);
        orangeHRM_loginPage.password.sendKeys("admin123");
        WaitUtils.waitFor(3);
        orangeHRM_loginPage.clickButton.click();
        WaitUtils.waitFor(3);
        ?/
         */

        //or use reusable method
        orangeHRM_loginPage.login(ConfigReader.getProperty("orangeHRM_username"), ConfigReader.getProperty("orangeHRM_password"));
        orangeHRM_dashboardPage.dropdown.isDisplayed();
        WaitUtils.waitFor(1);
        orangeHRM_dashboardPage.dropdown.click();
        WaitUtils.waitFor(1);
        orangeHRM_dashboardPage.logout.click();
        WaitUtils.waitFor(1);

        Assert.assertTrue(orangeHRM_loginPage.username.isDisplayed());

        //Close the driver

        Driver.closeDriver();


// Then verify the login is successful
// And logout the application
// Then verify the logout is successful
    }

    @Test(groups = "minor_regression_group")
    public void loginTestDynamic_ReusableMethods() {
        // Given user is the application login page
        Driver.getDriver().get(ConfigReader.getProperty("orangeHRM_url"));

        // Then enter the credentials
        // Inorder to access the Webelements, we need to create Page Object.
        OrangeHRM_LoginPage orangeHRMLoginPage = new OrangeHRM_LoginPage();

        // Recommended way => USE Reusable method from Utils Class
        BrowserUtils.sendKeysWithTimeout(orangeHRMLoginPage.username, ConfigReader.getProperty("orangeHRM_username"), 1);
        BrowserUtils.sendKeysWithTimeout(orangeHRMLoginPage.password, ConfigReader.getProperty("orangeHRM_password"), 1);
        BrowserUtils.clickWithTimeOut(orangeHRMLoginPage.clickButton, 1);

        // Then verify the login is successful
        OrangeHRM_DashboardPage orangeHRMDashboardPage = new OrangeHRM_DashboardPage(); // create an object from page class
        BrowserUtils.verifyElementDisplayed(orangeHRMDashboardPage.dropdown); //use reusable method from Utils class

        // And logout the application
        BrowserUtils.clickWithTimeOut(orangeHRMDashboardPage.dropdown, 1);
        BrowserUtils.clickWithTimeOut(orangeHRMDashboardPage.logout, 1);

        // Then verify the logout is successful
        BrowserUtils.verifyElementDisplayed(orangeHRMLoginPage.username);

        //Close the driver
        Driver.closeDriver();
    }

    //Home Work
    //Test the Login and logout functionality using Page Object Model
    // https://testcenter.techproeducation.com/index.php?page=form-authentication
    //Pages:
    //TechproHomePage
    //        - homeHeader
    //        - homeLogoutButton
    //TechproLoginPage
    //        - userName
    //        - password
    //        - submitButton
    //Tests:
    //        - Class: TechproLoginTest
    //        - Method: loginTest()
    //ConfigReaderTest Data – configuration.properties::
    //techpro_test_url=https://testcenter.techproeducation.com/index.php?page=form-authentication
    //techpro_test_username=techproed
    //techpro_test_password=SuperSecretPassword (edited)

}