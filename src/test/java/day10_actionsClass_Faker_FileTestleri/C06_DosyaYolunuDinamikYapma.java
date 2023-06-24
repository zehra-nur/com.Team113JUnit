package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_DosyaYolunuDinamikYapma {

    @Test
    public  void test(){
        /*
           Herkesin bilgisayarinda farkli bir dosya hiyerarşisi oldugundan
           herkesin dosya yolu birbirinden farkli olur.
           Dosya yolunu dinamik hale getirmek icin Java'dan yardim alacagiz
         */

        System.out.println(System.getProperty("user.dir"));
        // projenin dosya yolunu verir.
        // C:\Users\Zehranur\Desktop\com.Team113JUnit

        System.out.println(System.getProperty("user.home"));
        //  C:\Users\Zehranur

        /*
           Biz Downloads'a indirdigimiz dosyanin dosya yolunu 2'ye bolecegiz
           /Users/ahmetbulutluoz                    /Downloads/image.png
           herkesin bilgsayarinda farkli             herkeste ayni
           System.getProperty("user.home")

         */

        String dosyaYoluDegisenKisim = System.getProperty("user.home");
        String dosyaYoluHerkesteAyniOlanKisim = "/Downloads/image.png";

        String dosyaYolu = dosyaYoluDegisenKisim+dosyaYoluHerkesteAyniOlanKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // ayni islemi projemizin altindaki deneme.txt icin yaparsak
        // src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt

        dosyaYoluDegisenKisim = System.getProperty("user.dir");
        dosyaYoluHerkesteAyniOlanKisim = "/src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt";

        dosyaYolu = dosyaYoluDegisenKisim+dosyaYoluHerkesteAyniOlanKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

}
