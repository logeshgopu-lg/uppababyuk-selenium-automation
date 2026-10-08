package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class TC_27_VerifyProductRegistrationTypesDisplayed {

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

        // Find available product registration types
        List<WebElement> registrationTypes = driver.findElements(
                By.xpath("//*[contains(normalize-space(),'Stroller') or contains(normalize-space(),'Car Seat') or contains(normalize-space(),'Accessory')]")
        );

        if (registrationTypes.size() > 0) {

            boolean allDisplayed = true;

            for (WebElement registrationType : registrationTypes) {
                if (!registrationType.isDisplayed()) {
                    allDisplayed = false;
                    break;
                }
            }

            if (allDisplayed) {
                System.out.println("TC_27 Passed - Available product registration types are displayed");
            } else {
                System.out.println("TC_27 Failed - One or more product registration types are not displayed");
            }

        } else {
            System.out.println("TC_27 Failed - No product registration types were found");
        }

        driver.quit();
    }
}
