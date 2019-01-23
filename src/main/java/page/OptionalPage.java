package page;

import driver.Driver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class OptionalPage extends BasePage{

    String message = "";
    By search = By.id("action_create_cube");
    By searchText = By.id("search_input_text");
    By delAction = By.id("md_title");

    public SearchPage clickCenter(){
        find(By.id("image")).click();
        return new SearchPage();
    }

    public SearchPage search(String key)
    {
        find(search).click();
        find(searchText).sendKeys(key);
        return new SearchPage();

    }
    public ArrayList<String> getAllStockName(){

        ArrayList<String> arrayList = new ArrayList<String>();
        List<WebElement> stocks = Driver.getCurrDriver().findElements(By.id("stockName"));
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

    public void delByPress(String content){
        WebElement Elememt = find(text(content));//find(By.xpath("//*[@class='android.widget.TextView']"));
        //TouchActions

        TouchAction action = new TouchAction(Driver.getCurrDriver());
        action.longPress(new LongPressOptions().withElement(element(Elememt)).withDuration(Duration.ofSeconds(2)));
        action.perform();

        find(text("删除")).click();
        message =  find(By.xpath("//*[@class='android.widget.Toast']")).getText();
    }

    public SearchPage gotoSearch(){
        find(locate("action_create_cube")).click();
        return  new SearchPage();
    }

    public HotStockPage gotohotShare(){
        find(By.id("tv_check")).click(); //"去看看热门股票"
        return  new HotStockPage();
    }

    public List<WebElement> getAllSelectStock(){
       List<WebElement> webElements = finds(By.id("portfolio_whole_item"));
        return  webElements;
    }

    public String getMessage(){
        return message;
    }
}
