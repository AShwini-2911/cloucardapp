
Feature: Upload File in Files Module
 
 
 Background: 
    When the user taps on the Files module
 
  @Regression @E2E
  Scenario: files module- select file and upload it 
    And the user taps on the Create icon
    And the user taps on the Upload File option
    And the user selects a file from the file picker
    And user able to see notification of file uploaded
    Then the file should be uploaded successfully and visible in the file list
    
  Scenario: Sort uploaded files alphabetically (A-Z)
    When the user taps on the "A-Z" sort option
    Then the file list should be sorted alphabetically from A to Z

  Scenario: Sort uploaded files in reverse order (Z-A)
    When the user taps on the "Z-A" sort option
    Then the file list should be sorted alphabetically from Z to A

  Scenario: Sort uploaded files by file size
    When the user taps on the "File size" sort option
    Then the file list should be sorted in descending order of file size
    
  Scenario: Select file and perform delete operation
  When user select file to delete
  And click on delete button on files
  Then success message should be displayed "Moved to trash successfully"
  
  
 
    
 