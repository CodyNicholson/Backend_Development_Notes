# Pros and Cons of Approaches

### Testing

#### Pros:

- No false positives

-

#### Cons:

- Incomplete, testing can consider only a tiny fraction of the program domain and therefore a tiny fraction of the program's behavior

***

### Static Verification

#### Pros:

- Considers all program behaviors, it will consider all inputs in the program's input domain

-

#### Cons:

- Considers more than all program behaviors, also considers impossible behaviors, meaning it can generate false positives

***

### Inspections

#### Pros:

- Systematic and results in a thorough analysis of the code

-

#### Cons:

- They are a manual process, a human process
- This makes them informal and their effectiveness may depend on the specific people performing the inspection so the results can be subjective

***

### Formal Proof of Correctness

#### Pros:

- They provide strong guarantees of a programs correctness unlike any of the other approaches

-

#### Cons:

- They need a form of specification , a complete mathematical description of the expected behavior of the whole program
- Such a specification is rarely available
- It is very complex to build a static verification, and possibly expensive
