package myapp.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    //This is simple Driver Class.. created on Sinleton design pattern
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;

                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver=new FirefoxDriver();
                        break;

                        case "safari":
                            WebDriverManager.safaridriver().setup();
                            driver=new SafariDriver();
                            break;

                     case "edge":
                         WebDriverManager.edgedriver().setup();
                         driver = new EdgeDriver();
                         break;

                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                 //   driver.set(new ChromeDriver(new ChromeOptions().addArguments("--headless=new")));
                    break;
            }


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();}
        return driver;
    }

    public static void closeDriver(){
        if (driver != null) {
            driver.quit();
            driver=null;
        }
    }




}
