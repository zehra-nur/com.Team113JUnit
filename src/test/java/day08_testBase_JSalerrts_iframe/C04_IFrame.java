package day08_testBase_JSalerrts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_IFrame extends TestBase {

    // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
    // 2 ) Bir metod olusturun: iframeTest
    //   - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    //   - Text Box’a “Merhaba Dunya!” yazin.
    //   - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
    // gorunur oldugunu dogrulayin ve konsolda yazdirin.

    @Test
    public void test01() throws InterruptedException {
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2 ) Bir metod olusturun: iframeTest
        //   - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iframeYaziElementi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYaziElementi.isDisplayed());
        System.out.println(iframeYaziElementi.getText());

        //   - Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframeElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElementi);
        WebElement textBoxElementi = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBoxElementi.clear();
        textBoxElementi.sendKeys("Merhaba Dunya!");

        //   - TextBox’in altinda bulunan “Elemental Selenium” linkinin textinin
        //   gorunur oldugunu dogrulayin ve konsolda yazdirin.

        /*
           iframe'e gacis yapilinca
           driver'i oradan cikis yaptirana kadar driver iframe'in icinde kalir

           driver.switchTo().parentFrame() : ic ice birden fazlaiframe varsa, bir uste cikar
           driver.switchTo().defaultContent() : direk anasayfaya cikar
         */

        driver.switchTo().defaultContent();
        WebElement elementalSeleniumLinki = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSeleniumLinki.isDisplayed());
        System.out.println(elementalSeleniumLinki.getText());

    }
}
