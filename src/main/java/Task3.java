
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    public static void main(String arg[]) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        String title = "Google";
        if(title.equals(driver.getTitle()))
        {
            System.out.println("Title is correct");
        }
        else
        {
            System.out.println("title is incorrect");
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
