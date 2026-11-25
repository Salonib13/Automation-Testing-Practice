import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task18 {
    public static void main(String args[])
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationcentral.com/demo/dropdown.html");
        WebElement dropdownElement = driver.findElement(By.cssSelector("#simple-dropdown select"));
        Select dropdown = new Select(dropdownElement);
        List<WebElement> options = dropdown.getOptions();
        System.out.println("Total Option : " +options.size());
        System.out.println("Available Option:");
        for(WebElement option : options)
        {
            System.out.println(option.getText());
        }
        dropdown.selectByVisibleText("Option 2");
        System.out.println("Selected Option :"+dropdown.getFirstSelectedOption().getText());
        dropdown.selectByIndex(2);
        System.out.println("Select Option :"+dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("option1");

        List<WebElement> selectedOptions = dropdown.getAllSelectedOptions();
        for (WebElement option : selectedOptions)
        {
            System.out.println(option.getText());
        }
        driver.quit();


    }
}
