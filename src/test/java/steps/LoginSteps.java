package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;
import runner.RunCucumberTest;
import suport.Utility;

public class LoginSteps extends RunCucumberTest {
    HomePage homePage = new HomePage();
    static LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    public static String email = Utility.email.getEmail();


    //login com sucesso
    @Dado("que entrei na página de login")
    public void enterLogin(){
        homePage.pageCheck();
        homePage.clickLogin();
        loginPage.pageCheck();
    }

    @Quando("preencho o formulário com meu email e senha")
    public void loginDados(){
        loginPage.enterEmail(email);
        loginPage.enterPassword("Ep7M#IfL_]xSE(U");
    }

    @E("clico em Login")
    public void clickButton(){
        loginPage.clickButton();
    }

    @E("seleciono Lembrar de Mim")
    public void selectCheckbox(){
        loginPage.selectRemember();
    }

    @Então("o login é realizado com sucesso")
    public void dashboard(){
        dashboardPage.checkLoginPopup();
        dashboardPage.button();
        dashboardPage.checkLogin();
    }

    //login falha

    @Quando ("preencho o formulário com email errado")
    public void emailError(){
        loginPage.enterWrongEmail("hhh");
    }

    @Quando ("preencho o formulário com senha errada")
    public void passwordError(){
        loginPage.enterEmail(email);
        loginPage.enterWrongPassword("111");
    }

    @Então ("vejo uma mensagem de email errado")
    public void emailMessage (){
        loginPage.errorEmail();
    }

    @Então ("vejo uma mensagem de senha errada")
    public void passwordMessage (){
        loginPage.errorPassword();
    }

}
