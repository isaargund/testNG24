package myapp.tests.smokeTest;

import myapp.pages.BlueRental_HomePage;
import myapp.pages.BlueRental_LoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.testng.annotations.Test;

public class Day22_BlueRentalLoginTest {

    //Given user is on the application home page https://www.bluerentalcars.com/
    //Then clicks on login link
    //Then enters admin email, password
    //Then click on login button
    //Then verify the login is successful
    //Then click logout
    //Verify logout is successful

    @Test
    public void blueRentalLoginTest(){
        //Given user is on the application home page https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("bluerental_url")); //Dynamic way

        //Then clicks on login link
        //To click on the login, we need to create an object of the class where this element is stored
        BlueRental_HomePage blueRental_homePage=new BlueRental_HomePage();
        BrowserUtils.clickWithTimeOut(blueRental_homePage.userIcon,1);

        //Then enters admin email, password
        //To type on the email, password we need to create an object of the class where these elements are stored
        BlueRental_LoginPage blueRentalLoginPage = new BlueRental_LoginPage();
        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.email, ConfigReader.getProperty("bluerental_email"), 1);
        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.password, ConfigReader.getProperty("bluerental_password"), 1);

        //Then click on login button
        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.loginButton,1);

        //Then verify the login is successful
        BrowserUtils.verifyElementDisplayed(blueRental_homePage.dropdown);

        //Then click logout
        BrowserUtils.clickWithTimeOut(blueRental_homePage.dropdown, 1);
        BrowserUtils.clickWithTimeOut(blueRental_homePage.logoutOption, 1);
        BrowserUtils.clickWithTimeOut(blueRental_homePage.okOption, 1);

        //Verify logout is successful
        BrowserUtils.verifyElementDisplayed(blueRental_homePage.userIcon);

        // Close the driver
        Driver.closeDriver();
    }

}
