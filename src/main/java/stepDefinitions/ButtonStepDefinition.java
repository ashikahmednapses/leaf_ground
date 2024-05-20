package stepDefinitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ButtonStepDefinition {
    Playwright playwright;
    Browser browser;
    Page page;
    
@Given("user Opens the website")
public void user_on_the_login_page() throws Throwable {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    page = browser.newPage();

    page.navigate("https://www.leafground.com/dashboard.xhtml");
}

@When("user goes to the Button page")
public void user_goes_to_the_Button_page() {
    page.locator("//i[@class='pi pi-server layout-menuitem-icon']").click();
    
    page.locator("(//span[contains(text(),'Button')])[1]").click();
}



@When("user click on the click button")
public void user_clicks_on_login_button() {
    page.locator("//i[@class='pi pi-server layout-menuitem-icon']").click();
    
    page.locator("(//span[contains(text(),'Button')])[1]").click();
    
   
}
@When("user confirm the button is disabled or not")
public void user_confirm_the_button_is_disabled_or_not()  {
    
    System.out.println(page.locator("//button[@id ='j_idt88:j_idt92']").isDisabled());
    
}
@Then("user finds position of the submit button")
public void user_enters_login_page_successfully() {
    
    
}

@Then("user finds the color of the save button")
public void user_finds_the_color_of_the_Save_button()
{
    
}
@Then("user finds height and weight of this button")
public void user_finds_height_and_weight_of_this_button()
{
    page.locator("(//span[contains(text(),'Submit')])[1]").click();
    
    Locator hw = page.locator("(//span[contains(text(),'Submit')])[2]");
    
    double height = hw.boundingBox().height;
    double width = hw.boundingBox().width;
    
    System.out.println("Height = "+height +" Width= " +width);

   
    
}
@Then("user mouser over and finds the color changed")
public void user_mouser_over_and_finds_the_color_changed()
{
    System.out.println(page.locator("(//span[contains(text(),'Save')])[1]").evaluate("e => window.getComputedStyle(e).backgroundColor"));
    
}


@Then("user finds how many rounded buttons are there")
public void user_finds_how_many_rounded_buttons_are_there()
{
     
}

}
