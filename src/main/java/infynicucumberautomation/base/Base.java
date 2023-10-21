package infynicucumberautomation.base;

import java.io.FileNotFoundException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import infynicucumberautomation.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	
	
	public static void launchBrowser(String browser) {
		
		if (browser.equals("Chrome")){
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			 driver = new ChromeDriver(options);
	        		
		}else if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver(); 	
		}
		driver.manage().window().maximize();
		
	}
	
	
	public static void launchApp() throws FileNotFoundException  {
		//launchBrowser("Chrome");
				
		String url= PropertyReader.readDataFromPropertyFile("appurl");
		
		driver.get(url);
		implicitWait(5);
	}
   
   
	public static void closeApp() {
		driver.close();
	}
	
	public static void implicitWait(long seconds) {
		//Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	

	public static void loadingData() {
		System.out.println("Before Test: This method will run before each test");
	}
	

	public static void closingApp() {
		System.out.println("After Test: This method will run after each test");
	}

	public static void loadData() {
		System.out.println("Before Suite: This method will run before all the testcases");
	}
	

	public static void closeApplication() {
		System.out.println("After Suite: This method will run after all the testcases executed");
	}
	
}
