package stepDefinitions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class WindowStepDefinition {
    
    Playwright playwright;
    Browser browser;
    Page page;
    
@Given("user navigates to the leafground page")
public void user_navigate_to_the_leafground_page() throws Throwable {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    page = browser.newPage();

    page.navigate("https://www.leafground.com/dashboard.xhtml");
}

@Then("user opens the window tab")
public void user_opens_the_window_tab()
{
    page.locator("//i[@class='pi pi-globe layout-menuitem-icon']").click();
    page.locator("(//span[contains(text(),'Window')])[1]").click();
}

@Then("user clicks and opens the new window")
public void user_clicks_and_opens_the_new_window()
{
   Page popup = page.waitForPopup(()->
    {
        page.locator("//button[@id='j_idt88:new']").click();
    });
    popup.waitForLoadState();
    System.out.println(popup.url());
    System.out.println(popup.title());
    popup.close();
}


@SuppressWarnings("resource")
@Then("user opens multiple tabs")
public void user_opens_multiple_tabs()
{
    page.waitForPopup(new Page.WaitForPopupOptions().setPredicate(p -> p.context().pages().size() == 3), 
    ()->{
        page.locator("//button[@id='j_idt88:j_idt91']").click();
    });
    
    List<Page> pages = page.context().pages();
    for (Page tabs : pages) {
        tabs.waitForLoadState();
        System.out.println(tabs.url());
    }

    Page p1 = pages.get(1);
    p1.close();
    Page p2 = pages.get(2);
    p2.close();
    
   
}

@SuppressWarnings("resource")
@Then("user opens and closes multiple window")
public void user_opens_and_closes_multiple_window()
{
    page.waitForPopup(new Page.WaitForPopupOptions().setPredicate(pg -> pg.context().pages().size() == 4), 
    ()->{
        page.locator("//button[@id='j_idt88:j_idt93']").click();
    });
    
    List<Page> multiplepages = page.context().pages();
    
    for (Page tabs1 : multiplepages) {
        tabs1.waitForLoadState();
        System.out.println(tabs1.url());
    }
    Page p01 = multiplepages.get(0);
    Page p02 = multiplepages.get(1);
    Page p03 = multiplepages.get(2);
    Page p04 = multiplepages.get(3);
    p02.close();
    p03.close();
    p04.close();
}


}
