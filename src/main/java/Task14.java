import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
public class Task14
{
    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        try
        {
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            if (driver.getCurrentUrl().contains("inventory.html"))
            {
                System.out.println("PASS - Login successful");
            }
            else
            {
                System.out.println("FAIL - Login failed");
                return;
            }
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
            driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
            driver.findElement(By.className("shopping_cart_link")).click();
            List<WebElement> products = driver.findElements(By.className("cart_item"));
            System.out.println("Initial product count: " + products.size());
            List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
            for (int i = 0; i < productNames.size(); i++)
            {
                System.out.println("Product: " + productNames.get(i).getText());
            }
            driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
            List<WebElement> updatedProducts = driver.findElements(By.className("cart_item"));
            if (updatedProducts.size() == 2)
            {
                System.out.println("PASS - Only two products remain");
            }
            else
            {
                System.out.println("FAIL - Product count is incorrect");
            }

            driver.findElement(By.id("continue-shopping")).click();

            driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

            driver.findElement(By.className("shopping_cart_link")).click();

            List<WebElement> finalProducts = driver.findElements(By.className("cart_item"));
            if (finalProducts.size() == 3)
            {
                System.out.println("PASS - Three products are displayed");
            }
            else
            {
                System.out.println("FAIL - Product count is incorrect");
            }

        }
        finally
        {
            driver.quit();
        }
    }
}
