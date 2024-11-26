package recruit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class FitPeoDemo {
static WebDriver driver;
	@Test
	public void test1() {
	    WebDriverManager.chromedriver().setup();
	    //Open the web browser and navigate to FitPeo Homepage.
		driver = new ChromeDriver();
		driver.get("https://www.fitpeo.com/home");
		driver.manage().window().maximize();
	}


	@Test
	public void test2(){
		try {
			//navigate to the Revenue Calculator Page.
			driver.navigate().to("https://fitpeo.com/revenue-calculator");
			//Locating the slider
			WebElement slider=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/span[1]/span[3]/input"));	
			//Locating the textBox
			WebElement textBox=driver.findElement(By.xpath("//*[@id=\":R57alklff9da:\"]"));
	

			//Scroll down to the slider section
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", textBox);
	
			//Get current value of the slider
			int currentValue=Integer.valueOf(slider.getAttribute("value"));
			System.out.println("Slider: "+currentValue);
	
			//Adjust the slider to set its value to 820
	        for (int i = 0; i < (820-currentValue); i++) {
	            slider.sendKeys(Keys.ARROW_RIGHT);
	
	        }
	
			//Get current textBoxValue 
			int textBoxValue=Integer.valueOf(textBox.getAttribute("value"));
			//Assert whether textBoxValue is updated
			Assert.assertEquals(textBoxValue, 820);	
			System.out.println("TextBox: "+textBox.getAttribute("value"));
			
			//Clear the textBox
			int length=textBox.getAttribute("value").length();
			for(int i=length;i>0;i--) {
				textBox.sendKeys(Keys.BACK_SPACE);
			}
			
			//send 560 through text box
			textBox.sendKeys("560");
			int textBoxValueAfter=Integer.valueOf(textBox.getAttribute("value"));
			System.out.println("TextBoxAfter: "+textBoxValueAfter);
			
			//Assert whether slider is updated
			int currentValueAfter560=Integer.valueOf(slider.getAttribute("value"));
			Assert.assertEquals(currentValueAfter560, 560);	
			System.out.println("currentValueAfter560:"+currentValueAfter560);
			
			
			//clear the text box
			for(int i=textBox.getAttribute("value").length();i>0;i--) {
				textBox.sendKeys(Keys.BACK_SPACE);
			}
			
			//send 820 through text box
			textBox.sendKeys("820");
			//Locating the check boxes for given CPT
			WebElement checbox99091=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/label/span[1]/input"));
			WebElement checbox99453=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/label/span[1]/input"));
			WebElement checbox99454=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/label/span[1]/input"));
			WebElement checbox99474=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[8]/label/span[1]/input"));
			
			//Select the check boxes for given CPT
			checbox99091.click();
			checbox99453.click();
			checbox99454.click();
			checbox99474.click();
			
			//Locating Total Recurring Reimbursement for all Patients Per Month
			WebElement totalRRPperMonth=driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/p[4]/p"));
			String totalRRPperMonthValue=totalRRPperMonth.getText();
			Assert.assertEquals(totalRRPperMonthValue, "$110700");	
			System.out.println("totalRRPperMonthValue: "+totalRRPperMonthValue);
			driver.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}




}
