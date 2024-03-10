package com.lightbend.lagom.maven_archetype;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownList {
	WebDriver  driver;
	By Dropdownlist = By.name("Job ");
	
	public void clickDropDownList() {
		driver.findElement(Dropdownlist).click();
	}	
	public void selectFromDropDown(String option) {
		Select dropdownElement = new Select(driver.findElement(Dropdownlist));
		dropdownElement.deselectByVisibleText(option);
	}
	public List<String> getSelectOption(){
		List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
		return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
	}
	
	public void scrollDropDown() {
		String text = "arguments[0].setAttribute('multiple', '')";
		((JavascriptExecutor)driver).executeScript(text, findDropDownElement());
	}
	private Select findDropDownElement() {
		return new Select((driver.findElement(Dropdownlist)));
	}
}
