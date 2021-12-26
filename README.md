# Dalhousie University | Fall 2021 | CSCI5410 | SDP (Serverless Data Processing)
All five assignments and the final group project is done in class CSCI5410 (Serverless Data Processing) Fall 2021 of MACS at Dalhousie University.<br/>


## Authors
* [Dhrumil Rakesh Shah](mailto:dh647095@dal.ca) - *(Creator)*

## Assignments

### Assignment 1
* This assignment covers some basic concepts of cloud computing and services. The primary objective of this assignment is to introduce you to the cloud computing platform and perform a cloud computing literature review.
📄 [Problem Statement PDF]()<br/>
<br/>

### Assignment 2
* This assignment covers concepts of containerization and Serverless components of cloud computing. The primary objective of this assignment is to introduce you to the cloud computing containerization application using Docker and creation of a chatbot using Lex.
📄 [Problem Statement PDF]()<br/>
<br/>

### Assignment 3
* This assignment will help you learn a key concept related to Cloud computing through a literature study. In addition, by implementing a simple Serverless application, you will get practical experience of event-driven application building.
📄 [Problem Statement PDF]()<br/>
<br/>

### Assignment 4
* This assignment will help you learn some key services of AWS platform. In this assignment, you are required to work on GCP ML, and AWS Comprehend.
📄 [Problem Statement PDF]()<br/>
<br/>

### Assignment 5
* This assignment will help you learn some key services of AWS platform. In this assignment, you are required to work on AWS Lambda/SQS/SNS.
📄 [Problem Statement PDF]()<br/>
<br/>

## Final Group Project
* Project Description: DALSoft5410 is building a serverless SafeDeposit using multi-cloud deployment model, and Backend-as-a-Service (BaaS). The SafeDeposit, should provide customization feature, and additional services for authorized users, and limited services to guests. The SafeDeposit should provide an online virtual assistance, which can quickly answer the queries of users, and in addition, it should provide a message passing functionality between the authorized users.
* Inception Year: 2021
* Team Name: Group 5
* Team Members:
	* [Dhrumil Amish Shah](mailto:dh416386@dal.ca)
    * [Dhrumil Rakesh Shah](mailto:dh647095@dal.ca)
    * [Sanket Ushangbhai Mehta](mailto:sn630454@dal.ca)
* Project Features:
	* User Management Module (By [Dhrumil Amish Shah](mailto:dh416386@dal.ca))
		* Sign up validation (GCP and AWS) - Registering maximum of 3 users for each SafeDeposit box.
		* Once registered the user will get a box number dynamically generated with a valid logic.
		* Managing and storing User details (GCP and AWS)
	* Authentication Module (By [Dhrumil Amish Shah](mailto:dh416386@dal.ca))
		* ID-password - AWS DynamoDB
		* Question Answer - Firebase Firestore
		* Caesar Cipher - AWS Lambda
	* Online Support Module (By [Dhrumil Rakesh Shah](mailto:dh647095@dal.ca))
		* Bots should respond to queries - Online virtual assistance for navigation, searching box numbers based on clue provided etc... - AWS Lambda
	* Message Passing Module (By [Dhrumil Amish Shah](mailto:dh416386@dal.ca))
		* Authorized users should be able to communicate - GCP Pub/Sub
	* Machine Learning Module (By [Sanket Ushangbhai Mehta](mailto:sn630454@dal.ca))
		* To identify the similarity of the image file and to add appropriate matching score - You can use GCP built-in image classification algorithm. - GCP AutoML and GCP Vertex AI
	* Web Application Building and Hosting (By [Dhrumil Amish Shah](mailto:dh416386@dal.ca))
		* Building a front-end application using suitable framework, and calling backend services - Use of React, Nodejs, Lamda etc. - Google Container Registry (GCR) and Google Cloud Run
		* Hosting of entire application and user/client facing interface (GCP CloudRun or AWS)
	* Report Generation and Visualization Module (By [Dhrumil Rakesh Shah](mailto:dh647095@dal.ca))
		*  User login or access Statistics - GCP DataStudio
	* Documentation - Team Work
		* This project requires extensive and systematic documentation.
		* Every team meeting must be logged with dates, and added as part of design document, and final report. 
* Final Group Project GitHub: [Final Group Project]()
