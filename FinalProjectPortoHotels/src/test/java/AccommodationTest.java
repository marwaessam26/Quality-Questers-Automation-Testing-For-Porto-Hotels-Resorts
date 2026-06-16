import org.testng.annotations.Test;

public class AccommodationTest extends BaseClass {

    @Test
    public void verifyAccommodationPage() {

        driver.get(
                "https://www.portohotelseg.com/marina-Hotel/accommodation");

        MarinaHotelPage accommodation =
                new MarinaHotelPage(driver, wait);

        accommodation.verifyAccommodationPage();
    }
}