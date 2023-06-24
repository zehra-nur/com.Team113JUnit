package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Actions extends TestBase {

    @Test
    public void test01(){

        // 1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        // 2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin

        Actions actions = new Actions(driver);
        WebElement accountListElementi = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountListElementi).perform();

        // 3- “Create a list” butonuna basin
        WebElement createAndListElementi = driver.findElement(By.xpath("//*[text()='Create a List']"));
        createAndListElementi.click();

        // 4- Acilan sayfada “Your Lists” yazisi oldugunu test edin

        WebElement yourListElementi = driver.findElement(By.xpath("//div[@role='heading']"));
        String expectedYazi = "Your Lists";
        String actualYazi = yourListElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
    }


}
