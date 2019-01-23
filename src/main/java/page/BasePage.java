package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

//from org.openqa.selenium.support import expected_conditions as EC;

public class BasePage {

    static WebElement find(By locator){

        try{
             Driver.getCurrDriver().findElement(locator);
            //WebDriverWait(Driver.getCurrDriver(),10, 0.5)
            //WebDriverWait(Driver.getCurrDriver(),30, 0.5).until(ExpectedConditions.presence_of_element_located(Element));
            return Driver.getCurrDriver().findElement(locator);
        }catch (Exception e){
            Driver.getCurrDriver().findElement(text("下次再说")).click();
            return Driver.getCurrDriver().findElement(locator);
        }
    }

    static List<WebElement> finds(By locator){

        try{
            return Driver.getCurrDriver().findElements(locator);
        }catch (Exception e){
            Driver.getCurrDriver().findElement(text("下次再说")).click();
            return Driver.getCurrDriver().findElements(locator);
        }
    }



    static By locate(String locator){
        if(locator.matches("/.*")){
            return By.xpath(locator);
        }else{
            return By.id(locator);
        }
    }
    static By text(String content){
        return By.xpath("//*[@text='"+ content + "']");
    }


}