package myapp.tests.topics;

import myapp.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day20_DriverTest {

   // Test case:
// Go to amazon page
// Verify the title includes amazon
// Check if Driver class is working

    @Test
    public void driverTest() throws InterruptedException {
        Driver.getDriver().get("https://www.amazon.com/");
        Thread.sleep(2000);
        Driver.getDriver().navigate().refresh();
        String title =Driver.getDriver().getTitle();
        Assert.assertEquals(title,"Amazon");
    }
    //trying
}
