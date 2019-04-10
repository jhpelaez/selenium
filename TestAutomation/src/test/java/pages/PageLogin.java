package pages;

import static helpers.Helpers.sleepSeconds;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLogin {
	
	private WebDriver driver;
	
	private By userField;
	private By passwordField;
	private By loginButton;
	
	public PageLogin(WebDriver driver) {
		this.driver = driver;
		userField = By.name("userName");
		passwordField = By.name("password");
		loginButton = By.name("login");
	}
	
	public void login(String user, String password) {
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		sleepSeconds(4);
	}

}
