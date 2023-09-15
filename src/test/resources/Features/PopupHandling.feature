@ai @rtc @dashboardAutomation @popup

Feature: Dashboard App Performance 

  Scenario: Verify user can see App info performance of the devices
    Given user is on Dashboard Popup Page
    When user clicks on News App info
    Then user can see News App info performance of devices
    When user scrolls down the page
    Then user clicks on Performance Testing service button present on the screen
    And user scroll down the page till footer