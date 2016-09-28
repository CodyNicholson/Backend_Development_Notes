#SOLID Principles  (Single Responsibility)

- By clean code book Martin
- Single responsiblity principle
- open-close principle
- Liskov Substitution principle
- Interface Segregation
- Dependancy Inversion principles

___

#Single Responsiblity Principle

- A class should have only one reason to change
- Every time you need to open up a file, you risk breaking something
- Allowing access to more (fields/methods) than is necessary is also risky
- More responsibilities -> More dependencies
- Dependencies change -> rebuilds/retests/redeploys must occur
- More dependencies -> more complexity -> more opportunity to break