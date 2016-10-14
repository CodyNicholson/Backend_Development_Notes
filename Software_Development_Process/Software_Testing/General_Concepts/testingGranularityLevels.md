#Testing Granularity Levels

##There are three testing levels:

1. We start with Unit Testing which is the testing of individual modules of the system in isolation

2. Then we move to integration testing which is testing of multiple modules and thier interations

  If we integrate all the modules together at once we are preforming big bang integration testing

3. After we test the complete system as a whole in a process called system/acceptance testing

-

System testing is the testing of the complete system and it includes both functional and non-functional testing

Functional tests are tests that aim to verify the functionality provided by the system

Conversely, non-functional tests are the ones that target non-functional properties of the system like performance tests, load tests, robustness tests

Non-functional tests will try to assess different qualities of the system like reliability, maintainability, usability, etc

***

####There are two more levels of software testing that both involve the whole system:

1. Acceptance Testing which is the validation of the software against the customer requirements
  
  This testing makes sure that the system does what the customer wants it to do


2. Regression Testing is the type of testing or retesting that we preform every time that we change our system to make sure the changes behave as intended and the unchanged code still works

  When you modify the code, parts of the code that are unrelated to the changes are actually affected by the changes and start misbehaving

  We call those Regression Errors and they are very common

  Regression testing is very expensive maintenance work

  To save as much money as you can you should use automate regression testing to make it more effective and more efficient -- use scripts, save your harness, save your input and output so you can rerun your test at the push of a button
