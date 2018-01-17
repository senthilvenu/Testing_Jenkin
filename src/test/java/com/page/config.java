package com.page;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class config {

	public Properties pro;
	public config() {
		try {
		File fp=new File("C:\\Users\\siva\\eclipse-workspace\\Jenkindo\\src\\test\\resources\\Data\\Config");
		FileInputStream fis=new FileInputStream(fp);
		 pro =new Properties();	
			pro.load(fis);
		
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String chormepath() {
		String path =pro.getProperty("ChromeDriver");
		
		return path;
		
		}
	
	public String excelpath() {
		
		String excelPath=pro.getProperty("ExcelPath");
		return excelPath;
	}
	
	}

