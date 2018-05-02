# NIT-Calicut-Mess-System

In every educational institute there is a system of mess. So in our college also every hostel
whether boys or girls , there are various messes. And everything is managed here manually.
For getting the details about the mess bill and the dues , students have to go to the hostel
office again and again . And also for the purpose of mess card at the end of each mess at the
hostel office.

# Functional Requirements
**Login Window**

Description: The user will enter the credentials to be authenticated.
Response : The user's credentials will be verified.
Pre-condition: User tries to login with his or her valid details.
Post-condition: Either the user is successfully logged in or is an invalid user.
Risk : Prone to SQL injections and denial of service attacks.

**Mess Details**

Description: It will contain the details of all the messes.
Response : The detail of the selected mess will appear on the screen.
Pre-condition: The user is logged in and seeks to check the mess details.
Post-condition: A screen containing mess details will be opened.
Risk: A student may receive incorrect details for his requisites.

**Mess Card Generation**

Description: User will be able to avail a mess card for the desired mess.
Response: An authorized mess card will be generated with user's details.
Pre-condition: Logged in user will select the desired mess and confirm the mess details.
Post-condition: After the confirmation by the user, a mess card will be generated.
Risk : Details of the user on the generated mess card may be incorrect.

**Mess Bill Calculation**

Description: The mess manager in the system will calculate the mess bill according to the
daily fixed charges and extra food item charges.
Response: The calculated mess bill will be reflected in the user's profile.
Pre-condition: The user is logged in and trying to access the mess details and payment dues.
Post-condition: A screen with the calculated mess bill will be reflected.
Risk: Mess bill may be calculated incorrectly.

**Admin Access**

Description: An admin has the authority to access the details of all the members enrolled in
their respective messes.

Response: An admin will verify the details of all the members in their respective messes.

Pre-condition: An admin has logged-in into the system after undergoing the authentication
process.

Post-condition: An admin will confirm the details of required member for his mess
enrolment.

Risk: An unauthorized person might login as an admin.

**Join mess**

Description: Any student can join the mess by undergoing the procedure in the system for
registration in any mess.

Response: Student will be member of the desired mess.

Pre-condition: Student will check the details of all the messes to inquire his mess
requirements.

Post-condition: Student will generate the mess card for the chosen mess by himself.

Risk: Even if the mess intake limit has been crossed, all the currently logged in members can
select that limited seat's mess simultaneously.
