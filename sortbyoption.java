package newPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class sortbyoption {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String baseurl = "http://live.guru99.com/index.php/";
		
		
		driver.get(baseurl);
		String pageTitle = driver.getTitle();
		System.out.println("PAGETITLE" + pageTitle);
		
		driver.findElement(By.className("level0")).click();
		String pageTitle1 = driver.getTitle();
		System.out.println("PAGETITLE" + pageTitle1);
		
		 Select sortbydropdown = new Select(driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")));
		 sortbydropdown.selectByVisibleText("Name");
				
	}
}
