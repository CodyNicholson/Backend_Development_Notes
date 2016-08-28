There are certain styles of system architecture that allow our system to be more elegant, effective, efficient, dependable, evolvable, scalable, etc

Architectural style defines a family of systems in terms of a pattern of structural organization; a vocabulary of componenets and connectors, with constraints on how they can be combined

Basically, a named collection of architectural design decisions applicable in a given context


Architectural Styles


Pipes and Filters:

A chain of processing elements which can be processes and threads can be arranged so that the output of each element is the input of the next one, usually with some buffering between elements


Event Driven:

Typically systems designed with this style will have an event-o-meter and event consumers that are notified when events of interest occur and have the responsiblity of reacting to those events

Think of a GUi, where widgets generate events and listener listen to those events and react to them, for example they react to the push of a button


Publish-subscribe:

In this style senders of messages called publishers do not send messages directly to receivers, instead they publish messages with one or more associated texts without knowledge of who will recieve such messages

Similarly, subscribers will express interest in one or more texts and will only recieve messages of interest according to such text

Typical example, Twitter


Client-Server:

Computers in a network assume one of two roles

The server who provides resources and functionality

or the client who initiates contact with the server and requests the use of those resources and functionality

Typical example, E-mail in which an email server provides storage and management capabilities and an email client will use those capabilities


Peer-to-Peer:

A type a decentralized and distributed network system in which individual nodes inside the network called peers act as independant agents that are both suppliers and consumers

This is in contrast with the centalized client-server modal where cleint nodes interact with a central authority


Representational State Transfer (REST):

REST is a hybrid architectural style for distributed hyper-media systems that is derived from serveral other network-based architectural styles and that is characterized by uniform connector interface

REST is very widely used because it is the style that governs the world wide web