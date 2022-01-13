HW2


Using livesql.oracle.com
* Q-1
   * Created tables named EMPLOYEE, MEETING, NOTIFICATION, SYMPTOM, SCAN_TABLE, TEST_TABLE, CASE_TABLE, HEALTH_STATUS
   * Added foreign key constraints to all the tables
   * TEST_TABLE, CASE_TABLE, HEALTH_STATUS have foreign key EMPLOYEE_ID related to EMPLOYEE table as I think that they will be directly to the employee.
   * Inserted values into the respective tables
* Q-2
   * Created a view having columns as symptom id and the respective frequency of the symptom ids. View can also be used for other things like finding the least reported symptom or the symptom which is never reported.
   * Giving the output as symptom id whose frequency is the maximum
* Q-3
   * Created a view having floor number and total number of positive cases at each floor. View can be used to find the healthiest floor (the floor where no cases are reported)
   * Giving output as floor number which has maximum positive cases.
* Q-4
   * Created queries to output number of scans, number of tests, number of employees who self-reported symptoms, number of positive cases between dates ‘2020-03-01’ to ‘2021-01-01’
   * The dates can be changed to get the frequencies for any particular dates.
* Q-5
   * Thought of designing a query which will output the employee ids of the employee who never tested positive. This will help the company to know who are the healthiest employees and when the vaccines are rolled out the other employees should be given it first and then these employees. The company could even do their tests to know whether they have acquired antibodies on their own.
   * Designed it using division.