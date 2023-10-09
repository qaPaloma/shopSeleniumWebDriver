package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import runner.RunBase;
import suport.Utility;
import java.time.Duration;

public class RegistrationPage extends RunBase {

    //region variables
    private final By registerButton = By.id("btnRegister");
    private final By user = By.id("user");
    private final By email = By.id("email");
    private final By passwordField = By.id("password");
    public static String name = Utility.name.getRandomName();
    //endregion

    public void pageCheck (){
        Utility.located(registerButton, Duration.ofSeconds(10));
        WebElement registerCheck = getDriver().findElement(registerButton);
        Assert.assertTrue(registerCheck.isDisplayed());
    }

    public void addName(){
        Utility.located(user, Duration.ofSeconds(10));
        getDriver().findElement(user).sendKeys(name);
    }

    public void addEmail(){
        getDriver().findElement(email).sendKeys(Utility.getRandomEmail());
    }

    public void addPassword(){
        getDriver().findElement(passwordField).sendKeys(Utility.getRandomPassword());
    }

    public void clickButton(){
        getDriver().findElement(registerButton).click();

    }

}
