import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task12 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try
        {
            driver.get("https://www.saucedemo.com/");
            WebElement username = driver.findElement(By.id("user-name"));
            WebElement password = driver.findElement(By.id("password"));

            username.sendKeys("standard_user");
            password.sendKeys("secret_sauce");

            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            if (driver.getCurrentUrl().contains("inventory.html"))
            {
                System.out.println("Login successful");
            }
            WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
            System.out.println("Add to Cart enabled: " + addToCart.isEnabled());

            if (addToCart.isEnabled()) {
                addToCart.click();
                System.out.println("Product added to cart successfully");
            }

            WebElement product = driver.findElement(By.className("inventory_item_name"));
            System.out.println("Product name: " + product.getText());

            WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
            String cartCount = cartBadge.getText();
            System.out.println("Cart count: " + cartCount);
            if (cartCount.equals("1")) {
                System.out.println("PASS - Cart count verified");
            } else {
                System.out.println("FAIL - Cart count mismatch");
            }
        }
        finally
        {
            driver.quit();
        }
    }
}
