import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task16 {
    public static void main(String args[])
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationcentral.com/demo/checkboxes.html");


        WebElement checkBox1 = driver.findElement(By.xpath("//span[text()='Option 1']/preceding-sibling::input"));
        if(!checkBox1.isSelected())
        {
           checkBox1.click();
        }
        else {
            System.out.println("checkbox is already selected");
        }
        System.out.println("is checkbox selected : " +checkBox1.isSelected());

        WebElement checkBox2 = driver.findElement(By.xpath("//span[text()='Option 2']/preceding-sibling::input"));
        if(!checkBox2.isSelected())
        {
            checkBox2.click();
        }
        else
        {
            System.out.println("checkbox is already selecetd");

        }
        WebElement checkBox3 = driver.findElement(By.xpath("//span[text()='Option 3']/preceding-sibling::input"));
        if(!checkBox3.isSelected())
        {
            checkBox3.click();
        }
        else
        {
            System.out.println("checkbox is already selecetd");

        }
        System.out.println("is checkbox option 1 selected : " +checkBox1.isSelected());
        System.out.println("is checkbox option 2 selected : " +checkBox2.isSelected());
        System.out.println("is checkbox option 3 selected : " +checkBox3.isSelected());

        driver.quit();

    }
}
