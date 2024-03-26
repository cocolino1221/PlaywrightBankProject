import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.example.HomePageBank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePageBankTest extends HomePageBank {
    public static HomePageBank homePage;
    public static Playwright playwright;
    public static Browser browser;
    public static Page page;
    BrowserContext context;



    @BeforeAll
    public static void setup() {
        playwright = Playwright.create();
        browser = playwright.firefox().launch();
        page = browser.newPage();
        homePage = new HomePageBank();
        page.navigate("https://parabank.parasoft.com/parabank/services.htm");

    }
    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }



    @Test
    public void loginFunction() {

        page.locator("text = Username").fill("john");
        page.screenshot();
        page.locator("input[type=\"password\"]").fill("password");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();
        assertThat(page.getByTitle("Error!")).hasText("An internal error has occurred and has been logged.");
    }
    @Test
    public void registerNewUser(){
        homePage.registerButtonClick();
        page.locator("[id=\"customer\\.firstName\"]").click();
        page.locator("[id=\"customer\\.firstName\"]").fill("John");
        page.locator("[id=\"customer\\.lastName\"]").fill("Wick");
        page.locator("[id=\"customer\\.address\\.street\"]").fill("USA");
        page.locator("[id=\"customer\\.address\\.city\"]").fill("LA");
        page.locator("[id=\"customer\\.address\\.state\"]").fill("California");
        page.locator("[id=\"customer\\.address\\.zipCode\"]").fill("12345");
        page.locator("[id=\"customer\\.phoneNumber\"]").fill("98898987");
        page.locator("[id=\"customer\\.ssn\"]").fill("123312");
        page.locator("[id=\"customer\\.username\"]").fill("john1221");
        page.locator("[id=\"customer\\.password\"]").fill("password");
        page.locator("#repeatedPassword").fill("password");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Register")).click();
       assertThat(page.locator(".title[text='Welcome']").getByText("Welcome John")).hasText("Welcome John");
    }



}
