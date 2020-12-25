Feature: Find friends
  Scenario: Find Alexander
    Given Bob opens login page
    And Bob logins
    When Bob enters in search bar Alexander
    Then Bob should find at least 1 Alexander