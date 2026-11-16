import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task11 {
    public static void main(String args[])
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));

        System.out.println("username field displayed:" +username.isDisplayed());
        System.out.println("Password field displayed:" +password.isDisplayed());

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        WebElement loginbutton = driver.findElement(By.id("login-button"));
        loginbutton.click();

        if(driver.getCurrentUrl().contains("inventory.html"));
        {
            System.out.println("Login successful");
        }
        WebElement product = driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and text()='Sauce Labs Backpack']"));
        System.out.println(product.getText());

        WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        System.out.println("Add to Cart enabled: "+ addToCart.isEnabled());
        driver.quit();


    }
}
//output:
//username field displayed:true
//Password field displayed:true
//Login successful
//Sauce Labs Backpack
//Add to Cart enabled: true