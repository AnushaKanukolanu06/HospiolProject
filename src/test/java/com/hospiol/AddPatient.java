package com.hospiol;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddPatient {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://testing.hospiol.com/site/login");
		driver.findElement(By.name("username")).sendKeys("sampath.marolix@gmail.com");
		driver.findElement(By.name("password")).sendKeys("sampath@777");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text()='Appointment']")).click();
		driver.findElement(By.xpath("//a[@data-target='#myModal']")).click();
		driver.findElement(By.id("add")).click();
		driver.findElement(By.name("name")).sendKeys("Anusha");
		driver.findElement(By.name("guardian_name")).sendKeys("Krishna");
		driver.findElement(By.name("gender")).sendKeys("Female");
		driver.findElement(By.name("dob")).sendKeys("06-08-1997");
		driver.findElement(By.name("blood_group")).sendKeys("B+");
		driver.findElement(By.name("marital_status")).sendKeys("single");
	//	driver.findElement(By.name("file")).sendKeys("C:\\Users\\admin\\Downloads.JPEG");
		WebElement image=driver.findElement(By.name("file"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",image);
		Robot rb = new Robot(); 
		rb.delay(1000);
		StringSelection ss = new StringSelection("C:\\Users\\admin\\Downloads\\patient");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);  
		rb.keyPress(KeyEvent.VK_CONTROL); 
		 rb.keyPress(KeyEvent.VK_V);
		 rb.keyRelease(KeyEvent.VK_CONTROL);  
		 rb.keyRelease(KeyEvent.VK_V);
		 rb.keyPress(KeyEvent.VK_ENTER);      
		 rb.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.name("mobileno")).sendKeys("7893611237");
		driver.findElement(By.id("addformemail")).sendKeys("anusha06.marolix@gmail.com");
		driver.findElement(By.name("address")).sendKeys("hyd");
		
	}
 
}
