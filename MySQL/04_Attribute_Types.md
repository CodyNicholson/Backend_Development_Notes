# Attribute Types

```
------------ Numeric Types ------------

TINYINT: A number with a value no bigger than 127 or smaller than -128
SMALLINT: A number with a value no bigger than 32,768 or smaller than -32,767
MEDIUM INT: A number with a value no bigger than 8,388,608 or smaller than -8,388,608
INT: A number with a value no bigger than 2^31 or smaller than 2^31 â�� 1
BIGINT: A number with a value no bigger than 2^63 or smaller than 2^63 â�� 1
FLOAT: A number with decimal spaces, with a value no bigger than 1.1E38 or smaller than -1.1E38
DOUBLE: A number with decimal spaces, with a value no bigger than 1.7E308 or smaller than -1.7E308

------------ String Types ------------

CHAR: A character string with a fixed length
VARCHAR: A character string with a length thatâ��s variable
BLOB: Can contain 2^16 bytes of data
ENUM: A character string that has a limited number of total values, which you must define.
SET: A list of legal possible character strings. Unlike ENUM, a SET can contain multiple values in comparison to the one legal value with ENUM.

------------ Date & Time Types ------------

DATE: A date value with the format of (YYYY-MM-DD)
TIME: A time value with the format of (HH:MM:SS)
DATETIME: A time value with the format of (YYYY-MM-DD HH:MM:SS)
TIMESTAMP: A time value with the format of (YYYYMMDDHHMMSS)
YEAR: A year value with the format of (YYYY)
```

```
a. VARCHAR(30) : Characters with an expected max length of 30

b. NOT NULL : Must contain a value

c. NULL : Doesn't require a value

d. CHAR(2) : Contains exactly 2 characters

e. DEFAULT "PA" : Receives a default value of PA

f. MEDIUMINT : Value no greater then 8,388,608

g. UNSIGNED : Can't contain a negative value

h. DATE : Stores a date in the format YYYY-MM-DD

i. ENUM('M', 'F') : Can contain either a M or F

j. TIMESTAMP : Stores date and time in this format YYYY-MM-DD-HH-MM-SS

k. FLOAT: A number with decimal spaces, with a value no bigger than 1.1E38 or smaller than -1.1E38

l. INT : Contains a number without decimals
```
