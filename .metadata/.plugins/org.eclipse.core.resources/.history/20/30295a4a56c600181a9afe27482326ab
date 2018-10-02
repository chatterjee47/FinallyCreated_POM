package browsersetup;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public WebDriver driver;
	public WebDriverWait wait;
	private List<String> assertMessage;
	private String clientName;
	private String DBRoleChange;
	public static String DBRoleValue=null;

	public String getDBRoleChange() {
		return DBRoleChange;
	}

	public void setDBRoleChange(String dBRoleChange) {
		DBRoleChange = dBRoleChange;
	}

	
	
	@BeforeMethod(timeOut = 600000, alwaysRun=true)
	@Parameters({ "browser"})
	public void setup(String browser) throws InterruptedException, MalformedURLException 
	{
		this.setClientName(clientName);
		if(clientName.equals("CAP"))
		{
			Setup setup = new Setup();
			driver = setup.setupBrowser(browser);
		}
		
	}

	public void setAssertMessage(String message, int verificationNumber)
	{
		try
		{
			assertMessage.add(message);
		} 
		catch (Exception e) 
		{
			assertMessage = new ArrayList<String>();
			assertMessage.add(message);
		}
	}

	public List<String> getAssertMessage()
	{
		return assertMessage;
	}

	@AfterMethod(timeOut = 600000, alwaysRun=true)
	@Parameters({ "browser","clientName" })
	public void quit(String browser, String clientName) throws InterruptedException 
	{
		try
		{
			if((!assertMessage.isEmpty()) && (!(assertMessage==null)))
			{
				assertMessage.clear();
			}
		}
		catch (Exception e)
		{
			assertMessage = new ArrayList<String>();
			assertMessage.addAll(assertMessage);
		}
		tearDown(browser,clientName);
	}
	
	private void tearDown(String browser, String clientName)
	{
		try 
		{
			if(clientName.equals("CAP"))
			{
				driver.close();
				driver.quit();
				if(WindowsUtils.thisIsWindows() && browser.equalsIgnoreCase("Firefox")) 
				WindowsUtils.killByName("firefox.exe");
			else if(WindowsUtils.thisIsWindows() && browser.equalsIgnoreCase("chrome"))
				WindowsUtils.killByName("chrome.exe");
			else if(WindowsUtils.thisIsWindows() && browser.equalsIgnoreCase("InternetExplorer"))
				WindowsUtils.killByName("iexplore.exe");

			}}
		catch (Exception n) 
		{
			n.printStackTrace();
		}
	}

	public static WebDriver getDriver() 
	{
		return getDriver();
	}

	public void setDriver(WebDriver driver) 
	{
		this.driver = driver;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}	
}