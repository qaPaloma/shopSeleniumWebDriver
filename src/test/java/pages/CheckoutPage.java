package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import runner.RunCucumberTest;
import suport.Utility;
import java.time.Duration;

public class CheckoutPage extends RunCucumberTest {

    //region variables
    private final By pageHeader = By.xpath("//*[@id=\"checkout_one\"]/div/div/div[1]/div/div[1]/h3");
    private final By firstName = By.id("fname");
    private final By lastName = By.id("lname");
    private final By companyName = By.id("cname");
    private final By emailAddress = By.id("email");
    private final By country = By.id("country");
    private final By city = By.id("city");
    private final By zipCode = By.id("zip");
    private final By fullAddress = By.id("faddress");
    private final By additionalNotes = By.id("messages");
    private final By saveAddressBook = By.id("materialUnchecked");
    private final By saveButton = By.xpath("//*[@id=\"checkout_one\"]/div/div/div[1]/div/button");
    private final By success = By.xpath("//*[@id=\"checkout_one\"]/div/div/div[1]/div/div[2]/h3");
    private final By orderPopup = By.xpath("/html/body/div[3]/div/div/div/div/div/div/div[2]/div/div[1]/div/h2");
    private final By methodTransfer = By.id("html");
    private final By methodBank = By.id("javascript");
    private final By methodPayPal = By.id("css");
    private final By orderButton = By.xpath("//*[@id=\"checkout_one\"]/div/div/div[2]/div[2]/button");
    //endregion

    public void pageCheck (){
        getDriver().get("https://automationpratice.com.br/checkout-one");
        getDriver().manage().window().maximize();

        Utility.located(pageHeader, Duration.ofSeconds(10));
        WebElement productCheck = getDriver().findElement(pageHeader);
        Assert.assertTrue(productCheck.isDisplayed());
    }

    //Cadastro de informações de cobrança

    public void addFirstName(String fName){
        getDriver().findElement(firstName).sendKeys(fName);
    }

    public void addLastName(String lName){
        getDriver().findElement(lastName).sendKeys(lName);
    }

    public void addCompany(String company){
        getDriver().findElement(companyName).sendKeys(company);
    }

    public void addEmail(){
        getDriver().findElement(emailAddress).sendKeys(Utility.getRandomEmail());
    }

    public void addCountry(Integer countryName){
        Select selectCountry = new Select(getDriver().findElement(country));
        selectCountry.selectByIndex(countryName);
    }

    public void addCity(String cityName){
        Select selectCity = new Select(getDriver().findElement(city));
        selectCity.selectByVisibleText(cityName);
    }

    public void addZipCode(){
        getDriver().findElement(zipCode).sendKeys(Utility.getRandomNumber());
    }

    public void addAddress(String address){
        getDriver().findElement(fullAddress).sendKeys(address);
    }

    public void addNote(String note){
        getDriver().findElement(additionalNotes).sendKeys(note);
    }

    //Botões Cobrança

    public void saveInBook(){
        WebElement check = getDriver().findElement(saveAddressBook);
        Utility.clickButton(check);
    }

    public void clickSave(){
       WebElement click = getDriver().findElement(saveButton);
       Utility.clickButton(click);
    }

    public void successBilling(){
        WebElement registrationCompleted = getDriver().findElement(success);
        Assert.assertTrue(registrationCompleted.isDisplayed());
    }

    //Completar pedido

    public void paymentMethod(Integer type){
        Utility.located(orderButton, Duration.ofSeconds(10));
        if (type == 1){
            WebElement click = getDriver().findElement(methodTransfer);
            Utility.clickButton(click);
        } else if (type == 2) {
            WebElement click = getDriver().findElement(methodBank);
            Utility.clickButton(click);
        } else if (type == 3) {
            WebElement click = getDriver().findElement(methodPayPal);
            Utility.clickButton(click);
        }
    }

    public void placeOrder(){
        WebElement click = getDriver().findElement(orderButton);
        Utility.clickButton(click);
    }

    public void successOrder(){
        Utility.located(orderPopup, Duration.ofSeconds(10));
        WebElement orderCompleted = getDriver().findElement(orderPopup);
        Assert.assertTrue(orderCompleted.isDisplayed());
    }














}
