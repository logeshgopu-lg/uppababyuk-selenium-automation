package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_18_VerifyDecreaseCartQuantity {

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

        // Get quantity field
        WebElement quantityField = driver.findElement(
                By.xpath("//input[@type='number' or contains(@class,'quantity')]")
        );

        // Get initial quantity
        String initialQuantity = quantityField.getAttribute("value");

        // Click plus button first to increase quantity
        WebElement plusButton = driver.findElement(
                By.xpath("//button[contains(@aria-label,'Increase') or contains(@aria-label,'increase') or contains(@class,'plus')]")
        );

        plusButton.click();
        Thread.sleep(2000);

        // Get increased quantity
        String increasedQuantity = quantityField.getAttribute("value");

        // Click minus button
        WebElement minusButton = driver.findElement(
                By.xpath("//button[contains(@aria-label,'Decrease') or contains(@aria-label,'decrease') or contains(@class,'minus')]")
        );

        minusButton.click();
        Thread.sleep(2000);

        // Get updated quantity after decrease
        String updatedQuantity = quantityField.getAttribute("value");

        // Verify quantity was decreased
        if (increasedQuantity.equals(updatedQuantity) == false
                && updatedQuantity.equals(initialQuantity)) {

            System.out.println("TC_18 Passed - Cart quantity was decreased successfully using the minus button");

        } else {

            System.out.println("TC_18 Failed - Cart quantity was not decreased using the minus button");
        }

        driver.quit();
    }
}
