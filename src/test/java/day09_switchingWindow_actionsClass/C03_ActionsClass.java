package day09_switchingWindow_actionsClass;

import org.junit.Test;

import java.time.LocalTime;

public class C03_ActionsClass {

    @Test
    public void Test01(){

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
    }
}
