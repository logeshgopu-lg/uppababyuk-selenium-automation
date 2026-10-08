package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_24_VerifyCountryDropdownDisplayed {

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

        // Find Country dropdown
        WebElement countryDropdown = driver.findElement(
                By.xpath("//select[contains(@name,'country') or contains(@id,'country')]")
        );

        // Verify Country dropdown is displayed
        if (countryDropdown.isDisplayed() && countryDropdown.isEnabled()) {

            Select countrySelect = new Select(countryDropdown);

            if (countrySelect.getOptions().size() > 0) {
                System.out.println("TC_24 Passed - Country dropdown is displayed and selectable");
            } else {
                System.out.println("TC_24 Failed - Country dropdown is displayed but has no options");
            }

        } else {

            System.out.println("TC_24 Failed - Country dropdown is not displayed or selectable");
        }

        driver.quit();
    }
}
