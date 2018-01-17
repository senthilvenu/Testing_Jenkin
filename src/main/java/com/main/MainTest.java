package com.main;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.page.GmailLogin;


public class MainTest {

	WebDriver driver;
	public String username;
	public String password;	
	public String TestFlag;
	public String url;
	
			
	@Test
	public void Gmail() throws InterruptedException, IOException {
		 	
			GmailLogin login =new GmailLogin();
			login.GmailLogin(TestFlag,url,username, password);
			
			
			}
	
	}
