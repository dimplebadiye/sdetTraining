Feature: ELSC_011

	TO verify whether application allows admin to add classes, subscribe user to class, subscribe class to course & subscribe class to sessions.

	Scenario: Admin actions
		Given user navigate to eLearning site
		And user enter Username: 'admin'
		And user enter Password: 'admin@123'
		And user click 'Login' button
		And user is on Home page
		When user click 'Administration' tab
		And users select 'Classes' under Users section
		And user click 'Add classes' icon
		And user enter data in 'Add classes' page
		And user click 'Add' button
		And user locates newly added class 'DimTest 1'
		And if the class already exist get users, courses and sessions count 
		And user click 'Subscribe user to class' icon
		And select users from 'Users on platform' section and add to 'Users in group' section
		And click 'Subscribe Users to class' button
		And user locates newly added class 'DimTest 1'
		And user click 'Subscribe class to courses' icon
		And select cources from 'Courses on the platform' section and add to 'Courses in group' section
		And click 'Subscribe class to courses' button
		And user locates newly added class 'DimTest 1'
		And user click 'Subscribe class to sessions' icon
		And select sessions from 'Sessions not subscribed' section and add to 'Sessions in group' section
		And click 'Subscribe class to sessions' button
		And user locates newly added class 'DimTest 1'
		Then selected course should get subscribe to the class & number of courses subscribed should get displayed in courses
		And user Logout of 'eLearning' site