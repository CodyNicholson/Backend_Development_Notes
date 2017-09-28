# Foreign Keys

Foreign Keys are used to link different tables together. Every variable in a table should directly relate to the primary key.

If you have a customer table you should create tables for all of your customers potential states, cities, and zip codes, instead of including them in the main customer table. Then you would link them using foreign keys.

```
15. CREATE TABLE test(
    date DATE NOT NULL,
    type ENUM('T', 'Q') NOT NULL,
    class_id INT UNSIGNED NOT NULL,
    test_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY);
    
    a. class_id is a foreign key
    
    I. Used to make references to the Primary Key of another table 
    
    II. Example: If we have a customer and city table. If the city table had a column which listed the unique primary key
    of all the customers, that Primary Key listing in the city table would be considered a Foreign Key. 
    
    III. The Foreign Key can have a different name from the Primary Key name. 
    
    IV. The value of a Foreign Key can have the value of NULL. 
    
    V. A Foreign Key doesn't have to be unique
```
