package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileDownloadTest extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        // image.png dosyasını indirelim
        WebElement imageElementi = driver.findElement(By.linkText("image.png"));
        imageElementi.click();
        Thread.sleep(3000);

        // Dosyanın başarıyla indirilip indirilmediğini test edelim


        // Dosyayi downloads klasörüne indirecek
        String dosyaYolu = "C:\\Users\\Zehranur\\Downloads\\image.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
