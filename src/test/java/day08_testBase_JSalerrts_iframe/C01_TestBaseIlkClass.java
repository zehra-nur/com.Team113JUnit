package day08_testBase_JSalerrts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_TestBaseIlkClass extends TestBase {

    @Test
    public void test01(){
        // amazon'a gidelim
        driver.get("https://www.amazon.com");

        // Nutella icin arama yapalim
        WebElement aramaKutusuElementi = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuElementi.sendKeys("Nutella"+ Keys.ENTER);

        // arama sonuclarinin Nutella icerdigini test edelim
        String expectedIcerik = "Nutella";
        String actualAramaSonucuYazisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();

        Assert.assertTrue(actualAramaSonucuYazisi.contains(expectedIcerik));

    }
}
