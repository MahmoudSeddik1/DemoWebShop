package basetests;

import InnoScripta.InnoHomepage;
import com.google.common.io.Files;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utilities.MyListenerClass;
import utilities.WindowManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class BaseTests  {
    private WebDriver driver;
    private WebDriver original;
    protected HomePage homePage;
    protected InnoHomepage innoHomepage;
    @BeforeClass
    public void Setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\12378\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

        original = new ChromeDriver(options());
        MyListenerClass listener = new MyListenerClass();
        driver = new EventFiringDecorator(listener).decorate(original);
        homePage = new HomePage(driver);
//        innoHomepage = new InnoHomepage(driver);
        goHome();

    }
//    @BeforeClass
//    public void mybeforeClass(ITestContext c){
//
//        System.out.println("Class "+c.getName()+" is open");
//    }
    @BeforeMethod
    public void goHome(){
    driver.get("http://demowebshop.tricentis.com/");
    }
    @BeforeMethod
    public void beforeTestCase(Method m) {
        System.out.println("Executing: "+m.getName());
    }
    @AfterMethod
    public void recordFailure(ITestResult result, Method m){
        if(ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot,
                        new File("resources/screenshots/" + result.getName() +".png"));
            }catch (IOException e){
                            e.printStackTrace();
            }

        } else{
            System.out.println(m.getName()+" Executed Successfully");
        }

    }
//    @AfterClass
//    public void myafterClass(ITestContext c) {
//        System.out.println(c.getName()+" is done!");
//    }
//    @AfterMethod
//    public void closeAll(){
//        driver.quit();
//    }


    @AfterClass
    public void closeAll(){
        driver.quit();
    }


    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
    public ChromeOptions options(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
//        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

//        options.setExperimentalOption("credentials_enable_service", false);     // was trying to disable save password prompt but i couldn't
//        options.setExperimentalOption("profile.password_manager_enabled", false);

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("useAutomationExtension", false);

        options.setExperimentalOption("prefs", prefs);



//        options.setHeadless(true);
        return options;

    }
    @DataProvider(name = "Credentials")
    public Object[][] getData(){
        Object[][] data = new Object[3][2];
        data[0][0]="mahmoud.seddik@expleogroup.test";
        data[0][1]="Tosca1234!";

        data[1][0]="mahmoud.seddik";
        data[1][1]="Tosca123";

        data[2][0]="mahmoud.seddik@expleogroup";
        data[2][1]="Tosca1234";

        return  data;
    }
    public void impWait(int sec){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }
    @DataProvider(name = "Excel")
    public Object[][] readExcel() throws Exception{
        String path ="C:\\Users\\12378\\IdeaProjects\\AutomationPractice\\TestData\\TestData.xlsx";
        String sheetname= "Tabelle1";
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(sheetname);
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(sheet.getLastRowNum()).getLastCellNum();
        String[][] data = new String[rowCount][colCount];
        for(int i = 0; i<rowCount;i++){
            for(int j=0;j<colCount;j++){
                data[i][j]= String.valueOf(sheet.getRow(i).getCell(j));
            }
        }
        return data;


    }

}
