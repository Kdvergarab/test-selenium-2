package stepsDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class SearchGoogleDefinition {

    // Defined ChromeDriver
    private RemoteWebDriver driver;

    @Given("Load Google website")
    public void loadGoogleWebsite() throws InterruptedException, MalformedURLException {
        // Driver locate
        //System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        // Constructor
        //driver = new ChromeDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "109.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        driver = new RemoteWebDriver(new URL("http://192.168.1.161:4444/wd/hub"), capabilities);
        // Load home page
        driver.get("https://www.google.com/");
        // Window maximize
        //driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    // TestCase 1

    @When("Look up the word Delfin")
    public void lookUpTheWordDelfin() throws InterruptedException {
        // WebElement
        WebElement inputSearch = driver.findElement(By.name("q"));
        // Method
        inputSearch.clear();
        inputSearch.sendKeys("Delfin");
        inputSearch.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }
    @Then("Result is displayed Delfin")
    public void resultIsDisplayedDelfin() {
        // Validate search
        String title = driver.getTitle();
        // Assert
        Assert.assertEquals(title,"Delfin - Buscar con Google");
        driver.close();
    }

    // TestCase 2

    @When("Look up the word Cat")
    public void look_up_the_word_Cat() throws InterruptedException {
        // WebElement
        WebElement inputSearch = driver.findElement(By.name("q"));
        // Method
        inputSearch.clear();
        inputSearch.sendKeys("Gato");
        inputSearch.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }
    @Then("Result is displayed Cat")
    public void result_is_displayed_Cat() {
        // Validate search
        String title = driver.getTitle();
        // Assert
        Assert.assertEquals(title,"Gato - Buscar con Google");
        driver.close();
    }
}
