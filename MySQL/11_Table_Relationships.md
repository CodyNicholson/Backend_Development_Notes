# Table Relationships

59. One-to-One Relationship (SLIDE)

    a. In this One-to-One relationship there can only be one social security number per person. Hence,  each social security number can be associated with one person. As well, one person in the other table only matches up with one social security number.

    b. One-to-One relationships can be identified also in that the foreign keys never duplicate across all rows.

    c. If you are confused by the One-to-One relationship it is understandable, because they are not often used. Most of the time if a value never repeats it should remain in the parent table being customer in this case. Just understand that in a One-to-One relationship, exactly one row in a parent table is related to exactly one row of a child table.

60. One-to-Many Relationship

    a. When we are talking about One-to-Many relationships think about the table diagram here. If you had a list of customers chances are some of them would live in the same state. Hence, in the state column in the parent table, it would be common to see a duplication of states. In this example, each customer can only live in one state so their would only be one id used for each customer.

    b. Just remember that, a One-to-Many relationship is one in which a record in the parent table can have many matching records in the child table, but a record in the child can only match one record in the parent. A customer can choose to live in any state, but they can only live in one at a time.

61. Many-to-Many Relationship

    a. Many people can own many different products. In this example, you can see an example of a Many-to-Many relationship. This is a sign of a non-normalized database, by the way. How could you ever access this information:

    b. If a customer buys more than one product, you will have multiple product id's associated with each customer. As well, you would have multiple customer id's associated with each product.
