package otomasyon;

//#region imports
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
//#endregion

public class Test_Add_And_Delete_Cart extends BaseTest{
    //#region fields
    HomePage homePage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    String productPrice;
    CartPage cartPage;
    //#endregion

    //#region methods
    
    @Test
    @Order(1)
    public void site_control(){
        homePage = new HomePage(driver);    
        // homePage.acceptCookies();
        Assertions.assertEquals("Beymen", homePage.linkControl(),"Site is not correct");
        
    }
    
    @Test
    @Order(2)
    public void account_control(){
        homePage = new HomePage(driver);
        Assertions.assertEquals("Hesabım", homePage.accountControl(), "Account name is not correct");
    }
   
    @Test
    @Order(3)
    public void favory_control(){
        homePage = new HomePage(driver);
        Assertions.assertEquals("Favorilerim", homePage.favoryControl(), "Favory  is not correct");
    }
    @Order(4)
    @Test
    public void cart_control(){
        homePage = new HomePage(driver);
        Assertions.assertEquals("Sepetim", homePage.cartControl(), "Cart is not correct");
    }
    @Test
    @Order(5)
    public void search_product() throws InterruptedException{
        homePage = new HomePage(driver);
        homePage.searchbox().search("pantalon");
    }
    @Test
    @Order(6)
    public void scroll_down() throws InterruptedException{
        Thread.sleep(3000);
        homePage = new HomePage(driver);
        homePage.scrollBy();
    }
    @Test
    @Order(7)
    public void select_a_product() throws InterruptedException{
        Thread.sleep(3000);
        productPage = new ProductPage(driver);
        Thread.sleep(3000);
        productPage.selectProduct();
    }

    @Test
    @Order(8)
    public void add_to_product() throws InterruptedException{
        productDetailPage= new ProductDetailPage(driver);
        Thread.sleep(3000);
        productPrice=productDetailPage.productPrice();
        Thread.sleep(3000);
        productDetailPage.addToSize();
        Thread.sleep(3000);
        productDetailPage.addToCart();
    }

    @Test
    @Order(9)
    public void go_cart(){
        homePage.goToCart();

    }
    @Test
    @Order(10)
    public void compare_price(){
        cartPage = new CartPage(driver);
        Assertions.assertEquals(productPrice,cartPage.cardPrice(),"Prices is not equal" );
    }
    @Test
    @Order(11)
    public void add_to_product_count(){
    
        cartPage.addToProductCount();
        
    }
    @Test
    @Order(12)
    public void delete_product_count() throws InterruptedException{
        cartPage = new CartPage(driver);
        Thread.sleep(3000);
        cartPage.deleteToProduct();
        Thread.sleep(3000);
        Assertions.assertEquals("SEPETINIZDE ÜRÜN BULUNMAMAKTADIR",cartPage.text(),"Card is not empty" );
    }
    //#endregion

}