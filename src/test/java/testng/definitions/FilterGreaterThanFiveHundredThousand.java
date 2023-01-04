package testng.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testng.utils.HelperClass;
import java.time.Duration;

public class FilterGreaterThanFiveHundredThousand {
    WebDriver driver ;
    private final By dropdownList = By.xpath("/html/body/main/div[1]/div/div[1]/div/div/div[2]/div[2]/form/div[1]/button/i");
    private final By sale = By.xpath("/html/body/main/div[1]/div/div[1]/div/div/div[2]/div[2]/form/div[1]/ul/li[2]/button");
    private final By search = By.xpath("/html/body/main/div[1]/div/div[1]/div/div/div[2]/div[2]/form/div[4]/input");
    private final By price = By.xpath("/html/body/main/div/div[1]/div/div[2]/div[1]/div/div/div[1]/button");
    private final By text = By.xpath("/html/body/main/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div/form/div[1]/label/input");
    private final By PriceHouse = By.xpath("/html/body/main/div/div[1]/div/div[3]/div/div[2]/div/div/div[1]/div/div[2]/a/div[2]/div/span[1]");

    @Given("User is on home page {string}")
    public void user_is_on_home_page(String url) {
        HelperClass.openPage(url);
        driver = HelperClass.getDriver();
        driver.findElement(By.cssSelector(".css-oygwkp")).click();

    }
    @And("And I select the sale from dropdown list")
    public void and_i_select_the_sale_from_dropdown_list() {
        driver = HelperClass.getDriver();
        //We click on the tab we want
        driver.findElement(By.cssSelector("#property-tab")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(dropdownList).click();
    }
    @And("I click on the button search")
    public void i_click_on_the_button_search() {
        driver = HelperClass.getDriver();
        driver.findElement(sale).click();
        driver.findElement(search).click();
    }
    @And("I click on the price filter")
    public void i_click_on_the_price_filter() {
        driver = HelperClass.getDriver();
        driver.findElement(price).click();
    }
    @When("^I press enter on the keyboard with (.*)$")
    public void i_press_on_the_keyboard(String price) {
        driver = HelperClass.getDriver();
        //Compare numbers
        String prices= price;
        WebElement element_enter = driver.findElement(text);
        element_enter.sendKeys(prices);
        element_enter.sendKeys(Keys.ENTER);
    }
    @Then("^the price is greater than (.*)$")
    public void the_price_is_greater_than(Integer price) {
        driver = HelperClass.getDriver();
        WebElement e = driver.findElement(PriceHouse);
        System.out.println("First search is " +e.getText());
        String str = e.getText();
        str = str.replace(" €", "");
        str = str.replace(".", "");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        int a = Integer.parseInt(str);

        if(a<price){
            throw new ArithmeticException("Then the price is smaller than "+ price);
        }
    }
}
