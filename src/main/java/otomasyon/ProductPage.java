package otomasyon;
//#region imports
import java.util.List;
import java.util.function.BooleanSupplier;
import io.netty.util.internal.ThreadLocalRandom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//#endregion
public class ProductPage extends BasePage {
    //#region Fields
    private final By produclists = By.className("o-productList__item");
    WebDriver driver;
    //#endregion
    //#region Constructor
    public ProductPage(WebDriver driver) {
        super(driver); 
        this.driver = driver;      
    }    
    //#endregion
    //#region Methods
    public BooleanSupplier isOnProductPage() {
        return null;
    }
    
    public BooleanSupplier isProductCountUp() {
        return null;
    }

    public void selectProduct() throws InterruptedException{
        Thread.sleep(3000);
        List<WebElement> products = findall(produclists);
        
        // int y =products.size();
        int rand = ThreadLocalRandom.current().nextInt(1, 30);
        // Thread.sleep(600);
        products.get(rand).findElement(By.tagName("a")).click();      
    }
    //#endregion    
}
