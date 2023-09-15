package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.epam.healenium.SelfHealingDriver;
import com.rtc_ai_development.AIConstant;
import com.rtc_ai_development.RtcAI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import pageObjects.DemoAppObject;
import pageObjects.CommonObject;
import utils.ChatGpt_Helper;
import utils.ExceptionLogger;

public class DashboardAppStepDefs {
	WebDriver driver;
	WebDriver delegate;
	SelfHealingDriver selfHealingDriver;
	String methodName, errorMessage;
	String className = "DashboardAppStepDefs";
	int waitTime = 5000;

	@Given("user is on Demo App Page")
	public void user_already_on_Demo_App_page() {
		driver = CommonObject.launchApplication();
		driver.navigate().to("https://sa.rtctek.com/RTC_AI_Dashboard");
		System.out.println("Hello! You are on Demo App");

	}

	@Given("user is on Dashboard Popup Page")
	public void user_is_on_dashboard_popup_page() {
		driver = CommonObject.launchApplication();
		driver.navigate().to("https://sa.rtctek.com/RTC_AI_Dashboard/Popup/");
		System.out.println("Hello! You're on Dashboard Popup Page");
	}

	@Given("user is on Dashboard Alert Page")
	public void user_is_on_dashboard_alert_page() {
		driver = CommonObject.launchApplication();
		driver.navigate().to("https://sa.rtctek.com/RTC_AI_Dashboard/Alert/");
		System.out.println("Hello! You're on Dashboard Alert Page");
	}

	@Given("user is on Dashboard banner Page")
	public void user_is_on_dashboard_banner_page() {
		driver = CommonObject.launchApplication();
		driver.navigate().to("https://sa.rtctek.com/RTC_AI_Dashboard/Banner/");
		System.out.println("Hello! You're on Dashboard Banner Page");
	}

	@Given("user is on Login Demo Page")
	public void user_is_on_login_demo_page() {
		//selfHealingDriver = SelfHealingDriver.create(CommonObject.launchApplication());
		//selfHealingDriver = SelfHealingDriver.create(commonObject.launchApplication());
		if(selfHealingDriver == null) {
			driver = CommonObject.launchApplication();
			driver.navigate().to("https://sa.rtctek.com/RTC_AI_Dashboard/Login/");
		} else {
			selfHealingDriver.navigate().to("https://sa.rtctek.com/RTC_AI_Dashboard/Login/");
		}
		System.out.println("Hello! You're on Login Demo Page");
	}
	
	@Given("user is on Modified Login Demo Page")
	public void user_is_on_modified_login_demo_page() {
		//selfHealingDriver = SelfHealingDriver.create(commonObject.launchApplication());
		if(selfHealingDriver == null) {
			driver = CommonObject.launchApplication();
			driver.navigate().to("https://sa.rtctek.com/RTC_AI_Dashboard/Login1/");
		} else {
			selfHealingDriver.navigate().to("https://sa.rtctek.com/RTC_AI_Dashboard/Login1/");
		}
		System.out.println("Hello! You're on Login Demo Page");
	}
	
	@Given("user is on Login with Checkbox Demo Page")
	public void user_is_on_login_with_checkbox_demo_page() {
		
		//selfHealingDriver = SelfHealingDriver.create(commonObject.launchApplication());
		if(selfHealingDriver == null) {
			driver = CommonObject.launchApplication();
			driver.navigate().to("https://sa.rtctek.com/RTC_AI_Dashboard/Login2/");
		} else {
			selfHealingDriver.navigate().to("https://sa.rtctek.com/RTC_AI_Dashboard/Login2/");
		}
		System.out.println("Hello! You're on Login Demo Page");
	}

	@When("user clicks on Accept terms and condition checkbox")
	public void user_clicks_on_accept_terms_and_condition_checkbox() throws InterruptedException {
		Thread.sleep(waitTime);
		try {
			if(selfHealingDriver != null) {
				System.out.println("user is using SelfHealing Driver");
				selfHealingDriver.findElement(DemoAppObject.acceptTermsAndConditionCheckbox).click();
			} else {
				System.out.println("user is using WebDriver");
				driver.findElement(DemoAppObject.acceptTermsAndConditionCheckbox).click();
			}
		} catch(Exception e) {
			ExceptionLogger.logException(e, "user_fill_creds_in_the_login_screen", className);
			new RtcAI().fixTestMethod("user_is_on_login_with_checkbox_demo_page", className,e + "");
		}
	}

