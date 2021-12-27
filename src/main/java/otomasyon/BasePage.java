package otomasyon;
//#region imports
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//#endregion
public class BasePage {
    //#region fields
    private WebDriver driver;
    String baseUrl = "https://beymen.com/";

    //#endregion
    //#region constructor
    public BasePage(WebDriver driver) 
    {
        this.driver = driver;
    }
    //#endregion
    
    //#region methods
    public WebElement find(By locator)
    {
        return driver.findElement(locator);
    }
    public List<WebElement> findall(By locator){
        return driver.findElements(locator);
    }
    public void findbyindexClick(List<WebElement> locators,int index,String tag){
        locators.get(index).findElement(By.tagName("a")).click();
        
    }
    public void click(By locator){
        find(locator).click();
    }
    public void type(By locator,String text ){
        find(locator).sendKeys(text);
    }
    public Boolean isSelected(By locator) {
        return find(locator).isDisplayed();
    }
    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }
    
    // public void findxpath(By locator){
    //    driver.findElement
    // }
    //#endregion
}