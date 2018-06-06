Demo Java app that reads and operates over a simple Address Book.

## Task

Write a Java application that reads the AddressBook file and answers the following questions:

1. How many males are in the address book?
2. Who is the oldest person in the address book?
3. How many days older is Bill than Paul?

## Some specs

- Project was built with Java build "1.8.0_152"
- Logs are written to a `logs` directory in the root of the application home.

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

To generate a test code coverage report.

```
$ gradle jacocoTestReport
```

## Output of running the application

```text
INFO  com.gumtree.addressbook.Application - How many males are in the address book? Answer: 3
INFO  com.gumtree.addressbook.Application - Who is the oldest person in the address book? Answer: Wes Jackson
INFO  com.gumtree.addressbook.Application - How many days older is Bill than Paul? Answer: 2862 days
```

## Some notable observations

- Viewing the commit log will show that failing tests were committed. This was intended in order to 
demonstrate the process of TDD but would not be usual practise as it generally breaks the build.

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
 
- Some operations are very inefficient - notably `AddressBook.getEntryByName` which searches for 
elements by filtering the whole Address Book each time. This is acceptable for such a 
small dataset but should never be used in production. If I spent more time on this demo then the next 
thing I would do is possibly improve the efficiency of `AddressBook.getEntryByName` either by 
converting to some collection with less time complexity search behaviour or by doing something 
like sorting and binary searching over the underlying list implementation.
