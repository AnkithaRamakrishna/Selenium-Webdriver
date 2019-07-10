package newPackage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadingExceldata {

	public static void main(String[] args) throws IOException,InterruptedException,Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32/chromedriver.exe");					
		WebDriver driver = new ChromeDriver();		
		String baseurl="https://www.facebook.com/";
		String expectedtitle = "Log into Facebook | Facebook";


		driver.get(baseurl);

		//Open MyDataSheet.xls file from given location. 
		FileInputStream fileinput = new FileInputStream("C:\\Users\\Akshay\\Documents\\MyLoginDataFile.xlsx");

		//Access first data sheet. getSheet(0) describes first sheet.
		XSSFWorkbook workbook = new XSSFWorkbook(fileinput);
		XSSFSheet sheet = workbook.getSheetAt(0);

		//Read data from the first data sheet of xls file and store it in array.
		//String TestData[][] = row().getCell();
		int rowCount = sheet.getLastRowNum();

		//Type data in first name and last name text box from array.
		for(int i=0;i<=rowCount;i++)
		{
			Row row = sheet.getRow(i);
			for (int j=0;j<=1;j++)
			{
				String TestData = row.getCell(j).getStringCellValue();
				if(j==0)
				{
					driver.findElement(By.name("email")).sendKeys(TestData);
				}

				else 
				{
					driver.findElement(By.name("pass")).sendKeys(TestData);
					driver.findElement(By.id("loginbutton")).click();
					Thread.sleep(5000);
					String actualtitle = driver.getTitle();
					System.out.println("actualtitle" + driver.getTitle());
					
					if(!actualtitle.equals(expectedtitle))
					{
						//Select dropdown = new Select(driver.findElement(By.id("logoutMenu")));
						//dropdown.selectByVisibleText("Log Out");
						//driver.findElement(By.xpath("//div[contains(@id,'userNavigationLabel')]")).click();
						//Thread.sleep(1000);

						driver.findElement(By.xpath("//div[contains(@id,'userNavigationLabel')]")).click();
						Thread.sleep(5000);

						WebElement logOut = driver.findElement(By.xpath("//span[contains(text(),'Log Out')]"));
						logOut.click();
						
						//Thread.sleep(5000);    	 
					}
					
				}

			}
			int j=0;
			driver.get(baseurl);
			Thread.sleep(1000);
			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("pass")).clear();
		}
		Thread.sleep(1000);
	}
}
