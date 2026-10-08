package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class TC_23_VerifyCheckoutRequiredFieldsDisplayed {

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

        // Click Add to Cart button
        WebElement addToCartButton = driver.findElement(
                By.xpath("//button[contains(translate(normalize-space(.),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'ADD TO CART') or contains(translate(normalize-space(.),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'ADD TO BASKET')]")
        );

        addToCartButton.click();
        Thread.sleep(3000);

        // Open shopping cart
        WebElement cartLink = driver.findElement(
                By.xpath("//*[contains(translate(normalize-space(.),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'CART') or contains(translate(normalize-space(.),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'BASKET')]")
        );

        cartLink.click();
        Thread.sleep(3000);

        // Click Checkout
        WebElement checkoutButton = driver.findElement(
                By.xpath("//button[contains(translate(normalize-space(.),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'CHECKOUT')] | //a[contains(translate(normalize-space(.),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'CHECKOUT')]")
        );

        checkoutButton.click();
        Thread.sleep(4000);

        // Verify required checkout fields
        List<WebElement> requiredFields = driver.findElements(
                By.xpath("//input[@required or @aria-required='true'] | //select[@required or @aria-required='true'] | //textarea[@required or @aria-required='true']")
        );

        if (requiredFields.size() > 0) {

            boolean allFieldsDisplayed = true;

            for (WebElement field : requiredFields) {
                if (!field.isDisplayed()) {
                    allFieldsDisplayed = false;
                    break;
                }
            }

            if (allFieldsDisplayed) {
                System.out.println("TC_23 Passed - Required checkout fields are displayed correctly");
            } else {
                System.out.println("TC_23 Failed - One or more required checkout fields are not displayed");
            }

        } else {
            System.out.println("TC_23 Failed - No required checkout fields were found");
        }

        driver.quit();
    }
}
