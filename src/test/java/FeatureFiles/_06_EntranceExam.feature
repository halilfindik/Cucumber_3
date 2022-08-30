#1 sınav girişi yapıp
#2 sınav ismi, academic period, grade level girilecek
#3 sınavı kaydet
#4 girilen sınavı sil

Feature: Entrance Exam Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Create and Delete an Entrance Exam
    And Click on the element in the Left Navigation Panel
      | entranceExamsOne  |
      | setupTwo          |
      | entranceExamsTwo  |

    And Click on the element in the Dialog
      | addButton |

    And User sends the keys in dialog content
      | nameInput        | halilExam1  |

    And Click on the element in the Form Content
      | academicPeriod   |
      | academicPeriod1  |
      | gradeLevel       |
      | gradeLevel1      |

    #TODO: Akademik period ve GradeLevel tıklama sorunu

    And Click on the element in the Dialog
      | saveButton  |

    Then Success message should be displayed

    And Click on the element in the Left Navigation Panel
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And User deletes item from Dialog
      | halilExam1 |

    And Success message should be displayed

    Then Success message should be displayed

