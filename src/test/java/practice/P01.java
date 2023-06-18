package practice;

import org.junit.Test;

public class P01 {
    /*
       @BeforeClass     // Sadece bir kere calisiyor
       @Before         // Her testten once bir kere calisir
       @AfterClass    // Tüm testlerden sonra bir kere calisir
       @After        // Her testten sonra bir kere calisir
       @Test        // Yapacagimiz test kodlarinin yer aldigi kisim
     */

    @Test
    public  void test01(){
        System.out.println("Test 01");
    }
    @Test
    public  void test02(){
        System.out.println("Test 02");
    }
    @Test
    public  void  test03(){
        System.out.println("Test 03");
    }
}
