# Architecture-Centric

The Rational Unified Process (RUP) is Architecture-centric

While Use Cases define the function of the system, Architecture defines the form of the system

Use Cases give you the functionality, Architecture tells you how the system should be structured to provide the functionality

***

To define software architecture in the RUP we create:

- A rough outline of the system by modeling the platform on which the system will run

- The overall style

- Whether it is client-server or peer-to-peer or etc

***

We then use the key use cases in our case diagram to define the main subsystem of the architecture

For example, in the case of a banking IT system, one of these subsystems we decide we need will be a withdrawal system

We then review use cases that refer to withdrawal activity, where we then realize that we also need a subsystem that implements that piece of functionality

So again we use the key use cases to identify the key subsystems for my architecture

***

Then we make it better iteratively by using additional use cases and considering more and more pieces of functionality that will help us to refine the architecture of the system and also leverage our increasing understanding of the system that we are modeling

This will continue iteratively until we are happy with the architecture that we defined
