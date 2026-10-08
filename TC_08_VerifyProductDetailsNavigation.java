package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_08_VerifyProductDetailsNavigation {

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
        WebElement firstProduct = driver.findElement(
                By.xpath("(//div[contains(@class,'product')]//a)[1]")
        );

        firstProduct.click();
        Thread.sleep(3000);

        // Verify product details page
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("product") || currentUrl.contains("strollers")) {
            System.out.println("TC_08 Passed - Clicking a product navigated to the product details page");
        } else {
            System.out.println("TC_08 Failed - Clicking a product did not navigate to the product details page");
        }

        driver.quit();
    }
}
