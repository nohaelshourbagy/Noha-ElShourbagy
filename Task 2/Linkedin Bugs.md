# Linkedin Bugs

## A  (IOS 14.4, IPhone 11)

### Title: LinkedIn - Homepage - Search Bar - If the user inserted a space in the search bar and clicked search, “See all results” link should not be displayed.

* Open LinkedIn App
* Go to the Search bar in Homepage
* Clear the previous Search history
* Insert space in the search bar

	**Expected**: Nothing should happen
	
	**Actual**: “See all results” text is displayed
	
	**Severity**: 4-low 
	**Priority**: 3
	**Network**: Wifi
Check the screenshot
## B (IOS 14.4, IPhone 11)

### Title: LinkedIn - Homepage/Notification - Search Bar - There should be no search history if the user clicked search without entering any data.

* Open LinkedIn App
* Go to the Search bar Homepage/Notification
* Clear the Search History
* Insert space in the search bar
* Click on See All results
* Click on the back arrow
* Check the search History

**Expected**: There should be no search history since the user searched on nothing

**Actual**: There is search history as per the screenshot

Check the screenshot

**Severity**: 4-low 
**Priority**: 3
**Network**: Wifi



## C (IOS 14.4, IPhone 11)

### Title: LinkedIn - Home - Your Story - The User should be able to add a story even if he/she denied the microphone permission.


* Open LinkedIn App
* Login
* Navigate to Home 
* Click on Your Story
* Allow LinkedIn to access the Camera 
* Don’t Allow LinkedIn to access the Microphone 
* Check the Story

**Expected**: The user should be able to add a story and the camera should be working fine.

**Actual**: The camera is showing a black background and the user is unable to add a story
Check the screen recording.

**Severity**: 2-High 
**Priority**: 2
**Network**: Wifi





## D (IOS 14.4, IPhone 11)

### Title: LinkedIn - Home - Share a post via Airdrop - The sharing window should automatically closed when the user hits done.


* Open LinkedIn App
* Navigate to Home
* Share any post via Airdrop 
* After its shared, click Done

**Expected**: The sharing window should be closed automatically
**Actual**: The sharing window is not closed after the user hits “Done”

Check the screen recording

**Severity**: 4-low 
**Priority**: 3
**Network**: Wifi



## E (IOS 14.4 IPhone 11)
 
### Title: LinkedIn - Forgot Password - The menu tabs are duplicated after the user finished the forgot password process

* Open LinkedIn App
* Login 
* Click on the User Picture in the upper left corner of the screen
* Click on Settings
* Click on Sign in & Security 
* Click on Change Password 
* Click on the Forgot Password Link
* Verify that the email address in the reset screen is correct
* Click on Reset Password Button 
* Navigate to your email inbox and insert the 6 digit code
* Click submit
* Click on Go to LinkedIn
* Check the menu Bar at the bottom of the screen

**Expected**: The Menu bar should not be displayed twice or duplicated
**Actual**: The Menu bar is displayed Duplicated 

Check the screen recording and the screenshot



**Severity**: 4-low 
**Priority**: 3
**Network**: Wifi













## F (IOS 14.4 IPhone 11)

### Title: LinkedIn - Forgot Password - The user profile is displayed in the homepage as if the user is logged in, yet when navigating to settings ,i get redirected to the signup screen.



* Open LinkedIn App
* Login 
* Click on the User Picture in the upper left corner of the screen
* Click on Settings
* Click on Sign in & Security 
* Click on Change Password 
* Click on the Forgot Password Link
* Verify that the email address in the reset screen is correct
* Click on Reset Password Button 
* Navigate to your email inbox and insert the 6 digit code
* Click submit
* Click on Go to LinkedIn
* Click on the user picture 
* Click on Settings 

**Expected**: The user should be redirected to the settings screen not the Signup screen.

**Actual**: The user is redirected to the signup screen

Check the screen recording 

**Severity**: 2-High
**Priority**: 1
**Network**: Wifi



## G (IOS 14.4 IPhone 11)

### Title: LinkedIn - Forgot Password - After the user finished the forgot password process, the app should sign the user out and redirect to the login page.


