package com.gumtree.addressbook.model;

import java.time.LocalDate;
import java.util.Objects;

public class AddressBookEntry {

  final String name;
  final Gender gender;
  final LocalDate dob;

  public AddressBookEntry(String name, Gender gender, LocalDate dob) {
    this.name = name;
    this.gender = gender;
    this.dob = dob;
  }

  public String getName() {
    return name;
  }

  public Gender getGender() {
    return gender;
  }

  public LocalDate getDob() {
    return dob;
  }

  @Override
  public String toString() {
    return "AddressBookEntry{" +
            "name='" + name + '\'' +
            ", gender=" + gender +
            ", dob=" + dob +
            '}';
  }

}