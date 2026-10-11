import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.BeforeMethod;

public class UIValidationTest {

Playwright playwright;
Browser browser;
Page page;


    @BeforeMethod
    public void setUp() {

        playwright = Playwright.create();
        browser = playwright.chromium().launch();
        page = browser.newPage();
    }
}
