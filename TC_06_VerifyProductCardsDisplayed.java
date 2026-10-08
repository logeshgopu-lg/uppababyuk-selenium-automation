package MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class TC_06_VerifyProductCardsDisplayed {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open UPPAbaby UK home page
        driver.get("https://stg.uppababy.co.uk/");
        Thread.sleep(3000);

        // Click Pushchairs menu
        driver.findElement(By.xpath("//*[normalize-space()='Pushchairs']")).click();
        Thread.sleep(3000);

        // Find product cards on Pushchairs page
        List<WebElement> productCards = driver.findElements(
                By.xpath("//div[contains(@class,'product')]")
        );

        // Validate product cards
        if (productCards.size() > 0) {

            boolean allDisplayed = true;

            for (WebElement productCard : productCards) {
                if (!productCard.isDisplayed()) {
                    allDisplayed = false;
                    break;
                }
            }

            if (allDisplayed) {
                System.out.println("TC_06 Passed - Product cards are displayed correctly on the Pushchairs page");
            } else {
                System.out.println("TC_06 Failed - One or more product cards are not displayed");
            }

        } else {
            System.out.println("TC_06 Failed - No product cards are displayed on the Pushchairs page");
        }

        driver.quit();
    }
}
