# Working With Tables

```
11. SELECT * FROM student;

    a. Shows all the student data
    
12. CREATE TABLE class(
    name VARCHAR(30) NOT NULL,
    class_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY);
    
    a. Create a separate table for all classes

13. show tables;

    a. Show all the tables

14. INSERT INTO class VALUES
('English', NULL), ('Speech', NULL), ('Literature', NULL),
('Algebra', NULL), ('Geometry', NULL), ('Trigonometry', NULL),
('Calculus', NULL), ('Earth Science', NULL), ('Biology', NULL),
('Chemistry', NULL), ('Physics', NULL), ('History', NULL),
('Art', NULL), ('Gym', NULL);

    a. Insert all possible classes
    
    b. select * from class; 
    
15. CREATE TABLE test(
    date DATE NOT NULL,
    type ENUM('T', 'Q') NOT NULL,
    class_id INT UNSIGNED NOT NULL,
    test_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY);
    
    a. class_id is a foreign key
    
    I. Used to make references to the Primary Key of another table 
    
    II. Example: If we have a customer and city table. If the city table had a column which listed the unique primary key of all the customers, that Primary Key listing in the city table would be considered a Foreign Key. 
    
    III. The Foreign Key can have a different name from the Primary Key name. 
    
    IV. The value of a Foreign Key can have the value of NULL. 
    
    V. A Foreign Key doesn't have to be unique

16. CREATE TABLE score(
    student_id INT UNSIGNED NOT NULL,
    event_id INT UNSIGNED NOT NULL,
    score INT NOT NULL,
    PRIMARY KEY(event_id, student_id));
    
    a. We combined the event and student id to make sure we don't have 
    duplicate scores and it makes it easier to change scores
    
    b. Since neither the event or the student ids are unique on their 
    own we are able to make them unique by combining them
    
17. CREATE TABLE absence(
    student_id INT UNSIGNED NOT NULL,
    date DATE NOT NULL,
    PRIMARY KEY(student_id, date));
    
    a. Again we combine 2 items that aren't unique to generate a 
    unique key
    
18. Add a max score column to test

    a. ALTER TABLE test ADD maxscore INT NOT NULL AFTER type; 
    
    b. DESCRIBE test;

19. Insert Tests

    a. INSERT INTO test VALUES
    ('2014-8-25', 'Q', 15, 1, NULL),
    ('2014-8-27', 'Q', 15, 1, NULL),
    ('2014-8-29', 'T', 30, 1, NULL),
    ('2014-8-29', 'T', 30, 2, NULL),
    ('2014-8-27', 'Q', 15, 4, NULL),
    ('2014-8-29', 'T', 30, 4, NULL);
    
    b. select * FROM test;
    
20. ALTER TABLE score CHANGE event_id test_id 
    INT UNSIGNED NOT NULL;
    
    a. Change the name of event_id in score to test_id
    
    b. DESCRIBE score;


21. Enter student scores

    a. INSERT INTO score VALUES
    (1, 1, 15),
    (1, 2, 14),
    (1, 3, 28),
    (1, 4, 29),
    (1, 5, 15),
    (1, 6, 27),
    (2, 1, 15),
    (2, 2, 14),
    (2, 3, 26),
    (2, 4, 28),
    (2, 5, 14),
    (2, 6, 26),
    (3, 1, 14),
    (3, 2, 14),
    (3, 3, 26),
    (3, 4, 26),
    (3, 5, 13),
    (3, 6, 26),
    (4, 1, 15),
    (4, 2, 14),
    (4, 3, 27),
    (4, 4, 27),
    (4, 5, 15),
    (4, 6, 27),
    (5, 1, 14),
    (5, 2, 13),
    (5, 3, 26),
    (5, 4, 27),
    (5, 5, 13),
    (5, 6, 27),
    (6, 1, 13),
    (6, 2, 13),
    # Missed this day (6, 3, 24),
    (6, 4, 26),
    (6, 5, 13),
    (6, 6, 26),
    (7, 1, 13),
    (7, 2, 13),
    (7, 3, 25),
    (7, 4, 27),
    (7, 5, 13),
    # Missed this day (7, 6, 27),
    (8, 1, 14),
    # Missed this day (8, 2, 13),
    (8, 3, 26),
    (8, 4, 23),
    (8, 5, 12),
    (8, 6, 24),
    (9, 1, 15),
    (9, 2, 13),
    (9, 3, 28),
    (9, 4, 27),
    (9, 5, 14),
    (9, 6, 27),
    (10, 1, 15),
    (10, 2, 13),
    (10, 3, 26),
    (10, 4, 27),
    (10, 5, 12),
    (10, 6, 22);
    
22. Fill in the absences

    a. INSERT INTO absence VALUES
    (6, '2014-08-29'),
    (7, '2014-08-29'),
    (8, '2014-08-27');
```

