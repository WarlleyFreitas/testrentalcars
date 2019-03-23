package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private String pageUrl = "https://www.rentcars.com/pt-br/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //###Element Locators###
    private By campoPesquisarLocator = By.cssSelector("#SuggestPickup");
    private By retornoLocator = By.cssSelector("#ui-id-11");
    private By btnPesquisarLocator = By.cssSelector("#submitPesquisa");

    //Data e Hora de retirada
    private By campoDataRetiradaLocator = By.cssSelector("#DataRetirada");
    private By campoHoraRetiradaLocator = By.cssSelector("#HoraRetirada");
    private By listaHoraRetiradaLocator = By.cssSelector("#HoraRetirada option:nth-child(18)");

    //01/03/2019
    private By dataRetiradaLocator =
            By.cssSelector("#ui-datepicker-div > div.ui-datepicker-group.ui-datepicker-group-last > table > tbody > tr:nth-child(1) > td:nth-child(6) > a");

    //Data e Hora de devolução
    private By campoDataDevolucaoLocator = By.cssSelector("#DataDevolucao");
    private By campoHoraDevolucaoLocator = By.cssSelector("#HoraDevolucao");
    private By listaHoraDevolucaoLocator = By.cssSelector("#HoraDevolucao option:nth-child(18)");

    //08/03/2019
    private By dataDevolucaoLocator =
            By.cssSelector("#ui-datepicker-div > div.ui-datepicker-group.ui-datepicker-group-first > table > tbody > tr:nth-child(2) > td:nth-child(6) > a");

    //Banners
    private By bannerLocalidadeLocator = By.cssSelector("#alert-demand .alert-content");
    private By bannerTitleLocator = By.cssSelector("#alert-demand .alert-title");

    //Mensagem de alerta - campo de pesquisa não preenchido
    private By alertLocator = By.cssSelector(".bubble");

    //Lista de moedas
    private By dropdownCurrencyLocator = By.cssSelector("#dropdown-currency span");

    //Libra esterlina
    private By currencyLocator = By.cssSelector("#i18nContainer > div > div + div > div > ul > li:nth-child(13)");

    //Banner destino SP - Brasil
    private By currencyCheckLocator = By.cssSelector("#destination-vue-container > div:nth-child(1) > div > div:nth-child(2) " +
            "> div.wrapper-destination-list > ul > li:nth-child(1) > a > span.price-from > span");


    //Botão FAQ
    private By faqButtonLocator = By.cssSelector("#faq > div > div > a");

    //Campo de pesquisa do FAQ
    private By faqSearchLocator = By.cssSelector("#tags");
    private By menuLocator = By.cssSelector("#sidebar-fixed > nav > ul > li + li > a[href=\"/pt-br/faq/requisitos-para-alugar-carro-no-brasil\"]");
    private By infoLocator = By.cssSelector("#requisitos-para-alugar-carro-no-brasil > div > h1");
    private By expandRequisitosLocator = By.cssSelector("#box-faq-suggestions > ul > li + li > span > span " +
            "+ a[href=\"/pt-br/faq/requisitos-para-alugar-carro-no-brasil/quais-sao-os-requisitos-para-alugar-um-carro-no-brasil\"]");

    //###Interações###
    public HomePage accessPage() {
        driver.get(this.pageUrl);
        return this;
    }

    public HomePage preencheCampoLocalidade(String texto) {
        driver.findElement(campoPesquisarLocator).sendKeys(texto);
        return this;
    }

    public HomePage preencheCampoDataRetirada() {
        WebElement calendarBox = driver.findElement(campoDataRetiradaLocator);
        calendarBox.click();

        WebElement datePicker = driver.findElement(dataRetiradaLocator);
        datePicker.click();

        return this;
    }

    public HomePage preencheCampoHoraRetirada() {
        driver.findElement(campoHoraRetiradaLocator).click();
        driver.findElement(listaHoraRetiradaLocator).click();
        return this;
    }

    public HomePage preencheCampoDataDevolucao() {
        WebElement calendarBox = driver.findElement(campoDataDevolucaoLocator);
        calendarBox.click();

        WebElement datePicker = driver.findElement(dataDevolucaoLocator);
        datePicker.click();

        return this;
    }

    public HomePage preencheCampoHoraDevolucao() {
        driver.findElement(campoHoraDevolucaoLocator).click();
        driver.findElement(listaHoraDevolucaoLocator).click();
        return this;
    }

    public HomePage clickOnPesquisar() {
        driver.findElement(btnPesquisarLocator).click();
        return this;
    }

    public boolean verificarPesquisa() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#alert-demand")));

        String localidade = driver.findElement(bannerLocalidadeLocator).getText();
        String title = driver.findElement(bannerTitleLocator).getText();

        if (localidade.contains("Recife") || title.contains("Recife")) {
            return true;
        } else {
            return false;
        }
    }

    public String getAlertMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bubble")));
        String msg = driver.findElement(alertLocator).getText();

        return msg;
    }

    public HomePage clickOnDropdownCurrency(){
        driver.findElement(dropdownCurrencyLocator).click();
        return this;
    }

    public HomePage selectCurrency(){
        driver.findElement(currencyLocator).click();
        return this;
    }

    public boolean checkCurrencyChange(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(currencyCheckLocator));

        String simbol = driver.findElement(dropdownCurrencyLocator).getText();
        String currencyCheck = driver.findElement(currencyCheckLocator).getText();

        if ((simbol.compareTo("£") == 0) && (currencyCheck.compareTo("£") == 0)){
            return true;
        }else {
            return false;
        }
    }

    public String clickOnFaqOption(){
        String winHandleBefore = driver.getWindowHandle();
        driver.findElement(faqButtonLocator).click();

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("https://www.rentcars.com/pt-br/faq"));
        return driver.getCurrentUrl();
    }

    public String acessarMenu() {
        WebDriverWait waitResponse = new WebDriverWait(driver, 10);
        waitResponse.until(ExpectedConditions.visibilityOfElementLocated(menuLocator));

        driver.findElement(menuLocator).click();
        return driver.findElement(infoLocator).getText();
    }

    public boolean checkResposta(){
        if (driver.findElement(expandRequisitosLocator).isDisplayed()){
            return true;
        }else{
            return false;
        }
    }

}