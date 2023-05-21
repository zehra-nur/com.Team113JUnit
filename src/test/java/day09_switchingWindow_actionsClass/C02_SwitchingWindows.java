package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C02_SwitchingWindows extends TestBase {
    @Test
    public void test01(){
        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement openingWindowYaziElementi = driver.findElement(By.tagName("h3"));
        String expectedText = "Opening a new window";
        String actualText = openingWindowYaziElementi.getText();
        Assert.assertEquals(expectedText,actualText);

        String ilkSayfaWindowHandleDegeri = driver.getWindowHandle();

        // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        // ● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        // Bu asamadan itibaren yeni sayfa acildi, artık iki Window var.

        Set<String> WindowHandleDegerleriSet = driver.getWindowHandles();
        String ikinciWindowHandleDegeri = "";

        for (String eachWhd : WindowHandleDegerleriSet
             ) {
            if (!eachWhd.equals(ilkSayfaWindowHandleDegeri)){
                ikinciWindowHandleDegeri = eachWhd;
            }
        }
        //Artık acilan 2. window'un WindowsHandlesDegerine sahibiz

        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciWindowHandleDegeri);

        expectedTitle = "New Window";
        actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newWindowYaziElementi = driver.findElement(By.tagName("h3"));
        expectedText = "New Window";
        actualText = newWindowYaziElementi.getText();
        Assert.assertEquals(expectedText,actualText);

        // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
