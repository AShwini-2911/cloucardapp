#Feature: End-to-End App Launch and Login Flow Using QR Code
  #
  #As a QA Engineer
  #I want to validate the full user journey from app launch to successful login
  #So that the onboarding and authentication workflows function correctly
#
  #Background: 
    #Given the mobile app is installed on the device
#
  #@Regression @E2E
  #Scenario: Successful login using QR code after onboarding flow
    #When the user launches the app
    #When the user completes the onboarding steps
    #And the user taps the Upload QR button
    #Then the user should be prompted to choose an app to select a photo
    #When the user selects the photo app and chooses the QR code image
    #Then the user should be navigated to the login page
    #When the user enters the security PIN
    #And the user taps the Login button
    #Then the user should land on the home page of the app
#
