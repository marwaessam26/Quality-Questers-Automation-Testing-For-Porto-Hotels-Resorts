Feature:  Porto Hotels Meetings , Events Verification & Restaurants Page - Porto Sokhna

  Scenario: Verify Meetings & Events Page
    Given User navigated to Porto Hotels website for Meetings and Events
    When User navigates to Meetings and Events page of Porto Sokhna Hotel
    Then Venue details or capacity information should be displayed


Scenario: Verify Restaurants Page - Porto Sokhna
Given User navigates to Porto Sokhna Hotel & Spa
When User clicks on Restaurants tab
Then At least one restaurant should be displayed with name and description



