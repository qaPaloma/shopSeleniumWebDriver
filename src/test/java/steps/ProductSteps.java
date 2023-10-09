package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.ProductPage;
import runner.RunCucumberTest;

public class ProductSteps extends RunCucumberTest {
    ProductPage productPage = new ProductPage();


    //Adicionar produto no carrinho
    @Dado("que estou na página do produto")
    public void pageProduct(){
        productPage.pageCheck();
    }

    @E("seleciono o tamanho")
    public void sizeXL(){
        productPage.size("xl");
    }

    @Quando("clico em Add to cart")
    public void addButton(){
        productPage.addCartButton();
    }

    @Então("o produto é adicionado com sucesso no carrinho")
    public void addedSuccess(){
        productPage.addedSuccess();
    }
}
