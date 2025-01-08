# Metro-POS-System
A clone of the METRO POS System submitted as a semester project for the course Software Construction and Development. Written in following tech stack:

1. Frontend: HTML, CSS (Tailwind CSS), JavaScript
2. Backend: Spring Boot (Java)
3. Database: MySQL (www.freesqldatabase.com)
4. Build Tool: Maven
5. Version Control: Git
6. Testing: JUnit, Mockito
7. Notifications: Twilio (WhatsApp notifications), MailTrap (Balance Sheet of Daily Transactions)

The web application simulates the workings of a POS system including 4 entities with their privileges:
![Screenshot 2025-01-08 130059](https://github.com/user-attachments/assets/22e2d2dc-dc8a-41cd-bea8-406376396b43)

## 1. Super-Admin
Has root priveleges for the entire application. Only 1 SuperAdmin exists and can only do the following:
![superadmin](https://github.com/user-attachments/assets/d11ae4d6-9809-4b9e-815b-3255ab088019)

1. Adding new branches in any location.
2. Adding a respective Branch Manager to a branch.
3. Edit details of branch and their respective employees
4. Edit the status of branch [active | inactive].
5. Determine no. of employees [limit Branch Manager's priviliges]
6. Recieves data related to the total purchases and sales information for all registered branches.

## 2. Branch Manager
Has priveleges limited to its own branch in terms of adding and removing new employees [limited under SuperAdmin domain]
![BM](https://github.com/user-attachments/assets/83e44e53-13fe-46d3-9d8b-afc0ceb78c54)

1. Can add and remove employees [Data Operator | Cashier]
2. Recieves WhatsApp message notification of the employees logging into the system.
![twilio3](https://github.com/user-attachments/assets/b4bbce05-663b-4672-a9b1-164fba255957) ![twilio2](https://github.com/user-attachments/assets/1c4607fb-cfda-4376-9861-bc8e9cba4f6c)
4. Recieves Excel Balance Sheet of daily transactions collected under cashier of respective branch.

## 3. Data Operator
Assigned/employed under a respective Branch Manager, to add new products and their respective information limited to that branch.
![Screenshot 2025-01-08 131512](https://github.com/user-attachments/assets/0d5f8f4d-d5dc-4d4d-8dae-4900538b796b)
1. Can Add and Remove Products with Barcode information, name, type, quantity and respective vendor
2. Can Add and Remove Vendors with name, email, phone, address etc.
3. Can edit respective pieces of each information for all products and vendors.

## 4. Cashier
Base Level employee of their respective branch and can only be added/removed by their Branch Manager
![Screenshot 2025-01-08 131458](https://github.com/user-attachments/assets/b63d84e7-675f-41c8-9697-1b7420599190)

1. Can scan/search products using their assigned barcodes and quantities of their respective products
2. Can deduct and remove product from list.
3. Generate Bill of transaction (added within balance sheet).
4. Send Total Balance sheet data to Branch Manager at the end of shift.
![Screenshot 2025-01-08 141503](https://github.com/user-attachments/assets/e7b42f12-8a95-4f1d-b14d-98ad9992d523)
5. Log out of Dashboard

______________________________________________________________________________

# Deployment
> The application is deployed as on an embedded TomCat Server within the SpringBoot application, which renders Hikari thread pools to provide a connection pooling mechanism with the MySQL JDBC connection. This provide a thread-safe feature to ensure database connectivity in parallel to the site loading in the background.
> When launched, the project will automatically open on localhost:8080, with a default login screen.

The following should be edited in terms of your configuration basis for your own use.

1. Custom JDBC connection tailored with site schema.
2. Twilio SandBox configuration (render it with your own number).
3. MailTrap for custom email render.

All of the following is required to be edited within the *application.properties* file within the sites and relevant *.java* classes which use these services within.

> Future renditions of this project will be deployed within a Docker container for easy access and deployment. Tutorial will be posted later.
> Remember to compile the project as .WAR file, to make use of the static resources such as web pages and node packages





