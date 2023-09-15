@ai @rtc @dashboardAutomation @alert

Feature: Dashboard Home Page

  Scenario: Verify that user is able to access the APK on the dashboard page
    Given user is on Dashboard Alert Page
    When user clicks on APK updater
    Then user can see News APK updater performance of devices
    When user scrolls down the page
    Then user clicks on Functional Testing service button present on the screen
    And user scroll down the page till footer