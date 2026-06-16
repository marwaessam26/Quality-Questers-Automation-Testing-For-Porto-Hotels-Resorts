package Mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class RestaurantsPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public RestaurantsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
    }



    By hotelsAndResortsMenu =
            By.xpath("(//span[@data-link-text='HOTELS & RESORTS'])[2]");

    By ainSokhna =
            By.xpath("(//span[@data-link-text='AIN SOKHNA'])[2]");

    By portoSokhna =
            By.xpath("//a[@data-target-page-alias='sokhna---home']");

    By restaurantsTab =
            By.xpath("//a[@href='/sokhna-hotel/restaurants']");

    // أسماء المطاعم الموجودة فعلاً في الصفحة: Capri, I-Cafe, La Bistro Lounge, In-room Dining
    // اسم أول مطعم - Blue Marine Restaurant
    By restaurantNames =
            By.xpath("//div[@data-element-type='paragraph']//h2//span");


    By restaurantDescriptions =
            By.xpath("//div[@data-element-type='paragraph']//p[@class='text-align-justify'][string-length(normalize-space(.)) > 30]");



    public void navigateToPortoSokhna() {
        WebElement hotels = wait.until(
                ExpectedConditions.visibilityOfElementLocated(hotelsAndResortsMenu)
        );
        actions.moveToElement(hotels).perform();
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}

        WebElement sokhna = wait.until(
                ExpectedConditions.visibilityOfElementLocated(ainSokhna)
        );
        actions.moveToElement(sokhna).perform();
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}

        WebElement portoSokhnaLink = wait.until(
                ExpectedConditions.elementToBeClickable(portoSokhna)
        );
        actions.moveToElement(portoSokhnaLink).perform();
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", portoSokhnaLink);
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
    }

    public void clickRestaurantsTab() {
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}

        JavascriptExecutor js = (JavascriptExecutor) driver;


        for (int i = 0; i < 6; i++) {
            js.executeScript("window.scrollBy(0, 500)");
            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        }

        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(restaurantsTab)
        );
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        js.executeScript("arguments[0].click();", element);
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
    }

    public boolean isRestaurantsDisplayed() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            try { Thread.sleep(3000); } catch (InterruptedException ignored) {}

            System.out.println("Current URL: " + driver.getCurrentUrl());


            for (int i = 0; i < 12; i++) {
                js.executeScript("window.scrollBy(0, 300)");
                try { Thread.sleep(400); } catch (InterruptedException ignored) {}
            }

            java.util.List<WebElement> restaurants = driver.findElements(restaurantNames);

            if (restaurants.isEmpty()) {
                System.out.println("No restaurant names found!");
                return false;
            }

            System.out.println(" Found: " + restaurants.size() + " restaurants");
            restaurants.forEach(r -> System.out.println("   🍽️ " + r.getText().trim()));


            java.util.List<WebElement> descriptions = driver.findElements(restaurantDescriptions);

            if (descriptions.isEmpty()) {
                System.out.println(" No descriptions found!");
                return false;
            }

            System.out.println(" Description found: " + descriptions.get(0).getText().trim().substring(0, 50) + "...");

            return true;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Current URL: " + driver.getCurrentUrl());
            return false;
        }
    }
}