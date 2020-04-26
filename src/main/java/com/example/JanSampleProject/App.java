package com.example.JanSampleProject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
	
	WebDriver driver;
	
	public  void setup() throws InterruptedException {
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\ammulu123\\Jan2020\\JanSampleProject\\drivers\\chromedriver.exe");

     // Setting new download directory path
     Map<String, Object> prefs = new HashMap<String, Object>();
      
     // Use File.separator as it will work on any OS
     prefs.put("download.default_directory",
             System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
      
     // Adding cpabilities to ChromeOptions
     ChromeOptions options = new ChromeOptions();
     options.setExperimentalOption("prefs", prefs);
      
     // Printing set download directory
     System.out.println(options.getExperimentalOption("prefs"));
      
     // Launching browser with desired capabilities
       driver= new ChromeDriver(options);
	 
	 
	 
	 driver.get("https://www.rbi.org.in/Scripts/bs_viewContent.aspx?id=2009");
	 
	 driver.manage().window().maximize();
	 
	
	//*[@id="example-min"]/div/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/a
	 
	 int listofbanks=driver.findElements(By.xpath("//*[@id='example-min']/div/table/tbody/tr[2]/td/table/tbody/tr")).size();
	 System.out.println("Size.............."+listofbanks);
	 
	 for(int i=1;i<=listofbanks;i++) {
		 
		
		 System.out.println("Bank sequence number in for loop -"+i);
		WebElement element =driver.findElement(By.xpath("//*[@id=\"example-min\"]/div/table/tbody/tr[2]/td/table/tbody/tr["+i+"]/td[2]/a"));
		
		 System.out.println("Bank name ----"+ element .getText());
		 try {
		 element.click();
		 driver.get("https://www.rbi.org.in/Scripts/bs_viewContent.aspx?id=2009");

		 }
		 catch (Exception e) {
			// driver.get("https://www.rbi.org.in/Scripts/bs_viewContent.aspx?id=2009");

		 }
 		}
 		 
	 
	 driver.close();
	
	}

  public static void main(String[] args) throws InterruptedException {
    System.out.println("Hello World!");
    new App().setup();
  }

}
