package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class TC_29_VerifyPushchairRegistrationFormDisplayed {

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

        // Click Stroller
        driver.findElement(
                By.xpath("//*[normalize-space()='Stroller']")
        ).click();
        Thread.sleep(3000);

        // Find form fields
        List<WebElement> formFields = driver.findElements(
                By.xpath("//form//input | //form//select | //form//textarea")
        );

        if (formFields.size() > 0) {

            boolean allFieldsDisplayed = true;

            for (WebElement field : formFields) {
                if (!field.isDisplayed()) {
                    allFieldsDisplayed = false;
                    break;
                }
            }

            if (allFieldsDisplayed) {
                System.out.println("TC_29 Passed - Pushchair Registration form fields are displayed correctly");
            } else {
                System.out.println("TC_29 Failed - One or more Pushchair Registration form fields are not displayed");
            }

        } else {

            System.out.println("TC_29 Failed - No Pushchair Registration form fields were found");
        }

        driver.quit();
    }
}
