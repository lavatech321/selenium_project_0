package www.lavatech.com;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {

	WebDriver driver;
	
	@BeforeTest
	public void connectSite() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/");
	}
	
	@Test(priority=0)
	public void logIn() throws InterruptedException {
		WebElement username = driver.findElement(By.name("user-name"));
		username.sendKeys("standard_user");
		Thread.sleep(1000);
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("secret_sauce");
		Thread.sleep(1000);
		
		WebElement login = driver.findElement(By.id("login-button"));
		login.click();
		Thread.sleep(1000);
	}
	
	@Test(priority=1)
	public void addCart() throws InterruptedException {
		Thread.sleep(3000);
		WebElement add_cart1 = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/button[1]"));
		add_cart1.click();
		Thread.sleep(1000);
		
		WebElement add_cart2 = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/button[1]"));
		add_cart2.click();
		Thread.sleep(2000);
	}
	
	@Test(priority=2)
	public void placeOrder() throws InterruptedException {
		driver.get("https://www.saucedemo.com/v1/cart.html");
		Thread.sleep(1000);
		
		WebElement checkout = driver.findElement(By.linkText("CHECKOUT"));
		checkout.click();
		Thread.sleep(1000);
		
		WebElement first_name = driver.findElement(By.id("first-name"));
		first_name.sendKeys("Dummy");
		Thread.sleep(1000);
		
		WebElement last_name = driver.findElement(By.id("last-name"));
		last_name.sendKeys("User");
		Thread.sleep(1000);
		
		WebElement postal_code = driver.findElement(By.id("postal-code"));
		postal_code.sendKeys("4231");
		Thread.sleep(1000);
		
		WebElement cont_btn = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[3]/div[1]/form[1]/div[2]/input[1]"));
		cont_btn.click();
		Thread.sleep(2000);
		
		WebElement finish_btn = driver.findElement(By.linkText("FINISH"));
		finish_btn.click();
		Thread.sleep(2000);
	}

	@AfterTest
	public void closeSite() {
		driver.quit();
	}

	
}
