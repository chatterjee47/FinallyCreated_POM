package tests;

import io.qameta.allure.*;
import pages.FlightObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.excelutils.ExcelUtil;
import utils.extentreports.ExtentTestManager;
import utils.listeners.TestListener;


@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Login Tests")
public class FlightApplication extends BaseTest {

    @BeforeTest
    public void setupTestData () throws Exception {
        //Set Test Data Excel and Sheet
        System.out.println("************Setup Test Level Data**********");
        ExcelUtil.setExcelFileSheet("LoginData");
    }

    @Test (priority = 0, description="Flight Application Demo")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Flight Application Demo")
    @Story("Invalid username and password login test")
    public void FlightApplicationDemo () throws Exception {
    	
        ExtentTestManager.getTest().setDescription("Flight Application Demo");

        FlightObject FlightObject = new FlightObject(driver,wait);
 
        FlightObject.goToN11();
        
        FlightObject.FindFlight();
        
        FlightObject.ChooseThisFlight();
        
        FlightObject.EnterName(ExcelUtil.getRowData(6));

    }
}
