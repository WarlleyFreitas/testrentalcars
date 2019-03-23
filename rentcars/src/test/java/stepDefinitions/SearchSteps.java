package stepDefinitions;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;
import util.Environment;

public class SearchSteps {

    WebDriver driver = Environment.driver;
    private SearchPage searchPage = new SearchPage(driver);

    @Then("o usuário pode optar por um orçamento sugerido")
    public void o_usuário_pode_escolher_um_orçamento_sugerido() {
        searchPage.clickOnBtnOrcamento();
        searchPage.enviarOrcamento();
        Assert.assertEquals("ORÇAMENTO ENVIADO", searchPage.checkOrcamento());
    }
}
