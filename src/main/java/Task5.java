
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task5 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.google.com");
            String id1 = driver.getWindowHandle();

            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://www.wikipedia.org");
            String id2 = driver.getWindowHandle();

            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://www.youtube.com");
            String id3 = driver.getWindowHandle();

            driver.switchTo().window(id1);
            System.out.println(driver.getTitle());

            driver.switchTo().window(id2);
            System.out.println(driver.getTitle());

            driver.switchTo().window(id3);
            System.out.println(driver.getTitle());

        } finally {
            driver.quit();
        }
    }
}
