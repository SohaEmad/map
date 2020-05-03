# indoor
Indoor mapping


The API contain 5 Paths  2 for the users and 3 for the owner 

To use the system you can checkout through intellij 

 User paths 
1-	Show the user location history    http://localhost:9999/user?user_id=1
•	Front end:  can be used to display user tracker on his profile 

2-	Enter a new information about the user 

•	all the information will be taken from the login process and js detection library for the gps and mobile version nothing to show for the user except maybe the block name 
•	front end: the display for the user could be a map of the building with a sign of his current position in one of the building blocks 


owner paths:

1-	Show all mobile devices http://localhost:9999/mobile
•	Front end : can be shown as a table of all user column mobile phone  
2-	Show all users information http://localhost:9999/users

•	Front end: I wanted to add a join date to show time line by a curve that show the users interest in the building app 
•	It also could be by user name setting the user name and phone in a table 

3-	Show the heat map http://localhost:9999/building

•	Front end : can be shown like a big table by building block and number of user in each block or by bar chart for the different building block and the number of visitor who been to this block 


