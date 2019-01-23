package page;

import org.openqa.selenium.By;

public class StockItemPage extends  BasePage {

    String message;
    By cancel =  locate("action_close");

    public void  addSelect(){
        find(By.xpath("//*/android.widget.TextView[@text='加自选']")).click();
        //message =  find(By.xpath("//*[@class='android.widget.Toast']")).getText();
    }

    public void  disSelect(){
        //find(text("删除自选")).click();
        find(By.xpath("//*/android.widget.TextView[@text='设自选']")).click();
        find(text("删除自选")).click();
        //message =  find(By.xpath("//*[@class='android.widget.Toast']")).getText();
    }


    public String getMessage(){

        return message;
    }

    public OptionalPage backtoOptional(){
        find(By.id("action_back")).click();
        find(cancel).click();
        return new OptionalPage();
    }
}
