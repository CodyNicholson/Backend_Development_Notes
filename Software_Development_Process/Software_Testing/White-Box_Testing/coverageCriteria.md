#Coverage Criteria

Coverage Criteria can be defined in terms of test requirements that are the elements or the entities in the code we need to exercise by executing the code in order to satisfy the criteria

This will result in a set of test specifications that are descriptions of how the tests should be in order to satisfy the requirements

They also result in actual test cases that can be created according to the specifications

There are many different kinds of Coverage Criteria, I have listed a few before

***

###Statement Coverage

This coverage is characterized by two aspects, the first of which is test requirements for the criteria and the second which is how we measure the coverage for that criteria

-

Test requirements are all the statements in the program

-

A good measure of how we exercise the code is the ration of the number of executed statements over the total number of statements, the higher this number the better the code is being exercised

We can also look at the coverage criteria in terms of questions, what are the questions that we were trying to answer when we look at a specific set of test cases?

-

Statement coverage is satisfied when all the statements in the program have been executed

-

Statement Coverage is the most used type of coverage, and the typical coverage target is 80-90% which means that the outcome of the test cases should be that 80-90% of the statements were exercised at the end

***

###Branch Coverage

The goal of branch coverage is to execute all of the branches in the program

The Test Requirements for branch coverage are the branches in the program

The Coverage Measure is defined as the number of executed branches over the total number of branches in the program

Branches are the outgoing edges from a decision point, examples are an if statement, a switch statement, a while statement, any node in the Control Flow Diagram that has more than one outgoing edge -- those edges are called branches

By covering all branches in our test cases we can achieve 100% branch coverage, which is ideal but does not guarantee that our system has no errors

If you hav 100% branch coverage, you will also have 100% state coverage because branch criteria is a stronger criteria than statement coverage

***

###Test Criteria Subsumption

One test criteria subsumes another criteria when all the tests widths that satify that criteria will also satisfy the other one

Branch coverage subsumes statement coverage which means that, in general, it is more expensive to achieve branch coverage than to achieve statement coverage because achieveing branch coverage requires the generation of more test cases

This relation means that branch coverage is stronger than statement coverage but also more expensive

***

###Condition Coverage

The test requirements for Condition Coverage are the individual conditions in the program, so we want each condition in the program to be both true and false for the first time execution

To measure the Coverage for Condition Coverage we divide the number of conditions that are both true and false by the total number of conditions, which gives us the percentage of coverage

Has each boolean sub-expression, which means every condition in every predicate, evaluated both to true and false when we run our tests?

Branch/Decision coverage and condition coverage are normally considered together because they

***

###Branch/Decision and Condition Coverage

The Test Requirements include all the branches and individual conditions in the program

The Coverage Measure is computed considering both coverage measures for Branch and Condition coverage

Branch and Condition Coverage subsumes (implies) Branch Coverage and it subsumes Condtion Coverage

To clarify, if a test case gets 100% coverage using Branch and Condition Coverage then it must also get 100% coverage on Branch, Condtion, and Statement Coverage as well since it subsumes all of them

***

###Modified Condition/Decision Covereage (MC/DC)

This is often the kind of coverage that is required for the safety of critical applications, for example, this is required for Airplane Software

The key idea is to test only the important combinations of conditions instead of all of them, and to limit testing costs by excluding the rest of the test cases

It works by extending branch and decision coverage with the requirement that each condition should affect the decision outcome independantly

MC/DC subsumes Branch and Condition Coverage because it requires every single condition to be true and false, it also requires every predicate to be true and false so it subsumes branch coverage, and it also the true and false values of the conditions have to decide the overall value of the predicate, so its stronger than Branch and Condition, Branch, Statement, and Condition Coverage

***

###Path Coverage

In Path Coverage the test requirements are all the paths in the program, so to satify this criteria we need to generate enough test cases such that all the paths in the program are covered

This is a very expensive coverage

Path coverage subsumes Branch Coverage, but it does not relate to Branch and Condition, MC/DC, or Multiple Condition Coverage because their requirements are different

***

###Data-flow Coverage

In Data-Flow Coverage the focus shifts from the coverage of individual elements in the code to the coverage of pairs of elements

In particular, the coverage of Statements in which the content of some memory locations is modified, and in statements in which the content of the same memory location is used

Our tests will excercise the assignments of values to the memory, and the usage of those assignments

Data-flow Coverage does not have any relation to the other types of coverage

***

###Mutation Coverage

The key concept of Mutation Coverage is that we want to evaluate the goodness of our test by modifying the code

Like changing a conditional statement from "<" to "<="

Then we have to find out how goof the test cases are at distinguishing the original program from the mutant we created by changing the code

Since I am changing the code based on the way I expect to introduce errors in the code, the more my test can identify mutants, the better they are at identifying real faults

Mutation Coverage does not have any relations to the other types of coverage

***

###Theoretical Criteria

Path, Multiple Condition, and Mutation Coverage are considered Theoretical Criteria because they are useful in theory but not applicable in practice because they're too expansive since they require too many test cases to be satisfied

***

###Practical Criteria

MC/DC, Branch and Condition, Branch, Statement, and Condition Coverage are considered Practical Criteria because they are not too expansive to be used in the real world
