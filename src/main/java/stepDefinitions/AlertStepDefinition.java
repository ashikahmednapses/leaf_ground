package stepDefinitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AlertStepDefinition 
{
    Playwright playwright;
    Browser browser;
    Page page;
    
@Given("user returns to the website")
public void user_on_the_login_page() throws Throwable 
{
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    page = browser.newPage();

    page.navigate("https://www.leafground.com/dashboard.xhtml");
}

@Then("user opens the browser tab")
public void user_opens_the_browser_tab()
{
    page.locator("//i[@class='pi pi-globe layout-menuitem-icon']").click();
    page.locator("//span[contains(text(),'Alert')]").click();
    page.locator("(//span[contains(text(),'Show')])[1]").click();
    page.onceDialog(dialog ->{
        String text = dialog.message();
        System.out.println(text);
        dialog.accept();
    });

   
}

@Then("user opens the confirm dialog")
public void user_opens_the_confirm_dialog() throws InterruptedException
{
    page.locator("(//span[contains(text(),'Show')])[2]").click();
    page.onceDialog(dialog ->{
        String text = dialog.message();
        System.out.println(text);
        dialog.accept();
    });
    
}
    
@Then("user opens the sweet alerts")
public void user_opens_the_sweet_alert()
{
    page.locator("(//span[contains(text(),'Show')])[3]").click();
    page.locator("(//span[contains(text(),'Dismiss')])").click();
}


@Then("user opens sweet modal dialog")
public void user_opens_sweet_modal_dialog()
{
    page.locator("(//span[contains(text(),'Show')])[4]").click();
    page.locator("(//span[@class='ui-icon ui-icon-closethick'])[2]").click();
}

@Then("user opens prompt dialogs")
public void user_opens_prompt_dialog()
{
    page.locator("(//span[contains(text(),'Show')])[5]").click();
   page.onceDialog(dialog ->{
        String text = dialog.message();
        System.out.println(text);
        dialog.accept("Ashik");
    }); 
}

@Then("user opens the sweet alert conformation")
public void user_opens_the_sweet_alert_conformation()
{
    page.locator("//span[contains(text(),'Delete')]").click();
    page.locator("//span[contains(text(),'Yes')]").click();
}

}
