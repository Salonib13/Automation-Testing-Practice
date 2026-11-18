import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task13 {
    public static void main(String args[])
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        if(driver.getCurrentUrl().contains("inventory.html"))
        {
            System.out.println("Login Successfully");
        }
        else
        {
            System.out.println("Login Failed");
        }
        WebElement addToCartProduct1 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        WebElement addToCartProduct2 = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addToCartProduct1.click();
        addToCartProduct2.click();

        driver.findElement(By.className("shopping_cart_link")).click();
        if(driver.getCurrentUrl().contains("cart.html"))
        {
            System.out.println("Cart page is open succesfully");

        }
        List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
        System.out.println("First Product Name : "+productNames.get(0).getText());
        System.out.println("Second Product Name : "+ productNames.get(1).getText());

        if(productNames.size()==2)
        {
            System.out.println("PASS - Cart contains 2 products");

        }
        WebElement removeProduct1 = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeProduct1.click();
        List<WebElement> remainingProducts = driver.findElements(By.className("inventory_item_name"));
        if(remainingProducts.size()==1 && !remainingProducts.get(0).getText().equals("Sauce Labs Backpack"))
        {
            System.out.println("PASS - Backpack removed successfully");
        }
        WebElement updatedBadge = driver.findElement(By.cssSelector("[data-test='shopping-cart-badge']"));
        String updatedCount = updatedBadge.getText();
        if (updatedCount.equals("1"))
        {
            System.out.println("PASS - Cart contains 1 product");
        }
        else
        {
            System.out.println("FAIL - Cart count mismatch");
        }

        driver.quit();
    }
}
