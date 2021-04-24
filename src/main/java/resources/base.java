package resources;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {
	public WebDriver driver;
	public WebDriver initDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream inputFile = new FileInputStream("C:\\Users\\saadkhan\\eclipse-workspace\\googleMortgageCalculator\\src\\main\\java\\resources\\data.properties");

		prop.load(inputFile);
		String browser = prop.getProperty("browser", "chrome");
		String driverPath = prop.getProperty("driverPath");
		
		if (browser.toLowerCase().equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath + "\\chromedriver.exe");
			System.out.println(System.getProperty("webdriver.chrome.driver"));
			driver = new ChromeDriver();
		} else if (browser.toLowerCase().equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.toLowerCase().equals("edge")) {
			System.setProperty("webdriver.edge.driver", driverPath + "\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public Object getTestData(String testName) throws IOException, ParseException {
//		Properties prop = new Properties();
//		FileInputStream inputFile = new FileInputStream("C:\\Users\\saadkhan\\eclipse-workspace\\googleMortgageCalculator\\src\\test\\java\\automation\\googleMortgageCalculator\\testData.properties");
//		prop.load(inputFile);
//		
//		return prop;
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:\\Users\\saadkhan\\eclipse-workspace\\googleMortgageCalculator\\src\\test\\java\\automation\\googleMortgageCalculator\\testData.json"));
		
		return jsonObject.get(testName);
	}
	
	public void clickElement(By elementBy) {
		driver.findElement(elementBy).click();
	}
	
	public void clearElement(By elementBy) {
		driver.findElement(elementBy).clear();
	}

	public void sendKeysToElement(By elementBy, String text) {
		driver.findElement(elementBy).sendKeys(text);
	}
	
	public void sendKeysToElement(By elementBy, Keys keys) {
		driver.findElement(elementBy).sendKeys(keys);
	}
	
	public void waitForElement(By elementBy, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
	}
	
	public void checkTextInElement(By elementBy, String expectedText) {
		String existingText = driver.findElement(elementBy).getText();
		assert existingText.equals(expectedText): "Expected: " + expectedText + "; Got: " + existingText;
	}
}
