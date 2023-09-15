package pageObjects;

import org.openqa.selenium.By;

public class DemoAppObject {
    public static By header = By.xpath("//div//h3");
    public static By appData = By.xpath("//li//a[@href='#AppData']");
    public static By cpuInfo = By.xpath("//li//a[@href='#CPUInfo']");
    public static By newsApp = By.xpath("//li//a[@href='#NewsApp']");
    public static By apkUpdater = By.xpath("//li//a[@href='#APKUpdator']");
    public static By recommendation = By.xpath("//*[@id=\"CPUInfoData\"]/div/div/h4");
    public static By device1 = By.xpath("//*[@id=\"CPUInfoData\"]/div/ul/li[1]");
    public static By device2 = By.xpath("//*[@id=\"CPUInfoData\"]/div/ul/li[2]");
    public static By device3 = By.xpath("//*[@id=\"CPUInfoData\"]/div/ul/li[3]");
    public static By device4 = By.xpath("//*[@id=\"CPUInfoData\"]/div/ul/li[4]");
    public static By device5 = By.xpath("//*[@id=\"CPUInfoData\"]/div/ul/li[5]");
    public static By userNameField = By.xpath("//input[@id='username']");
    public static By passwordField = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//button[@type='submit']");
    public static By acceptTermsAndConditionCheckbox = By.xpath("//input[@type='checkbox']//following-sibling::span");
    public static By performanceTestingButton = By.xpath("//button[contains(text(), 'Performance')]");
    public static By functionalTestingButton = By.xpath("//button[contains(text(), 'Functional')]");
    public static By automationTestingButton = By.xpath("//button[contains(text(), 'Automation')]");
}