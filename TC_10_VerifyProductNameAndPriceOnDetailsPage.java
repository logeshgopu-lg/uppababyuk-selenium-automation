package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_10_VerifyProductNameAndPriceOnDetailsPage {

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

        // Find product name
        WebElement productName = driver.findElement(
                By.xpath("//h1")
        );

        // Find product price
        WebElement productPrice = driver.findElement(
                By.xpath("//*[contains(@class,'price') or contains(text(),'£')]")
        );

        // Verify product name and price
        if (productName.isDisplayed()
                && !productName.getText().trim().isEmpty()
                && productPrice.isDisplayed()
                && !productPrice.getText().trim().isEmpty()) {

            System.out.println("TC_10 Passed - Product name and price are displayed correctly on the product details page");

        } else {

            System.out.println("TC_10 Failed - Product name or price is not displayed correctly on the product details page");
        }

        driver.quit();
    }
}
