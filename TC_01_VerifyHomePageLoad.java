package MyProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_01_VerifyHomePageLoad {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://stg.uppababy.co.uk/");
		Thread.sleep(3000);

		String pageTitle = driver.getTitle();

		if(pageTitle.contains("UPPAbaby")) {
			System.out.println("TC_01 Passed - UPPAbaby UK home page loaded successfully");
		}else {
			System.out.println("TC_01 Failed - UPPAbaby UK home page did not load");
		}

		driver.quit();
	}
}
