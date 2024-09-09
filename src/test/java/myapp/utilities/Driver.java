package myapp.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    //This is simple Driver Class.. created on Sinleton design pattern
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().window().maximize();}
        return driver;
    }
    /*
    public static void closeDriver(){
        if (driver != null) {
            driver.quit();
            driver.get();
        }
    }

     */


}
