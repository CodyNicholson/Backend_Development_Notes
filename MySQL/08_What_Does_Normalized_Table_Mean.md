# What Is A Normalized Table Mean?

Normalized just means that the database is organized in a way that is considered standardized by professional SQL programmers. So if someone new needs to work with the tables they'll be able to understand how to easily.

Another benefit to normalizing your tables is that your queries will run much quicker and the chance your database will be corrupted will go down. 

### What are the rules for creating normalized tables:

The tables and variables defined in them must be atomic Each row must have a Primary Key defined. Like your social security number identifies you, the Primary Key will identify your row. 

You also want to eliminate using the same values repeatedly in your columns. Ex. You wouldn't want a column named instructors, in which you hand typed in their names each time. You instead, should create an instructor table and link to it's key. 

Every variable in a table should directly relate to the primary key. Ex. You should create tables for all of your customers potential states, cities and zip codes, instead of including them in the main customer table. Then you would link them using foreign keys. Note: Many people think this last rule is overkill and can be ignored! 

No two columns should have a relationship in which when one changes another must also change in the same table. This is called a Dependency. Note: This is another rule that is sometimes ignored.
