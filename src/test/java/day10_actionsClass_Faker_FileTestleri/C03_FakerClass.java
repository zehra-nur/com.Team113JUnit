package day10_actionsClass_Faker_FileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_FakerClass extends TestBase {
    /*
       Faker kutuphanesi
       fake degerler olusturabilecegimiz bir kutuphanedir.

       Buradan deger uretebilmek icin
       Faker class'indan bir obje olusturmaliyiz.
     */

    @Test
    public void test01() throws InterruptedException {

        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        // 2- "Yeni hesap olustur" butonuna basalim
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions =new Actions(driver);
        WebElement isimKutusu = driver.findElement(By.name("firstname"));

        Faker faker = new Faker();
        String email = faker.internet().emailAddress();  // İki kez email/password girilmesi istendiginde
                                                         // karisiklik cikmamasi icin atama yapabiliriz.

        actions.click(isimKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)     // faker.internet().emailAddress() seklinde de calisabilir (bir kez istenirse)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        Thread.sleep(1000);

        // 4- Kaydol tusuna basalim
        driver.findElement(By.name("websubmit")).click();
    }

}
