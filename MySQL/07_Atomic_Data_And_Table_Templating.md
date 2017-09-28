# Atomic Data & Table Templating

As your database increases in size, you are going to want everything to be organized, so that it can perform your queries quickly. If your tables are set up properly, your database will be able to crank through hundreds of thousands of bits of data in seconds.

How do you know how to best set up your tables though? Just follow some simple rules:

Every table should focus on describing just one thing. Ex. Customer Table would have name, age, location, contact information. It shouldn't contain lists of anything such as interests, job history, past address, products purchased, etc.
After you decide what one thing your table will describe, then decide what things you need to describe that thing. Refer to the customer example given in the last step.

Write out all the ways to describe the thing and if any of those things requires multiple inputs, pull them out and create a new table for them. For example, a list of past employers.

Once your table values have been broken down, we refer to these values as being atomic. Be careful not to break them down to a point in which the data is harder to work with. It might make sense to create a different variable for the house number, street name, apartment number, etc.; but by doing so you may make your self more work? That decision is up to you?

p. Some additional rules to help you make your data atomic: Don't have multiple columns with the same sort of information. Ex. If you wanted to include a employment history you should create job1, job2, job3 columns. Make a new table with that data instead. 

Don't include multiple values in one cell. Ex. You shouldn't create a cell named jobs and then give it the value: McDonalds, Radio Shack, Walmart, Normalized Tables
