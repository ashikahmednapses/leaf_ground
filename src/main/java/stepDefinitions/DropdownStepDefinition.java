package stepDefinitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en_old.Tha;

public class DropdownStepDefinition 
{
    Playwright playwright;
    Browser browser;
    Page page;
    
@Given("User open the website")
public void user_on_the_login_page() throws Throwable {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    page = browser.newPage();

    page.navigate("https://www.leafground.com/dashboard.xhtml");
}

@Then("user goes to the Dropdown page")
public void user_goes_to_the_Dropdown_page()
{
    page.locator("//i[@class='pi pi-server layout-menuitem-icon']").click();
    page.locator("//span[text()='Dropdown']").click();
}
    
@Then("select the automation tool")
public void select_the_automation_tool()
{
   Locator automation = page.locator("//select[@class='ui-selectonemenu']");
   automation.selectOption("Selenium");
}

@Then("Select your Country")
public void  Select_your_Country() 
{
    page.locator("//label[@id='j_idt87:country_label']").click();
   // Locator country = page.locator("//select[@id='j_idt87:country_input']");
   // country.selectOption("India");
    page.locator("//li[@id='j_idt87:country_3']").click();
}

@Then("User selects the city")
public void User_selects_the_city() throws InterruptedException
{
    page.locator("//label[@id='j_idt87:city_label']").click();
    page.locator("//li[@id='j_idt87:city_1']").click();
}

@Then("User selects the course")
public void User_selects_the_course()
{
    page.locator("//ul[@class='ui-autocomplete-multiple-container ui-autocomplete-dd-multiple-container ui-widget ui-inputfield ui-state-default ui-corner-left']").click();
    page.keyboard().type("Selenium Testing");
    page.keyboard().press("Enter");
    page.keyboard().type("Playwright Testing");
    page.keyboard().press("Enter");

}

@Then("User selects the language")
public void User_selects_the_language()
{
    page.locator("//label[@id='j_idt87:lang_label']").click();
    page.locator("//li[@id='j_idt87:lang_2']").click();
    
}
@Then("user selects the number two")
public void user_selects_the_number_two()
{
    page.locator("//label[@id='j_idt87:value_label']").click();
    page.locator("//li[@id='j_idt87:value_1']").click();
}








}
