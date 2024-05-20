package Normal;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class File {
    
    public static void main(String[] args) {
    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    Page page = browser.newPage();
    page.navigate("https://www.leafground.com/dashboard.xhtml");
    Locator l = page.locator("//i[@class='pi pi-globe layout-menuitem-icon']");
    l.click();
    
    Locator l2 = page.locator("//span[contains(text(),'Alert')]");
    l2.click();
    page.onDialog(d1 ->{
        d1.accept();
        System.out.println(d1.message());
        System.out.println(page.locator("//span[@id ='simple_result']").textContent());
        page.offDialog(null);
    });
    page.onDialog( D2->{
        D2.accept();
    }

    );
    Locator l3 = page.locator("(//span[contains(text(),'Show')])[1]");
    l3.click();

    }
    
}
