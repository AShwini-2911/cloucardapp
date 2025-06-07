Feature: Upload File in Files Module
 
 
Background: 
    When the user taps on the Files module
 

Scenario: Search for an existing file by its name
  And a file named "text.txt" exists in the file listing
  When I enter "text.txt" into the search bar
  And I initiate the search
  Then I should see "text.txt" in the displayed file listing
  And no other files should be displayed 
  And the search result count should indicate 1 matching file

Scenario: Search for a non-existent file
  When I enter "text.txt" into the search bar
  And I initiate the search
  Then I should see a "No results found" message
  And the file listing should be empty
  And the search result count should indicate 0 matching files (if applicable)

Scenario: Search with partial file name (if supported)
  And files named "report_q1.xlsx", "report_q2.xlsx", and "presentation.pptx" exist in the file listing
  When I enter "report" into the search bar
  And I initiate the search
  Then I should see "report_q1.xlsx" in the displayed file listing
  And I should see "report_q2.xlsx" in the displayed file listing
  And I should not see "presentation.pptx" in the displayed file listing
  And the search result count should indicate 2 matching files (if applicable)

Scenario: Search with case-insensitive file name (if supported)
  And a file named "Invoice_2025.docx" exists in the file listing
  When I enter "invoice_2025.docx" into the search bar (lowercase)
  And I initiate the search
  Then I should see "Invoice_2025.docx" in the displayed file listing
  And the search result count should indicate 1 matching file (if applicable)

Scenario: Search with special characters in file name (if supported)
  And a file named "file_with_!@#$.txt" exists in the file listing
  When I enter "file_with_!@#$.txt" into the search bar
  And I initiate the search
  Then I should see "file_with_!@#$.txt" in the displayed file listing
  And the search result count should indicate 1 matching file (if applicable)

Scenario: Search with empty search query
  When I leave the search bar empty
  And I initiate the search
  Then I should see the full file listing (or no change in listing if previous search was active)
  And the search result count should reflect the total number of files (if applicable)
