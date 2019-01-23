import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.MainPage;
import page.OptionalPage;
import page.SearchPage;
import page.StockItemPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StockSelectTest {
    static MainPage mainPage;
    static SearchPage searchPage;
    static OptionalPage optionalPage;

    @BeforeAll
    static void BeforeAll() {
        mainPage = MainPage.start();
        optionalPage = mainPage.gotoOption();
        //searchPage = mainPage.gotoSearch2();

    }

    @ParameterizedTest
    @CsvSource({
            "pdd, 拼多多",
            "xiaomi, 小米集团-W",
            "法轮功,Null",

    })
    public void search(String key, String expected) {
        String xpectedMsg = "添加成功";
        String index = searchPage.search(key).getAllStockName().get(0);
        assertThat(index, equalTo(expected));

        StockItemPage stockItemPage = searchPage.gotoItem(expected);
        stockItemPage.addSelect();
        String Message = stockItemPage.getMessage();
        assertThat(Message, equalTo(xpectedMsg));
    }


}

//        System.out.println(getMessage);
//        stockItemPage.disSelect();
//        getMessage = stockItemPage.getMessage();
//        System.out.println(getMessage);
//
//        searchPage.cancel();




