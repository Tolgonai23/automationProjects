package automationProjects;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

  public class ProjectTask {
	  static WebDriver driver;
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
@Test
	public void testOrder() throws InterruptedException {
		driver.get("http://secure.smartbearsoftware.com");	
		 Thread.sleep(3000);
			Random random=new Random();
			 Faker faker = new Faker();
			driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		WebElement username =driver.findElement(By.name("ctl00$MainContent$username"));
		username.sendKeys("Tester");
		WebElement password =driver.findElement(By.name("ctl00$MainContent$password"));
		password.sendKeys("test");
		WebElement login =driver.findElement(By.name("ctl00$MainContent$login_button"));
		login.click();
		WebElement orderButton =driver.findElement(By.linkText("Order"));
		orderButton.click();
		WebElement quantityButton =driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity"));
		int r = random.nextInt(100);
		quantityButton.sendKeys(""+random.nextInt(100));
		WebElement name =driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName"));
		 String fullname = faker.name().fullName();
		name.sendKeys(fullname);
		WebElement street =driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2"));
		 String street1 = faker.address().streetAddress();
		street.sendKeys(street1);
		WebElement city =driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3"));
		 String city1= faker.address().city();
		city.sendKeys(city1);
		WebElement state =driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4"));
		 String state1= faker.address().state();
		state.sendKeys(state1);
		WebElement zipcode =driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5"));
		 String zipcode1= faker.address().zipCode();
		//zipcode.sendKeys(zipcode1);
		zipcode.sendKeys(""+random.nextInt((90000)+10000));
		
		int card = random.nextInt(3);
		if (card ==0) {
			WebElement credittypeVisa =driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
			credittypeVisa.click();
		WebElement creditcardVisa =driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6"));
		 creditcardVisa.sendKeys("4444555566667777");
		}
		if (card ==1) {
			WebElement credittypeMaster =driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1"));
			credittypeMaster.click();
		WebElement creditcardMaster =driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6"));
		 creditcardMaster.sendKeys("5555000066667777");
		}
		if (card ==2) {
			WebElement credittypeAMEX =driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2"));
			credittypeAMEX.click();
		WebElement creditcardAMEX =driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6"));
		 creditcardAMEX.sendKeys("333344445555666");
		}
		WebElement date = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1"));
		date.sendKeys("01/21");
		WebElement process = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
		process.click();
		
	}
	
	}

