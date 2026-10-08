package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_19_VerifyRemoveProductFromCart {

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

        // Get product name
        WebElement productName = driver.findElement(By.xpath("//h1"));
        String productNameText = productName.getText().trim();

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

        // Verify product is present in cart before removing
        if (driver.getPageSource().contains(productNameText)) {

            // Click Remove button
            WebElement removeButton = driver.findElement(
                    By.xpath("//*[contains(translate(normalize-space(.),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'REMOVE')]")
            );

            removeButton.click();
            Thread.sleep(3000);

            // Verify product is removed from cart
            if (!driver.getPageSource().contains(productNameText)) {
                System.out.println("TC_19 Passed - Product was removed successfully from the shopping cart");
            } else {
                System.out.println("TC_19 Failed - Product is still displayed in the shopping cart");
            }

        } else {
            System.out.println("TC_19 Failed - Product was not found in the shopping cart");
        }

        driver.quit();
    }
}
