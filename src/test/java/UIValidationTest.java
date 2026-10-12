import com.microsoft.playwright.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UIValidationTest {

Playwright playwright;
Browser browser;
Page page;
BrowserContext context;


    @BeforeMethod
    public void setUp() {

        playwright = Playwright.create();
        browser = playwright.chromium().launch();
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://rahulshettyacademy.com/loginpagePractise/");
    }

    @Test
    public void ChildWindowHandle() {

       Locator blinkingTexts = page.locator(".blinkingText");

       Page newPage = context.waitForPage(() -> blinkingTexts.first().click());
       newPage.waitForLoadState();
       String childText = newPage.locator(".red").textContent();
       String emailId = childText.split("at ")[1].split(" ")[0];
       System.out.println(emailId);

    }
}
