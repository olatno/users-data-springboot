# users-data-springboot
Simple users data spring boot
	Encrypted users data rest API 

		Build spec. 

		1. Spring boot framework 

		2. Hibernate 

		3. Java 11. 

		4. Intellij ide 

		5. Spring boot H2 imemory database 

		6. Inbuilt tomcat in spring boot

	Run and deploy the spring boot application
	
		1. git clone git@github.com:olatno/users-data-springboot.git
		
		2. Open the project with intellij

		3. In IntelliJ go to the Build Project tool from the top right hand, select the ApiApplication.

		4. Click on the green play button to run the application

		5. After successful running, go to localhost:8080 to view the web pages.

		6. The default page will show 3 input fields, first name, last name, and email.

		7. The system allows the user to input as many records which is saved into the database.
		
	Run from command line:
	
		1. git clone git@github.com:olatno/users-data-springboot.git
		
		2. Go to the users-data-springboot root and use the command - mvn spring-boot:run
		

	To verify that user records are encrypted, please go to localhost:8080/h2
	
		1. In the login window, please use jdbc:h2:mem:usersData for the JDBC ULR field

		2. Default user - sa

		3. The password - password

		4. After access to the database, please click on USERS_DATA the database schema at the top left of the window. This will show SELECT * FROM USERS_DATA query in the query text area

		5. Click on the run button which will show all records inputted as encrypted data.

	The following requirement has been met

		1. The data is encrypted when saved into the database

		2. The code has been unit tested including integration testing

		3. The project has been built using MVN

		4. The project has been hosted on GitHub URL - https://github.com/olatno/users-data-springboot

		5. I have created the readme file containing building and deployment instructions

		6. The encrypted data is decrypted in the UsersDataEncryptor class with the method convertToEntityAttribute. This can also be verified from the response that we get in the frontend after saving data to the database.
		
    Note
	
		Please enable lombok plugin in the intellij by going to settings -> plugin -> marketplace -> search for lombok and then click on install
