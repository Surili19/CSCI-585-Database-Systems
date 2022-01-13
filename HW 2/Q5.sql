REM   Script: Q5
REM   Q5

--using https://livesql.oracle.com
SELECT * 
  FROM EMPLOYEE E 
 WHERE NOT EXISTS 
          (SELECT * 
             FROM TEST_TABLE T 
            WHERE T.EMPLOYEE_ID = E.EMPLOYEE_ID 
           MINUS 
           SELECT * 
             FROM TEST_TABLE T 
            WHERE TEST_RESULT = 'Negative');

