#Strong Vs Weak Typing

Strong typing guarantees no runtime type errors

- oft used but poorly defined

- type safety is more precise

- weak typing may permit runtime type errors

Runtime type error = data used contrary to type

- E.g., a floating point number used as an integer

***

Strong, static: Java, C#, Scala, Rust, etc.

- early warning, strong guarantees

Weak, static: C

- early warning, weak guarantees

Strong, dynamic: Scheme, Python, Ruby, etc.

- problem detected at runtime

- but before a runtime type error occurs!