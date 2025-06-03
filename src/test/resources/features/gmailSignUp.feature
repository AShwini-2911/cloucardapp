Feature: End-to-End App Launch and Login Flow Using email
  
  As a QA Engineer
  I want to validate the full user journey from app launch to successful login
  So that the onboarding and authentication workflows function correctly

  Background: 
    Given the mobile app is installed on the device

  #@Regression @E2E
  #Scenario: Successful sign-up with onboarding, email verification, and QR flow
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
  Scenario: Sign up with invalid email format
    Given the user launches the application
    When the user completes the onboarding skip
    And the user taps on the Sign Up button
    When the user enters a invalid email ID
    And the user accepts the Terms and Conditions
    And the user taps on the Continue button
    Then an error message should be displayed "Enter a Valid email"
