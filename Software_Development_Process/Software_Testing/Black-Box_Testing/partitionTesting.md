#Partition Testing

Failures tend to be dense, meaning that if there is one failure then there is probably more failures very close by to it

***

We take advantage of that by using Partition Testing which has two steps:

1. Identify Partitions of our domain

2. Select inputs from each partition

***

By doing this we can dramatically increase our chances to reveal faults in the code

-

####Example:


Split(String str, int size)

Some possible partitions:

```
size < 0   str with length < size
size = 0   str with length in[size, size * 2]
size > 0   str with length > size * 2
```
