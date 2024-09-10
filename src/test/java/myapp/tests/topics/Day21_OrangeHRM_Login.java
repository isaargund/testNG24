package myapp.tests.topics;

import myapp.utilities.Driver;
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
// Then verify the login is successful
// And logout the application
// Then verify the logout is successful
    }
}
