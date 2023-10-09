package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import runner.RunBase;
import suport.Utility;
import java.time.Duration;

public class HomePage extends RunBase {

    //region variables
    private final By login = By.xpath("//*[@id=\"top_header\"]/div/div/div[2]/div/ul/li[1]/a");
    private final By registration = By.xpath("//*[@id=\"top_header\"]/div/div/div[2]/div/ul/li[2]/a");
    //endregion

    public void pageCheck (){
        getDriver().get("https://automationpratice.com.br/");
        getDriver().manage().window().maximize();

        String title = getDriver().getTitle();
        Assert.assertEquals("QAZANDO Shop E-Commerce", title);
    }

    public void clickLogin (){
        Utility.located(login, Duration.ofSeconds(10));
        getDriver().findElement(login).click();
    }

    public void clickRegister (){
        Utility.located(registration, Duration.ofSeconds(10));
        getDriver().findElement(registration).click();
    }

}
