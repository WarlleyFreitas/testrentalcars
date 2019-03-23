package util;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Environment {

    public static WebDriver driver = new ChromeDriver();

    @Before
    public void beforeScenario(){
        System.setProperty("webdriver.chrome.driver",
                "W:\\Pós Graduação Testes Ageis\\Testes de Sistema\\chromedriver.exe");

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @After
    public void afterScenario(){
        this.driver.quit();
    }
}
