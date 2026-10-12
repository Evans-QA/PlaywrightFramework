import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;

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

        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));


        page = context.newPage();
        page.navigate("https://rahulshettyacademy.com/loginpagePractise/");
    }

    @AfterMethod
    public void tearDown() {
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
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
