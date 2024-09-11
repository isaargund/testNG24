package myapp.pages;

import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_LoginPage {

    //1.Create a constructor and use page factory class in it to initialise the page objects
    //2. locate the webelement using  @FindBy annotation so we can call them in Test
    // Class
    //Traditional way/JUnit way =>Webelement username =driver.findElement(By.id"")
    //  In TestNG => @FindBy("any locater") public Webelement username;

    public OrangeHRM_LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public  WebElement clickButton;

    //Reusable Method for page specific Function
    public void  login( String userId,String pass){
        username.sendKeys(userId);
        WaitUtils.waitFor(1);
        password.sendKeys(pass);
        WaitUtils.waitFor(1);
        clickButton.click();
    }


}
