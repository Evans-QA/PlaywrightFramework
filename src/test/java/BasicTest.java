import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BasicTest {

    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeMethod
    public void setUp() {

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();



        //Actions takes 10 seconds (default)
        page.setDefaultTimeout(8000);

        //Assertions takes 5 seconds (default)
        PlaywrightAssertions.setDefaultAssertionTimeout(7000);

    }

    @Test
    public void DemoTest() {

        page.navigate("https://eventhub.rahulshettyacademy.com/");
        System.out.println(page.title());
        assertThat(page).hasTitle("EventHub — Discover & Book Events");
        page.getByPlaceholder("Email").fill("rahulshetty1@yahoo.com");
        page.getByLabel("Password").fill("Magiclife1!");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Browse Events").setExact(true)).click();
        assertThat(page).hasURL("https://eventhub.rahulshettyacademy.com/events");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add New Event").setExact(true)).click();
        assertThat(page).hasURL("https://eventhub.rahulshettyacademy.com/admin/events");
        page.getByTestId("event-title-input").fill("QA Summit - Test Event", new Locator.FillOptions().setTimeout(10000));
        page.getByPlaceholder("Describe the event").fill("Description of great QA summit event");
        page.getByLabel("Category").selectOption("Sports");
        page.getByLabel("City").fill("Warsaw");
        page.getByLabel("Venue").fill("Pl. Defilad 1, 00-901 Warszawa");
        page.getByLabel("Event Date & Time").fill("2027-01-05T10:50");
        page.getByLabel("Price ($)").fill("300");
        page.getByLabel("Total Seats").fill("2000");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add Event")).click(new Locator.ClickOptions().setTimeout(12000));
        assertThat(page.getByText("Event created!")).isVisible();

        page.locator("#nav-events").click();
        Locator eventCards = page.getByTestId("event-card");
        assertThat(eventCards).hasCount(8);
        Locator targetEvent = eventCards.filter(new Locator.FilterOptions().setHasText("QA Summit - Test Event"));
        assertThat(targetEvent).isVisible();
    }

    @AfterMethod
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}