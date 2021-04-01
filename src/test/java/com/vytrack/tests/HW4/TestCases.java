package com.vytrack.tests.HW4;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCases extends TestBase {

    Actions actions = new Actions(Driver.get());
    @BeforeMethod
    public void NavigateCalender(){

        LoginPage  loginpage = new LoginPage();
        String username = ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");
        loginpage.login(username, password);
        BrowserUtils.waitFor(2);
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

    }
    @Test
    public  void testcase01(){

       CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        BrowserUtils.waitFor(2);
        actions.moveToElement(calendarEventsPage.threedot).perform();

        List<WebElement> dots = driver.findElements(By.xpath("//*[@id=\"grid-calendar-event-grid-1494572078\"]/div[2]/div[2]/div[2]/div/table/tbody/tr[4]/td[9]/div/div/ul/li/ul/li[1]/a/i"));

        for(int i = 1; i <= 3; i++){
            WebElement element = driver.findElement(By.xpath("//*[@id=\"grid-calendar-event-grid-1494572078\"]/div[2]/div[2]/div[2]/div/table/tbody/tr[4]/td[9]/div/div/ul/li/ul/li["+i+"]/a/i"));
            Assert.assertTrue(element.isDisplayed());

        }
CalendarEventsPage calendarEventsPage1 = new CalendarEventsPage();



    }
}
