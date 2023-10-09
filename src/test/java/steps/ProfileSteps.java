package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.DashboardPage;
import runner.RunCucumberTest;

public class ProfileSteps extends RunCucumberTest {
    DashboardPage dashboardPage = new DashboardPage();

    //Acessar perfil de usuário e página de atualização
    @Dado("que estou logado no dashboard")
    public void pageDashboard(){
        dashboardPage.pageCheck();
    }

    @Quando("clico para acessar meu perfil de usuário")
    public void clickProfile(){
        dashboardPage.clickProfile();
        dashboardPage.profilePage();
    }

    @E("clico no botão de atualização de dados")
    public void clickGoUpdate(){
        dashboardPage.clickGoUpdate();
    }

    @Então("acesso a página de atualização")
    public void updatePage(){
        dashboardPage.updatePage();
    }

    //Atualizar perfil de usuário
    @Dado("que estou na página de atualização de perfil")
    public void profileUpdate(){
        updatePage();
    }

    @Quando("preencho o formulário com meus dados")
    public void updateData(){
        dashboardPage.addGender(1);
        dashboardPage.addFirstName();
        dashboardPage.addLastName();
        dashboardPage.addEmail();
        dashboardPage.addCurrentPassword("Ep7M#IfL_]xSE(U");
        dashboardPage.addNewPassword();
        dashboardPage.retypeNewPassword();
        dashboardPage.addImage("C:\\Users\\palom\\OneDrive\\Documentos\\Projetos\\qazando-shop\\src\\img\\selenium_logo.png");
    }

    @E("clico para atualizar meus dados")
    public void clickUpdateButton(){
        dashboardPage.clickUpdateButton();
    }

    @Então("o perfil é atualizado com sucesso")
    public void successUpdate(){
        dashboardPage.successUpdate();
    }
}
