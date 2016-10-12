#The Rational Unified Process is Iterative and Incremental

The lifetime of a RUP consists of a series of cycles that are also called increments

Each one of these cycles involves all of the main phases of software development

Each cycle results in a product release which can be internal or external

Each cycle terminates with a product release that includes a complete set of artifacts for the project -- which means code, manuals, use cases, non-functional specifications, test cases, and so on

Specifically each cycle is further divied into four main phases: Inception, Elaboration, Construction, and Transition

Within these four individual phases there can be multiple iterations that each correspond to a different group of use cases that are selected to deal with the most important risks first

If you have a set of use cases that you are considering, which means that you have a set of features that you need to implement, you will select for each iteration the most risky ones that you still haven't realized and realize them in that iteration

Then continue in the following iterations with less and less risky features to implement so that in the end each iteration extends the functionality beyond the previous iteration

***

Example for the banking IT system:

```
Cycle 1: Basic Withdrawal Facilities
|------|-----------------------|-----|------|
Inception Elaboration Construction Transition


                                    Cycle 2: Account and System Management
                                    |-----|------|--------------------|---------|
                                    Inception Elaboration Construction Transition

                                                                Cycle 3: Full Account Management and Cross Selling
                                                                |------|--------|------------|--------------|
                                                                Inception Elaboration Construction Transition

// Notice that the cycles can overlap one another, like Cycle two starts during the end of the construction phase of cycle one
// Inside each of the four phases of the cycle there can be multiple iterations resulting in multiple product releases inside of a single phase of a single cycle
```

***

In almost every iteration developers do the following activities:


1. Identify relevant use cases, which piece of functionality will this iteration develop?


2. Create the design for the considered use cases guided by the choosen architecture


3. Implement the design which will result in a set of software componenets


4. Verify code in components against use cases


5. Release a product at the end the iteration, this could be an internal or external release
