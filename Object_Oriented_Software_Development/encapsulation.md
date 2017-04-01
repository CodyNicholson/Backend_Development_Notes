# Encapsulation

- Keep implementation details hidden
- “Black box programming”
- Large organizations function because not everyone needs to know every detail all the time -- they break down when too many people need to know too much.

-

- Math.random() provides a pseudo-random number without the caller needing to know how
- Encapsulating is about abstracting the functionality from the caller
- In Java, when you send information across a network, you don’t create individual packets

___

### Encapsulation: Principle of Least Knowledge
-

- Hide as much as possible
- Don't make commitments you can't keep
- The more you hide, the less chance you have for tight coupling
- Think back to SRP issue in Homework 1 – Record and InventorySet are “tightly” coupled. Changes to Record can require changes to InventorySet
- Only acceptable time where changing the functionality of one class changes others is when a public interface is changed

