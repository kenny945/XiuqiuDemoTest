package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sun.awt.windows.WEmbeddedFrame;


import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {

    By searchText = locate("search_input_text");
    By StockName = locate("stockName");
    By addselect = locate("follow_btn");
    By hasselect = locate("followed_btn");
    By cancel =  locate("action_close");

    public SearchPage search(String key)
    {
        //find(By.id("search_input_text")).click();
        find(searchText).sendKeys(key);
        return this;

    }

    public MainPage cancel()
    {
        find(cancel).click();
        return new MainPage();
    }

    public ArrayList<String> getAllStockName(){

        ArrayList<String> arrayList = new ArrayList<String>();
        List<WebElement> stocks = finds(StockName); //Driver.getCurrDriver().findElements(By.id("stockName"));
        if (!((List) stocks).isEmpty()){
            for(WebElement e: stocks){
                arrayList.add(e.getText());
            }
            return arrayList;
        }
        else {
            arrayList.add("Null");
            return arrayList;
        }
    }



    public SearchPage getByStock(){
        return  this;
    }

    public ArrayList<String> addSelected(){
        ArrayList<String> arrayList = new ArrayList<String>();

        WebElement select = find(By.xpath("//*[contains(@resource-id,'follow') and contains(@resource-id,'_btn')]"));

        arrayList.add(select.getText());
        select.click();
//        WebElement select2 = find(By.xpath("//*[contains(@resource-id,'follow') and contains(@resource-id,'_btn')]"));
//        arrayList.add(select2.getText());
//        System.out.println(select2.getText());
        //select2.click();

        return  arrayList;
    }

    public SearchPage removeSelected(){
        return  this;
    }

    public StockItemPage gotoItem(String content){

        find(text(content)).click();
        return new StockItemPage();
    }

}
