package browsersetup;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Setup extends BaseClass {

	private WebDriver driver = null;

	public WebDriver setupBrowser(String browser)
			throws InterruptedException, MalformedURLException {
		
		if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Wipro\\datadriven\\drivers\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Wipro\\datadriven\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		} else if (browser.equalsIgnoreCase("Internet Explorer")) {
			System.setProperty("webdriver.ie.driver", "D:\\Wipro\\datadriven\\drivers\\IEDriverServer.exe");
			WebDriver driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	
	}
}