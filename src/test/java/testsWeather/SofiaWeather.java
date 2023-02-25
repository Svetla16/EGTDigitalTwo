package testsWeather;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SofiaWeather extends BaseTest {


    @Test
    public void compareSofiaWeather() throws NumberFormatException {

        driver.get("https://www.sinoptik.bg/sofia-bulgaria-100727011?location");
        WebElement elementSinoptik = driver.findElement(By.xpath("//*[@id=\"wfCurrent\"]/a[1]/span[3]/span"));
        String textSinoptik = elementSinoptik.getText();

        driver.get("https://www.accuweather.com/en/bg/sofia/51097/weather-forecast/51097");
        WebElement elementAccuweather = driver.findElement(By.className("temp"));
        String textAccuweather = elementAccuweather.getText();

        driver.get("https://www.bbc.com/weather/727011");
        WebElement elementBBC = driver.findElement(By.className("wr-value--temperature--c"));
        String textBBC = elementBBC.getText();

        int tempSinoptik = Integer.parseInt(textSinoptik.split("°")[0]);
        int tempAccuweather = Integer.parseInt(textAccuweather.split("°")[0]);
        int tempBBC = Integer.parseInt(textBBC.split("°")[0]);

        assertTrue((tempSinoptik == tempAccuweather) && (tempAccuweather == tempBBC));
    }


}
