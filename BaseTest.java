package com.janitriinnovations.bases;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.janitriinnovations.pages.LoginPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setup() {
       
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 1);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--user-data-dir=C:/tmp/profile_" + System.currentTimeMillis());
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        // Set implicit wait
        // This will wait for elements to be present before throwing an exception
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://dev-dash.janitri.in/");
    }

    @AfterTest
        public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}




