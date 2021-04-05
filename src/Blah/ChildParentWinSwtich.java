package Blah;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChildParentWinSwtich {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kumarikh\\OneDrive - VMware, Inc\\VMwareCorp\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/");
		ChildParentWinSwtich obj = new ChildParentWinSwtich();
		//obj.nestedframe(driver);
	}
	
	public void login(WebDriver driver) {
		driver.findElement(By.xpath("//a[text()=\"Free Access to InterviewQues/ResumeAssistance/Material\"]")).click();
		String parent = driver.getWindowHandle();
		Set<String> all = driver.getWindowHandles();
		for (String string : all) {
			if(!(string.contains(parent))) {
				driver.switchTo().window(string);
				System.out.println("pass");
			}
		}
		WebElement emailID = driver.findElement(By.xpath("//a[text()=\"mentor@rahulshettyacademy.com\"]"));
		//WebDriverWait wait = new WebDriverWait(driver, 8);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()=\"mentor@rahulshettyacademy.com\"]")));
		String Email = emailID.getText();
		System.out.println(Email);
		driver.switchTo().parentFrame();
	}
	
	public void childWin(WebDriver driver) {
		String parent  = driver.getWindowHandle();
		System.out.println(parent);
		driver.findElement(By.xpath("//a[text()=\"Multiple Windows\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Click Here\"]")).click();
		Set<String> allWin =driver.getWindowHandles();
		for (String string : allWin) {
			if(!(string.contains(parent))) {
				driver.switchTo().window(string);
			}
		}
		String Newin = driver.findElement(By.xpath("//div/h3[contains(text(),'New Window')]")).getText();
		System.out.println(Newin);
		
		driver.switchTo().window(parent);
		String Newin1 = driver.findElement(By.xpath("//div/h3[contains(text(), 'Opening a new window')]")).getText();
		System.out.println(Newin1);
	}
	
	public void nestedframe(WebDriver driver) {
		driver.findElement(By.xpath("//a[text()=\"Nested Frames\"]")).click();
		WebElement frame = driver.findElement(By.xpath("//frame[@name=\"frame-bottom\"]"));
		driver.switchTo().frame(frame);
		String getText = driver.findElement(By.xpath("//body[@data-new-gr-c-s-check-loaded='14.1001.0'] [contains(., 'BOTTOM')]")).getText();
		System.out.println(getText);
	}

}