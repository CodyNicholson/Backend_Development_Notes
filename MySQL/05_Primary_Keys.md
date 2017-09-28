# Primary Keys

```
n. PRIMARY KEY (SLIDE): Unique ID that is assigned to this row of data

    I. Uniquely identifies a row or record 
    
    II. Each Primary Key must be unique to the row 
    
    III. Must be given a value when the row is created and that value canâ��t be NULL 
    
    IV. The original value canâ��t be changed It should be short 
    
    V. Itâ��s probably best to auto increment the value of the key

m. AUTO_INCREMENT : Generates a number automatically that is one greater then the previous row
```

Auto Increment is useful for primary keys because you should always increment the primary key of a new row. If you create your table with your primary key set to NULL with Auto Increment, upon inserting your first row you will increment from NULL to 1. Your second insert will have 2, then 3, etc.
