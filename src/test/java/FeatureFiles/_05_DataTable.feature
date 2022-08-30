Feature: DataTable Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

    Scenario: Create Country
      And Click on the element in the Left Navigation Panel
        | setupOne   |
        | parameters |
        | countries  |
      And Click on the element in the Dialog
        | addButton |

      And User sends the keys in dialog content
        | nameInput   | halil1  |
        | codeInput   | hali1   |

      And Click on the element in the Dialog
        | saveButton  |

      And Success message should be displayed

      And User deletes item from Dialog
        | halil1 |

    Scenario: Create a Nationality
      And Click on the element in the Left Navigation Panel
        | setupOne     |
        | parameters   |
        | nationality  |

      And Click on the element in the Dialog
        | addButton |

      And User sends the keys in dialog content
        | nameInput   | halilNat11 |

      And Click on the element in the Dialog
        | saveButton  |

      And User deletes item from Dialog
        | halilNat1 |

      And Success message should be displayed

    Scenario: Create a Fee, Delete Fee
      And Click on the element in the Left Navigation Panel
        | setupOne     |
        | parameters   |
        | fees         |

      And Click on the element in the Dialog
        | addButton |

      And User sends the keys in dialog content
        | nameInput             | halilFee1 |
        | codeInput             | hll1      |
        | integrationCodeInput  | h.f.1     |
        | priorityInput         | 112       |

      And Click on the element in the Dialog
        | saveButton  |

      And User deletes item from Dialog
        | halilFee1 |

      And Success message should be displayed


      # Senaryo Outline'da verilen değerler için
      # DataTable'da ise sadece ilgili step için