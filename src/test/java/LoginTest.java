import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public  class LoginTest {

    MainPage mainPage=MainPage.start();
    //        public  void NotMobile(){
    //
    //            MainPage mainPage=MainPage.start();
    //            ProfilePage profilePage=mainPage.gotoProfile();
    //            LoginPage loginPage=profilePage.gotoLogin();
    //            loginPage.passwordFail("15600534760", "xxxxxxxx");
    //            //assertThat(loginPage.getMessage(), equalTo("手机号码填写错误"));
    //        }
    @ParameterizedTest
    @CsvSource({
            "13588993345,1111111 ,用户名或密码错误",
            "1358899334,1111111 ,手机号码填写错误",
            "1358899334111111111111,1111111 ,手机号码填写错误",
    })
    public  void passLogin(String username, String pwd, String expected){
        //MainPage mainPage=MainPage.start();
        //ProfilePage profilePage=mainPage.gotoProfile();
        //LoginPage loginPage=profilePage.gotoLogin();

        ProfilePage profilePage=mainPage.gotoProfile();
        LoginPage loginPage=profilePage.gotoLogin();
        loginPage.passwordFail(username, pwd);
        assertThat(loginPage.getMessage() , equalTo(expected));

    }




}