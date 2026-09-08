import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;


import static org.testng.Assert.assertEquals;

public class BasicTest {

    @Test
    public void DemoTest() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
       //Browser browser = playwright.chromium().launch();
        //Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://eventhub.rahulshettyacademy.com/");
        System.out.println(page.title());
        assertEquals("EventHub — Discover & Book Events", page.title());
        assertThat(page).hasTitle("EventHub — Discover & Book Events");
        page.getByPlaceholder("Email").fill("rahulshetty1@yahoo.com");
        page.getByLabel("Password").fill("Magiclife1!");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();


        //browser.close();
        //playwright.close();

    }
}