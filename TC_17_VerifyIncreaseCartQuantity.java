package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_17_VerifyIncreaseCartQuantity {

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

        // Get current quantity
        WebElement quantityField = driver.findElement(
                By.xpath("//input[@type='number' or contains(@class,'quantity')]")
        );

        String initialQuantity = quantityField.getAttribute("value");

        // Click plus button
        WebElement plusButton = driver.findElement(
                By.xpath("//button[contains(@aria-label,'Increase') or contains(@aria-label,'increase') or contains(@class,'plus')]")
        );

        plusButton.click();
        Thread.sleep(2000);

        // Get updated quantity
        String updatedQuantity = quantityField.getAttribute("value");

        // Verify quantity increased
        if (!initialQuantity.equals(updatedQuantity)) {

            System.out.println("TC_17 Passed - Cart quantity was increased successfully using the plus button");

        } else {

            System.out.println("TC_17 Failed - Cart quantity was not increased using the plus button");
        }

        driver.quit();
    }
}
