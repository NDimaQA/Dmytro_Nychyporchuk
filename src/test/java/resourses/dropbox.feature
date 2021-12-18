Feature: Dropbox Api Test

  Scenario Outline: File uploading test
    Given I have a file "<name>"
    When I upload file "<name>" to Dropbox
    Then I see file "<name>" successfully uploaded
    Examples:
      |                 name |
      |         Homework.txt |


  Scenario Outline: Get file metadata test
    Given I have an uploaded file "<name>"
    When I request metadata of file "<name>" by its id
    Then I receive metadata for file "<name>"
    Examples:
      |                 name |
      |         Homework.txt |

  Scenario Outline: Delete files test
    Given I have an uploaded file "<name>"
    When I ask to delete file "<name>"
    Then I see file "<name>" is successfully deleted
    Examples:
      |                 name |
      |         Homework.txt |

