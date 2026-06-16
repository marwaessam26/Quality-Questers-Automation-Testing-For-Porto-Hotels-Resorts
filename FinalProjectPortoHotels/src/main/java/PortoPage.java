import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class PortoPage {

    private WebDriver driver;

    private By navigationMenuItems = By.cssSelector("ul.unav-top > li[data-depth='0'] > a .nav-item-text");;
    private By checkAvailabilityButton = By.xpath("//button[@class='section-submit_wrap'][1]");


    public PortoPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle(){
        return driver.getTitle();
    }
    public List<String> getNavigationMenuTexts() {
        List<WebElement> elements = driver.findElements(navigationMenuItems);
        List<String> textList = new ArrayList<>();

        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                textList.add(element.getText().trim());
            }
        }

        return textList;
    }

    public boolean isCheckAvailabilityByButtonDisplayed(){
        return driver.findElement(checkAvailabilityButton).isDisplayed();
    }

}