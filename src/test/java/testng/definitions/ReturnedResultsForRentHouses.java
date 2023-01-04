package testng.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testng.utils.HelperClass;

import java.time.Duration;

public class ReturnedResultsForRentHouses {
    WebDriver driver ;
    private final By btnSearch = By.xpath("/html/body/main/div[1]/div/div[1]/div/div/div[2]/div[2]/form/div[4]/input");
    private final By btnFirstSearch = By.xpath("/html/body/main/div/div[1]/div[1]/div[3]/div/div[2]/div/div/div[1]/div/div[1]/a/div/div/div/div/div[2]/div/div/img");


    @Given("User is on the home page {string}")
    public void user_is_on_the_home_page(String url) {
        HelperClass.openPage(url);
        driver = HelperClass.getDriver();
        driver.findElement(By.cssSelector(".css-oygwkp")).click();
    }
    @And("I click on the real estate")
    public void i_click_on_the_real_estate() {
        driver = HelperClass.getDriver();
        //We click on the tab we want
        driver.findElement(By.cssSelector("#property-tab")).click();
    }
    @When("I click on the search")
    public void i_click_on_the_search() {
        driver = HelperClass.getDriver();
        //We click on the search button
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(btnSearch).click();
    }
    @Then("I click on the first search")
    public void i_click_on_the_first_search() {
        driver = HelperClass.getDriver();
        try{
            WebElement element = driver.findElement(btnFirstSearch);

            if(isDisplayed(element) && isEnabled(element)){
                //We click on the first search
                element.click();
            }
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }


}
