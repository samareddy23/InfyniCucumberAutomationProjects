package infynicucumberautomation.pageobjects;

import org.openqa.selenium.By;

import infynicucumberautomation.base.Base;

public class LoginPage extends Base {
	
	public static By emailInputBox = By.id("user_email");
	//public static By emailInputBox = By.xpath("//input[@id='user_email']");
	public static By passwordInputBox = By.id("user_password");
	//public static By passwordInputBox = By.xpath("//input[@id='user_password']");
	public static By signinButton = By.name("commit");
	//public static By signinButton = By.xpath("//input[@name='commit' and @value='Sign in']");
	//public static By allProjectsText = By.id("ember69");
	public static By allProjects = By.id("ember60");
	public static By signoutButton = By.xpath("//div[@id='ember62']/a[3]");
	public static By profileButton = By.xpath("//button[@class='dropdown-toggle ht-dropdown__toggle ht-btn t-avatar-menu']");
	public static By errorMessageText = By.xpath("//p[text()='Invalid email or password.']");
	
	public static void enterEmailId(String emailAddress) {
		try {
			
			driver.findElement(emailInputBox).clear();
			driver.findElement(emailInputBox).sendKeys(emailAddress);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void enterPassword(String password) {
		try {
			
			driver.findElement(passwordInputBox).clear();
			driver.findElement(passwordInputBox).sendKeys(password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void clickSignInButton () {
		try {
			driver.findElement(signinButton).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void clickProfile() {
		driver.findElement(profileButton).click();
	}
	
	public static void clickSignOutButton() {
	    driver.findElement(signoutButton).click(); // Add the click() method to click the button.
	}
	
	public static boolean allProjectsTextPresence(){
			boolean result;
			result = driver.findElement(allProjects).isDisplayed();
			return result;
		}
	
	public static String getAllProjectsText() {
	    String text = driver.findElement(allProjects).getText();
	    return text;
	}

	
	public static boolean errorMessagePresence() {
		boolean result = false;
		try {
			result = driver.findElement(errorMessageText).isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
