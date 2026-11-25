
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Task17 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationcentral.com/demo/radiobuttons.html");
        driver.manage().window().maximize();
        List<WebElement> totalRadioButton = driver.findElements(By.name("options"));
        System.out.println("Total radio buttons: " + totalRadioButton.size());
        WebElement radioButton1 = driver.findElement(By.xpath("//span[text()='Option A']/preceding-sibling::input"));
        if (radioButton1.isEnabled())
        {
            radioButton1.click();
        }

        System.out.println("Option A selected: " + radioButton1.isSelected());
        WebElement radioButton2 = driver.findElement(By.xpath("//span[text()='Option B']/preceding-sibling::input"));
        radioButton2.click();

        System.out.println("Option B selected: " + radioButton2.isSelected());

        System.out.println("Option A selected after choosing B: " + radioButton1.isSelected());

        driver.quit();
    }
}
