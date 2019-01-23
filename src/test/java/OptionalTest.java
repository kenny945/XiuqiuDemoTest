import driver.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class OptionalTest {

    static MainPage mainPage;
    static OptionalPage optionalPage;
    static SearchPage searchPage;
    static HotStockPage hotStockPage;

    @BeforeAll
    static void BeforeAll(){
        mainPage = MainPage.start();
        optionalPage = mainPage.gotoOption();
        //searchPage = optionalPage.clickCenter();
        //hotStockPage = optionalPage.gotohotShare();
        //searchPage = optionalPage.gotoSearch();


    }

    @ParameterizedTest
    @CsvSource({
            "pdd, 拼多多",
            "xiaomi, 小米集团-W",
            "700,腾讯控股",
            //"法轮功,Null",

    })
    public  void search(String key,  String expected){
        String expectedMsg="添加成功";
        searchPage = optionalPage.gotoSearch();
        searchPage.search(key);
        String index = searchPage.getAllStockName().get(0);
        assertThat(index, equalTo(expected));

        StockItemPage stockItemPage = searchPage.gotoItem(index);
        stockItemPage.addSelect();
        String Message = stockItemPage.getMessage();
        stockItemPage.backtoOptional();
        assertThat(Message, equalTo(expectedMsg));

    }


    @ParameterizedTest
    @CsvSource({
            "拼多多",
            "小米集团-W",
            "腾讯控股",
            //"法轮功,Null",

    })
    public void testDelByPress(String key){
        String expectedMsg="已从自选删除";
        optionalPage.delByPress(key);
        String msg = optionalPage.getMessage();
        assertThat(msg, equalTo(expectedMsg));
    }


    @AfterAll
    static void AfterAll(){
        Driver.stop();
    }


}

