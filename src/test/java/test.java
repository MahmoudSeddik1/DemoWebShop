import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import static org.testng.Assert.assertTrue;

public class test {
//    @Test
//        public void test(){
//        LoginPage loginPage = homePage.clickLoginPage();
//        loginPage.enteremail_custom("mahmoud.seddikk@expleogroup.test");
//        loginPage.enterpassword_custom("Tosca123");
////        loginPage.clickRememberMe();
//        MainPage mainPage= loginPage.clickLogin();
//        BlueJeansPage blueJeansPage = mainPage.clickApparelButton().clickBlueJeans();
//        blueJeansPage.enterquantity(3);
//        blueJeansPage.clickAddToCart();
//        System.out.println("Price is "+ blueJeansPage.getPrice());
//        ShoppingCartPage shoppingCartPage= mainPage.clickShoppingCart();
////        shoppingCartPage.removeBlueJeans();
////        shoppingCartPage.removeMusic2_10();
//        shoppingCartPage.emptyCart();
//
//
//
//    }

    @Test
    public void captcha() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\12378\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/recaptcha/api2/demo");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        By notRobotButton = By.xpath("//span[@id='recaptcha-anchor']");
        By submitButton = By.xpath("//input[@id='recaptcha-demo-submit']");
        By reCaptchaSuccess = By.xpath("//div[@class='recaptcha-success']");
        Actions actions= new Actions(driver);
        actions.moveToElement(driver.findElement(notRobotButton)).click().perform();
        driver.findElement(submitButton).click();
        assertTrue(driver.findElement(reCaptchaSuccess).isDisplayed());
//        driver.findElement(By.xpath("//input[@id='search']")).click();
//        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.chord("Selenium", Keys.ENTER));
//        Runnable Login = new LoginTests().LoginTest1_Success();


    }

    public static void main(String[] args) throws Exception {
//        System.out.println("Please enter sequence length.");
//        Scanner sc = new Scanner(System.in); //System.in is a standard input stream.
//        int i = sc.nextInt();
//        int x=0,y=1,z;
//
//        for(int n=0;n<i;n++){
//            z=x+y;
//            System.out.println(z);
//            x=y;
//            y=z;
//        }
        System.out.println(Arrays.deepToString(readExcel()));

    }
    public static Object[][] readExcel() throws Exception{
        String path ="C:\\Users\\12378\\IdeaProjects\\AutomationPractice\\TestData\\TestData.xlsx";
        String sheetname= "Tabelle1";
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(sheetname);
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(sheet.getLastRowNum()).getLastCellNum();
        Object[][] data = new Object[rowCount][colCount];
        for(int i = 0; i<rowCount;i++){
            for(int j=0;j<colCount;j++){
                data[i][j]= sheet.getRow(i).getCell(j);
            }
        }
        return data;


    }



}


//        do {
//            System.out.print("Enter Number ");
//            int n = sc.nextInt();
//
//            for (int i = 1; i <= n; i++) {
//                if (i % 2 == 1 && i % 3 == 1 && i % 4 == 1 && i % 5 == 1 && i % 6 == 1 && i % 7 == 0) {
//                    System.out.println(i);
//
//                } else {
//                }
//
//
//            }
//            System.out.print("Again?Y/N");
//        }while(sc.next().equals("Y"));
//
//
//        }
//
//
//        }






