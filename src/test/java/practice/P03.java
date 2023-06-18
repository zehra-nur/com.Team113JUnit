package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {

    /*   Exercise-1:

         BeforeClass ile driver'i oluşturun ve class icinde static yapin
         Maximize edin ve 10 sn bekletin
         http://www.qooqle.com adresine gidin
         arama kutusuna "12 Angry Men" yazip, cikan sonuc şayisini yazdinin
         arama kutusuna "Vizontele" yazip, cikan sonuc şayisini yazdirin
         arama kutusuna "Saving Private Ryan" yazip, cikan sonuc şayisini yazdirin
         AfterClass ile kapatin.
     */
    static WebDriver driver;
    WebElement searchbox;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Before
    public void before(){
        driver.get("http://www.google.com");
        searchbox = driver.findElement(By.xpath("//textarea[@title='Ara']"));
    }
    @Test
    public void test01(){
        // driver.findElement(By.xpath("//div[text()='Tümünü reddet']")).click(); // Cookie den kurtulduk(Turkiye'de cikmiyor)
        searchbox.sendKeys("12 Angry Men"+ Keys.ENTER);

    }
    @Test
    public void test02(){
        searchbox.sendKeys("Vizontele"+Keys.ENTER);
    }
    @Test
    public void test03(){
        searchbox.sendKeys("Saving Private Ryan"+Keys.ENTER);
    }
    @After
    public void after(){
        WebElement resultText = driver.findElement(By.id("result-stats")); //"//div[@id='result-stats']"
        System.out.println(resultText.getText());
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
}
