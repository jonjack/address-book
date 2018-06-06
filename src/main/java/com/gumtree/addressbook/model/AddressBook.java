package com.gumtree.addressbook.model;

import java.util.Collections;
import java.util.List;

public class AddressBook {

  private final List<AddressBookEntry> entries;

  public AddressBook(List<AddressBookEntry> entries) {
    this.entries = entries;
  }

  public List<AddressBookEntry> getEntries() {
    return Collections.unmodifiableList(entries);
  }

  public int numberOfMalesInBook() {
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public AddressBookEntry oldestPersonInBook() {
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public int ageDifferenceInDaysBetweenTwoPersonsInBook(String name1, String name2) {
    throw new UnsupportedOperationException("Not yet implemented");
  }

  @Override
  public String toString() {
    return "AddressBook{" +
            "entries=" + entries +
            '}';
  }

}