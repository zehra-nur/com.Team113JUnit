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

public class C02_ExplicitlyWait {

    @Test
    public void test01(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textboxElementi = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textboxElementi.isEnabled());

        // Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));

        wait.until(ExpectedConditions.elementToBeClickable(textboxElementi));

        // “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnableElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's enabled!\"]")));

        Assert.assertTrue(itsEnableElementi.isDisplayed());

        // Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(textboxElementi.isEnabled());

        driver.close();
    }
}
