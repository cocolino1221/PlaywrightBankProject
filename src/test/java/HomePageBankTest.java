import org.example.HomePageBank;
import org.junit.jupiter.api.Test;

public class HomePageBankTest {
    HomePageBank page;



    @Test
    public void openBrowser() {
        page = new HomePageBank();
        page.openPage();



    }

}
