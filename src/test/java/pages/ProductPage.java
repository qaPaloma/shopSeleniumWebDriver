package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import runner.RunBase;
import suport.Utility;
import java.time.Duration;

public class ProductPage extends RunBase {

    //region variables
    private final By sizeSelect = By.xpath("//*[@id=\"product_single_one\"]/div/div[1]/div[2]/div/div/div[2]/select");
    private final By addButton = By.xpath("//*[@id=\"product_single_one\"]/div/div[1]/div[2]/div/div/div[4]/a");
    private final By popupSuccess = By.id("swal2-title");
    //endregion

    public void pageCheck (){
        getDriver().get("https://automationpratice.com.br/product-details-one/1");
        getDriver().manage().window().maximize();

        Utility.located(addButton, Duration.ofSeconds(10));
        WebElement productCheck = getDriver().findElement(addButton);
        Assert.assertTrue(productCheck.isDisplayed());
    }

    //Tamanho

    public void size (String size){
        Select selectSize = new Select(getDriver().findElement(sizeSelect));
        selectSize.selectByValue(size);
    }

    //Adicionar no carrinho

    public void addCartButton(){
        Utility.located(addButton, Duration.ofSeconds(10));
        getDriver().findElement(addButton).click();
    }

    public void addedSuccess(){
        Utility.located(popupSuccess, Duration.ofSeconds(10));
        WebElement success = getDriver().findElement(popupSuccess);
        Assert.assertTrue(success.isDisplayed());
    }

}
