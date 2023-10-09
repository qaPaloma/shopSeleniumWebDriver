package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import runner.RunBase;
import steps.LoginSteps;
import suport.Utility;
import java.time.Duration;

public class DashboardPage extends RunBase {

    //region variables
    private final By button = By.xpath("/html/body/div[2]/div/div[6]/button[1]");
    private final By popupText = By.id("swal2-html-container");
    private final String nameCheck = RegistrationPage.name;
    private final String emailCheck = LoginSteps.email;
    private final By headerCheck = By.xpath("//*[@id=\"userLogged\"]");
    private final By dashboard = By.xpath("//*[@id=\"my-account_area\"]/div/div/div[1]/div/ul/li[1]/a");
    private final By accountTab = By.xpath("//*[@id=\"my-account_area\"]/div/div/div[1]/div/ul/li[5]/a");
    private final By updateGoButton = By.xpath("//*[@id=\"dashboard\"]/div/div[1]/a");
    private final By updatePage = By.xpath("//*[@id=\"account_edit\"]/div/div[2]/div[2]/div/div/h2");
    private final By mr = By.xpath("//*[@id=\"account_info_form\"]/div[1]/span[1]/input");
    private final By mrs = By.xpath("//*[@id=\"account_info_form\"]/div[1]/span[2]/input");
    private final By firstName = By.id("f_name");
    private final By lastName = By.xpath("//*[@id=\"account_info_form\"]/div[2]/input[2]");
    private final By emailAddress = By.id("email_address");
    private final By cPassword = By.id("current_password");
    private final By nPassword = By.id("new_password");
    private final By rPassword = By.id("re_password");
    private final By uploadImage = By.xpath("//*[@id=\"account_edit\"]/div/div[2]/div[1]/div/div/div/input");
    private final By saveUpdate = By.xpath("//*[@id=\"account_info_form\"]/button");
    private final By profileHeader = By.xpath("//*[@id=\"vendor_area\"]/div/div/div[2]/div/div/div/h4");
    String newPassword = Utility.getRandomPassword();
    //endregion

    public void pageCheck (){
        getDriver().get("https://automationpratice.com.br/my-account");
        getDriver().manage().window().maximize();

        Utility.located(dashboard, Duration.ofSeconds(10));
        WebElement check = getDriver().findElement(dashboard);
        Assert.assertTrue(check.isDisplayed());
    }

    //Página de perfil
    public void clickProfile(){
        getDriver().findElement(accountTab).click();
    }

    public void profilePage(){
        Utility.located(updateGoButton, Duration.ofSeconds(10));
        WebElement button = getDriver().findElement(updateGoButton);
        Assert.assertTrue(button.isDisplayed());
    }

    public void clickGoUpdate(){
        getDriver().findElement(updateGoButton).click();
    }

    //Atualização de dados
    public void updatePage(){
        Utility.located(updatePage, Duration.ofSeconds(10));
        WebElement header = getDriver().findElement(updatePage);
        Assert.assertTrue(header.isDisplayed());
    }

    public void addGender (Integer type){
        if (type == 1){
            WebElement click = getDriver().findElement(mr);
            Utility.clickButton(click);
        } else if (type == 2) {
            WebElement click = getDriver().findElement(mrs);
            Utility.clickButton(click);
        }
    }

    public void addFirstName(){
        getDriver().findElement(firstName).sendKeys(Utility.name.getRandomFirstName());
    }

    public void addLastName(){
        getDriver().findElement(lastName).sendKeys(Utility.name.getRandomLastName());
    }

    public void addEmail(){
        getDriver().findElement(emailAddress).sendKeys(Utility.getRandomEmail());
    }

    public void addCurrentPassword (String password){
        getDriver().findElement(cPassword).sendKeys(password);
    }

    public void addNewPassword(){
        getDriver().findElement(nPassword).sendKeys(newPassword);
    }

    public void retypeNewPassword () {
        getDriver().findElement(rPassword).sendKeys(newPassword);
    }

    public void addImage (String pathFile){
        getDriver().findElement(uploadImage).sendKeys(pathFile);
    }

    public void clickUpdateButton () {
        WebElement button = getDriver().findElement(saveUpdate);
        Utility.clickButton(button);
    }

    public void successUpdate(){
        //O site de prática não atualiza os dados; para checar o update, apenas confirmei a página
        Utility.located(profileHeader, Duration.ofSeconds(10));
        String header = getDriver().findElement(profileHeader).getText();
        Assert.assertTrue(header.contains("Profile"));
    }

    //Cadastro com sucesso
    public void checkRegisterPopup(){
        Utility.located(button, Duration.ofSeconds(10));
        String text = getDriver().findElement(popupText).getText();
        Assert.assertTrue(text.contains(nameCheck));
    }

    public void checkRegister(){
        Utility.located(dashboard, Duration.ofSeconds(10));
        String check = getDriver().findElement(headerCheck).getText();
        Assert.assertTrue(check.contains(nameCheck));
    }

    //Login com sucesso
    public void checkLoginPopup(){
        Utility.located(button, Duration.ofSeconds(10));
        String text = getDriver().findElement(popupText).getText();
        Assert.assertTrue(text.contains(emailCheck));
    }

    public void checkLogin(){
        Utility.located(dashboard, Duration.ofSeconds(10));
        String check = getDriver().findElement(headerCheck).getText();
        Assert.assertTrue(check.contains(emailCheck));
    }

    //Botão do popup
    public void button(){
        getDriver().findElement(button).click();
    }

}
