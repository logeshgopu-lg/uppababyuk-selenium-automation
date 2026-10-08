package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_09_VerifyProductDetailsPageLoad {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open UPPAbaby UK home page
        driver.get("https://stg.uppababy.co.uk/");
        Thread.sleep(3000);

        // Click Pushchairs menu
        driver.findElement(By.xpath("//*[normalize-space()='Pushchairs']")).click();
        Thread.sleep(3000);

        // Click the first product
        driver.findElement(
                By.xpath("(//div[contains(@class,'product')]//a)[1]")
        ).click();
        Thread.sleep(3000);

        // Verify product details page
        String currentUrl = driver.getCurrentUrl();
        String pageTitle = driver.getTitle();

        if ((currentUrl.contains("product") || currentUrl.contains("strollers"))
                && pageTitle.length() > 0) {

            System.out.println("TC_09 Passed - Product details page loaded successfully");

        } else {

            System.out.println("TC_09 Failed - Product details page did not load successfully");
        }

        driver.quit();
    }
}