* Open LinkedIn App
* Login 
* Click on the User Picture in the upper left corner of the screen
* Click on Settings
* Click on Sign in & Security 
* Click on Change Password 
* Click on the Forgot Password Link
* Verify that the email address in the reset screen is correct
* Click on Reset Password Button 
* Navigate to your email inbox and insert the 6 digit code
* Click submit
* Click on Go to LinkedIn

**Expected**: The user should be redirected to the Login Page or the homepage (In Anonymous mood)

**Actual**: The user is redirected to the homepage logged in.

Check the screen recording E'

**Severity**: 3-Medium 
**Priority**: 2
**Network**: Wifi




## H (IOS 14.4 IPhone 11)

### Title: LinkedIn - Change Password - The user should not be allowed to insert the old password in the new Password field


* Open LinkedIn App
* Login
* Click on the user picture
* Click on Settings
* Click on Change Password
* In the New password field, insert the old password
* Fill in the rest of the form and submit

**Expected**: The user should not be allowed to insert the old password in the new password field and a validation message should be fired
**Actual**: No validation message is fired and the app accepts the input successfully 

**Severity**: 2-Medium 
**Priority**: 1
**Network**: Wifi




## I (IOS 14.4 IPhone 11) 
### Title: LinkedIn - Change Password - After the user submits the change password form, the user should be redirected to the homepage.

* Open LinkedIn App
* Login 
* Click on the user picture
* Click on Settings
* Click on Change Password
* Fill in the form and submit

**Expected**: The user should be redirected to the Homepage after submission 

**Actual**: The user remains in the Change password screen

Check the screenshot
**Severity**: 4-Medium 
**Priority**: 2
**Network**: Wifi






## J(IOS 14.4 IPhone 11)

### Title: LinkedIn - SignUp - If the user cleared the app from the iPhone History, and opened it again, it should not open in the last signup step the user reached.

* Open LinkedIn App
* Click on Signup
* Follow the steps till the First and last name step
* Clear the App from the iPhone History 
* Open the App again

**Expected**: The app should open naturally , first it should show the welcome screen and then redirects to the homepage.

**Actual**: The app opens in the same signup step the user last reached before removing it from the IPhone history 

Check the screen recording

**Severity**: 3-Medium 
**Priority**: 1
**Network**: Wifi




## K(IOS 14.4 IPhone 11)

### Title: LinkedIn - Messaging - Voice Messages - The user should not be able to send voice messages if the microphone is not enabled from the settings


* Open LinkedIn App
* Login
* Navigate to Messages
* Open a conversation with any connection
* Click on the voice recording icon 
* In the Permission popup, click on Settings
* Don’t change the toggle in the settings
* Go back to LinkedIn App 
* Navigate to the conversation and try to send a voice record

**Expected**: The permission popup should be displayed

**Actual**: The user can send a voice record , but its received empty at the other end.

Check the screenshot

**Severity**: 2-high
**Priority**: 1
**Network**: wifi


## L(IOS 14.4  IPhone 11)

### Title: LinkedIn - Change Password - when the user entered white spaces for all the password input fields, the system displayed an incorrect validation message

* Open LinkedIn App
* Login
* Navigate to settings
* Choose to change Password
* Insert spaces in all the passwords fields
* Click submit

**Expected**: A validation message shall be displayed that white spaces are not allowed.

**Actual**: A validation message is displayed “Please Enter a new Password”

Check the screenshot
**Network**: wifi

**Severity**: 3-medium
**Priority**: 1




## M(IOS 14.4 IPhone 11)

### Title: LinkedIn - Reset Password - If the user clicked on the back arrow in the reset password screen, a warning shall be displayed


* Open LinkedIn App
* Login Navigate to settings
* Navigate to Sign & Security 
* Navigate to Change Password
* Click on the forget password link
* Insert the email address and submit
* Insert the verification code and submit
* After the reset password screen is opened, click on the back arrow in the upper left corner of the screen

**Expected**: A warning popup shall be displayed “If you go back, you will not be able to reset your password. Would you like to proceed?” with yes and Cancel option buttons

**Actual**: A message is displayed that this file cannot be downloaded, and underneath is a “Something went wrong ” screen.

Check the screen recording
**Network**: wifi

**Severity**: 2-High
**Priority**:1