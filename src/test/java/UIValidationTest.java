import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class UIValidationTest {

Playwright playwright;
Browser browser;
Page page;
BrowserContext context;


    @BeforeMethod
    public void setUp() {

        playwright = Playwright.create();
        //browser = playwright.chromium().launch();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
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

       @Test
       public void UIControls() {

        Locator radioButton = page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("User"));
        radioButton.click();

        Locator okayButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Okay"));
        okayButton.click();

        Assert.assertTrue(radioButton.isChecked());

        Locator checkboxTerms = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("I Agree to the terms and conditions"));
        checkboxTerms.click();
        Assert.assertTrue(checkboxTerms.isChecked());

        Locator dropdownSelection = page.getByRole(AriaRole.COMBOBOX);
        dropdownSelection.selectOption("Teacher");

        page.waitForTimeout(3000);

    }
}
