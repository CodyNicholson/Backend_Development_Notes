#Refactoring

Refactoring is changing the structure of the code without changing its functionality

***

###When to Refactor
-

-   Code smell: some code that indicates there may be a larger design issue

    Example: Homework 1 violation of SRP

-   Refactor when you end up with a high volume of technical debt (check out SonarQube)

    Technical debt is what you end up with when you implement the easy solution and not the correct solution

***

###How to Refactor
-

1. Write unit tests to extensively cover the code that will be refactored

2. Plan your design changes

3. Refactor

4. Run unit tests to make sure the code works the same as it did before

***

###Why Refactor?
-

- Erase potential areas for bugs

- Improve design (increase potential for extensibility and maintainability)

- Remove dependencies (decrease complexity)