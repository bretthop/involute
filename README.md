#Involute

Atm, this is a basic project skeleton. It has examples of saving and retrieving data from a database, rendering
HTML and serving that back to the user. Its a basic tracer bullet. Just something to build off of.

It uses:
    - Spring
    - MySQL
    - Basic JDBC (for now)

##Instructions
    - Setting up the database:
        - Set up a local MySQL instance that contains a user with the user/pass combo: root/password
        - Create a database called 'involute' (this is done by the command 'create database involute')
        - Run the SQL contained in db/changes/00001.sql to create the user_account table
    - Setting up the web server:
        - Install Tomcat (google it)
    - Install Maven
        - Again, google it
    - Build the project with Maven
        - Open a terminal window and navigate to the root of this project
        - Run the command 'mvn package'
        - This will create a directory in the root called 'target' and inside there will be an artifact called 'Involute.war'
    - Deploy the WAR file to Tomcat
        - Copy the 'Involute.war' file into the 'webapps' folder in your Tomcat installation
        - Restart the Tomcat instance
    - Done!
