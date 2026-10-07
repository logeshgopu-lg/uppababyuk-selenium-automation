package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_03_VerifyMainNavigationMenuDisplayed {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://stg.uppababy.co.uk/");
        Thread.sleep(3000);

        // Locate main navigation menu items
        WebElement pushchairs = driver.findElement(
                By.xpath("//*[normalize-space()='Pushchairs']"));

        WebElement travelSystems = driver.findElement(
                By.xpath("//*[normalize-space()='Travel Systems']"));

        WebElement carSeats = driver.findElement(
                By.xpath("//*[normalize-space()='Car Seats']"));

        WebElement accessories = driver.findElement(
                By.xpath("//*[normalize-space()='Accessories']"));

        WebElement support = driver.findElement(
                By.xpath("//*[normalize-space()='Support']"));

        // Verify all main navigation menu items are displayed
        if (pushchairs.isDisplayed()
                && travelSystems.isDisplayed()
                && carSeats.isDisplayed()
                && accessories.isDisplayed()
                && support.isDisplayed()) {

            System.out.println(
                    "TC_03 Passed - Main navigation menu items are displayed correctly");

        } else {

            System.out.println(
                    "TC_03 Failed - One or more main navigation menu items are not displayed");
        }

        driver.quit();
    }
}
