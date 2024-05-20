package stepDefinitions;

import javax.swing.WindowConstants;

import org.apache.commons.io.input.WindowsLineEndingInputStream;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import Locators.Loginlocators;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginsStepDefintion {
    
    Playwright playwright;
    Browser browser;
    Page page;
    
@Given("User opens the page")
public void user_on_the_login_page() throws Throwable {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    page = browser.newPage();

    page.navigate("https://www.leafground.com/dashboard.xhtml");
}

@When("user opens Text Box tab")
public void user_enters_the_username() {
    
    page.locator("//i[@class='pi pi-server layout-menuitem-icon']").click();
   // if ($("//input[@id='j_idt88:j_idt93']").is("disabled")) {
     //   System.out.println("is disabled");
        
   // }
   
}
@When("user fills name and city")
public void user_fills_name_and_city(){
    page.locator("(//i[@class='pi pi-fw pi-check-square layout-menuitem-icon'])[1]").click();
    page.locator("//input[@id='j_idt88:name']").fill("Ashik");
    page.keyboard().press("Tab");

    page.locator("//input[@id='j_idt88:j_idt91']").fill("Erode");
}

@When("user cleared value on the text field")
public void user_cleared_value_on_the_text_field()  {

   page.locator("//input[@id='j_idt88:j_idt95']").clear();
  
}

@When("user gets the value and entered email")
public void user_gets_the_value_and_entered_email() {

   page.locator("//input[@id='j_idt88:j_idt97']").textContent();
   System.out.println(page.locator("//input[@id='j_idt88:j_idt97']").inputValue());
   page.locator("//input[@id='j_idt88:j_idt99']").fill("ashik@gmail.com");
   
}

@Then("user fills the detail about himself")
public void user_fills_the_detail_about_himself() {
    page.keyboard().press("Tab");
    page.keyboard().type("Ashik ahmed is a good boy");
    
}

@Then("user trying to get error message")
public void user_trying_to_get_error_message()
{
    page.locator("//input[@id='j_idt106:thisform:age']").click();
     page.keyboard().press("Enter");
     
     System.out.println(page.locator("//span[@id='j_idt106:thisform:j_idt110_error-detail']").textContent());
      //page.locator("(//span[contains(text(),'ui-button')])[1]").fill("05/24/1998");;
     
}

@Then("user enters the name")
public void user_enters_the_name()
{
    page.locator("//input[@id='j_idt106:float-input']").click();
     page.locator("//input[@id='j_idt106:auto-complete_input']").fill("Ashik");
     page.keyboard().press("Enter");
     page.locator("//input[@id='j_idt106:auto-complete_input']").fill("Ahmed");
     page.keyboard().press("Enter");
     page.locator("//input[@id='j_idt106:auto-complete_input']").fill("bassa");
     page.keyboard().press("Enter");
    
}

@Then("user enters the value and set the value")
public void user_enters_the_value_and_set_the_value()
{
    page.evaluate("document.getElementById('j_idt106:j_idt116_input').value='05/24/1998'");
     page.locator("//input[@id='j_idt106:j_idt118_input']").fill("13");
     page.keyboard().press("Enter");
     page.locator("//span[@class='ui-icon ui-c ui-icon-triangle-1-n']").click();
     page.locator("//input[@id='j_idt106:slider']").fill("24");
     page.locator("//input[@id='j_idt106:j_idt122']").click();
    
}
}
