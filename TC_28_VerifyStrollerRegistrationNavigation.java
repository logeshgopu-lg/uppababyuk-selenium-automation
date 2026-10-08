package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_28_VerifyStrollerRegistrationNavigation {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open UPPAbaby UK home page
        driver.get("https://stg.uppababy.co.uk/");
        Thread.sleep(3000);

        // Click Support menu
        driver.findElement(By.xpath("//*[normalize-space()='Support']")).click();
        Thread.sleep(2000);

        // Click Product Registration
        driver.findElement(
                By.xpath("//*[contains(normalize-space(),'Product Registration')]")
        ).click();
        Thread.sleep(3000);

        // Click Stroller registration
        driver.findElement(
                By.xpath("//*[normalize-space()='Stroller']")
        ).click();
        Thread.sleep(3000);

        // Verify Pushchair Registration page
        String currentUrl = driver.getCurrentUrl();
        String pageTitle = driver.getTitle();

        if (currentUrl.toLowerCase().contains("registration")
                || pageTitle.toLowerCase().contains("registration")) {

            System.out.println("TC_28 Passed - Clicking Stroller navigated to the Pushchair Registration page");

        } else {

            System.out.println("TC_28 Failed - Clicking Stroller did not navigate to the Pushchair Registration page");
        }

        driver.quit();
    }
}
