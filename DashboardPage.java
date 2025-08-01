package com.janitriinnovations.pages;

import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openDashboard() {
        driver.get("https://dev-dash.janitri.in/");
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}

