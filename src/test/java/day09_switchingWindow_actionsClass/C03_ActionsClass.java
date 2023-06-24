package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.time.LocalTime;
import java.util.Set;

public class C03_ActionsClass extends TestBase {

    @Test
    public void Test01() throws InterruptedException {

        // 1- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // 2- Cizili alan uzerinde sag click yapin,
        WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);

        actions.contextClick(ciziliAlan).perform();  // Actions clasında çalıştırdığımız methodların sonuna perfom()'u eklemeliyiz.

        // 3- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.

        String expectedAlertYazisi = "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        // 4- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        // 5- Elemental Selenium linkine tiklayalim.(linki tikladigimizda yeni window acildigindan
        // tiklamadan önce ilk window'un WHD almamiz gerekir)

        String ilkWindowHandleDegeri = driver.getWindowHandle();
        WebElement elementalSeleniumLinki = driver.findElement(By.linkText("Elemental Selenium"));
        elementalSeleniumLinki.click();

        // ikinci sayfa biz newWindow() demeden acildigindan
        // ikinciWindow'un WHD'ni Java kullanarak bulmaliyiz

        String ikinciWHD = "";
        Set<String> windowHandleDegerleri = driver.getWindowHandles(); // icinde 2 tane WHD var
        // ilkWindowHandleDegeri'ne esit olmayani ikinciWHD olarak atayalim

        for (String eachWHD : windowHandleDegerleri
             ) {
            if (!eachWHD.equals(ilkWindowHandleDegeri)){
                ikinciWHD = eachWHD;
            }
        }
        driver.switchTo().window(ikinciWHD);

        // 6- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        String expectedYazi = "Elemental Selenium";
        WebElement yaziElementi = driver.findElement(By.tagName("h1"));
        String actualYazi = yaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        Thread.sleep(5000);
    }
}
/*   ************************************
// x saniyelik bir sayac yapalim
        int x =3;
        LocalTime baslangic = LocalTime.now();
        int baslangicSaniyesi = baslangic.getSecond();
        int saniyeKontrol = 123;

        int bitisSaniyesi = baslangicSaniyesi+x >60 ? baslangicSaniyesi+x-60 : baslangicSaniyesi ;

        while (bitisSaniyesi != saniyeKontrol){
            saniyeKontrol=LocalTime.now().getSecond();
        }

        System.out.println("baslangic saniyesi : " + baslangicSaniyesi);
        System.out.println("saniyeKontrol : " + saniyeKontrol);
 */