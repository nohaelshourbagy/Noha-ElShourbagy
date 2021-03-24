

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Facebook {

	public static void main(String[]args) throws Exception {

	}


	public static WebDriver openFacebook() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.facebook.com/");

		return driver;
	}


	public static Workbook loadExcelFile(WebDriver driver, String filePath) throws BiffException, IOException
	{


		File src = new File(filePath);


		System.out.println("Excel Located");

		Workbook wb = Workbook.getWorkbook(src);

		System.out.println("Workbook Loaded");
		return wb;
	}

}














