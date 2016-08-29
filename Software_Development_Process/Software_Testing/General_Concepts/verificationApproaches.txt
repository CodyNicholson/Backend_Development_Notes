How can we verify software?

Here are four mainstream approaches:


1. Testing which is also called Dynamic Verification

Testing a software system means exercising the system to try to make it fail

Consider a program, its input domain that is a set of all the possible inputs for the program, and its output domain which is a set of all the possible corresponding outputs

Given this context we can define what a test case is

A test case is a pair that consists of an input from the input domain and then expected output from the output domain

Test case: {i E D, o E O} where i is an input from the input domain D, and where o is the corresponding output from the output domain O

A Test Suite is a set of test cases



2. Static Verification

Tries to identify specific classes of problems in the program such as null pointer dereferences

Unlike testing it considers all possible inputs for the program

So it considers all possible executions of the program and all possible behaviors of the program and that's why say that verification unlike testing is complete



3. Inspections

Also called reviews or walkthroughs

Unlike previous techniques, inspections are a human intensive activity

They are a manual and group activity in which several people from the organization that developed the software look at the code or other artifacts developed during the software production and try to identify defects in these artifacts

Inspections have shown to be quite effective in practice



4. Formal Proofs of Correctness

Given a formal software specification, a document that formally describes the expected behavior of the program, a form of proofcorrectness proves that the program being verified actually implements the program specification

It doesthat through a sophisticated mathematical analysis of the specifications and of the code