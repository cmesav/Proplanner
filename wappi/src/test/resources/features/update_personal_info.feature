#Author: mesa.cristian@gmail.com

Feature: Update personal information
  As a client
  I want to update my personal info
  to be in contact

  Background:
    Given I log in the page

  @UpdateInfo
  Scenario: update information
    When I fill the data
    Then I see the message "Tu información se guardó correctamente"

    @ValidateUpdateFields
    Scenario: Validate mandatory fields
      When I send the personal info form void
      Then I see the error in the mandatory fields