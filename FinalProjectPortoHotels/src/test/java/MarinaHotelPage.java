import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class MarinaHotelPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MarinaHotelPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    private final By roomNames =
            By.cssSelector("h2");

    private final By roomImages =
            By.cssSelector("img[data-dm-image-path]");

    private final By bookButtons =
            By.xpath("//span[normalize-space()='BOOK NOW']");

    public void verifyAccommodationPage() {

        List<WebElement> rooms = driver.findElements(
                By.xpath("//h2//strong[contains(@class,'font-size-36')]"));

        long validRooms = rooms.stream()
                .filter(WebElement::isDisplayed)
                .map(WebElement::getText)
                .filter(text -> !text.trim().isEmpty())
                .count();

        Assert.assertTrue(validRooms > 0,
                "No room types displayed.");

        List<WebElement> images =
                driver.findElements(
                        By.cssSelector("img[data-dm-image-path]"));

        Assert.assertTrue(images.size() > 0,
                "No room images found.");

        List<WebElement> bookButtons =
                driver.findElements(
                        By.xpath("//span[normalize-space()='BOOK NOW']"));

        Assert.assertTrue(bookButtons.size() > 0,
                "No BOOK NOW buttons found.");

        System.out.println("Rooms Found: " + validRooms);
    }

}