import com.microsoft.playwright.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelloWorldActionTest {
    private Browser browser;
    Playwright playwright;

    @BeforeEach
    public void setclearUp() {
        playwright = Playwright.create();
        System.out.println("Playwright installation done");
    }

    public void performTest(Browser browser) {
        Page page = browser.newPage();
        page.navigate("http://localhost:8080/struts2-demo/");
        // Perform actions
        page.click("#increase_button");
        assertEquals("1", page.locator("#counter").textContent(), "increase button click test");

        page.click("#increase_button");
        assertEquals("2", page.locator("#counter").textContent(), "increase button click test second time");

        page.click("#decrease_button");
        assertEquals("1", page.locator("#counter").textContent(), "decrease button click test");

        // Close the browser
        page.close();
    }

    @Test
    public void testWebPage() {
        // performTest(browser);
        if (playwright == null) {
            playwright = Playwright.create();
        }
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(true));
        performTest(browser);
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true));
        performTest(browser);
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(true));
        performTest(browser);
    }

    @AfterEach
    public void tearDown() {
        browser.close();
    }
}
