package com.amazon.qa.base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public static WebDriver driver;
   static Properties prop;

    public BaseTest() throws IOException {
        prop=new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/com/amazon/qa/config/config.properties");
        prop.load(fis);
    }
    public static void initialization()
    {
     String browserName=prop.getProperty("browser");
     if(browserName.equals("chrome"))
     {
         WebDriverManager.chromedriver().setup();
         ChromeOptions ops = new ChromeOptions();
         ops.addArguments("--remote-allow-origins=*");
//         ChromeDriver driver = new ChromeDriver(ops);
         driver=new ChromeDriver(ops);

     }
     else if (browserName.equals("firefox")) {
         WebDriverManager.firefoxdriver().setup();
         driver=new FirefoxDriver();

     }
     driver.manage().window().maximize();
     driver.manage().deleteAllCookies();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.get(prop.getProperty("url"));
    }
    public static String getUserName()
    {
        return prop.getProperty("userName");
    }
    public static String getPassword()
    {
        return prop.getProperty("pwd");
    }
    public static String getSignInName()
    {
        return prop.getProperty("signIn");
    }

}
