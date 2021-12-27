package otomasyon;
//#region imports
import java.util.List;
import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//#endregion
public class CartPage extends HomePage{
    //#region fields
    private final By selectOptionTwo = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/ul/li[3]/div[2]/div/select/option[2]");
    private final By deleteCard = By.id("removeCartItemBtn0");
    private final By selectFirst = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/ul/li[3]/div[2]/div/select");
    private final By emptyCartMessage = new By.ByCssSelector("class['m-empty__messageTitle'");
    private final By emptyCartId = By.id("emtyCart");
    private final By productCartPagePrice= By.className("m-productPrice__salePrice");
    private final By emptyCart = By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div/strong");
    private final By emptyCartMessageTwo = By.className("m-empty__messageTitle");
    WebDriver drive;
    //#endregion
   
    //#region Methods
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String cardPrice(){
        String productpageprice =find(productCartPagePrice).getText();
        return productpageprice;
    }
    
    public void addToProductCount(){
        if(shopCount() > 1){
            click(selectOptionTwo);
       }

    }
    public void deleteToProduct(){
        click(deleteCard);
    }
    
    private int shopCount(){
        int opitonSize=findall(selectFirst.tagName("option")).size();
        return opitonSize;
    }
    public String text(){
        String message=find(emptyCartId).findElement(By.className("m-empty__messageTitle")).getText();
        return message;       
    }
    
   //#endregion

   //#region Experiment
   private static final By emptyCardIdT = By.id("emtyCart");

    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.beymen.com/cart");
        driver.manage().window().maximize();
        String element = driver.findElement(emptyCardIdT).findElement(By.className("m-empty__messageTitle")).getText();
        System.out.println(element);

    }
   //#endregion
       
}
