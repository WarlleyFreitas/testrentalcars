package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    //Botão salvar Orçamento
    private By btnOrcamentoLocator = By.cssSelector("#gridSource div:nth-child(1) > li  a > span");

    //Campos para Orçamento
    private By textoSalvarOrcamentoLocator = By.cssSelector("#modalOrcamentoList > div > div > div > div > div > div.col-md-4.equal-height.budget-form > h4");
    private By campoNomeOrcamentoLocator = By.cssSelector("#nomeOrcamento");
    private By campoEmailOrcamentoLocator = By.cssSelector("#email");
    private By checkboxReceberEmailLocator = By.cssSelector("#receberEmail");
    private By btnSaveOrcamentoLocator = By.cssSelector("#saveOrcamento");
    private By textoOrcamentoEnviadoLocator = By.cssSelector("#modalOrcamentoList > div > div > div > div.col-sm-12 > div > div.col-md-4.budget-success > h4");

    private By btnOfertasLocator = By.cssSelector("#btClose");

    public SearchPage clickOnBtnOrcamento() {

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#alert-demand")));

        driver.findElement(btnOrcamentoLocator).click();
        return this;
    }

    public SearchPage enviarOrcamento(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#modalOrcamentoList > div > div > div > div " +
                " div > div.col-md-4.equal-height.budget-form > h4")));

        driver.findElement(campoNomeOrcamentoLocator).sendKeys("Warlley Freitas");
        driver.findElement(campoEmailOrcamentoLocator).sendKeys("wvff@cesar.school");
        driver.findElement(checkboxReceberEmailLocator).click();
        driver.findElement(btnSaveOrcamentoLocator).click();

        return this;
    }

    public String checkOrcamento(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#modalOrcamentoList > div > div > div > div.col-sm-12 > div > div.col-md-4.budget-success > h4")));

        String txt = driver.findElement(textoOrcamentoEnviadoLocator).getText();

        return txt;
    }


}
