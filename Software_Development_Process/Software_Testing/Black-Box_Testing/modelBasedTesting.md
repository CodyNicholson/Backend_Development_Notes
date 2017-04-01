# Model Based Testing

In Model-Based Testing the way in which we go from specification to test cases is through the construction of a model

A model is an abstract representation of the software under test, and there are many possible models that we can use

-

##### The model we will consider is the Finite State Machines model (FSM)

###### In this model:

Nodes represent states

Edges represent transitions between states

Edge labels represent events/actions, events are indexed with numbers to tell that correspond to there definition which is stored elsewhere

```
     ___________  Event1  ___________
Ex:  | State 1 | -------> | State 2 |
```

Event1 is when the user clicks the 'Home' button

***

#### How do we build a FSM?

1. We start with the specification and identify the system's boundaries and the input and output to the system

2. Once we have done that we can identify, within the boundaries of the the system, the relevant states and transitions

3. We split this single state and refine it into several states and identify how the system can go from one state to another, including which inputs cause which transitions and result and outputs we can obtain

***

### Final notes:

This process is all about breaking down the complex system into smaller parts that we can create test cases for to be more efficient and effective in testing

-

Testing based on finite state machines is a very general approach that we can apply in a number of contexts

In UML state machines are readily available because state charts are nothing else but a special kind of state machine

You can apply the technique that we just saw directly on state charts and try to cover their states and their transitions

-

Abstraction is key, you have to find the right level of abstraction

The bigger the system the more you have to abstract if you want to represent it with a model and with a Finite State Machine

The more you represent, the more complex your system is going to be, and the more thorough your testing is going to be but also more expensive

The less you represent, the less complex the system, the less expensive it will be, and the less thorough the testing will be

You have to find the right balance of abstraction for your system

-

There are many other approaches other than the FSM like Decision Tables, Flow Graphs, and Historical Models
