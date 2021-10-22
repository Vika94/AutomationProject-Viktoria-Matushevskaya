Feature: Test
  Scenario: Test for Booking
    Given go to "https://www.booking.com/index.html?aid=1376321"
    When enter hotel name and click search button
    Then сheck that the hotel is displayed and its rating is 4 stars