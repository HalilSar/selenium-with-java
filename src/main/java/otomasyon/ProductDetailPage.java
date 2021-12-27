package otomasyon;
//#region Imports
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//#endregion
public class ProductDetailPage extends BasePage{
    //#region Fields
    private final By addCart = By.xpath("/html/body/div[3]/div[1]/div/div[2]/div[2]/div[4]/button[1]");
    private final By sizeCss = new By.ByCssSelector("span[class='m-variation__item']"); //  m-variation__item
    private static final By sizeCsst = By.className("m-variation__item");
    List<WebElement> sList=findall(sizeCsst);
    private  final By productDetailPagePrice =By.id("priceNew");
    //#endregion

    //#region Constructor
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    //#endregion
    
    //#region Methods
    public void addToSize(){       
        if(sListOfControl()>1 ){
            for (WebElement webElement : sList) {
                if( webElement.getTagName().contentEquals("span") && (webElement.getAttribute("class").endsWith("item") || webElement.getAttribute("class").contentEquals("m-variation__item -criticalStock")))
                {
                    webElement.click();                   
                    break;
                }
            }
        }
        else{
             click(sizeCss);
        }
       
    }
    public void addToCart(){
        click(addCart);
    }
    public String productPrice(){
        String productpageprice = find(productDetailPagePrice).getText();
        return productpageprice;
    }

    private int sListOfControl(){
        return sList.size();
    }

    //#endregion
   
}

