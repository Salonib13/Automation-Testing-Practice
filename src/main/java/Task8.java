import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Task8 {
    public static void main(String args[])
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
        if(driver.getTitle().equals("Swag Labs"))
        {
            System.out.println("Login succesfully");
        }
        else {
            System.out.println("Login failed");
        }
        driver.close();
    }

}
