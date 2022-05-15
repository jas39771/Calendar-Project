In this DSL project, we’re planning to build a 30-day planner that would allow someone to have their days planned out for the entire month.

The first feedback that we got from our TA Nico is that our idea was a little bit too simplistic, and so we decided to add a bunch of more features to make the planner more robust. Please note that although we are planning to implement many of these features, it is almost impossible to have all of them implemented, given the limited time that we have during this project.

Here are the list of potential features that we are going to implement for this DSL planner project:

1. The ability to set recurring events for every n days, n weeks, etc; or have it be a one time event.
2. Notifications for overlapping/intersecting events
3. Defining the type of the event (class, party, meeting, etc)
4. When defining an event the user can choose to “Extend” for a number of days.
5. Set the colour of an event to make it stand out in the planner.
6. Allow certain events to be overlapped and others cannot. (Ex. You can workout on your birthday, but you can’t workout during a party.)
7. Restrict certain days to not allow any events.
8. Allow users to define an event that they want fitted in their schedule, and a timeslot is found for them (give the events a time range that is viable)
9. Allow events to have different priorities that the user defines., Ex. Hospital visits would be allowed to overwrite a party event.
10. Users have the option to select the view of calendar (daily, weekly, monthly)
11. Adding time zones for the planner.
12. Allow users to save settings for an event (location time priority etc) and quickly add that event by just calling on it by name.



Milestone 2:

Division of responsibilities:

Front-End: Bill and Felix

- Responsibilities will include converting the parsed results of user inputs into a 30 day calendar. This will be done in                  Java using Swing. 

Back-End: Jaskaran, Sahib and Jenny
- Responsibilities will include implementing the tokenizer, parser, and functionality of our language. 

These are the main division of roles that we agreed on. The responsibilities are pretty general as of now but our next step is to figure out what exactly each individual is working on.

Summary of progress so far:
- We have chosen our language to write our DSL in: Java. Everything will be done in Java, including the GUI (JSwing).
- In terms of coding progress we have not started coding. We finished dividing up responsibilities and are figuring out the               structure of our project.
- We have come up with a few code examples of our DSL. It does not reflect the entirety of the features but it does showcase               some core features.
           
Roadmap:
- For our roadmap, we want to confirm what features we want to focus on and implement first. This should be done in the next              couple of days so we can start organizing the structure of our project, the specific tasks each individual does, and start              coding. 
- We want to carry out our first user study preferably within the next week (especially with milestone 3 happening in a                    week).
           
Code examples:

Event: {

	Name: UBC’s alumni’s meetup
	Type: Party
	Place: UBC
	Date: Sep 24
	Start time: 20:00
	End time: 22:00
	Color: Blue
	allowOverlap: No
	Priority: Not important
}

Event: {

	Name: 410 Lecture
	Type: Class
	Place: UBC
	Start time: 12:00
	End time: 13:00
	Color: Yellow
	allowOverlap: No
	Priority: Important
}

Event: {

  	Name: Buy party supplies
 	 Type: Other
 	 Place: 123 Main St.
  	Start time: 8:00
 	 End time: 9:00
  	Color: Red
 	 isRecurring: No
 	 allowOverlap: Yes
 	 Priority: Not important
}

Milestone 3:

For milestone 3 our mockup of concrete language design is the 3 code examples we submitted in milestone 2. We used these code examples for our user study. We will create an EBNF for our language for milestone 4.


We conducted our first user study to receive some feedback on our language design and other aspects of the features. 

The user we reached out to is a SFU student studying business. The user was first given the code examples to familiarize themselves with the structure of the code and features present. We then gave the user a set of tasks that requires them to complete the task by writing the code. Finally, we received feedback on the process and the usage of our language.


<b>Code examples provided to the user:</b>

Event: {

	Name: UBC’s alumni’s meetup
	Type: Party
	Place: UBC
	Date: Sep 24
	Start time: 20:00
	End time: 22:00
	Color: Blue
	allowOverlap: No
	Priority: Not important
}

Event: {

	Name: 410 Lecture
	Type: Class
	Place: UBC
	Start time: 12:00
	End time: 13:00
	Color: Yellow
	allowOverlap: No
	Priority: Important
}

Event: {

  	Name: Buy party supplies
 	 Type: Other
 	 Place: 123 Main St.
  	Start time: 8:00
 	 End time: 9:00
  	Color: Red
 	 isRecurring: No
 	 allowOverlap: Yes
 	 Priority: Not important
}

<b>Description of tasks for user to complete</b>

