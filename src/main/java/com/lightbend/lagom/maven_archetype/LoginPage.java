package com.lightbend.lagom.maven_archetype;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	By usernameInput = By.name("username");
	  By passwordInput = By.name("password");
	  By loginButton = By.tagName("button");
	
	  public LoginPage(WebDriver driver) {
	      this.driver = driver;
	  }
	 
	  public void enterUsername(String username) {
	      driver.findElement(usernameInput).sendKeys(username);
	  }
	 
	  public void enterPassword(String password) {
	      driver.findElement(passwordInput).sendKeys(password);
	  }
	 
	  public void clickLoginButton() {
	      driver.findElement(loginButton).click();
	}
	  
	  public void getAccountName(String className) {
		  WebElement accountNameElement = driver.findElement(By.className("oxd-userdropdown-name"));
		  String accountName = accountNameElement.getText();
		  System.out.print(accountName);
		  
	  }
	  
	  public void accessAdminTab(String href) {
		  WebElement adminTab = driver.findElement(By.xpath(href));
		  adminTab.click();
	  }
	public void verifyText(String expectedText) {
		WebElement className = driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']//h6"));
		String Text = className.getText();
		if(Text.equals(expectedText)) {
			System.out.println(" The text is displayed correctly as requirement!");
		   }
		   else {
		     System.out.println(" The text is displayed incorrect!");
		   }
		}
	 public void verifySelectedoption(String selectedString) {
		    By liLocator = By.xpath("//ul[not(@class)]/li[contains(@class, 'oxd-topbar-body-nav-tab') and contains(@class, '--parent')][2]");
		    WebElement liElement = driver.findElement(liLocator);
		    liElement.click();
		    System.out.println(liElement.getText());
		    By liSelectedpath = By.xpath("//ul[@class='oxd-dropdown-menu']/li[1]");
		    WebElement liSelected= driver.findElement(liSelectedpath);
		    System.out.println(liSelected.getText());
		    if (selectedString.equals(liSelected.getText())) {
		      System.out.println(" The text is displayed correctly as requirement!");
		    }
		    else {
		      System.out.println(" The text is displayed incorrect!");
		    }
		    
		  }
}

