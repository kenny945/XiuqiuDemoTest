package page;

import driver.Driver;
import org.openqa.selenium.By;



public class LoginPage extends BasePage {

    By other = By.xpath("//*[@text='手机及其他登录']");
    By passwdLogin = By.xpath("//*[@text='邮箱手机号密码登录']");
    By username = By.id("login_account");
    By pwd = By.xpath("//*[@password='true']");
    By login = By.id("button_next");
    By msg = By.id("md_content");

    String Message;


    public LoginPage passwordFail (String username, String password){
        find(other).click();
        find(passwdLogin).click();
        find(this.username).sendKeys(username);
        find(this.pwd).sendKeys(password);
        find(login).click();
        Message = find(msg).getText();
        find(By.id("md_buttonDefaultPositive")).click();
        return this;



    }

    public String getMessage(){
        return  Message;
    }

    public ProfilePage gotoProfile(){
        find(By.id("iv_close")).click();
        return new ProfilePage();
    }
}