1. You noticed that you’re having an event at UBC coming up next week on Tuesday. The event will be called “UBC’s annual alumni gathering” and it’s going to be held at the AMS Student Nest at 6pm until 9pm. 
You consider the event to be important, but not mandatory to attend, and you notice that there is no overlap with your other schedules on that day.
How would you type the input using the language of our app?

2. Your cat just got sick, and you just made an appointment with a vet in Downtown Vancouver at 123 Robson St, this Saturday at 12pm. You consider this event to be mandatory and is extremely important since you need to get your cat injected with a vaccine or medicine.
How would you type the input using the language of our app?

3. You just got yourself enrolled in a French class this semester at UBC, called “French 101: Beginner French”, and the class location is at the Buchanan building, room number 401. The class starts every Monday, Tuesday, and Wednesday at 10am - 11am.
How would you type the input using the language of our app?

<b>Code as written by the user</b>

Event: {

	Name: UBC’s annual alumni gathering
	Type: Gathering
	Place: AMS Student Nest
	Date: Oct 6
	Start time: 18:00
	End time: 21:00
	Color: Blue
	allowOverlap: No
	Priority: Not important
	
}

Event: {

	Name: Vet Appointment
	Type: Other
	Place: 123 Robson St
	Date: Oct 3
	Start time: 12:00
	End time: 13:30
	Color: Red
	allowOverlap: No
	Priority: Important
	
}

Event: {

	Name: French 101: Beginner French
	Type: Class
	Place: Buchanan Building, room 401
	Date: Oct 5
	Start time: 10:00
	End time: 11:00
	Color: Orange
	allowOverlap: No
	Priority: Important
	
}

Event: {

	Name: French 101: Beginner French
	Type: Class
	Place: Buchanan Building, room 401
	Date: Oct 6
	Start time: 10:00
	End time: 11:00
	Color: Orange
	allowOverlap: No
	Priority: Important
	
}

Event: {

	Name: French 101: Beginner French
	Type: Class
	Place: Buchanan Building, room 401
	Date: Oct 7
	Start time: 10:00
	End time: 11:00
	Color: Orange
	allowOverlap: No
	Priority: Important
	
}

<b>Responses to user study questions and feedback provided by the user</b>

Q: One a scale of 1 to 10, with 1 being the worst and 10 being the best, how would you rate the ease of use of this language? Was it too hard to use and to remember for you?   
A: 8, quite easy. Once you get the hang of it, it’s really easy and simple to use.

Q: Any other feedback that you think we should know?    
A: Nothing, the overall ease of use is already good for someone who’s pretty tech savvy like me. The defaults were confusing at first, but I realized that they’re actually useful!

Q: Do you prefer having a default settings for inputs?  
A: What you guys are doing with the defaults is already helpful since it’s going to minimize my typing: set the isRecurring to be No for all event types other than classes, and allowOverlap to be No for all events.

Q: Are there any changes that you would like to suggest for the language design?  
A: None.


Our first user study went well and the feedback was positive. Because of this, we decided to continue with our language design and hopefully start implementing next week. We will conduct more user studies (likely after implementation) and tweek our language design based on the feedbacks we receive. 

Milestone 4: 

Status of implementation: we've got the EBNF grammar done, and we're planning to begin with our coding this week.

PROGRAM 		::= EVENT* | USERDEF
<br>USERDEF			::= “Type: {“  \n  “Name: ” NAME  \n  (INFO)* \n  “}”
<br>EVENT       		::=  “Event: {“  \n  “Name: ” NAME  \n  ( “Type: “ NAME )? \n “Date: “  DATE  \n   “Start time: “  TIME  \n  “End time: “  TIME  \n   (INFO)*  \n “}”
<br>INFO         		::=  PLACE | COLOR | PRIORITY | OVERLAP | REOCCURRING
<br>PLACE       		::=  “Place: “ NAME
<br>COLOR     		::=  “Color: “ (“Red” | “Green” | “Blue” )    [  any colors we have ]
<br>PRIORITY 		::=  “Priority: ” (T | F)
<br>OVERLAP 		::= “Overlap: ” (T | F)
<br>REOCCURRING         	::= “Reoccurring: “ (T| F)
<br>NAME                  	::=   [^{}|\n]+
<br>TIME			::=  (2[0-3] | [01]?[0-9]):[0-5][0-9]

Plans for final user study: we're going to conduct our final user study once we're done with everything just to test out the whole program's implementation with a real user. We're going to ask the same person, but measure different things since the app right now will have been done by that point.

Planned timeline for the remaining days: we're planning to get our tokenizer and parser done first. In this case, Jaskaran, Sahib and Jenny are all in charge for this since this is more of a backend work. From there, Bill and I will help them along the way while creating the front end of the calendar using the Java Swing library.
