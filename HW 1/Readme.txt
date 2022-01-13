COVID-19 contact tracing system
* There is a Employee entity which contains all the information about Employee
   * Employee_id - unique identification number given to any person joining the company.
   * Employee_name - name of employee in format “First name Last name”.
   * Smart_phone_number - the number given by an employee for contacting him/her.
   * Email_id - email id of the employee.
   * Status - this contains status of employee’s health such as sick, well, hospitalized, quarantined
   * Screening_temparature - temperature that employee updates on application or the temperature taken while entering the building.
* There is a Report entity which contains information of the covid report of the employee.
   * Report_id - the id of the report generated of an employee
   * Employee_id - the report will contain the employee_id of the employee whose report it is
   * Result - it will either negative or positive
   * Date - the date on which the report was done
   * Type - it will state whether symptomatic, pre-symptomatic or asymptomatic
(The date is stored so that if the employee updates the status to well it can be compared and checked whether the two weeks of mandatory quarantine is complete or not and also to keep a track of how many days an employee took to get recovered. Also the date will help in identifying the other employees who were in contact with that employee on that day via the employee_location entity)
* There is a Building entity which contains information about building.
   * Building_number - unique number assigned to the building.
   * Floor_number - The number of the floor
   * Meeting_room_number - unique number assigned to the meeting room.
   * Office_room_number - unique number assigned to the office
(I am assuming that meeting rooms are rooms where conferences or team meetings or department meetings happen. The office room is a room given to specific people like team lead, manager, CEO,CFO, etc. In the office room any employee can enter for a quick 1 to 1 or a small meeting of 3 to 4 employees can be conducted. Entry level employees and other staff would be sitting in open cabins on each floor.)
* There is an Employee_Location entity that contains information regarding the location.
   * Employee_id - unique identification number of an employee
   * Meeting_room_number - unique number assigned to the meeting room.
   * Office_room_number - unique number assigned to the office
   * Floor_number - The number of the floor
   * Meeting_start_time - The start time of a meeting in a particular meeting room.
   * Number_of_attendees - number of employees that attended the particular meeting at particular time 
   * Date- the date on which a particular meeting was held
   * Result - Result of employees that attend the meeting in meeting room 
( To select a row in this entity we will need a combination of employee_id, meeting_room_number and meeting_start_time,date, the result from the report will be an attribute here. If an employee test positive we can find out the employee_id and date on which he tested positive from the report entity and from the employee_location entity we can find out all the meeting_room_number and meeting_start time on that day where he went and then find out the employee_id of others who were present in that room at that time and send them alert message. Similarly it can be done for office_room_number. Once we have meeting_room_number and office_room number we can find out the floors on which it is located from the meeting_room and office_room entities. The employee_location has floor_number so when an employee who is not part of any meeting room or is not in any office room and sits in open cabins, then the alert will be sent to employees who have been on that floor on that day. Number_of_attendees attribute is kept so that when notifying the employees we can compare the number of employees to this number and make sure we have not missed anyone.)
* There is Building entity that contains information about the building
   * Building_number - The number given to the building by government
   * Floor_number - Numbers of floors
   * Meeting_room_number - Assuming that each meeting room in the building is given a unique number
   * Office_room_number - Assuming that each office room in the building is given a unique number
(I am assuming that a building consists of several floors and each floor has several office rooms and meeting rooms)
* Office_room entity contains details about office room
   * Office_room_number - The number given to the room.
   * Floor_number - floor on which the office is located
   * Office_capacity - number of employees sitting in the office
( Assuming that it is possible that an office space can be individual space as well as can be shared by 2 or more people working in same team or same project)
* Meeting_room entity contains details about meeting room
   * Meeting_room_number - the number given to the rooms.
   * Floor_number - floor on which the meeting room is located
   * Meeting_capacity - the number of employees that can attend a meeting in the room.
(Assuming that big conference rooms and small meeting rooms are all considered in the meeting room label. Different rooms will have different capacities.)
* Alert entity contains details about alerts published
   * Employee_id - the ids found from the employee_location entity that need to be notified
   * Alert_message - the message that specifies whether an employee should immediately take a test or a concern message suggesting to take the test.
   * Report_status - this is to know whether an employee that was notified has taken a test or not
* Self_Report_Symptoms entity contains five important symptoms of Covid19
   * Employee_id - Unique identification number of an employee
   * Fever - An employee can self report if he has fever or not or when the employee gets tested the report states whether he has fever or not
   * Bodyache - An employee can self report or when he gets tested his report can state whether he has bodyache or not
   * Breathing - An employee can self report or when he gets tested his report can state whether he has breathlessness or not
   * Taste - An employee can self report or when he gets tested his report can state whether he has lost the taste sensation or not
   * Sore_throat - An employee can self report or when he gets tested his report can state whether he has sore throat or not
( An employee can test negative but still have symptoms like fever or sore_throat or anything which can be signs of other illness like flu or common cold. An employee can test positive but it is possible that he would not have any of these symptoms)


* Relationships 
   * Employee and Self_Report_Symptoms
      * One employee can have zero or many symptoms and can self report them on the app or can be detected via random screening
   * Employee and Report
      * One employee can have zero or many reports. It is possible that it is the employee's first day and he was not required to do any report or a lucky employee may never show any symptoms or never have any contact with a sick employee and so never does a report so an employee can have zero reports. Also an employee has fever and gets a report done but is tested negative but after a few days also his fever doesn’t go so he gets tested again this way an employee can have many reports.
   * Employee and Employee_location
      * An employee can be present at many locations. A location can have many employees present there. For example an employee like a manager can have his own office room and also be a part of different meetings throughout the day and can be present on different floors during the day.
      * Location like a meeting room can have several meetings hosted with different numbers of people attending them. 
      * Also if an employee enters the building he is certain to be at a location whether it's in an open cubicle on the floor or an office room or a meeting room. Example a receptionist on the front desk might not be part of any meetings but she will still have a location which is the floor on which her desk is.
   * Employee_Location and Report
      * From the report entity the employee_id, result and date is used to find out the location of the employee on the date when that employee tested positive and find out the other employees who were present there.
      * It is possible that multiple employees can test positive at a particular location on the same date. Or one positive employee could have been to multiple locations on the same date.
   * Employee_location and Alert
      * From the employee_location the employees who were exposed to risk of Covid19 are detected and a separate entity is made so that the alert message is sent to them and a check on the report_status is maintained.
      * In an extreme case there is a possibility that no employee ever gets tested positive hence zero or many notation is kept. Also there is a possibility that the founder of the company has a whole floor dedicated to him and attends no meeting on a particular day and so when he tests positive no other employee needs to get notified.
   * Building and Office_Room
      * There is only one building as specified in the HW1 description and it has many offices on many floors
   * Building and Meeting_Room
      * There is only one building as specified in the HW1 description and it has many meeting rooms on many floors.
   * Employee_location and Meeting_Room
      * An employee_location which is the location of an employee can be in many meeting rooms for a day or not at all in any meeting room
   * Employee_location and Office_Room
      * An employee_location which is the location of an employee can be in many office rooms for a day or not at all in any office rooms.