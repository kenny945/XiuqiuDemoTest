package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HotStockPage extends BasePage {

    public HotStockPage addAll(){
        ArrayList arrayList = new ArrayList();

        List<WebElement> webElements =  finds(By.id("iv_fous"));

        for(WebElement e: webElements){
            //System.out.println(e.findElement(By.id("com.xueqiu.android:id/tv_stock_name")).getText());
            e.click();
        }
       return this;
    }
}
