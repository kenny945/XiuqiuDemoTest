package page;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePage {
    By profile=By.id("user_profile_icon");

    public static MainPage start(){
        Driver.start();
        return new MainPage();
    }

    public ProfilePage gotoProfile(){
        Driver.getCurrDriver().findElement(profile).click();
        return new ProfilePage();

    }

    public SearchPage gotoSearch(){
        find(By.id("home_search")).click();
        return new SearchPage();

    }

    public SearchPage gotoSearch2(){
        find(By.id("quick_action")).click();
        find(By.id("item_add_stock")).click();
        return new SearchPage();
    }

    public OptionalPage gotoOption(){
        //find(By.xpath("//*/"));
        //List<WebElement> list = finds(By.id("tab_icon"));
        find(By.xpath("//*[contains(@resource-id,'tab_name')  and @text='自选' ]")).click();

        return new OptionalPage();
    }
}