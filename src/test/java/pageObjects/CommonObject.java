package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonObject {

	By header = By.xpath("//div//h3");
	private static WebDriver driver;

	public static WebDriver launchApplication() {
//		System.setProperty("webdriver.chromedriver", "C:\\Users\\Administrator\\Desktop\\rtc-ai-automation\\src\\test\\resources\\driver\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		//options.addArguments("--headless");
//		WebDriver driver = new ChromeDriver(options);		
//		driver.manage().window().maximize();
		WebDriverManager.chromedriver().browserVersion("117.0.5938.63").setup();
		driver = new ChromeDriver();
		return driver;
	}
	
}