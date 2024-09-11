package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_DashboardPage {

    //1. Create a constructor with page factory class
    //2. Locate elements using @FindBy annotation

    public OrangeHRM_DashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    public WebElement dropdown;

    @FindBy(linkText = "Logout")
    public WebElement logout;

}
