import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Task15 {

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
                System.out.println("Login Successfully");
            }
            else
            {
                System.out.println("Login Failed");
            }

            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            driver.findElement(By.cssSelector("[data-test='shopping-cart-link']")).click();

            WebElement products_name = driver.findElement(By.className("inventory_item_name"));

            if (products_name.getText().equals("Sauce Labs Backpack"))
            {
                System.out.println("Product is visible");
            }
            else
            {
                System.out.println("Product is not visible");
            }
            WebElement checkOut = driver.findElement(By.id("checkout"));
            checkOut.click();

            driver.findElement(By.id("first-name")).sendKeys("Saloni");
            driver.findElement(By.id("last-name")).sendKeys("Bhingare");
            driver.findElement(By.id("postal-code")).sendKeys("422605");
            driver.findElement(By.id("continue")).click();

            WebElement checkoutProduct = driver.findElement(By.className("inventory_item_name"));
            System.out.println("Checkout Product: " + checkoutProduct.getText());
            WebElement totalPrice = driver.findElement(By.className("summary_total_label"));

            System.out.println("Total Price: " + totalPrice.getText());
            driver.findElement(By.id("finish")).click();
            WebElement orderComplete = driver.findElement(By.className("complete-header"));
            if (orderComplete.getText().equals("Thank you for your order!"))
            {
                System.out.println("Order is completed");
            }
            else
            {
                System.out.println("Order is not completed");
            }

        }
        finally
        {
            driver.quit();
        }
    }
}
