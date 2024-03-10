package com.lightbend.lagom.maven_archetype;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDropDownList {
	WebDriver driver;
	
    DropDownList dropDownList = new DropDownList();
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
	    public void testSelectOption() throws InterruptedException {
		 LoginPage loginPage = new LoginPage(driver);
	        // login
	        loginPage.enterUsername("Admin");
	        loginPage.enterPassword("admin123");
	        loginPage.clickLoginButton();
	        
	        loginPage.accessAdminTab("//a[@href='/web/index.php/admin/viewAdminModule']"); 
	         
	        loginPage.verifySelectedoption("Job Titles");
	        Thread.sleep(5000);
	    }

	 
	    @AfterMethod
		public void tearDown() {
	        driver.quit();
	    }
}
