package com.janitriinnovations.tests;

import com.janitriinnovations.bases.BaseTest;
import com.janitriinnovations.pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationTest extends BaseTest {

    @Test
    public void openExampleAndVerifyTitle() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.openDashboard();
        String actualTitle = dashboardPage.getPageTitle();
        String expectedTitle = "Janitri"; 

        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch!");
    }
}






