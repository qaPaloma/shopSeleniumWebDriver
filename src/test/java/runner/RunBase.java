package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RunBase {
    static WebDriver driver;

    public enum Browser {CHROME, FIREFOX, EDGE}

    //Se o browser não estiver aberto, abre um novo browser. Se ele já estiver aberto, só retorna o
    // driver que já está sendo executado
    public static WebDriver getDriver(){

        if (driver == null){
            return getDriver(Browser.CHROME);
        } else {
            return driver;
        }
    }

    //Executa quando o getDriver define um browser. if fecha o navegador após o cenário ser concluído
    public static WebDriver getDriver(Browser browser){

        if (driver != null){
            driver.quit();
        }

        switch (browser){
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Passe um navegador válido");
        }
        return driver;
    }

}
