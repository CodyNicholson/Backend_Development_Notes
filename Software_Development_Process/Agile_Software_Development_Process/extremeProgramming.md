# Extreme Programming

Extreme Programming (XP) is a lightweight, humanistic, discipline of software development

- Lightweight - Does not over burden the developers with an invasive process

- Humanistic - Developers and Customers are at the center of the process

- Discipline - It includes practices that we need to follow

- Software Development - All of these procedures and processes are done to develop software

***

### Developing is like driving

We need to focus on steering and not pointing in one direction

We need to be able to correct ourselves quickly if we make a wrong turn

Change is the only constant in developing software!

***

### Mentality of Sufficiency:

Create software like you would if you had all the time in the world
    - Write tests
    - Restructure often
    - Talk with fellow programmers and customers often

***

### XP Values and Principles

Communication - There is no good project without communication, use pair programming and customer involvement because they improve communication

Simplicity - Simple, gets the job done right without being overly complex

Feedback - Talk with customers as frequently as possible so that you can adapt software to their needs

Courage - Have the guts to throw away code that goes not work, to change it to make it better, to fix it if you find a problem, to try new things if you think they might work better

***

### XP Practices

#### Incremental Planning

Is based on the idea that requirements are recorded on story cards provided by the customer

1. Select user stories for release
2. Break stories into tasks
3. Plan release
4. Develop, integrate, test (Repeat step 4 many times in single cycle)
5. Release software
6. Evaluate system (Dev and Customer) and start a new iteration at step 1

-

#### Small Releases

By releasing small updates in short cycles rather than one large release at the end of a long cycle we make the customers happy because they will see the development happening

We can get feedback sooner and "steer" rather than point in one direction

We can adapt quickly to possible changes in the spec

Reduces risk because we will know quickly, from the customer, if we are ding something wrong

-

#### Simple Design

Only build enough to meet the requirements, and no duplicated functionality, so that we can adapt easily if it is wrong

Fewest methods and classes because a large and cumbersome project will not be flexible enough to adapt and change like it should in XP and Agile

-

#### Test First

There are no program features that exist without a test

Devs should create a unit test for each program functionality before it is made, so the test will always fail in the beginning

Since you know what your feature is supposed to do, you can create a Unit Test with that expected result

-

#### Refactoring

Take code and restructure it to make it simpler

Refactor on demand of the system and the process, not on speculation

-

#### Pair Programming

All production code is written with two people looking at one machine

The two devs alternate between the roles of programming and planning

Two people together can create much better quality work then two people working on there own, so it is not cutting productivity

-

#### Continuous Integration

In order to prevent problems from piling up, we must make sure that our new code integrates with the project code every few hours or every day

Programming -> Local tests -> Integrate -> System Tests

First you program and fix your code until you pass all of the local tests

Then you integrate your code with the code of other devs on the project

You then run system tests and if they fail you restart at the programming step, if they pass then you can integrate your code with the system

-

#### On-site Customers

There is a customer from the company that is an actual member of the dev team that sits with the team and brings them then new specs/requirements

***

### Requirements Engineering

User requirements are expressed as scenarios or stories that are written by customers on cards

The development team takes these cards and breaks them down into implementation tasks

Implementation tasks are then used for schedule and cost estimates

The customer will choose the stories that will be scheduled for the next release iteration

The developers will then take the stories/task cards and develop the corresponding code

***

### Testing Strategy:

Testing is coded confidence, when all the tests pass you know you did your job right

The programmer should test every feature, every special case that may exist, with unit tests

The customer will provide the system tests (also called ACCEPTANCE TESTS) and then the dev team will turn the customer's tests into coded automated tests

These system/acceptance tests will run every time the system is integrated, which is less frequently than the unit tests
