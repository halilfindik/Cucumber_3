#  Employee menusu için Create-Exist-Delete bölümleri olan Senaryoyu yazınız
#  Daha sonra aynı senaryoyu 5 farklı deger için çalıştırınız.

Feature: Employee Scenario Outline with DataTable Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Create Employee, Delete Employee

    And Click on the element in the Left Navigation Panel
      | humanResources     |
      | employees          |

    And Click on the element in the Dialog
      | addButton |

    And User sends the keys in dialog content
      | firstNameInput            | <feeName>            |
      | lastNameInput             | <feeCode>            |
      | integrationCodeInput      | <intCode>            |
      | priorityInput         | <feePriority>        |






    Examples:
      | feeName | feeCode | intCode | feePriority |