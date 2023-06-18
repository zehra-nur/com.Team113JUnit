package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P04 {

    // ilgili kurulumlari tamamlayalim
    // Kullanici https://www.google.com adresine gider
    // Çıkıyorsa Kullanici cookies i kabul eder
    // Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer
    // Para birimlerinin karsilastirmasini alin
    // Karsilastirilacak olan para biriminin 1.5 den kUCUk oldygu test edilir

    static WebDriver driver;

    @Before
    public void setup(){
        // ilgili kurulumlari tamamlayalim
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void paraKarsilastir(){
        // Kullanici https://www.google.com adresine gider
        driver.get("https://www.google.com");

        // Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer
        WebElement searchbox = driver.findElement(By.xpath("//*[@name='q']"));
        searchbox.sendKeys("usd to tl"+ Keys.ENTER);

        // Para birimlerinin karsilastirmasini alin
        WebElement resultElement = driver.findElement(By.xpath("//*[@class='DFlfde SwHCTb']"));
        String result = resultElement.getText().replace(",",".");
        double resultDouble = Double.parseDouble(result);

        Assert.assertTrue(resultDouble<25);
    }
    @After
    public void teardown(){
        driver.close();
    }
}
