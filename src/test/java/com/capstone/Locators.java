package com.capstone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Locators {

	WebDriver driver;
//	HOME
	@FindBy(xpath="/html/body/div[3]/nav/div/div[1]/a")
	WebElement homeButton;
	@FindBy(xpath="//*[@id=\"about\"]/a")
	WebElement aboutButton;
	@FindBy(xpath="//*[@id=\"contact\"]/a")
	WebElement contactButton;
	@FindBy(xpath="//*[@id=\"listProducts\"]/a")
	WebElement listProductsButton;
	
//	LOGIN
	@FindBy(xpath="//*[@id=\"username\"]")
	WebElement email;
	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement password;
	@FindBy(css="#loginForm > div:nth-child(3) > div > input.btn.btn-primary")
	WebElement loginButton;
	
	
	    

	public Locators(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void Home() throws InterruptedException {
//		homeButton.click();
		aboutButton.click();
		System.out.println(aboutButton.getText());
		Thread.sleep(2000);
		contactButton.click();
		System.out.println(contactButton.getText());
		Thread.sleep(2000);
		listProductsButton.click();
		
	}
	public void Login(String us, String pwd) {
		email.sendKeys(us);
		password.sendKeys(pwd);
		loginButton.click();
	}
	
	
	
	
	
}
