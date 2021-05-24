package nehal;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class Test1 {

    public RemoteWebDriver driver = null;
    String username = "mnejazi";
    String accesskey = "r1oCQHQc7e8MEq28u9y6Fv6zmU4sSJKSF0t0LHDmLwvDPh4OW5";

    @BeforeTest
    public void setup()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("version", "90.0"); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("resolution","1024x768");
        capabilities.setCapability("build", "First Nehal2 Test");
        capabilities.setCapability("name", "Sample Nehal2 Test");
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To
    try {
        driver = new RemoteWebDriver(new URL("https://"+username+":"+accesskey+"@hub.lambdatest.com/wd/hub"),capabilities);
    }catch (Exception e)
    {
        System.out.println("Invalid grid url");
    }


    }

    @Test
    public void test1()
    {
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://lambdatest.github.io/sample-todo-app/");
        driver.findElement(By.xpath("//input[@name='li1']")).click();
        driver.findElement(By.xpath("//input[@name='li2']")).click();
        driver.findElement(By.xpath("//input[@id='sampletodotext']")).clear();
        driver.findElement(By.xpath("//input[@id='sampletodotext']")).sendKeys("Yusuf");
        driver.findElement(By.xpath("//input[@id='addbutton']")).click();
        driver.quit();


    }
}
