package com.page;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GmailLogin {

	WebDriver driver;
	public static config chromepath;
	public Excelsheet excl;
	public String username;
	public String password;
	public String url;
	public String Testflag;
	public void GmailLogin(String TestFlag,String url,String username,String password) throws InterruptedException, IOException {
					
		chromepath =new config();
		config excelpath=new config();
		excl=new Excelsheet(excelpath.excelpath());
		int rowcount=excl.rowcount(0);		
		for(int i=1;i<rowcount;i++) {
			Testflag=excl.Testflag(0, i, 0);
			url =excl.Testurl(0, i, 1);
			username = excl.username1(0, i, 2);	
			password = excl.password1(0, i, 3);	
			System.setProperty("webdriver.chrome.driver",chromepath.chormepath());
			driver =new ChromeDriver();
			driver.get(url);
				if(Testflag.contains("Gmail")) {						
				driver.findElement(By.name("identifier")).sendKeys(username);
				driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				Thread.sleep(5000);			
				WebElement element=driver.findElement(By.xpath("//h1[contains(text(),'Welcome')]//following::input[3]"));
				Actions act=new Actions(driver);
				act.moveToElement(element).sendKeys(password).build().perform();			
				driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
				String email= driver.findElement(By.xpath("//span[@id=':3d']")).getText();
				String[] ar=email.split(" ");		
				System.out.println("Email id : " + ar[3]);						
				driver.findElement(By.xpath("//a[@class='gb_b gb_fb gb_R']")).click();
				driver.findElement(By.xpath("//a[@id='gb_71']")).click();
				driver.quit();
				
			} else if(Testflag.contains("ymail")) {
				
				System.out.println("yahoo mail launched sucessfully");
				driver.quit();	
				
			}
								
						}
							
	}
	
	}
