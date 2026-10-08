package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_15_VerifyProductDisplayedInCart {

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

        // Open Cart
        WebElement cartLink = driver.findElement(
                By.xpath("//*[contains(translate(normalize-space(.),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'CART') or contains(translate(normalize-space(.),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'BASKET')]")
        );

        cartLink.click();
        Thread.sleep(3000);

        // Verify product is displayed in cart
        WebElement cartProduct = driver.findElement(
                By.xpath("//*[contains(normalize-space(),'" + productNameText + "')]")
        );

        if (cartProduct.isDisplayed()) {
            System.out.println("TC_15 Passed - Shopping cart displays the added product");
        } else {
            System.out.println("TC_15 Failed - Added product is not displayed in the shopping cart");
        }

        driver.quit();
    }
}
