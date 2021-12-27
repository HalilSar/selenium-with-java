package otomasyon;
//#region imports
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//#endregion
public class HomePage extends BasePage{
    //#region fields
    SearchBox searchBox;
    JavascriptExecutor js;
    private final By cartButton=By.xpath("/html/body/header/div/div/div[3]/div/a[3]/span");
    private final By openControl= By.xpath("/html/body/header/div/div/div[1]/a");
    private final By account= By.xpath("/html/body/header/div/div/div[3]/div/a[1]/span");
    private final By favory= By.xpath("/html/body/header/div/div/div[3]/div/a[2]/span");   
    private final By acceptCookies = By.id("onetrust-accept-btn-handler"); 
    //#endregion
   
    //#region constructor
    public HomePage(WebDriver driver) {
        super(driver);
        searchBox =new SearchBox(driver);
        js = (JavascriptExecutor) driver;
    }
    //#endregion

    //#region  Methods
    public SearchBox searchbox(){
        return this.searchBox;
    }
    public String linkControl(){
        String linkControl=find(openControl).getAttribute("title");
        return linkControl;
    }
    public String accountControl(){
        String accountControl= find(account).getText();
        return accountControl;
    }
    public String favoryControl(){
        String favoryControl= find(favory).getText();
        return favoryControl;
    }
    public String cartControl(){
        String cartControl= find(cartButton).getText();
        return cartControl;
    }
    public void goToCart() {
        click(cartButton);
    }
    public void scrollBy() {
        js.executeScript("window.scrollBy(0,5000)");
    }
    public void acceptCookies(){
        if(isDisplayed(acceptCookies)){
            click(acceptCookies);
        }
    }
    //#endregion
    
}
