# City Record Online Workgroup (CROW) - WebApp

This is the main repository containing efforts pertaining to the web app development of CROW. For parsing libraries, see https://github.com/CityOfNewYork/CROL-Parsing or https://github.com/CityOfNewYork/CROL-Schema for parsing.

Disclaimer. In case of conflicting document versions, please refer to documents mentioned in GitHub as the latest version.


##Goal 

To serve as a temporary pipeline between the DCAS's internal DB structure and the optimized public schema to be exposed on the open data portal.

##Deliverables

* Cloud deployed web app to handle and validate requests and data output

* Set of integrated parsers to add structure where it is missing

* Full interactive documentation (Swagger- WIP)



##Overview

![alt tag](https://raw.github.com/CityOfNewYork/CROL-WebApp/master/img/diagram.png)

The web app handles database generated JSON objects and makes them available as structured JSON-LD objects.

To invoke the parsers, the client calls the web app specifying the document type ( the combination of NoticeType and Agency) of the data submitted. (As the work progresses, further normalization and standardization will follow to eventually unify the various libraries into one library that can handle all the different Document Types.)

 The web app is written in JAVA and and will map the input fields to a new Jstructured JSON-LD object based on a template.  This is then  in the document oriented database. The web app will then start calling on the individual parsers to enrich the individual JSON objects.

 The complete JSON-LD object will then remained stored and can be quieried through REST calls.

###Technologies

 * Python
 * Mongo DB
 * JSON, JSON-LD
 * JSON Schema
 * REST API
 * GitHub
 * Git
 * Java
 * Heroku & AWS



####JSON-LD
Each notice is stored as a JSON-LD document. Fully JSON based and compatible, JSON-LD is a lightweight Linked Data format. It is easy for humans to read and write, and provides a way to help JSON data interoperate at Web-scale. It is adopted by Google, Yahoo, Yandex, and Microsoft, and will provide the data with an off-the shelf integration to existing web apps as well as mapping by the major search engines of the city record data. Hence, The key project goals of “structuring” and “standardizing” will be achieved by adapting JSON-LD and established object structures from sources like schema.org and thepopoloproject.com.


####JSON Schema

We use JSON Schema to describe the data format in a clear, human- and machine-readable documentation. It provides complete structural validation, useful for automated testing as well as validating client-submitted data


###Schema Structure
The current proposed schema (in JSON-LD ) is built up by
* (a) notice skeleton (fields that are shared by all notice types), 
* (b) attributes (recursive and standardized objects such places, events, documents, organizations), and
* (c) sub-configurations (the set of notice-type specific fields, belonging, for instance, to all solicitations, or court notices). 
Skeleton

For more info, please see https://github.com/CityOfNewYork/CROL-Schema 


### Parsing libraries

A parser needs to be deployed as a standalone web- application ([See example](https://github.com/CityOfNewYork/addressparser). The response has to to validate according to the relevant section of the JSON Schema it seeks to enrich.

Table of available parsers (as of June 3, 2015)


Name          |       Object to Enrich             |      Status              |   Notes            | URl
--------------|------------------------------------|--------------------------|--------------------|--------------
Address Parser      | refLocation					       |       Draft              |  Handles most addresses, but cannot distinguish between referenced location and meeting location yet.                 |  ([Address Parser Repo](https://github.com/CityOfNewYork/addressparser))



## How to connect

The web app supports full REST (POST, GET, PUT, DELETE). The web-app supports JSON in the body. There are no query limits to the web-service.

The web app is currently deployed at: 

http://ec2-52-6-170-221.compute-1.amazonaws.com:8080/crol/v1/notice

NB. Remeber to 
 * only pass cammelCase for the terms (c.f. "requestId")
 * specify to specify content-type in the header (for POST & GET)

		Content-Type: application/json 	




### POST

To POST one or multiple JSON objects, simply use the POST to the endpoint, passing the JSON as an array.



Example:

POST http://ec2-52-6-170-221.compute-1.amazonaws.com:8080/crol/v1/notice with the following

	[
	  {
	  "startDate": "2014-10-27 00:00:00", 
	  "endDate": "2014-10-27 00:00:00", 
	  "shortTitle": "BOARD MEETINGS", 
	  "agencyName": "Board Meetings", 
	  "sectionID": "1", 
	  "agencyCode": "NBM", 
	  "sectionName": "Public Hearings and Meetings", 
	  "typeOfNoticeCode": "12", 
	  "additionalDescription": "NOTICE IS HEREBY GIVEN, pursuant to law, that the New York City Department of Consumer Affairs will hold a Public Hearing on Wednesday, January 28, 2015, at 2:00 P.M., at 66 John Street, 11th Floor, in the Borough of Manhattan, on the following petitions for sidewalk café revocable consent: 1. 132 Mulberry Inc. 132 Mulberry Street in the Borough of Manhattan.",
	  "requestID": "20140623104", 
	  "agencyDivision": "", 
	  "typeOfNoticeDescription": "Meeting", 
	  "confirmationNumber": "20140623104", 
	  "dueDate": ""
	 }
	 ]




### GET

The service will allow Public JSON-LD documents (i.e. City Record adverts) to be queried by their various properties through an HTTP request. An authorization token is NOT required.

URL:

		http://ec2-52-6-170-221.compute-1.amazonaws.com:8080/crol/v1/notice/


There are currently two ways of quering the notices, both specified in the header;


#####Specifying the last request date. This returns all new notices since last request 

Header: 
	
		lastRequestDate: 2015-06-03T04:18:58.155Z

Example:
	
		http://ec2-52-6-170-221.compute-1.amazonaws.com:8080/crol/v1/notice?lastRequestDate=2015-06-03T04:18:58.155Z


Dates are expressed using ISO8601, the International Standard for the representation of dates and times. All times are expresed in UTC (Coordinated Universal Time), with the special UTC designator "Z".



#####Specifying the noticeId

Header: 
	
		noticeId: 20140623999

Example:
	
		http://ec2-52-6-170-221.compute-1.amazonaws.com:8080/crol/v1/notice?noticeId=20140623999




##To Do's

[See Milestones]



## Licence

Apache License, Version 2.0



