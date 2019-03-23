package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import util.Environment;

public class HomeSteps {

    WebDriver driver = Environment.driver;
    private HomePage homePage = new HomePage(driver);

    @Given("que o web browser esta na página home da rentcars")
    public void que_o_web_browser_esta_na_página_home_da_rentcars() {
        homePage.accessPage();
        Assert.assertEquals("https://www.rentcars.com/pt-br/", driver.getCurrentUrl());
    }

    @Given("que o usuário insere {string} no campo de busca")
    public void que_o_usuário_insere_no_campo_de_busca(String string) {
        homePage.preencheCampoLocalidade(string);

        homePage.preencheCampoDataRetirada();
        homePage.preencheCampoHoraRetirada();

        homePage.preencheCampoDataDevolucao();
        homePage.preencheCampoHoraDevolucao();
    }

    @When("o usuário clicar no botão Pesquisar")
    public void o_usuário_clicar_no_botão_Pesquisar() {
       homePage.clickOnPesquisar();

    }

    @Then("a página para a busca realizada é exibida")
    public void uma_lista_de_carros_é_exibida_para_a_localidade_desejada() {
        Assert.assertTrue(homePage.verificarPesquisa());
    }

    @Then("um alerta é exibido indicando que o campo é obrigatório")
    public void um_alerta_é_exibido_indicando_que_o_campo_é_obrigatório() {
        Assert.assertEquals("Insira as 3 primeiras letras e aguarde para ver os resultados", homePage.getAlertMessage());
    }


    @Given("que o usuário acessa a opção de unidade monetária")
    public void que_o_usuário_acessa_a_opção_de_unidade_monetária() {
        homePage.clickOnDropdownCurrency();
    }

    @When("o usuário alterar a unidade monetária para Libra Esterlina")
    public void o_usuário_alterar_a_unidade_monetária_para_Libra_Esterlina() {
        homePage.selectCurrency();
    }

    @Then("os valores exibidos na página devem refletir a moeda selecionada")
    public void os_valores_exibidos_na_página_devem_refletir_a_moeda_selecionada() {
        Assert.assertTrue(homePage.checkCurrencyChange());

    }

    @Given("que o usuário acessa a opção de FAQ")
    public void que_o_usuário_acessa_a_opção_de_FAQ() {
        Assert.assertEquals("https://www.rentcars.com/pt-br/faq", homePage.clickOnFaqOption());
    }

    @When("o usuário acessar os requisitos para alugar um carro no Brasil no menu lateral esquerdo")
    public void o_usuário_acessar_os_requisitos_para_alugar_um_carro_no_Brasil_no_menu_lateral_esquerdo() {
        Assert.assertTrue(homePage.acessarMenu().contains("Requisitos para Alugar Carro no Brasil"));
    }


    @Then("a opção escolhida é exibida na página")
    public void a_opção_escolhida_é_exibida_na_página() {
        Assert.assertTrue(homePage.checkResposta());
    }


}
