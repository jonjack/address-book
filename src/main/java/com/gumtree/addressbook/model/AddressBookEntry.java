package com.gumtree.addressbook.model;

import java.time.LocalDate;

public class AddressBookEntry {

  private final String name;
  private final Gender gender;
  private final LocalDate dob;

  public AddressBookEntry(String name, Gender gender, LocalDate dob) {
    this.name = name;
    this.gender = gender;
    this.dob = dob;
  }

}