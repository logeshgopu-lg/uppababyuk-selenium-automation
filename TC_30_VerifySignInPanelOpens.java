package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_30_VerifySignInPanelOpens {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open UPPAbaby UK home page
        driver.get("https://stg.uppababy.co.uk/");
        Thread.sleep(3000);

        // Click Sign In option
        WebElement signIn = driver.findElement(
                By.xpath("//*[normalize-space()='Sign In' or normalize-space()='Sign In / Register']")
        );

        signIn.click();
        Thread.sleep(2000);

        // Verify Sign In panel is displayed
        WebElement signInPanel = driver.findElement(
                By.xpath("//input[@type='email' or @name='email']")
        );

        if (signInPanel.isDisplayed()) {

            System.out.println("TC_30 Passed - Clicking the Sign In option opened the Sign In panel");

        } else {

            System.out.println("TC_30 Failed - Sign In panel did not open");
        }

        driver.quit();
    }
}
