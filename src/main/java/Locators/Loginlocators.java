    package Locators;

    import com.microsoft.playwright.Browser;
    import com.microsoft.playwright.BrowserType;
    import com.microsoft.playwright.Locator;
    import com.microsoft.playwright.Page;
    import com.microsoft.playwright.Playwright;

    public class Loginlocators
    {
        Playwright playwright;
        Browser browser;
        Page page = null;
        
        //Locator l2 = page.locator(null);
        

        public void navigator(){
            playwright = Playwright.create();
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            page = browser.newPage();
            page.navigate("https://www.leafground.com/dashboard.xhtml");
            
        }
        //Locator l = page.locator("//i[@class='pi pi-globe layout-menuitem-icon']");

       // public void clicking(){
       //     l.click();
        //}
    }
