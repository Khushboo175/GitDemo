package Blah;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCart {

	public static void main(String[] args) throws InterruptedException {

		String[] productToCart = { "Cucumber", "Beetroot", "Apple" };

		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\kumarikh\\\\OneDrive - VMware, Inc\\\\VMwareCorp\\\\Desktop\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");
		AddCart obj = new AddCart();
		//obj.ExplicitWait(driver);
	}

	public void addToCart(WebDriver driver, String[] productToCart) {
		int j = productToCart.length;

		List<WebElement> Products = driver.findElements(By.cssSelector("h4.product-name"));
		List al = Arrays.asList(productToCart);
		for (WebElement singleProduct : Products) {

			String[] name = singleProduct.getText().split("-");
			if (al.contains(name[0].trim())) {
				System.out.println(name[0] + singleProduct);
				driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
			}
		}

		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()=\"PROCEED TO CHECKOUT\"]")).click();
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[text()=\"Apply\"]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("By.cssSelector(\"span.promoInfo\"")));
		String validate = driver.findElement(By.cssSelector("span.promoInfo")).getText();
		if (validate.contains("Code applied")) {
			System.out.println("passed");
		}
	}
	
	public void ExplicitWait(WebDriver driver) {
		driver.findElement(By.xpath("//a[text()=\"Click to load get data via Ajax!\"]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"results\"]"), "Process completed! This response has been loaded via the Ajax request directly from the web server, without reoading this page."));
		String s = driver.findElement(By.xpath("//*[@id=\"results\"]")).getText();
		if(s.contains("Process completed! This response has been loaded via the Ajax request directly from the web server, without reoading this page.")) {
			System.out.println("passed");
		}
		
	}
}
