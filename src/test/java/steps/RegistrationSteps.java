package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import runner.RunCucumberTest;

public class RegistrationSteps extends RunCucumberTest {
    HomePage homePage = new HomePage();
    RegistrationPage registerPage = new RegistrationPage();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();


    //cadastro com sucesso
    @Dado("que entrei na página de cadastro")
    public void cadastro() {
        homePage.pageCheck();
        homePage.clickRegister();
        registerPage.pageCheck();
    }

    @Quando("eu preencho o formulário com meus dados")
    public void personalData(){
        registerPage.addName();
        registerPage.addEmail();
        registerPage.addPassword();
    }

    @E("clico em Cadastrar")
    public void clickButton(){
        registerPage.clickButton();
    }

    @Então("o cadastro é realizado com sucesso")
    public void registerSuccess(){
        dashboardPage.checkRegisterPopup();
        dashboardPage.button();
        dashboardPage.checkRegister();
    }

    //acessar página de cadastro pela página de login
    @Quando("clico em Ainda não tem conta?")
    public void addAccount(){
        loginPage.add_account();
    }

    @Então("sou encaminhado para a página de cadastro")
    public void registerPage(){
        registerPage.pageCheck();
    }
}
