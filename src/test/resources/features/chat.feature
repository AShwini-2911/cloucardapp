#Feature: End-to-End App chat flow Using email
  #
  #As a QA Engineer
  #I want to validate the full user journey from app launch to successful chat
  #So that the onboarding and authentication workflows function correctly
#
  #Background: 
    #Given the mobile app is installed on the device
#
  #@Regression @E2E
  #Scenario: User chat
    #Given the user launches the application
    #When the user completes the onboarding skip
    #And the user taps on the Sign Up button
    #When the user enters a valid email ID
    #And the user accepts the Terms and Conditions
    #And the user taps on the Continue button
    #And the user taps the Verify Email button inside the email
    #When the user taps the Continue button on the verification success screen
    #And the user creates a new security PIN
    #And the user confirms the PIN by tapping the Confirm and Continue button
    #And the user taps Continue on the generated QR code page
    #And the user taps the Lets Get Started button
    #Then the user should land on the home page of the app
    #And user click on chat module
    #And user click on create chat icon
    #And user click on username
    #And user enter username
    #And user click on continue username button
    #And user type the message
    #Then user click on send message button
