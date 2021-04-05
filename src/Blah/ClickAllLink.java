package Blah;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;

public class ClickAllLink {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kumarikh\\\\OneDrive - VMware, Inc\\\\VMwareCorp\\\\Desktop\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());;
		WebElement footerdriver =driver.findElement(By.id("gf-BIG"));
		int footerLink=footerdriver.findElements(By.tagName("a")).size();
		System.out.println(footerLink);
		WebElement firstColumn= driver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]"));
		System.out.println(firstColumn.findElements(By.tagName("a")).size());
		
		for (int i = 1; i < firstColumn.findElements(By.tagName("a")).size(); i++) {
			
			 String s = Keys.chord(Keys.CONTROL, Keys.ENTER);
			 firstColumn.findElements(By.tagName("a")).get(i).sendKeys(s);
		}
		
		String parent=driver.getWindowHandle();
		
		Set<String> AllWin = driver.getWindowHandles();
		for (String title : AllWin) {
			System.out.println(driver.switchTo().window(title).getTitle());
		}
	}

}
