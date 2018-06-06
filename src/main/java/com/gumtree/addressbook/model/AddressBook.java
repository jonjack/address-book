package com.gumtree.addressbook.model;

import com.gumtree.addressbook.exception.AddressNotFoundException;

import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {

  private final List<AddressBookEntry> entries;

  public AddressBook(List<AddressBookEntry> entries) {
    this.entries = entries;
  }

  public List<AddressBookEntry> getEntries() {
    return Collections.unmodifiableList(entries);
  }

  public int numberOfMalesInBook() {
    return this.entries.stream().filter(person -> person.gender.equals(Gender.MALE)).
            collect(Collectors.toList()).size();
  }

  public AddressBookEntry oldestPersonInBook() {
    return this.entries.stream().min(Comparator.comparing(person -> person.dob)).get();
  }

  /**
   * Note that this implementation would be extremely inefficient for anything but
   * our trivially small Address book sample since the helper method getEntryByName reduces
   * the complete address book for each entry.
   */
  public long ageDiffInDaysBetweenTwoPersonsInBook(String name1, String name2) throws
          AddressNotFoundException {
    AddressBookEntry person1 = getEntryByName(name1);
    AddressBookEntry person2 = getEntryByName(name2);
    return ChronoUnit.DAYS.between(person1.dob, person2.dob);
  }

  private AddressBookEntry getEntryByName(String name) throws
          AddressNotFoundException {
    List<AddressBookEntry> result = this.entries.stream().filter(person -> person
            .getName()
            .equalsIgnoreCase(name))
            .collect(Collectors.toList());
    if (result.isEmpty())
      throw new AddressNotFoundException();
    else
      return result.get(0);
  }

  @Override
  public String toString() {
    return "AddressBook{" +
            "entries=" + entries +
            '}';
  }

}