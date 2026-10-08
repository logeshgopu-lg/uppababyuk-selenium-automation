package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class TC_07_VerifyProductNameAndPriceDisplayed {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open UPPAbaby UK home page
        driver.get("https://stg.uppababy.co.uk/");
        Thread.sleep(3000);

        // Click Pushchairs menu
        driver.findElement(By.xpath("//*[normalize-space()='Pushchairs']")).click();
        Thread.sleep(3000);

        // Find product cards
        List<WebElement> productCards = driver.findElements(
                By.xpath("//div[contains(@class,'product')]")
        );

        boolean allDetailsDisplayed = true;

        if (productCards.size() > 0) {

            for (WebElement productCard : productCards) {

                // Find product name
                List<WebElement> productNames = productCard.findElements(
                        By.xpath(".//*[self::h2 or self::h3 or contains(@class,'name') or contains(@class,'title')]")
                );

                // Find product price
                List<WebElement> productPrices = productCard.findElements(
                        By.xpath(".//*[contains(@class,'price') or contains(text(),'£')]")
                );

                if (productNames.size() == 0 || productPrices.size() == 0) {
                    allDetailsDisplayed = false;
                    break;
                }

                if (!productNames.get(0).isDisplayed() || !productPrices.get(0).isDisplayed()) {
                    allDetailsDisplayed = false;
                    break;
                }
            }

            if (allDetailsDisplayed) {
                System.out.println("TC_07 Passed - Product name and price are displayed for the products");
            } else {
                System.out.println("TC_07 Failed - Product name or price is not displayed for one or more products");
            }

        } else {
            System.out.println("TC_07 Failed - No products are displayed on the Pushchairs page");
        }

        driver.quit();
    }
}
