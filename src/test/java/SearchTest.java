import driver.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.MainPage;
import page.SearchPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {

    static MainPage mainPage;
    static SearchPage searchPage;

    @BeforeAll
    static void BeforeAll() {
        mainPage = MainPage.start();
        //searchPage = mainPage.gotoSearch();
        searchPage = mainPage.gotoSearch2();
    }

    @ParameterizedTest
    @CsvSource({
            "pdd, 拼多多",
            "xiaomi, 小米集团-W",
            "法轮功,Null",
            "700,腾讯控股"

    })
    public void search(String key, String expected) {

        String index = searchPage.search(key).getAllStockName().get(0);
        assertThat(index, equalTo(expected));

    }


    @AfterAll
    static void AfterAll(){
        Driver.stop();
    }

}
