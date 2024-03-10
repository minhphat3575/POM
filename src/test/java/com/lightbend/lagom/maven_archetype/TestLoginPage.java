package com.lightbend.lagom.maven_archetype;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;

import java.util.concurrent.TimeUnit;

public class TestLoginPage {
    WebDriver driver;

    @BeforeMethod
	public void setup() {
        String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        String driverPath = "D:\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        // login
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        // get then print account name
        loginPage.getAccountName("oxd-userdropdown-name");
        
        // access to the Admin tab
        loginPage.accessAdminTab("//a[@href='/web/index.php/admin/viewAdminModule']"); 
        
        // Verify a text
        loginPage.verifyText("Dashboard");
        Thread.sleep(5000);
    }

    @AfterMethod
	public void tearDown() {
        driver.quit();
    }
}
