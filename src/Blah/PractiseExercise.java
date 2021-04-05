package Blah;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PractiseExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\kumarikh\\\\OneDrive - VMware, Inc\\\\VMwareCorp\\\\Desktop\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption2")).click();
		WebElement dropDownSelect = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/fieldset/label[2]"));
		String optionText = dropDownSelect.getAttribute("textContent");
		String dropDownText = optionText.replaceAll("\\s", "");

		System.out.println(dropDownText);

		driver.findElement(By.id("dropdown-class-example")).click();
		driver.findElement(By.xpath("//option[contains(text(), '" + dropDownText + "')]")).click();
		
		// Enter lable into editbox
		
		
	}

}
