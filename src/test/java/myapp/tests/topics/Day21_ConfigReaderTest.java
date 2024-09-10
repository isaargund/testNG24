package myapp.tests.topics;

import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day21_ConfigReaderTest {
    @Test
    public void driverTest() throws InterruptedException {
        //  Driver.getDriver().get("https://www.amazon.com/");
        //Driver.getDriver().get("https://www.amazon.com/");


        Driver.getDriver().get(ConfigReader.getProperties("amazon_url"));

        Thread.sleep(2000);
        Driver.getDriver().navigate().refresh();

        Thread.sleep(3000);
        String title =Driver.getDriver().getTitle();
        System.out.println("title= "+title);


        Assert.assertTrue(title.contains(ConfigReader.getProperties("amazon_title")));

        Driver.closeDriver();
    }
}
