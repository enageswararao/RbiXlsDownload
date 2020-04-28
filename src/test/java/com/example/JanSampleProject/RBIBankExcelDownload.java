package com.example.JanSampleProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.OperatingSystem;
import io.github.bonigarcia.wdm.WebDriverManager;


import java.io.File;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;

public class RBIBankExcelDownload {
  WebDriver driver=null;

  @BeforeTest
  public static void deleteAllXLSFiles() {
     try {
       File file = new File("/home/ramesh/Nageswar/IFSCBankXLSFile");
       String[] myFiles;
       if (file.isDirectory()) {
         myFiles = file.list();
         for (int i = 0; i < myFiles.length; i++) {
           File myFile = new File(file, myFiles[i]);
           myFile.delete();
         }
       }
     }
    catch(Exception e)   {}
  }

 @Test
   public void downloadXLSfromRBISite() throws InterruptedException {
    String downloadFilepath = "/home/ramesh/Nageswar/IFSCBankXLSFile";
    Map<String, Object> preferences = new Hashtable<String, Object>();
    preferences.put("download.default_directory", downloadFilepath);
    ChromeOptions options = new ChromeOptions();
    options.setExperimentalOption("prefs", preferences);
    //String path = System.getProperty("user.dir")+ File.separator + "drivers"+File.separator + "chromedriver";
     System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
 //  System.setProperty("webdriver.chrome.driver",path);
    driver=new ChromeDriver(options);
     
    driver.get("https://m.rbi.org.in/Scripts/bs_viewcontent.aspx?Id=2009");
    List<WebElement> urlEments=driver.findElements(By.xpath("//div[@id='example-min']/div/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a"));
    for(int i=0;i<2;i++){
      Thread.sleep(5000);
      urlEments.get(i).click();
         }

  }
  @AfterTest
  public void closeBr(){
    driver.close();
  }

}
