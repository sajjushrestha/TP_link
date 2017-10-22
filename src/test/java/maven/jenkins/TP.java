package maven.jenkins;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TP {

	
	@Test
	public void Launch()    //2 commit
	
	
	{
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		
		options.addArguments("--headless");
		
		
		WebDriver driver=new ChromeDriver(options);
		
		
		driver.manage().window().maximize();
		
		driver.get("http://192.168.1.1");
		
		WebDriverWait wait=new WebDriverWait(driver,3000);
		
		driver.findElement(By.id("userName")).sendKeys("mybujji");
		
		driver.findElement(By.id("pcPassword")).sendKeys("bujji@0224");
		
		driver.findElement(By.id("loginBtn")).click();
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("bottomLeftFrame")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Bandwidth Control']"))).click();
		
		driver.switchTo().defaultContent();
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("mainFrame")));
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("down_bandWidth"))).clear();
		
		String input = "2048" ;//JOptionPane.showInputDialog("Enter  download speed");
	
		
		driver.findElement(By.name("down_bandWidth")).sendKeys(input);
		
		WebElement check=driver.findElement(By.name("QoSCtrl"));
		if(!(check.isSelected()))
		{
			check.click();
		}
		else {
			
		}
		
		driver.findElement(By.name("Save")).click();
		
	}
	
	
	
	
}
