package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Saucelab {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();
	}
//@Test
public void Login() {
	
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();

	 String expectedTitle = "Swag Labs";
     String actualTitle = "";

      actualTitle = driver.getTitle();

   
     if (actualTitle.contentEquals(expectedTitle)){
         System.out.println("Test Passed!");
     } else {
         System.out.println("Test Failed");
     }
    
    	
}
@Test(dataProvider="credentials")
public void  inputvalidations(String conditions,String username,String password) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.id("user-name")).sendKeys(username);
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
	driver.findElement(By.id("login-button")).click();
	
	
	if(conditions.equals("bothcorrect")) {
		WebElement account=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
		Assert.assertTrue(account.isDisplayed());
	}
	else if(conditions.equals("bothincorrect")){
		String errorMessage=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
		Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
	
	}
	
	else if(conditions.equals("incorrectusername")){
		String errorMessage=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
		Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
	
	}
	else if(conditions.equals("incorrectpassword")){
		String errorMessage=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
		Assert.assertEquals(errorMessage,"Epic sadface: Username and password do not match any user in this service");
}
	else if(conditions.equals("differentusername")){
		WebElement account=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
		Assert.assertTrue(account.isDisplayed());
	}}

@DataProvider(name="credentials")
public Object[][] getData() {
	
return new Object[][] {
	{"bothcorrect","standard_user","secret_sauce"},
	{"bothincorrect","user","user"},
	{"incorrectusername","standard","secret_sauce"},
	{"incorrectpassword","standard_user","secret"},
	{"differentusername","problem_user","secret_sauce"},
};
}

//@Test
public void addtocart() throws InterruptedException {
driver.findElement(By.id("user-name")).sendKeys("standard_user");
driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
driver.findElement(By.id("login-button")).click();

Select a=new Select(driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select")));
a.selectByVisibleText("Price (low to high)");

WebElement element1=driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
WebElement element2=driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]"));
WebElement element3=driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]"));

WebElement element4=driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]"));
WebElement element5=driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]"));
WebElement element6=driver.findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]"));

Actions action=new Actions(driver);
Action seriesOfActions = (Action) action.keyDown(Keys.CONTROL)
        .click(element1)
        .click(element2)
        .click(element3)
        .click(element4)
        .click(element5)
        .click(element6)
        .build();
seriesOfActions.perform();
Thread.sleep(3000);


  driver.findElement(By.id("checkout")).click(); Thread.sleep(1000);
  driver.findElement(By.id("first-name")).sendKeys("bini");
  driver.findElement(By.id("last-name")).sendKeys("b");
  driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("695584");
  
  driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
  
  driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
  driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
  Thread.sleep(1000);
  driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();
 
 
}}
