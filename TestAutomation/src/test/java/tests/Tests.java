package tests;

import static helpers.Helpers.sleepSeconds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import pages.PageLogin;
import pages.PageLogon;
import pages.PageReservation;

public class Tests {
	
	private static final String URL = "http://newtours.demoaut.com/";
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(URL);
		
	}
	
	//@Test
	public void pruebaUno() {
		PageLogin login = new PageLogin(driver);
		PageLogon logon = new PageLogon(driver);
		login.login("user", "user");
		logon.assertLogonPage();
	}
	
	//@Test
	public void pruebaDos() {
		PageLogin login = new PageLogin(driver);
		PageReservation pageReservation = new PageReservation(driver);
		login.login("mercury", "mercury");
		pageReservation.assertPage();
	}
	
	@Test
	public void pruebaTres() {
		PageLogin login = new PageLogin(driver);
		PageReservation pageReservation = new PageReservation(driver);
		login.login("mercury", "mercury");
		pageReservation.selectPassengers(2);
		pageReservation.selectFromPort(3);
		pageReservation.selectToPort("London");
		Helpers.sleepSeconds(4);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
