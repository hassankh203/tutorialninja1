package tryingZone;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testCases.BaseClass;

public class TryingZone extends BaseClass {

	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		screenshot("testcaseName");
		driver.close();

	}

	public static void screenshot(String testCaseName) throws IOException {

		TakesScreenshot sc = (TakesScreenshot) driver;
		File target = new File(System.getProperty("user.dir")+ "\\scrennShots\\" + timeStamp()+ ".png");
		File src = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, target);
	}

	public static String timeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());

	}
	

}
