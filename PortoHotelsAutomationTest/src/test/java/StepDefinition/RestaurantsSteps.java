package StepDefinition;

import Hooks.hooks;
import Mypackage.RestaurantsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RestaurantsSteps {

    RestaurantsPage restaurantsPage;

    @Given("User navigates to Porto Sokhna Hotel & Spa")
    public void user_navigates_to_porto_sokhna_hotel_and_spa()
            throws InterruptedException {
        hooks.driver.get("https://www.portohotelseg.com/");
        Thread.sleep(3000);
    }

    @When("User clicks on Restaurants tab")
    public void user_clicks_on_restaurants_tab()
            throws InterruptedException {
        restaurantsPage = new RestaurantsPage(hooks.driver); // ← السطر ده ناقص
        restaurantsPage.navigateToPortoSokhna();
        Thread.sleep(2000);
        restaurantsPage.clickRestaurantsTab();
        Thread.sleep(2000);
    }

    @Then("At least one restaurant should be displayed with name and description")
    public void at_least_one_restaurant_should_be_displayed_with_name_and_description() {
        Assert.assertTrue(
                restaurantsPage.isRestaurantsDisplayed(),
                "No restaurants found with name and description!"
        );
    }
}