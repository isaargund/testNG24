package myapp.tests.topics;

import myapp.pages.OrangeHRM_DashboardPage;
import myapp.pages.OrangeHRM_LoginPage;
import myapp.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day21_OrangeHRM_Login {
    // Automate login functionality, using page object model
// https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
// Given user is the application login page
// Then enter the credentials
// Then verify the login is successful
// And logout the application
// Then verify the logout is successful

    @Test
    public void testLogin(){
        // Automate login functionality, using page object model
// https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
// Given user is the application login page

// Then enter the credentials
     //in order to access the web element we need to create Page object
        OrangeHRM_LoginPage orangeHRM_loginPage= new OrangeHRM_LoginPage();
        OrangeHRM_DashboardPage orangeHRM_dashboardPage= new OrangeHRM_DashboardPage();

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
        orangeHRM_loginPage.login("Admin", "admin123");
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
}
