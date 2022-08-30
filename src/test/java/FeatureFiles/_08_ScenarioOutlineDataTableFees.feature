#  Daha önceki Create a Fee, delete Fee Senaryosunu
#  Aşağıdaki 5 farklı değerler için çalıştırınız.
#
# | ExamName        | AcademicPeriodOption      | GradeLevelOption |
# | Math exam is1   | academicPeriod2              | gradeLevel4  |
# | IT exam is1     | academicPeriod2              | gradeLevel2  |
# | Oracle exam is1 | academicPeriod2              | gradeLevel3  |
# | Math exam  is1  | academicPeriod2              | gradeLevel1  |

Feature: Fee Scenario Outline with DataTable Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Create a Fee, Delete Fee
    And Click on the element in the Left Navigation Panel
      | setupOne    |
      | parameters  |
      | fees        |

    And Click on the element in the Dialog
      | addButton |

    And User sends the keys in dialog content
      | nameInput             | <feeName>            |
      | codeInput             | <feeCode>            |
      | integrationCodeInput  | <intCode>            |
      | priorityInput         | <feePriority>        |

    And Click on the element in the Dialog
      | saveButton  |

    And Success message should be displayed

    And User deletes item from Dialog
      | <feeName> |

    And Success message should be displayed

    Examples:
      | feeName     | feeCode     | intCode | feePriority  |
      | HalilFee5   | 001015111   | papara  | 147          |
      | HalilFee6   | 001110132   | param   | 148          |
      | HalilFee7   | 014020113   | iyzico  | 149          |
