package testsWeather;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DublinWeather extends BaseTest {

    @Test
    public void compareDublinWeather() {

        driver.get("https://www.sinoptik.bg/dublin-ireland-102964574?search");
        WebElement elementSinoptik = driver.findElement(By.xpath("//*[@id=\"wfCurrent\"]/a[1]/span[3]/span"));
        String textSinoptik = elementSinoptik.getText();

        driver.get("https://www.accuweather.com/en/ie/dublin/207931/weather-forecast/207931");
        WebElement elementAccuweather = driver.findElement(By.className("temp"));
        String textAccuweather = elementAccuweather.getText();

        driver.get("https://www.bbc.com/weather/2964574");
        WebElement elementBBC = driver.findElement(By.className("wr-value--temperature--c"));
        String textBBC = elementBBC.getText();

        int tempSinoptik = Integer.parseInt(textSinoptik.split("°")[0]);
        int tempAccuweather = Integer.parseInt(textAccuweather.split("°")[0]);
        int tempBBC = Integer.parseInt(textBBC.split("°")[0]);

        assertTrue((tempSinoptik == tempAccuweather) && (tempAccuweather == tempBBC));
    }
}
