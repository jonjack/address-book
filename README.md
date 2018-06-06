Demo Java app that reads and operates over a simple Address Book.

## Task

Write a Java application that reads the AddressBook file and answers the following questions:

1. How many males are in the address book?
2. Who is the oldest person in the address book?
3. How many days older is Bill than Paul?

## Running the demo

To build the application.

```
$ gradle build
```

To run the tests.

```
$ gradle test
```

To run the application.

```
$ gradle run
```

## Some notable observations

- The task is relatively trivial if you take it at face value and assume things like: -
   - we do not need to consider a larger dataset for the address book.
   - there are no concurrency requirements. 
   
  The implementation does attempt to address some general concerns like concurrency (eg. by using
   immutable structures where possible) even though the task in itself does not specifically have
    a requirement for it.

- There are no interfaces in this demo, notably there is no`interface AddressBookService`, only 
an implementation. This is because I do not feel that this interface would likely be used anywhere 
else and so would arguably be redundant.

- I tend to agree with the view that the Anaemic domain model is an anti-pattern (generally) and 
hence the behaviours that operate on an `AddressBook` are part of that domain model object. There
 are pros and cons to this but I tend to like the approach of asking an object to perform it's 
 own operations rather than maintaining them in some service elsewhere. 
 
- `AddressBookService` is a singleton since we do not need more than one instance to perform it's
 tasks. Furthermore, it can restrict the number of times we read the input file and therefore 
 reduce IO.
