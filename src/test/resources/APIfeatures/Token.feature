Feature:
  Background:
    Given A JWT bearer token is generated
    @createemployee
  Scenario: Create an Employeee vie an API WorkFlow
      Given A request is prepared for creting an eployee
      When a post call is made to dreate an employee
      Then the status code for creating an employee is 201
      And the employee created contains the key "Message" and the value "Employee Created"
      And the employee id "Employee.employee_id" is stored as the global varible to be used for other call

      @getemployee
      Scenario: Get the created employee
        Given A request is prepared for getting the created  employee using api call
        When get call is prepared to get the created employee
        Then the status code is 200
        And the  id "employee.employee_id"  must match the globally stored employee id
        And the data  retried  at  "employee" objects must match the data used to create the employee with  the id "employee.employee_id"
          |emp_firstname|emp_lastname|emp_middle_name|emp_gender |emp_birthday |emp_status |emp_job_title|
          |Snobar      |Rabonas     |Suga           |Female         |2003-08-14   |Employee   |Tester       |
