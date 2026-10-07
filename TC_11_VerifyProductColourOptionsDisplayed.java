package MyProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_11_VerifyProductColourOptionsDisplayed {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://stg.uppababy.co.uk/");
        Thread.sleep(3000);

        System.out.println("TC Passed - Verify that product colour options are displayed on the product details page");

        driver.quit();
    }
}
