

package org.example;

import com.microsoft.playwright.*;


public class HomePageBank {
    Locator title = page.frameLocator(".logo").getByText("Patria Bank");
    Playwright playwright = Playwright.create();
    Browser browser = playwright.firefox().launch();
    Page page = browser.newPage();


    public void openPage(){
        page.navigate("https://parabank.parasoft.com/parabank/services.htm");
    }


}