package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageReservation {
	
	private WebDriver driver;
	
	private By titleText;
	private By passengersDrop;
	private By fromDrop;
	private By toDrop;
	
	public PageReservation(WebDriver driver) {
		this.driver = driver;
		titleText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");
		passengersDrop = By.name("passCount");
		fromDrop = By.name("fromPort");
		toDrop = By.name("toPort");
	}

	public void assertPage() {
		Assert.assertTrue(driver.findElement(titleText).getText().contains("Flight Finder to search"));
	}
	
	public void selectPassengers(int quantity) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement quantityPassengers = wait.until(ExpectedConditions.presenceOfElementLocated(passengersDrop));
		Select selectPassengers = new Select(quantityPassengers);
		selectPassengers.selectByVisibleText(Integer.toString(quantity));
	}
	
	public void selectFromPort(int index) {
		Select selectFrom = new Select(driver.findElement(fromDrop));
		selectFrom.selectByIndex(index);
	}
	
	public void selectToPort(String city) {
		Select selectArriving = new Select(driver.findElement(toDrop));
		selectArriving.selectByValue(city);
	}
}
