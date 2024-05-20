package stepDefinitions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class IframeStepDefinition 
{
    
    Playwright playwright;
    Browser browser;
    Page page;
    
@Given("User navigates to the home page")
public void user_on_the_login_page() throws Throwable {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    page = browser.newPage();

    page.navigate("https://www.leafground.com/dashboard.xhtml");
}

@Then("user opens the frames")
public void user_opens_the_frame()
{
    page.locator("//i[@class='pi pi-globe layout-menuitem-icon']").click();
    page.locator("//span[contains(text(),'Frame')]").click();

    FrameLocator iframe = page.frameLocator("//iframe[@src='default.xhtml']");
    iframe.locator("(//button[@id='Click' and contains(text(),'Click Me') and @style='color:#ffffff;background: linear-gradient(240deg, #ff7295 0%, #fe875d 100%);border: 0 none;width:15%;height:40%' ])").click();
    List<Frame> frames = page.frames();
    System.out.println(frames.size());

    FrameLocator insideframe1 = page.frameLocator("//iframe[@src='page.xhtml']");
    FrameLocator insideframe2 = insideframe1.frameLocator("//iframe[@id='frame2']");
    insideframe2.locator("//button[@id='Click' and @style='background: linear-gradient(240deg, #4b7ecf 0%, #8e70ee 100%); color:#ffffff;border: 0 none;width:15%;height:40%']").click();

    Frame count = page.frame("//iframe[@src='nested.xhtml']");
    List<Frame> countOfInnerFrame =count.childFrames();
    System.out.println(countOfInnerFrame.size());
    

}


}
