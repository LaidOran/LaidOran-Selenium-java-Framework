package AploadFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class AploadFileAutoIt {

	public static void main(String[] args) throws InterruptedException, IOException {
		String downloadPath=System.getProperty("user.dir");
		HashMap chromePrefs = new HashMap(); 
		chromePrefs.put("profile.default_content_settings.popups", 0); 
		chromePrefs.put("download.default_directory", downloadPath); 
		ChromeOptions options=new ChromeOptions(); 
		options.setExperimentalOption("prefs", chromePrefs); 
		WebDriver driver = new ChromeDriver(options);
        //driver.get("https://www.sodapdf.com/fr/pdf-en-jpg/");
        driver.get("https://www.ilovepdf.com/fr"); 
        driver.manage().window().maximize();
        //driver.findElement(By.xpath("//label[@class='btn-choose']")).click();
        driver.findElement(By.xpath("//h3[text()='PDF en JPG']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Sélectionner les fichiers PDF']")).click();
		Thread.sleep(3000);
        Runtime.getRuntime().exec("C:\\Users\\Fodil\\OneDrive - Levio\\Levio\\AutoIt\\FileApload.exe");
        WebDriverWait wait=new WebDriverWait(driver,10); 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='processTask']")));
        driver.findElement(By.xpath("//button[@id='processTask']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='pickfiles']")));
        Thread.sleep(5000); 
        File f=new File(downloadPath+"/ilovepdf_pages-to-jpg.zip"); 
        if(f.exists()) 
        { 
        	Assert.assertTrue(f.exists()); 
        	//f.delete(); 
        	
        	} 
        } 
}




