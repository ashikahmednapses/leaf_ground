package stepDefinitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CheckBoxStepDefinition {
    
    Playwright playwright;
    Browser browser;
    Page page;
    
@Given("User opened the website")
public void user_on_the_login_page() throws Throwable {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    page = browser.newPage();

    page.navigate("https://www.leafground.com/dashboard.xhtml");
}

    @Given("user enters checkbox")
    public void user_enters_checkbox()
    {
        page.locator("//i[@class='pi pi-server layout-menuitem-icon']").click();
        page.locator("//span[contains(text(),'Check Box')]").click();
        page.locator("//span[contains(text(),'Basic')]").click();
    }

    @Then("user enables notification")
    public void user_enables_notification()
    {
        page.locator("//span[contains(text(),'Ajax')]").click();
       
    }

    @Then("user selects the favorite language")
    public void user_selects_the_favorite_language()
    {
        page.locator("//label[@for='j_idt87:basic:0']").click();
        page.locator("//label[@for='j_idt87:basic:1']").click();
    }

    @Then("user checks the tri state checkbox works or not")
    public void user_checks_the_tri_state_checkbox_works_or_not()
    {
        page.locator("//input[@id='j_idt87:ajaxTriState_input']").click();
    }

    
    

}
