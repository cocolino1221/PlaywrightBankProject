import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.example.HomePageBank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePageBankTest extends HomePageBank {
    public static HomePageBank homePage;
    public static Playwright playwright;
    public static Browser browser;
    public static Page page;

    @BeforeAll
    public static void setup() {
        playwright = Playwright.create();
        browser = playwright.firefox().launch();
        page = browser.newPage();
        homePage = new HomePageBank();


    }



    @Test
    public void openBrowser() {
        homePage.openPage();
        page.getByLabel("Username").fill("asdasd");
        page.getByLabel("Password").fill("asda");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("LOGIN")).click();






    }

}
