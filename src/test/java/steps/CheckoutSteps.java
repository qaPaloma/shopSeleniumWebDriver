package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.CheckoutPage;
import runner.RunCucumberTest;

public class CheckoutSteps extends RunCucumberTest {
    CheckoutPage checkoutPage = new CheckoutPage();


    @Dado("que estou na página de checkout")
    public void pageCheck(){
        checkoutPage.pageCheck();
    }

    //Dados de cobrança
    @Quando("adiciono meus dados de cobrança")
    public void addInfo(){
        checkoutPage.addFirstName("John");
        checkoutPage.addLastName("Doe");
        checkoutPage.addCompany("Acme Corporation");
        checkoutPage.addEmail();
        checkoutPage.addCountry(1);
        checkoutPage.addCity("Aland Islands");
        checkoutPage.addZipCode();
        checkoutPage.addAddress("323 Morissette Crescent");
        checkoutPage.addNote("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
    }

    @E("clico para salvar os meus dados")
    public void saveInfo(){
        checkoutPage.saveInBook();
        checkoutPage.clickSave();
    }

    @Então("meus dados foram salvos com sucesso")
    public void success(){
        checkoutPage.successBilling();
    }

    //Completar pedido

    @E("já preenchi meus dados de cobrança")
    public void billing(){
        addInfo();
        saveInfo();
        success();
    }

    @Quando("seleciono o método de pagamento")
    public void paymentMethod(){
        checkoutPage.paymentMethod(1);
    }

    @E("clico para realizar o pedido")
    public void placeOrder(){
        checkoutPage.placeOrder();
    }

    @Então("meu pedido é realizado com sucesso")
    public void successOrder(){
        checkoutPage.successOrder();
    }
}
