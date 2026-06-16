import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PortoMarinaPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public PortoMarinaPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.actions = new Actions(driver);
    }

    private final By hotelsMenu =
            By.cssSelector("span[data-link-text='HOTELS & RESORTS']");

    private final By northCoast =
            By.cssSelector("span[data-link-text='NORTH COAST']");

    private final By portoMarinaHotel =
            By.cssSelector("a[data-target-page-alias='marina-resort-home']");

    public void navigateToPortoMarina() {

        WebElement menu =
                wait.until(ExpectedConditions.presenceOfElementLocated(hotelsMenu));

        actions.moveToElement(menu).perform();

        WebElement coast =
                wait.until(ExpectedConditions.presenceOfElementLocated(northCoast));

        actions.moveToElement(coast).perform();

        WebElement marina =
                wait.until(ExpectedConditions.presenceOfElementLocated(portoMarinaHotel));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", marina);
    }
}