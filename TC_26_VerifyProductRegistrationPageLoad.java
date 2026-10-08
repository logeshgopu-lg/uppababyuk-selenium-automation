package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_26_VerifyProductRegistrationPageLoad {

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

        // Verify Product Registration page
        String currentUrl = driver.getCurrentUrl();
        String pageTitle = driver.getTitle();

        if ((currentUrl.toLowerCase().contains("registration")
                || pageTitle.toLowerCase().contains("registration"))) {

            System.out.println("TC_26 Passed - Product Registration page loaded successfully");

        } else {

            System.out.println("TC_26 Failed - Product Registration page did not load successfully");
        }

        driver.quit();
    }
}
