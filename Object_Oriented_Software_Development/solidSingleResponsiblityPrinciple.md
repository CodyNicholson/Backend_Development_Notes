# SOLID Principles  (Single Responsibility)

- By clean code book Martin
- Single responsibility principle
- open-close principle
- Liskov Substitution principle
- Interface Segregation
- Dependency Inversion principles

___

# Single Responsibility Principle

- A class should have only one reason to change
- Every time you need to open up a file, you risk breaking something
- Allowing access to more (fields/methods) than is necessary is also risky
- More responsibilities -> More dependencies
- Dependencies change -> rebuilds/retests/redeploys must occur
- More dependencies -> more complexity -> more opportunity to break