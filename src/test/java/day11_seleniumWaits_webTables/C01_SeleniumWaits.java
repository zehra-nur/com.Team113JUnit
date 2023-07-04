package day11_seleniumWaits_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_SeleniumWaits {

    /*
       Otomasyon yaparken
       sayfanin yuklenmesi ve webelementlerin bulunmasi icin gerekli sureyi
       implicitly wait ile ayarlariz

       Implicitly wait sayfanin yuklenmesi ve
       her bir webelementin bulunmasi icin tanimlanan
       max. bekleme suresidir.
       her islem icin sifirdan baslar ve max sure doluncaya kadar
       gorevi tamamlamaya calisir
       max sure icerisinde gorev tamamlanamazsa
       exception verip calismayi durdurur

       Test buyuk cogunlugunda
       implicitly wait suresi
       senkronizasyonu saglamak icin yeterli olur
       ANCAK
       ozel bir gorev icin implicitly wait'de tanimlanan
       max. bekleme suresinden daha fazla beklememiz gerekirse
       O GOREVE OZGU, TEK SEFERLİK bir wait olusturabiliriz.
     */

    // Iki tane metod olusturun : implicitWait() , explicitWait()

    // Iki metod icin de asagidaki adimlari test edin.
    // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // Remove butonuna basin.
    // “It’s gone!” mesajinin goruntulendigini dogrulayin.
    // Add buttonuna basin
    // It’s back mesajinin gorundugunu test edin


    @Test
    public void test01(){
        // implicitly wait'in rolunu gorebilmek icin
        // baslangiz ayarlarini bu test methodunda yapalim.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Remove butonuna basin.
        driver.findElement(By.xpath("//*[@*='swapCheckbox()']")).click();

        // “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneElementi = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElementi.isDisplayed());

        // Add buttonuna basin
        driver.findElement(By.xpath("//*[@*='swapCheckbox()']")).click();

        // It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackElementi.isDisplayed());

        driver.close();
    }
    @Test
    public  void explicitlyWaitTesti(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Remove butonuna basin.
        driver.findElement(By.xpath("//*[@*='swapCheckbox()']")).click();

        // “It’s gone!” mesajinin goruntulendigini dogrulayin.

        /*
           Burada testi manuel olarak yapip bir karar vermemiz gerekiyor

           1- Test etmek istedigimiz webelement zaten gorünüyorsa
              webelementi locate edip sonra özel beklemeyi tanımlarım
           2- Test etmek istedigimiz elementin ulasilabilir olmasi icin
              beklemek gerekiyorsa
              locator'i verip, "bu locator ile bir element locate edene kadar
              exception fırlatma bekle" diyebiliriz
         */
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        WebElement itsGoneElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));

        Assert.assertTrue(itsGoneElementi.isDisplayed());

        // Add buttonuna basin
        driver.findElement(By.xpath("//*[@*='swapCheckbox()']")).click();

        // It’s back mesajinin gorundugunu test edin

        WebElement itsBackElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));

        driver.close();
    }
}
