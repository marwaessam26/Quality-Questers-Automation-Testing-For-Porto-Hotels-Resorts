import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PortoPageTest extends BaseClass {

    private PortoPage portoPage;

    @Test
    public void verifyPortoHomepage(){
        portoPage = new PortoPage(driver);
        String pageTitle = portoPage.getPageTitle();
        Assert.assertTrue(pageTitle.contains("Porto Hotels & Resorts"),
                "The page title did not contain 'Porto Hotels & Resorts'. Actual title: " + pageTitle);

        List<String> navigationMenu = portoPage.getNavigationMenuTexts();

        Assert.assertTrue(navigationMenu.contains("HOTELS & RESORTS"), "Menu Missing: HOTELS & RESORTS");
        Assert.assertTrue(navigationMenu.contains("OFFERS"), "Menu Missing: OFFERS");
        Assert.assertTrue(navigationMenu.contains("EXPERIENCES"), "Menu Missing: EXPERIENCES");
        Assert.assertTrue(navigationMenu.contains("GALLERY"), "Menu Missing: GALLERY");

        boolean isButtonDisplayed = portoPage.isCheckAvailabilityByButtonDisplayed();
        Assert.assertTrue(isButtonDisplayed, "The 'Check Availability' button is NOT displayed on the page!");
    }
}