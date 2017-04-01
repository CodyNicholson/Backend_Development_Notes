# Systematic Functional TestingApproach

Black-Box Testing starts from a description of the software also called a functional specification and the final result of black box testing is a set of test cases -- a set of actual inputs and corresponding outputs that we can use to exercise our code and to try and find defects

-

How do we get from a functional definition to a test cases?

We take a systematic approach to solving this problem

-

#### A systematic approach simplifies the overall problem by dividing the problem into elementary steps, in this case we will have three:


### 1 - Identify independently testable features, individual features in the software that we can test

Go from a functional specification to a set of features that we can test in the software

Identify all of the features of the software and consider them one at a time when generating test cases

-

### 2 - Identify what are the relevant inputs, what are the inputs or behavior that is worth testing for these features

-

### 3 - One we have the relevant inputs we are going to derive test specifications that are descriptions of the test cases that we can then use to generate actual test cases

***

#### By proceeding in this way has many advantages:

It allows for decoupling different activities

It allows for dividing brain intensive steps from steps that can be automated, which is a great advantage

It allows you to monitor the testing process to figure out whether your testing process is going as expected, for example, if you are generating too many test cases or if you are generating the number of test cases that your amount of resources available allows you to run

***

Deriving Test Case Specifications for the values using these, or using these values

The test case specification defines how the values should be put together when actually testing the system

We will then need to eliminate some of our meaningless test cases, like cases that cannot ever happen, like "if 1 = 0" kinds of test cases

-

The following step is to use these test case specifications to generate actual test cases