	@Given("user is on Login Modified Demo Page")
	public void user_is_on_login_modified_demo_page() {
		driver = CommonObject.launchApplication();
		driver.navigate().to("https://sa.rtctek.com/Dashboard/LoginModified/");
		System.out.println("Hello! You're on Login Demo Page");
	}

	@Then("user navigate to Login Modified Demo Page")
	public void user_navigate_to_login_modified_demo_page() {
		selfHealingDriver.navigate().to("https://sa.rtctek.com/Dashboard/LoginModified/");
	}

	@After
	public void closeBrowser(Scenario scenario) throws InterruptedException {
		Thread.sleep(waitTime);
		String scenarioName = scenario.getName();
		String scenarioStatus = scenario.getStatus().toString();
		System.out.println("Scenario: " + scenarioName + " - Status: " + scenarioStatus);

		if (scenario.isFailed()) {
			System.out.println("Your Test failed at : " + scenario.getLine());
		}
		if(selfHealingDriver != null){
			selfHealingDriver.quit();
		}
		if(driver != null) {
			driver.quit();
		}
		

	}

//	@AfterAll
//	public static void pushChanges() {
//		System.out.println("I am inside afterAll Method : ");
//		new RtcAI().pushChanges();
//	}

	@Then("validate Performance Dashboard header is appearing")
	public void validate_performance_dashboard_header_is_appearing() throws InterruptedException {
		Thread.sleep(waitTime);
		WebElement header = driver.findElement(DemoAppObject.header);
		try {
			Assert.assertTrue(header.isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("verify that AppData view is set as active")
	public void verify_that_app_data_view_is_set_as_active() throws InterruptedException {
		Thread.sleep(waitTime);
		WebElement appData = driver.findElement(DemoAppObject.appData);
		String attribute = appData.getAttribute("class");
		Assert.assertTrue(attribute.equalsIgnoreCase("Active"));
	}

	@When("user clicks on CPU Info")
	public void user_clicks_on_cpu_info() throws InterruptedException {
		Thread.sleep(waitTime);
		try {
			driver.findElement(DemoAppObject.newsApp).click();
			Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println("Exception Occured : " + e);
			methodName = "user_clicks_on_cpu_info";
			className = className;
			errorMessage = e + "";
		}

	}

	@Then("user can see CPU Info performance of devices")
	public void user_can_see_cpu_info_performance_of_devices() throws InterruptedException {
		Thread.sleep(waitTime);
		String attribute = driver.findElement(DemoAppObject.newsApp).getAttribute("class");
		Assert.assertTrue(attribute.equalsIgnoreCase("Active"));
	}

	@When("user clicks on News App info")
	public void user_clicks_on_news_app_info() throws InterruptedException {
	Thread.sleep(waitTime);
		try {
			driver.findElement(DemoAppObject.newsApp).click();
		} catch (Exception e) {
			ChatGpt_Helper.generateResponse(e.getClass().getName());
			ExceptionLogger.logException(e, "user_clicks_on_news_app_info", className);
			new RtcAI().fixTestMethod("user_clicks_on_news_app_info", className, e + "");
		}
	}

	@Then("user can see News App info performance of devices")
	public void user_can_see_news_app_info_performance_of_devices() throws InterruptedException {
		Thread.sleep(waitTime);
		String attribute = driver.findElement(DemoAppObject.newsApp).getAttribute("class");
		Assert.assertTrue(attribute.equalsIgnoreCase("Active"));
	}

	@When("user clicks on APK updater")
	public void user_clicks_on_apk_updator() throws InterruptedException {
		Thread.sleep(waitTime);
		try {
			driver.findElement(DemoAppObject.apkUpdater).click();
		} catch (Exception e) {
			ChatGpt_Helper.generateResponse(e+"");
			ExceptionLogger.logException(e, "user_tries_expand_the_recommendations_for_the_devices", className);
			new RtcAI().fixTestMethod("user_clicks_on_apk_updator", className, e + "");
		}
	}

	@Then("user can see News APK updater performance of devices")
	public void user_can_see_news_apk_updator_performance_of_devices() throws InterruptedException {
		Thread.sleep(waitTime);;
		String attribute = driver.findElement(DemoAppObject.apkUpdater).getAttribute("class");
		Assert.assertTrue(attribute.equalsIgnoreCase("Active"));
	}

	@When("user scrolls down the page")
	public void user_scrolls_down_the_page() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	@Then("user is able to see Recommendation Section on the Page")
	public void user_is_able_to_see_recommendation_section_on_the_page() throws InterruptedException {
		Thread.sleep(waitTime);
		WebElement recommendation = driver.findElement(DemoAppObject.recommendation);
		Assert.assertTrue(recommendation.isDisplayed());
	}

	@When("user tries expand the recommendations for the devices")
	public void user_tries_expand_the_recommendations_for_the_devices() throws InterruptedException {
		Thread.sleep(10000);
		WebElement fifthDevice = driver.findElement(DemoAppObject.device5);
		try {
			if (fifthDevice.isDisplayed()) {
				Thread.sleep(10000);
				fifthDevice.click();
				System.out.println("Fifth Device Clicked");
				// JavascriptExecutor js = (JavascriptExecutor) driver;
				// js.executeScript("arguments[0].setAttribute('class', 'active');",
				// fifthDevice);
				// System.out.println("Active class added to first device element");
			} else {
				System.out.println("Fifth Device doesnot Clicked");
			}
			Thread.sleep(10000);
		} catch (Exception e) {
			ChatGpt_Helper.generateResponse(e+"");
			ExceptionLogger.logException(e, "user_tries_expand_the_recommendations_for_the_devices", className);
			new RtcAI().fixTestMethod("user_tries_expand_the_recommendations_for_the_devices", className,
					e + "");
		}

	}

	@Then("the recommendations gets expanded")
	public void the_recommendations_gets_expanded() throws InterruptedException {
		// test
		Thread.sleep(waitTime);
		WebElement fifthDevice = driver.findElement(DemoAppObject.device5);
		String attribute = fifthDevice.getAttribute("class");
		Assert.assertTrue(attribute.equalsIgnoreCase("active"));
	}

	@When("user fill creds in the login screen")
	public void user_fill_creds_in_the_login_screen() throws InterruptedException {
		Thread.sleep(waitTime);
		try {
			if(selfHealingDriver != null) {
				System.out.println("user is using SelfHealing Driver");
				selfHealingDriver.findElement(DemoAppObject.userNameField).sendKeys("admin");
				selfHealingDriver.findElement(DemoAppObject.passwordField).sendKeys("admin");
			} else {
				System.out.println("user is using WebDriver");
				driver.findElement(DemoAppObject.userNameField).sendKeys("admin");
				driver.findElement(DemoAppObject.passwordField).sendKeys("admin");
			}
		} catch(Exception e) {
			ExceptionLogger.logException(e, "user_fill_creds_in_the_login_screen", className);
			new RtcAI().fixTestMethod("user_is_on_login_demo_page", className,e + "");
		}	
	}
	
	@When("user fill creds in the Modifiedlogin screen")
	public void user_fill_creds_in_the_modifiedlogin_screen() throws InterruptedException {
		Thread.sleep(waitTime);
		try {
			if(selfHealingDriver != null) {
				System.out.println("user is using SelfHealing Driver");
				selfHealingDriver.findElement(DemoAppObject.userNameField).sendKeys("admin");
				selfHealingDriver.findElement(DemoAppObject.passwordField).sendKeys("admin");
			} else {
				System.out.println("user is using WebDriver");
				driver.findElement(DemoAppObject.userNameField).sendKeys("admin");
				driver.findElement(DemoAppObject.passwordField).sendKeys("admin");
			}
		} catch(Exception e) {
			ExceptionLogger.logException(e, "user_is_on_modified_login_demo_page", className);
			new RtcAI().fixTestMethod("user_is_on_modified_login_demo_page", className,e + "");
		}	
	}
	
	@When("user fill creds in the login2 screen")
	public void user_fill_creds_in_the_login2_screen() throws InterruptedException {
		Thread.sleep(waitTime);
		try {
			if(selfHealingDriver != null) {
				System.out.println("user is using SelfHealing Driver");
				selfHealingDriver.findElement(DemoAppObject.userNameField).sendKeys("admin");
				selfHealingDriver.findElement(DemoAppObject.passwordField).sendKeys("admin");
			} else {
				System.out.println("user is using WebDriver");
				driver.findElement(DemoAppObject.userNameField).sendKeys("admin");
				driver.findElement(DemoAppObject.passwordField).sendKeys("admin");
			}
		} catch(Exception e) {
			ExceptionLogger.logException(e, "user_fill_creds_in_the_login_screen", className);
			new RtcAI().fixTestMethod("user_is_on_login_demo_page", className,e + "");
		}	
	}

	@When("user clicks on login\\/submit button")
	public void user_clicks_on_login_submit_button() throws InterruptedException {
		Thread.sleep(2000);
		try {
			if(selfHealingDriver != null ) {
				selfHealingDriver.findElement(DemoAppObject.loginButton).click();
			}else {
				driver.findElement(DemoAppObject.loginButton).click();
			}
			
		} catch (Exception e) {
			System.out.println("Exception Occured : " + e);
		}

	}
	

	@Then("user is able to login into the application")
	public void user_is_able_to_login_into_the_application() throws InterruptedException {
		Thread.sleep(waitTime);
		WebElement header;
		if(driver != null) {
			header = driver.findElement(DemoAppObject.header);
		} else {
			header = selfHealingDriver.findElement(DemoAppObject.header);
		}
		 
		try {
			Assert.assertTrue(header.isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("user clicks on News App info Demo App Page")
	public void user_clicks_on_news_app_info_on_demo_page() throws InterruptedException {
		Thread.sleep(waitTime);
		try {
			driver.findElement(DemoAppObject.newsApp).click();
		} catch (Exception e) {
			ChatGpt_Helper.generateResponse(e+"");
			ExceptionLogger.logException(e, "user_clicks_on_news_app_info", className);
			new RtcAI().fixTestMethod("user_clicks_on_news_app_info",className, e + "");
		}
	}

	@When("user clicks on APK updater Demo App Page")
	public void user_clicks_on_apk_updater_on_demo_page() throws InterruptedException {
		Thread.sleep(waitTime);
		try {
			driver.findElement(DemoAppObject.apkUpdater).click();
		} catch (Exception e) {
			ExceptionLogger.logException(e, "user_tries_expand_the_recommendations_for_the_devices", className);
			new RtcAI().fixTestMethod("user_clicks_on_apk_updator", className, e + "");
		}
	}
	
	@Then("user clicks on Performance Testing service button present on the screen")
	public void user_clicks_on_performance_testing_service_button_present_on_the_screen() {
	    driver.findElement(DemoAppObject.performanceTestingButton).click();
	}
	
	@Then("user clicks on Functional Testing service button present on the screen")
	public void user_clicks_on_functional_testing_service_button_present_on_the_screen() {
		 driver.findElement(DemoAppObject.functionalTestingButton).click();
	}
	
	@Then("user clicks on Automation Testing service button present on the screen")
	public void user_clicks_on_automation_testing_service_button_present_on_the_screen() {
		driver.findElement(DemoAppObject.automationTestingButton).click();
	}

	@Then("user scroll down the page till footer")
	public void user_scroll_down_the_page_till_footer() throws InterruptedException {
		Thread.sleep(waitTime);
//		waitTime = 2000;
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight/2)");
//		Thread.sleep(waitTime);
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long documentHeight = (Long) js.executeScript("return document.documentElement.scrollHeight");
		long scrollPosition = 0;
		int scrollStep = 500;
		
		while(scrollPosition < documentHeight) {
			js.executeScript("window.scrollTo(0, " + scrollPosition + ");");
			scrollPosition += scrollStep;
		}
	}

}