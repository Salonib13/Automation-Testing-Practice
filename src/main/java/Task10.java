import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task10 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/");
            // TC01 - Valid Login
            System.out.println("\nTC01 - Valid Login");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            if (driver.getTitle().equals("Swag Labs"))
            {
                System.out.println("PASS - Valid login successful");
            } else {
                System.out.println("FAIL - Valid login unsuccessful");
            }

            // Logout
            driver.findElement(By.id("react-burger-menu-btn")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("[data-test='logout-sidebar-link']")).click();
            Thread.sleep(2000);
            System.out.println("Logout successful");


            // TC02 - Invalid Password
            System.out.println("\nTC02 - Invalid Password");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("wrong123");
            driver.findElement(By.id("login-button")).click();
            Thread.sleep(2000);
            WebElement error1 = driver.findElement(By.cssSelector("[data-test='error']"));
            String expectedError = "Epic sadface: Username and password do not match any user in this service";
            if (error1.isDisplayed() && error1.getText().equals(expectedError)) {
                System.out.println("PASS - Invalid password error displayed");
            } else {
                System.out.println("FAIL - Invalid password test failed");
            }


            // TC03 - Invalid Username
            System.out.println("\nTC03 - Invalid Username");
            driver.findElement(By.id("user-name")).clear();
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("user-name")).sendKeys("wrong_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            Thread.sleep(2000);
            WebElement error2 = driver.findElement(By.cssSelector("[data-test='error']"));
            if (error2.isDisplayed() &&
                    error2.getText().equals(expectedError)) {
                System.out.println("PASS - Invalid username error displayed");
            } else {
                System.out.println("FAIL - Invalid username test failed");
            }


            // TC04 - Locked User
            System.out.println("\nTC04 - Locked User");
            driver.findElement(By.id("user-name")).clear();
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            Thread.sleep(2000);
            WebElement error3 = driver.findElement(By.cssSelector("[data-test='error']"));
            String lockedError = "Epic sadface: Sorry, this user has been locked out.";
            if (error3.isDisplayed() && error3.getText().equals(lockedError)) {
                System.out.println("PASS - Locked user error displayed");
            } else {
                System.out.println("FAIL - Locked user test failed");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("\nBrowser closed successfully");
        }
    }
}
