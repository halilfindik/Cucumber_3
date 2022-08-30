#  Bir önceki Exam Giriş Senaryosunu
#  Aşağıdaki değerler için çalıştırınız.

#| ExamName        | AcademicPeriodOption      | GradeLevelOption |
#| Math exam is1   | academicPeriod2              | gradeLevel4  |
#| IT exam is1     | academicPeriod2              | gradeLevel2  |
#| Oracle exam is1 | academicPeriod2              | gradeLevel3  |
#| Math exam  is1  | academicPeriod2              | gradeLevel1  |

Feature: Entrance Exam Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Create and Delete an Entrance Exam
    And Click on the element in the Left Navigation Panel
      | entranceExamsOne  |
      | setupTwo          |
      | entranceExamsTwo  |

    And Click on the element in the Dialog
      | addButton |

    And User sends the keys in dialog content
      | nameInput        | <ExamName>  |

    And Click on the element in the Form Content
      | academicPeriod   |
      | <AcademicPeriodOption>  |
      | gradeLevel       |
      | <GradeLevelOption>      |

    #TODO: Akademik period ve GradeLevel tıklama sorunu

    And Click on the element in the Dialog
      | saveButton  |

    Then Success message should be displayed

    And Click on the element in the Left Navigation Panel
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And User deletes item from Dialog
      | <ExamName> |

    And Success message should be displayed

    Then Success message should be displayed

    Examples:
      | ExamName       | AcademicPeriodOption      | GradeLevelOption |
      | Math101 Halo   | academicPeriod1              | gradeLevel1  |
      | IT101 Halo     | academicPeriod1              | gradeLevel1  |
      | Oracle101 Halo | academicPeriod1              | gradeLevel1  |
      | Math201 Halo   | academicPeriod1              | gradeLevel1  |

    #TODO yukarıdaki akademik ve Grade Level option için academicPeriod2  ve gradeLevel1,3,4  bulunup exapmple koyulacak

