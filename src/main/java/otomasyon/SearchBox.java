package otomasyon;
//#region imports
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//#endregion

public class SearchBox extends BasePage {
    //#region fields
    private static final By searchBoxLocator = By.xpath("html/body/header/div/div/div[2]/div/div/div/input");
    private static final By searchButtonLocator = By.xpath("/html/body/header/div/div/div[2]/div/button");
    //#endregion
    //#region constructor
    public SearchBox(WebDriver driver) {
        super(driver);
    }
    //#endregion
    //#region methods
    public void search(String text) throws InterruptedException{
        type(searchBoxLocator, text);
        click(searchButtonLocator);
    }
    //#endregion
}