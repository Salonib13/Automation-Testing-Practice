import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task9 {

    public static void main(String args[]) {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://www.saucedemo.com/");
            // TEST CASE 1: VALID LOGIN
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            String expectedTitle = "Swag Labs";
            if (driver.getTitle().equals(expectedTitle)) {

                System.out.println("PASS - Valid login successful");

                driver.findElement(By.id("react-burger-menu-btn")).click();

                //logout
                driver.findElement(By.cssSelector("[data-test='logout-sidebar-link']")).click();
                System.out.println("PASS - Logout successful");

            } else {

                System.out.println("FAIL - Valid login unsuccessful");
            }


            // TEST CASE 2: INVALID LOGIN


            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("wrong123");
            driver.findElement(By.id("login-button")).click();
            WebElement errorMsg = driver.findElement(By.cssSelector("[data-test='error']"));
            String actualMessage = errorMsg.getText();

            String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
            if (errorMsg.isDisplayed() && actualMessage.equals(expectedMessage)) {

                System.out.println("PASS - Invalid login rejected");

            } else {

                System.out.println("FAIL - Error message is incorrect");
            }

        } catch (Exception e) {

            System.out.println("Exception occurred: " + e.getMessage());

        } finally {

            driver.quit();

            System.out.println("Browser closed");
        }
    }
}
