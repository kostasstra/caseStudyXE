package testng.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testng.utils.HelperClass;

import java.time.Duration;
import java.util.NoSuchElementException;

public class SelectLandForSaleApplyPlotFilterSaveSearch {
    WebDriver driver;
    WebDriverWait wait ;
    @Given("User is on the second home page {string}")
    public void user_is_on_the_second_home_page(String url) {
        HelperClass.openPage(url);
        driver = HelperClass.getDriver();
        //The cookies banner obstructs our test here so we have to close it
        closeCookiesBannerIfPresent();

    }
    @And("I click on the land for sale")
    public void i_click_on_the_land_for_sale() {
        driver = HelperClass.getDriver();
        //Select land for sale
        driver.findElement(By.cssSelector("a[href*='poliseis-gis-oikopedon']")).click();


    }
    @And("I click on the search with button")
    public void i_click_on_the_search_with_button() {
        driver = HelperClass.getDriver();
        //Perform the search
        driver.findElement(By.cssSelector("input[class='button-property redesigned']")).click();

    }
    @And("I click on the save search")
    public void i_click_on_the_save_search() {
        driver = HelperClass.getDriver();
        //Click to save the search
        driver.findElement(By.cssSelector("[data-testid='save-search-btn']")).click();

    }
    @And("^I click on the login with (.*) and (.*)$")
    public void i_click_on_the_login_with_username_and_password(String username, String password) {
        driver = HelperClass.getDriver();
        //Click to connect
        driver.findElement(By.cssSelector("a[class='button-property external-link-button text-center']")).click();
        //Close cookies
        closeCookiesBannerIfPresent();
        //Wait for username to be visible and fill it in
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
        driver.findElement(By.cssSelector("input#email")).sendKeys(username);
        //Fill in password
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        //Click to connect
        driver.findElement(By.cssSelector(".login_button span")).click();
        driver = HelperClass.getDriver();
    }
    @When("search existed delete it")
    public void search_existed_delete_it() {
        driver = HelperClass.getDriver();
        //Delete search
        deleteSearchIfdisplayed();
        //Click to back
        driver.navigate().back();
        //Click to back page
        driver.navigate().back();
    }
    @Then("Then search is saved")
    public void then_search_is_saved() {
        driver = HelperClass.getDriver();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='save-search-btn']")));
        driver.findElement(By.cssSelector("[data-testid='save-search-btn']")).click();

        //Deal with the save search pop-up
        saveSearchDoNothingIfAlreadySaved();
    }

    public void closeCookiesBannerIfPresent(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".css-oygwkp")));
        if(driver.findElements(By.cssSelector(".css-oygwkp")).size()>0)
            driver.findElement(By.cssSelector(".css-oygwkp")).click();
    }

    /*
     * Clicks to save search in the save search pop up and then closes it.
     * If no pop-up is present then it does nothing.
     */
    public void saveSearchDoNothingIfAlreadySaved(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.button-property")));

        //Change css selector from input.button-property to  button-property redesigned
        if(driver.findElements(By.cssSelector("input.button-property")).size()>0) {

            //Save the search
            driver.findElement(By.cssSelector("input.button-property")).click();
            //Close the success modal
            driver.findElement(By.cssSelector(".xe-modal-close .xe.xe-close")).click();
        }else{
            System.out.println("Then search isn't saved");
        }
    }

    public void deleteSearchIfdisplayed(){

        //check if I have save search
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='user-info-label']")));
        driver.findElement(By.cssSelector("div[class='user-info-label']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='pu_img_container']")));
        driver.findElement(By.cssSelector("div[class='pu_img_container']")).click();


        try{
            while(true) {
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .ignoring(NoSuchElementException.class, InvalidSelectorException.class)
                        .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/fieldset/div/table/tbody/tr[3]/td[2]/a"))))
                        .getText();

                WebElement strvalue = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/fieldset/div/table/tbody/tr[3]/td[2]/a"));

                String expected = "Πωλήσεις εκτάσεων γης";
                String actual = strvalue.getText();
                //System.out.println(actual);

                if(expected.equals(actual)){
                    driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/fieldset/div/table/tbody/tr[3]/td[5]/a")).click();
                    driver.findElement(By.xpath("/html/body/div[7]/div/div[3]/button[2]")).click();
                }
            }
        } catch (Exception ignored){

        }
    }


}
