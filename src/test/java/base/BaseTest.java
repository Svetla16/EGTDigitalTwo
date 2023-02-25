package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;


    @BeforeClass
    public void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    }

    @BeforeMethod
    public void setUp() throws Exception {
        this.driver = new ChromeDriver();
        this.driver.manage().window().fullscreen();
    }


    @AfterMethod
    public void tearDownTest() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        //Clean any generated test data
    }
}


