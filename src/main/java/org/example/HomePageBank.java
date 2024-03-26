

package org.example;

import com.microsoft.playwright.*;


public class HomePageBank {
    Playwright playwright = Playwright.create();
    Browser browser = playwright.firefox().launch();
    Page page = browser.newPage();
    Locator registerButton = page.locator("[name='Register']");




    public void openPage() {
        page.navigate("https://parabank.parasoft.com/parabank/services.htm");

    }
    public void registerButtonClick(){
        registerButton.click();
    }


}