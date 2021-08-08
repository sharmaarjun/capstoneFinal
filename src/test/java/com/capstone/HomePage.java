package com.capstone;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;

public class HomePage {

	WebDriver driver;
	@BeforeClass
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arjun Sharma\\eclipse-workspace\\com.capstone\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}

	@Test
	public void homeLinks() throws InterruptedException {
		driver.get("http://localhost:5555/medicare/home");
		System.out.println("Medicare Project Started");
		Locators lc = new Locators(driver);
		lc.Home();
		Thread.sleep(5000);
	}
	
	@Test
	public void Login()throws InterruptedException{
		driver.get("http://localhost:5555/medicare/login");
		System.out.println("Login Flow");
		Locators lc = new Locators(driver);
		lc.Login("kn@gmail.com", "12345");
		Thread.sleep(3000);
	}
	
	@Test
	public void AddToCart() throws InterruptedException, IOException {
		driver.get("http://localhost:5555/medicare/home");
		System.out.println("Add To Cart Flow");
		Locators lc =new Locators(driver);
		lc.AddToCart("kn@gmail.com", "12345", "4242424242424242", "11", "22", "125");
		System.out.println("Screenshot Added");
		
	}


	@AfterClass
	public void exit() {
		driver.quit();
	}

}
