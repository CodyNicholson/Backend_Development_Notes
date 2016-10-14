#Category Partition Method

The Category Partition Method is a specific instance of the steps represented in the systematic functional-testing approach for going from a specification to a set of test cases by following six steps:

***

###1 - Identify independantly testable features

-

###2 - Identify categories, which are characteristics of each input element

For example: Split(String str, int size)

The charactieristics of str could be length and content, while the charateristic of size could be value

-

###3 - Partition categories into choices

We identified three categories: length of str, content of str, and value of size

We now need to pick out the interesting cases like what if length or size is zero or a negative number? What if content has spaces or special characters?

-

###4 - Identify Constraints among choices

We identify these constraints to eliminate meaningless combinations of inputs and to reduce the number of test cases

####There are three types of properties:

#####Pair property ... if

These are properites like "if not zero"

#####Error properties

These are properties that cause errors, like if you pass in an invaild arguement or a negative number as the length of a string

We only need to test these error properties once since it will be testing an error

#####Properties of type Single

This is a property we use when we want to limit the number of test cases by saying we only want to use this property in one single combination, not multiple

-

###5 - Produce and evaluate test case specifications

This step can be completely automated given the results of the previous test

The result of this test is a set of test frames that are the specifications of a test

If the number of test cases is too high, we can just add more constraints, press a button, and we will have our new test frames

-

###6 - Generate test cases from test case specifications

Simple instantiations of frames

The final results will be a set of concrete tests that come with unique id's so we can track each one
