import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import jxl.Workbook;
import jxl.read.biff.BiffException;

public class FacebookRegistration extends Facebook {

	public static void main(String[]args) throws BiffException, IOException, InterruptedException {
		facebookRegister();

	}

	public static void facebookRegister() throws BiffException, IOException, InterruptedException {

		WebDriver driver = openFacebook();
		Workbook wb =loadExcelFile(driver, "/Users/mac/Desktop/RegisterFinalTry2.xls");
		int rowCount = wb.getSheet(0).getRows();
		System.out.println(rowCount);



		WebElement registerBttn= driver.findElement(By.xpath("//*[text()='Create New Account']"));
		registerBttn.click();
		Thread.sleep(3000);

		for(int i=1;i<rowCount;i++) {



			String frstname = wb.getSheet(0).getCell(0, i).getContents();
			String lstname = wb.getSheet(0).getCell(1, i).getContents();
			String email = wb.getSheet(0).getCell(2, i).getContents();
			Thread.sleep(2000);
			String confirmEmail = wb.getSheet(0).getCell(3, i).getContents();
			String newPass = wb.getSheet(0).getCell(4, i).getContents();

			String dayOfBirth = wb.getSheet(0).getCell(5, i).getContents();
			String mnth = wb.getSheet(0).getCell(6, i).getContents();
			String yr = wb.getSheet(0).getCell(7, i).getContents();
			String gender = wb.getSheet(0).getCell(8, i).getContents();
			String expectedOutput = wb.getSheet(0).getCell(9,i).getContents();

			driver.findElement(By.name("firstname")).clear();
			driver.findElement(By.name("firstname")).sendKeys(frstname);
			Thread.sleep(1000);
			driver.findElement(By.name("lastname")).clear();
			driver.findElement(By.name("lastname")).sendKeys(lstname);
			Thread.sleep(1000);
			driver.findElement(By.name("reg_email__")).clear();
			driver.findElement(By.name("reg_email__")).sendKeys(email);
			Thread.sleep(2000);
			driver.findElement(By.name("reg_email_confirmation__")).clear();
			driver.findElement(By.name("reg_email_confirmation__")).sendKeys(confirmEmail);
			Thread.sleep(1000);
			driver.findElement(By.name("reg_passwd__")).clear();
			driver.findElement(By.name("reg_passwd__")).sendKeys(newPass);


			Select drpDate = new Select(driver.findElement(By.name("birthday_day")));

			drpDate.selectByValue(dayOfBirth);
			Thread.sleep(1000);
			Select month = new Select(driver.findElement(By.name("birthday_month")));
			month.selectByValue(mnth);
			Thread.sleep(1000);

			Select year = new Select(driver.findElement(By.name("birthday_year")));
			year.selectByValue(yr);
			Thread.sleep(1000);


			if(gender.equals("Female")) {
				driver.findElements(By.name("sex")).get(0).click();
				Thread.sleep(1000);

			}
			else {

				driver.findElements(By.name("sex")).get(1).click();
				Thread.sleep(1000);


			}
			driver.findElement(By.name("websubmit")).click();
			Thread.sleep(8000);
			
			if(i==8) {
				Thread.sleep(4000);
			}
			
			//validate that confirm email page is opened
			if(driver.getCurrentUrl().contains("confirmemail.php?")) {
				System.out.println("The Account is  Registered Successfully");
				Assert.assertEquals(expectedOutput, "Succeeded");
			}



			else {
				System.out.println("Registration Failed!");
				Assert.assertEquals(expectedOutput, "Failed");
			}


		}
		Thread.sleep(5000);
		driver.quit();

	}

}
