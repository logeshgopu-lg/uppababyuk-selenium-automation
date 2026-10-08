package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class TC_12_VerifyColourOptionSelection {

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

        // Find colour options
        List<WebElement> colourOptions = driver.findElements(
                By.xpath("//input[@type='radio' or @type='checkbox']/following-sibling::* | //label[contains(@class,'color') or contains(@class,'colour')]")
        );

        if (colourOptions.size() > 0) {

            WebElement firstColour = colourOptions.get(0);

            if (firstColour.isDisplayed()) {

                // Click the first colour option
                firstColour.click();
                Thread.sleep(2000);

                // Verify that the colour option is selected
                if (firstColour.getAttribute("class").contains("selected")
                        || firstColour.getAttribute("class").contains("active")
                        || firstColour.getAttribute("aria-selected") != null
                        || firstColour.getAttribute("aria-checked") != null
                        || firstColour.getAttribute("checked") != null) {

                    System.out.println("TC_12 Passed - Clicking a colour option updated the selected product colour");

                } else {

                    System.out.println("TC_12 Failed - Colour option was clicked but selection was not updated");
                }

            } else {

                System.out.println("TC_12 Failed - Colour option is not displayed");
            }

        } else {

            System.out.println("TC_12 Failed - No colour options were found on the product details page");
        }

        driver.quit();
    }
}
