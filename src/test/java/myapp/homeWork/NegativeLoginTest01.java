package myapp.homeWork;

import myapp.pages.BlueRental_HomePage;
import myapp.pages.BlueRental_LoginPage;
import myapp.utilities.ActionUtils;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest01 {

    @Test
    public void test(){
        //Given user is on the application home page https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("bluerental_url"));
//Then clicks on login link
        BlueRental_HomePage blueRental_homePage= new BlueRental_HomePage();
        BrowserUtils.clickWithTimeOut(blueRental_homePage.userIcon,1);

//Then enters email="fake@bluerentalcars.com", password="fakepass"
        BlueRental_LoginPage blueRentalLoginPage= new BlueRental_LoginPage();
        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.email,ConfigReader.getProperty("bluerental_fakeemail"),1);
        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.password,ConfigReader.getProperty("bluerental_fakepassword"),1);
        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.loginButton,1);

        System.out.println("******this is verify area*****");

       // ActionUtils.actionsHoverOverOnElement(blueRentalLoginPage.unsuccessfullogin);
       // BrowserUtils.verifyElementDisplayed(blueRentalLoginPage.unsuccessfullogin);
       // Assert.assertTrue(blueRentalLoginPage.unsuccessfullogin.isEnabled());
       // BrowserUtils.clickWithTimeOut(blueRentalLoginPage.unsuccessfullogin,1);

        BrowserUtils.verifyElementClickable(blueRentalLoginPage.unsuccessfullogin);

        Driver.closeDriver();




//Then click on login button
//Then verify the login is unsuccessful
    }
}
