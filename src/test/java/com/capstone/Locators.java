package com.capstone;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;

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
	
//	Add To Cart
	@FindBy(xpath="//*[@id=\"a_Antipyretics\"]")
	WebElement antipy;  
	@FindBy(xpath="//*[@id=\"productListTable\"]/tbody/tr[1]/td[6]/a[2]")
	WebElement cart;
	@FindBy(xpath="//*[@id=\"cart\"]/tfoot/tr[2]/td[4]/a")
	WebElement Checkout;
	@FindBy(css="body > div.wrapper > div.content > div > div > div.col-md-4 > div > div > div > a")
	WebElement select;
	@FindBy(xpath="//*[@id='cardNumber']")
	WebElement card;
	@FindBy(xpath="//*[@id='expityMonth']")
	WebElement expM;
	@FindBy(xpath="//*[@id='expityYear']")
	WebElement expY;
	@FindBy(xpath="//*[@id='cvCode']")
	WebElement cv;
	@FindBy(css="body > div.wrapper > div.content > div > div > div:nth-child(2) > a")
	WebElement Pay;
	@FindBy(css="body > div.wrapper > div.content > div > div.alert.alert-success > h3")
	WebElement order;

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
	public void AddToCart(String us, String pwd, String cn, String em, String ey, String cvCode) throws InterruptedException, IOException {
		antipy.click();
		cart.click();
		Thread.sleep(2000);
		email.sendKeys(us);
		password.sendKeys(pwd);
		loginButton.click();
		Thread.sleep(2000);
		Checkout.click();
		Thread.sleep(2000);
		select.click();
		card.sendKeys(cn);
		expM.sendKeys(em);
		expY.sendKeys(ey);
		cv.sendKeys(cvCode);
		Pay.click();
		Thread.sleep(2000);
		System.out.println(order.getText());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\Arjun Sharma\\eclipse-workspace\\com.capstone\\src\\test\\java\\com\\capstone\\screenshots\\addtocart.png"));
		
	}
	
	
}
