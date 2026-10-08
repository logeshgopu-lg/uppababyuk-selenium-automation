package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class TC_11_VerifyProductColourOptionsDisplayed {

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

        // Find colour options on product details page
        List<WebElement> colourOptions = driver.findElements(
                By.xpath("//*[contains(text(),'Colour') or contains(text(),'Color')]//following::*[self::button or self::label or self::input][position() <= 10]")
        );

        if (colourOptions.size() > 0) {

            boolean colourDisplayed = false;

            for (WebElement colourOption : colourOptions) {
                if (colourOption.isDisplayed()) {
                    colourDisplayed = true;
                    break;
                }
            }

            if (colourDisplayed) {
                System.out.println("TC_11 Passed - Product colour options are displayed on the product details page");
            } else {
                System.out.println("TC_11 Failed - Product colour options are not displayed");
            }

        } else {
            System.out.println("TC_11 Failed - No product colour options were found on the product details page");
        }

        driver.quit();
    }
}
