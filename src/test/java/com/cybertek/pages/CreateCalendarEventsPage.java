package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCalendarEventsPage extends BasePage {

    public CreateCalendarEventsPage(){
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(xpath = "//div[@class='control-group recurrence-summary alert-info']")
    public WebElement summaryFullMessage;

    @FindBy(xpath = "(//label[@class='fields-row']//input[@class='recurrence-subview-control__number'])[5]")
    public WebElement inputOccurences;

    @FindBy(xpath = "//span[contains(text(),'Daily every 1 day')]")
    public WebElement summary;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement repeatEvery;

    @FindBy(xpath = "//select[@id='recurrence-repeats-view747']")
    public WebElement getRepeatsall;

    @FindBy(xpath = "//select/option[@value='daily']")
    public WebElement daily;

    @FindBy(css = "[id^='recurrence-repeat-view']")
    public WebElement repeat;

    @FindBy(css = "[id^='recurrence-repeats-view']")
    public WebElement repeatOptions;

    @FindBy(className = "select2-chosen")
    public WebElement selectedOwner;

    @FindBy(css = "input[id^='oro_calendar_event_form_title-']")
    public WebElement title;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDate;
    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    public WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    public WebElement endTime;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement days;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement weekday;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement never;

    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement after;

    @FindBy(xpath = "(//input[@type='radio'])[5]")
    public WebElement by;

    @FindBy(xpath = "(//input[@placeholder='Choose a date'])[3]")
    public WebElement byInput;

    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    public WebElement year;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    public WebElement month;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[5]/a")
    public WebElement calendarDays;

    @FindBy(xpath = "//div[@class='control-group recurrence-summary alert-info']")
    public WebElement calendarSummary;

    @FindBy(xpath = "//select[@id='recurrence-repeats-view776']")
    public WebElement repeatWeekly;

    @FindBy(xpath = "//input[@value='monday']")
    public WebElement monday;

    @FindBy(xpath = "//input[@value='friday']")
    public WebElement friday;

    @FindBy(xpath = "(//label[@class='multi-checkbox-control__item'])[1]")
    public WebElement weeklyButton;

    @FindBy(xpath = "//div[@class='control-group recurrence-summary alert-info']")
    public WebElement weeklySummary;


    public Select repeatOptionsList(){
        return new Select(repeatOptions);
    }

}
