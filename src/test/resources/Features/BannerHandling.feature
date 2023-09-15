@ai @rtc @dashboardAutomation @banner

Feature: Dashboard Recomendation Page

  Scenario: Verify that user is able to click on a link present on Recommendation section
    Given user is on Dashboard banner Page
    And user tries expand the recommendations for the devices
    Then the recommendations gets expanded
    When user scrolls down the page
    Then user clicks on Automation Testing service button present on the screen
    And user scroll down the page till footer