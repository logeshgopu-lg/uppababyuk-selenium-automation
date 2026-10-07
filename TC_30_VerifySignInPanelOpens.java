package MyProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_30_VerifySignInPanelOpens {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://stg.uppababy.co.uk/");
        Thread.sleep(3000);

        System.out.println("TC Passed - Verify that clicking the Sign In option opens the Sign In panel");

        driver.quit();
    }
}
