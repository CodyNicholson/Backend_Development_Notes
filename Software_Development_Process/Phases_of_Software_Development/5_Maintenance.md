# Maintenance

Once the software is released and in operation, many different things can go wrong so we need to maintain it

***

There might be environment changes, like new Operating Systems and Libraries where our software has to operate

There could also be feature requests where the users decide that they need something else that is not present in the software currently

There could also be bugs discovered in the software that we will need to go back and fix without breaking anything else

***

In response to the three possible problems defined above, developers preform three kinds of maintenance activities

-

### 1. Corrective Maintenance

To eliminate problems with the code

-

### 2. Perfective Maintenance

To accommodate feature requests, or also to improve the software generally in terms of performance

-

### 3. Adaptive Maintenance

To take care of environment changes

***

Once these three steps have been completed, we need to run **regression tests** on our software

Regression testing is testing that makes sure that the parts of the software you didn't modify still work, and that the parts of the software you modified or added work correctly as well

Now we can release the software again and restart this same process

***

If you re-release the software after going through the three step process and then there are new errors, these errors are called regression errors

Regression errors are among the most expensive errors to fix
