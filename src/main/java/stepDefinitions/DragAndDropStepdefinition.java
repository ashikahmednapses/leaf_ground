package stepDefinitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DragAndDropStepdefinition 
{
    Playwright playwright;
    Browser browser;
    Page page;
    
@Given("user navigates to the leafgrounds page drag and drop")
public void user_navigate_to_the_leafground_page_drag_and_drop() throws Throwable {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    page = browser.newPage();

    page.navigate("https://www.leafground.com/dashboard.xhtml");
}
    

@Then("user drags and drops the item")
public void user_drags_and_drops_the_item() throws InterruptedException
{
    page.locator("//i[@class='pi pi-globe layout-menuitem-icon']").click();
    page.locator("//span[contains(text(),'Drag')]").click();
    page.locator("//div[@id='form:drag_content']").dragTo(page.locator("//div[@id='form:drop_header']"));
    //page.locator("//div[@id='form:conpnl_header']").hover();
    page.locator("(//span[@class='ui-column-title'])[1]").hover();
    page.mouse().down();
    page.locator("(//span[@class='ui-column-title'])[2]").hover();
    page.mouse().up();
}




}
