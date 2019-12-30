package com.vytrack.tests.HW3;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.vytrack.utilities.ConfigurationReader;

import java.util.List;


public class TestCases extends TestBase {

    @BeforeMethod
    public void openBrowser()  {

        LoginPage loginpage = new LoginPage();
        String username = ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");
        loginpage.login(username, password);

        BrowserUtils.waitFor(2);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

    }

    @Test
    public void test01() {
        DashboardPage dashboardPage = new DashboardPage();
        Assert.assertTrue(dashboardPage.Options.isDisplayed());

    }

    @Test
    public void test02() {
        CalendarEventsPage dashboardPage = new CalendarEventsPage();
        String actual = dashboardPage.pageNumber.getAttribute("value");
        //  System.out.println(actual);
        Assert.assertEquals(actual, "1");
    }

    @Test
    public void test03() {


        CalendarEventsPage dashboardPage = new CalendarEventsPage();
        String text = dashboardPage.ViewPerPage.getText();


        Assert.assertEquals(text, "25");

    }

    @Test
    public void test04(){
        List<WebElement> allRows = driver.findElements(By.xpath("//tbody/tr"));
        System.out.println(allRows.size());

        String expectation = "Total Of " + allRows.size() + " Records";
        String actual = driver.findElement(By.xpath("//label[contains(@class,'dib')][3]")).getText();
        Assert.assertEquals(expectation, actual );


    }

    @Test
    public void test05(){
         CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
         calendarEventsPage.title.click();


    }



}