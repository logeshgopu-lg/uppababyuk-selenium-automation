package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_04_VerifyPushchairsNavigation {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://stg.uppababy.co.uk/");
        Thread.sleep(3000);

        // Click on Pushchairs menu
        driver.findElement(By.xpath("//*[normalize-space()='Pushchairs']")).click();
        Thread.sleep(3000);

        // Verify navigation to Pushchairs listing page
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("strollers")) {
            System.out.println(
                    "TC_04 Passed - Clicking Pushchairs navigated to the Pushchairs listing page");
        } else {
            System.out.println(
                    "TC_04 Failed - Clicking Pushchairs did not navigate to the Pushchairs listing page");
        }

        driver.quit();
    }
}
