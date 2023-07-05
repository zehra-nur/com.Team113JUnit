package day13_ExcelOtomasyonu_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.security.Key;

public class C03_TumSayfaScreenshot extends TestBase {

    @Test
    public void test01() throws IOException {

        // Amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");

        // Nutella aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // Sonuclarin Nutella icerdigini test edelim
        WebElement sonucElementi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String expectedSonucYazisi = "Nutella";
        String actualResult = sonucElementi.getText();

        Assert.assertTrue(actualResult.contains(expectedSonucYazisi));

        // Rapora eklenmek uzere tum sayfanin ekran goruntusunu alalim

        TakesScreenshot tss = (TakesScreenshot) driver;

        File tumSayfaResim = new File("target/ekranResimleri/tumSayfaResim.png");

        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim,tumSayfaResim);

        ReusableMethods.tumSayfaFotografCek(driver);
    }
}
