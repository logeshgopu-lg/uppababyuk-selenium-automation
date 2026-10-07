package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_05_VerifyPushchairsPageLoad {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://stg.uppababy.co.uk/");
        Thread.sleep(3000);

        // Click Pushchairs menu
        driver.findElement(By.xpath("//*[normalize-space()='Pushchairs']")).click();
        Thread.sleep(3000);

        // Verify Pushchairs listing page
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("strollers")) {
            System.out.println("TC_05 Passed - Pushchairs listing page loaded successfully");
        } else {
            System.out.println("TC_05 Failed - Pushchairs listing page did not load");
        }

        driver.quit();
    }
}
