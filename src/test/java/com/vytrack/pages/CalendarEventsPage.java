package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;


    @FindBy(xpath = "(//input[@type='checkbox'])[7]")
    public WebElement title;

    @FindBy(xpath = "(//div[@class='btn-group'])[2]")
    public WebElement ViewPerPage;


    @FindBy(xpath = "(//label[@class='dib'])[3]")
    public WebElement TotalOf;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "//tbody/tr")
    public WebElement AllRows;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[7]")
    public WebElement threedot;


}
