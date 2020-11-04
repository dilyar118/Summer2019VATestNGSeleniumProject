package com.cybertek.tests.Homework;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;



public class TestCase08_12 extends TestBase {
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Test
    public void test08() throws InterruptedException {
        /**
         1.Go to “https://qa1.vytrack.com/"
         2.Login as a store manager
         3.Navigate to “Activities -> Calendar Events”
         4.Click on “Create Calendar Event” button
         5.Select “Repeat” checkbox
         6.Verify that “Repeat” checkbox is selected
         7.Verify that “Daily” is selected by default and following options are available in “Repeats” drop-down:
         */

        //2.Login as a store manager
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");
        loginPage.login(username, password);

        //3.Navigate to “Activities -> Calendar Events”
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        //4.Click on “Create Calendar Event” button
        calendarEventsPage.createCalendarEvent.click();

        //5.Select “Repeat” checkbox
        CreateCalendarEventsPage repeat = new CreateCalendarEventsPage();
        repeat.repeat.click();
        Assert.assertTrue(repeat.repeat.isSelected());
        Thread.sleep(2000);

        //6.Verify that “Repeat” checkbox is selected
        String dayly=repeat.daily.getText();
        System.out.println(dayly);
        Assert.assertEquals(dayly,"Daily");

        //7.Verify that “Daily” is selected by default and following options are available in “Repeats” drop-down:
        Assert.assertTrue(repeat.daily.isSelected());
        repeat.repeatOptions.click();
        Select stateList = new Select(repeat.repeatOptions);
        List<WebElement> options = stateList.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
            //repeat.waitUntilLoaderScreenDisappear();
            Assert.assertTrue(option.isDisplayed());
        }




    }

    @Test
    public void test09(){

        /**

         1.Go to “https://qa1.vytrack.com/"
         2.Login as a store manager
         3.Navigate to “Activities -> Calendar Events”
         4.Click on “Create Calendar Event” button
         5.Select “Repeat” checkbox
         6.Verify that “Repeat” checkbox is selected
         7.Verify that “Repeat Every” radio button is selected
         8.Verify that “Never” radio button is selected as an “Ends” option.
         9.Verify that following message as a summary is displayed: “Summary: Daily every 1 day”
         */

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");
        loginPage.login(username, password);
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.createCalendarEvent.click();
        CreateCalendarEventsPage repeat = new CreateCalendarEventsPage();
        repeat.repeat.click();

        //Verify that “Repeat” checkbox is selected
        Assert.assertTrue(repeat.repeat.isSelected());

        //Verify that “Repeat Every” radio button is selected
        Assert.assertTrue(repeat.repeatEvery.isSelected());

        //Verify that following message as a summary is displayed: “Summary: Daily every 1 day”
        String summaryMessage = repeat.summary.getText();
        String expected = "Daily every 1 day";
        Assert.assertEquals(summaryMessage,expected);



        //Verify that “Never” radio button is selected as an “Ends” option
        Assert.assertTrue(repeat.repeatEvery.isSelected());


    }

    @Test
    public void test10() throws InterruptedException {

      /**  1.Go to “https://qa1.vytrack.com/"
           2.Login as a store manager
           3.Navigate to “Activities -> Calendar Events”
           4.Click on “Create Calendar Event” button
           5.Select “Repeat” checkbox
           6.Select “After 10 occurrences” as an “Ends” option.
           7.Verify that following message as a summary is displayed: “Summary: Daily every 1 day, endafter 10 occurrences”
       */

      LoginPage loginPage = new LoginPage();
      String username = ConfigurationReader.get("store_manager_username");
      String password = ConfigurationReader.get("store_manager_password");
      loginPage.login(username, password);
      DashboardPage dashboardPage = new DashboardPage();
      dashboardPage.navigateToModule("Activities", "Calendar Events");
      CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
      Thread.sleep(2000);
      calendarEventsPage.createCalendarEvent.click();
      CreateCalendarEventsPage repeat = new CreateCalendarEventsPage();
      repeat.repeat.click();
      repeat.after.click();
      repeat.inputOccurences.sendKeys("10", Keys.ENTER);

      String expected = repeat.summaryFullMessage.getText();
      Thread.sleep(2000);
        System.out.println(expected);

        String actual = "Summary:\n" +
                "Daily every 1 day, end after 10 occurrences";
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void test11(){
        // Go to “https://qa1.vytrack.com/"
        // Login as a store manager
        // Navigate to “Activities -> Calendar Events”
        // Click on “Create Calendar Event” button
        // Select “Repeat” checkbox
        // Select “By Nov 18, 2021” as an “Ends” option.
        // Verify that following message as a summary is
        //displayed: “Summary: Daily every 1 day, end by Nov 18, 2021”

        // Login as a store manager
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");
        loginPage.login(username, password);

        // Navigate to “Activities -> Calendar Events”
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        // Click on “Create Calendar Event” button
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.createCalendarEvent.click();

        // Select “Repeat” checkbox
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        // Select “By Nov 18, 2021” as an “Ends” option.
        createCalendarEventsPage.by.click();
        BrowserUtils.waitFor(2);
        createCalendarEventsPage.byInput.click();
        Select year = new Select(createCalendarEventsPage.year);
        year.selectByValue("2021");
        BrowserUtils.waitFor(2);
        Select month = new Select(createCalendarEventsPage.month);
        month.selectByValue("10");
        WebElement calender = createCalendarEventsPage.calendarDays;
        calender.click();

        // Verify that following message as a summary is
        //displayed: “Summary: Daily every 1 day, end by Nov 18, 2021”
        String expected = "Summary:\n" +
                "Daily every 1 day, end by Nov 18, 2021";
        String actual = createCalendarEventsPage.calendarSummary.getText();
        System.out.println(actual);
        Assert.assertEquals(actual,expected);

    }

    @Test
    public void test12(){
        /**

         // Go to “https://qa1.vytrack.com/"
         //2. Login as a store manager

         //3. Navigate to “Activities -> Calendar Events”
         //4. Click on “Create Calendar Event” button
         //5. Select “Repeat” checkbox
         //6. Select “Weekly” options as a “Repeat” option
         //7. Select “Monday and Friday” options as a
         //“Repeat On” options
         //8. Verify that “Monday and Friday” options are
         //selected
         //9. Verify that following message as a summary is
         //displayed: “Summary: Weekly every 1 week on Monday, Friday”
         */

        //2. Login as a store manager
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");
        loginPage.login(username, password);

        //3. Navigate to “Activities -> Calendar Events”
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        //4. Click on “Create Calendar Event” button
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.createCalendarEvent.click();

        //5. Select “Repeat” checkbox
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        BrowserUtils.waitFor(2);

        //6. Select “Weekly” options as a “Repeat” option
        Select weekly = new Select(createCalendarEventsPage.repeatWeekly);
        weekly.selectByValue("weekly");

        //7. Select “Monday and Friday” options as a “Repeat On” options
        createCalendarEventsPage.monday.click();
        createCalendarEventsPage.friday.click();

        //8. Verify that “Monday and Friday” options are selected
        Assert.assertTrue(createCalendarEventsPage.monday.isSelected());
        Assert.assertTrue(createCalendarEventsPage.friday.isSelected());

        //9. Verify that following message as a summary is
        //displayed: “Summary: Weekly every 1 week on Monday, Friday”
        String actual = createCalendarEventsPage.weeklySummary.getText();
        System.out.println(actual);
        String expected = "Summary:\n" +
                "Weekly every 1 week on Monday, Friday";
        Assert.assertEquals(actual,expected);











    }




}
