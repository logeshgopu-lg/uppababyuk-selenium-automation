package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_16_VerifyProductPriceDisplayedInCart {

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

        // Get product price from product details page
        WebElement productPrice = driver.findElement(
                By.xpath("(//*[contains(@class,'price') and contains(.,'£')])[1]")
        );

        String productPriceText = productPrice.getText().trim();

        System.out.println("Product price on PDP: " + productPriceText);

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

        // Get product price from shopping cart
        WebElement cartPrice = driver.findElement(
                By.xpath("(//*[contains(@class,'price') and contains(.,'£')])[1]")
        );

        String cartPriceText = cartPrice.getText().trim();

        System.out.println("Product price in Cart: " + cartPriceText);

        // Verify product price is displayed and matches PDP price
        if (cartPrice.isDisplayed() &&
                !cartPriceText.isEmpty() &&
                cartPriceText.equals(productPriceText)) {

            System.out.println("TC_16 Passed - Product price is displayed correctly in the shopping cart");

        } else {

            System.out.println("TC_16 Failed - Product price in the shopping cart does not match the product details page");
        }

        driver.quit();
    }
}