```
23. SELECT * FROM student;

    a. Shows everything in the student table
    
24. SELECT FIRST_NAME, last_name 
    FROM student;
    
    a. Show just selected data from the table (Not Case Sensitive)
    
25. RENAME TABLE 
    absence to absences,
    class to classes,
    score to scores,
    student to students,
    test to tests;
    
    a. Change all the table names SHOW TABLES;
    
26. SELECT first_name, last_name, state 
    FROM students
    WHERE state="WA";
    
    a. Show every student born in the state of Washington
    
27. SELECT first_name, last_name, birth_date
    FROM students
    WHERE YEAR(birth_date) >= 1965;
    
    a. You can compare values with =, >, <, >=, <=, !=
    
    b. To get the month, day or year of a date use MONTH(), DAY(), or YEAR()
    
27. SELECT first_name, last_name, birth_date
    FROM students
    WHERE MONTH(birth_date) = 2 OR state="CA";
    
    a. AND, && : Returns a true value if both conditions are true 

    b. OR, || : Returns a true value if either condition is true 

    c. NOT, ! : Returns a true value if the operand is false
    
28. SELECT last_name, state, birth_date
    FROM students
    WHERE DAY(birth_date) >= 12 && (state="CA" || state="NV");
    
    a. You can use compound logical operators
    
29. SELECT last_name
    FROM students
    WHERE last_name IS NULL;
    
    SELECT last_name
    FROM students
    WHERE last_name IS NOT NULL;
    
    a. If you want to check for NULL you must use IS NULL or IS NOT NULL
    
30. SELECT first_name, last_name
    FROM students
    ORDER BY last_name;
    
    a. ORDER BY allows you to order results. To change the order use
    ORDER BY col_name DESC;
    
31. SELECT first_name, last_name, state
    FROM students
    ORDER BY state DESC, last_name ASC;

    a. If you use 2 ORDER BYs it will order one and then the other
    
32. SELECT first_name, last_name
    FROM students
    LIMIT 5;
    
    a. Use LIMIT to limit the number of results
    
33. SELECT first_name, last_name
    FROM students
    LIMIT 5, 10;
    
    a. You can also get results 5 through 10
    
34. SELECT CONCAT(first_name, " ", last_name) AS 'Name',
    CONCAT(city, ", ", state) AS 'Hometown'
    FROM students;
    
    a. CONCAT is used to combine results
    
    b. AS provides for a way to define the column name
    
35. SELECT last_name, first_name
    FROM students
    WHERE first_name LIKE 'D%' OR last_name LIKE '%n';
    
    a. Matchs any first name that starts with a D, or ends with a n
    
    b. % matchs any sequence of characters
    
36. SELECT last_name, first_name
    FROM students
    WHERE first_name LIKE '___y';
    
    a. _ matchs any single character
    
37. SELECT DISTINCT state
    FROM students
    ORDER BY state;
    
    a. Returns the states from which students are born because DISTINCT
    eliminates duplicates in results
    
38. SELECT COUNT(DISTINCT state)
    FROM students;
    
    a. COUNT returns the number of matchs, so we can get the number
    of DISTINCT states from which students were born
    
39. SELECT COUNT(*)
    FROM students;
    
    SELECT COUNT(*)
    FROM students
    WHERE sex='M';
    
    a. COUNT returns the total number of records as well as the total
    number of boys
    
40. SELECT sex, COUNT(*)
    FROM students
    GROUP BY sex;
    
    a. GROUP BY defines how the results will be grouped
    
41. SELECT MONTH(birth_date) AS 'Month', COUNT(*)
    FROM students
    GROUP BY Month
    ORDER BY Month;
    
    a. We can get each month in which we have a birthday and the total
    number for each month
    
42. SELECT state, COUNT(state) AS 'Amount'
    FROM students
    GROUP BY state
    HAVING Amount > 1;
    
    a. HAVING allows you to narrow the results after the query is executed
    
43. SELECT
    test_id AS 'Test',
    MIN(score) AS min,
    MAX(score) AS max,
    MAX(score)-MIN(score) AS 'range',
    SUM(score) AS total,
    AVG(score) AS average
    FROM scores
    GROUP BY test_id;
    
    a. There are many math functions built into MySQL. Range had to be quoted because it is a reserved word.
    
    b. You can find all reserved words here http://dev.mysql.com/doc/mysqld-version-reference/en/mysqld-version-reference-reservedwords-5-5.html
```
