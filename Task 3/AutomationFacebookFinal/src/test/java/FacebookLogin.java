import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import jxl.Workbook;
import jxl.read.biff.BiffException;

public class FacebookLogin extends Facebook {


	public static void main(String[]args) throws Exception {
		//facebookLogin();

		//facebookEncryptedPsswrdTest();


		int testCaseNum=3;
		if(testCaseNum==1) {
			facebookLogin();
		}
		else if(testCaseNum==2) {
			facebookEncryptedPsswrdTest();
		}

		else if(testCaseNum==3) {
			caseSensitivePassTest();
		}


	}


	// logs in to facebook using an excel file with  possible inputs
	public static void facebookLogin() throws Exception {

		WebDriver driver = openFacebook();
		/*Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.facebook.com/");
		 */
		try {

			Workbook wb =loadExcelFile(driver, "/Users/mac/Desktop/TestDataFinal9.xls");

			int rowCount = wb.getSheet(0).getRows();
			System.out.println(rowCount);

			for(int i=1;i<rowCount; i++) {


				String username = wb.getSheet(0).getCell(0, i).getContents();
				String password = wb.getSheet(0).getCell(1, i).getContents();
				String expectedOutput = wb.getSheet(0).getCell(2,i).getContents();




				driver.findElement(By.id("email")).clear();
				WebElement textbox = driver.findElement(By.id("email"));  //storing the email element in the textbox variable//
				textbox.sendKeys(username);

				driver.findElement(By.name("pass")).clear();
				WebElement pssword = driver.findElement(By.name("pass")); 
				pssword.sendKeys(password);

				WebElement submit = driver.findElement(By.xpath("//button[@name='login']"));
				submit.click();	

				Thread.sleep(5000);
				if(driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/?sk=welcome")) {
					System.out.println("Login Successfull!");
					Assert.assertEquals(expectedOutput, "valid");
					Thread.sleep(5000);

				}
				else {
					System.out.println("Login Failed");
					Assert.assertEquals(expectedOutput, "invalid");

					Thread.sleep(3000);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{

			driver.close();
			driver.quit();
		}

	}


	//Verifies that the password field is encrypted in the login

	public static void facebookEncryptedPsswrdTest() throws BiffException, IOException, InterruptedException
	{


		WebDriver driver = openFacebook();

		driver.findElement(By.id("email")).clear();
		WebElement textbox = driver.findElement(By.id("email"));  //storing the email element in the textbox variable//
		textbox.sendKeys("Username@gmail.com");

		driver.findElement(By.name("pass")).clear();
		WebElement pssword = driver.findElement(By.name("pass")); 
		pssword.sendKeys("Password");

		String passType = pssword.getAttribute("type");
		if(passType.equals("password")) {
			System.out.println("The Password is Encrypted.Test Passed!");
		}
		else {
			System.out.println("The Password is not Encrypted. Test Failed");
		}
		Thread.sleep(4000);

		driver.close();
		driver.quit();
	}



	//Verify that if the password is case sensitive, Facebook won't accept a non case sensitive password	

	public static void caseSensitivePassTest() throws BiffException, IOException, Exception {

		WebDriver driver= openFacebook();
		Workbook wb = loadExcelFile(driver,"/Users/mac/Desktop/TestData6.xls");
		int rowCount= wb.getSheet(0).getRows();

		for(int i=0;i<rowCount; i++) {


			String username = wb.getSheet(0).getCell(0, i).getContents();
			String password = wb.getSheet(0).getCell(1, i).getContents();



			driver.findElement(By.id("email")).clear();
			WebElement textbox = driver.findElement(By.id("email"));  //storing the email element in the textbox variable//
			textbox.sendKeys(username);

			driver.findElement(By.name("pass")).clear();
			WebElement pssword = driver.findElement(By.name("pass")); 
			pssword.sendKeys(password);

			WebElement submit = driver.findElement(By.xpath("//button[@name='login']"));
			submit.click();	
			Thread.sleep(3000);

			if(driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/?sk=welcome")) {
				System.out.println("Test Case Failed");
				Thread.sleep(5000);

			}
			else {
				System.out.println("A validation message is displayed that the password is incorrect!");
				System.out.println("Test Case Passed");
				Thread.sleep(3000);
			}
			driver.close();
			driver.quit();
		}

	}


}
