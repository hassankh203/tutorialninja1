package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public static WebDriver driver;
	Properties prop;
	FileInputStream data;

	@BeforeMethod
	public void setup() throws IOException {

		data = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\utilities\\config.properties");
		prop = new Properties();
		prop.load(data);

		// driver = new ChromeDriver();
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		data = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\utilities\\config.properties");
		prop = new Properties();
		prop.load(data);
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	public String randomString() {

		String randomString = RandomStringUtils.randomAlphabetic(5);
		return randomString;

	}

	public String randomNumber() {

		String randomNumber = RandomStringUtils.randomNumeric(10);
		return randomNumber;

	}

	public String randomAlphaNumeric() {

		String rs = RandomStringUtils.randomAlphabetic(5);
		String rn = RandomStringUtils.randomNumeric(10);
		return rs + rn;

	}

	public static String timeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());

	}

	public String takeScreenShot(String TestCaseName) {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		String Destination = System.getProperty("user.dir") + "\\scrennShots\\" + TestCaseName +"_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(src, new File(Destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Destination;
	}

	public void takScreenshotPortion() throws IOException {

		WebElement section = driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible"));
		File src2 = section.getScreenshotAs(OutputType.FILE);
		File target2 = new File("./screenShots/portion.png");
		FileUtils.copyFile(src2, target2);
	}

}
