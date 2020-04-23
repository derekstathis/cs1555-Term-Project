Derek Stathis
Dgs32

I couldn't get Athlete Dismissal to work correctly.

Also had to remove my ID triggers and sequences from
trigger.sql due to bugs with incorrect increments of
primary keys when inserting values.

Driver.java ReadMe.txt

Compile:
	javac -cp "ojdbc7.jar;." Driver.java
	
Run:
	java -cp "ojdbc7.jar;." Driver
	

How to run:
	1. Change the username and password to your database
	login to get the program to run correctly
	2. Run the program and all the functions should output the information