package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import runner.RunBase;
import suport.Utility;
import java.time.Duration;

public class LoginPage extends RunBase {

    //region variables
    private final By loginButton = By.id("btnLogin");
    private final By user = By.id("user");
    private final By addPassword = By.id("password");
    private final By createButton = By.id("createAccount");
    private final By select = By.id("materialUnchecked");
    private final By wEmail = By.xpath("//*[@id=\"login_area\"]/div/div/div/div/div[1]/span");
    private final By wPassword = By.xpath("//*[@id=\"login_area\"]/div/div/div/div/div[2]/span");
    //endregion


    public void pageCheck() {
        Utility.located(loginButton, Duration.ofSeconds(10));
        WebElement loginCheck = getDriver().findElement(loginButton);
        Assert.assertTrue(loginCheck.isDisplayed());
    }

    //Dados de usuário

    public void enterEmail(String email) {
        Utility.located(user, Duration.ofSeconds(10));
        getDriver().findElement(user).sendKeys(email);
    }

    public void enterWrongEmail(String email) {
        Utility.located(user, Duration.ofSeconds(10));
        getDriver().findElement(user).sendKeys(email);
    }

    public void enterPassword(String password) {
        getDriver().findElement(addPassword).sendKeys(password);
    }

    public void enterWrongPassword(String password) {
        getDriver().findElement(addPassword).sendKeys(password);
    }


    //Botões da página

    public void clickButton() {
        getDriver().findElement(loginButton).click();
    }

    public void add_account() {
        Utility.located(createButton, Duration.ofSeconds(10));
        getDriver().findElement(createButton).click();
    }

    public void selectRemember() {
        getDriver().findElement(select).click();
    }

    //Mensagens de erro

    public void errorEmail(){
        String error = getDriver().findElement(wEmail).getText();
        Assert.assertTrue(error.contains("E-mail inválido."));
    }

    public void errorPassword(){
        String error = getDriver().findElement(wPassword).getText();
        Assert.assertTrue(error.contains("Senha inválida."));
    }


}