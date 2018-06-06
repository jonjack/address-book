package com.gumtree.addressbook.model;

import java.time.LocalDate;
import java.util.Objects;

public class AddressBookEntry {

  final String name;
  final Gender gender;
   LocalDate dob;

  public AddressBookEntry(String name, Gender gender, LocalDate dob) {
    this.name = name;
    this.gender = gender;
    this.dob = dob;
  }

  @Override
  public String toString() {
    return "AddressBookEntry{" +
            "name='" + name + '\'' +
            ", gender=" + gender +
            ", dob=" + dob +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AddressBookEntry that = (AddressBookEntry) o;
    return Objects.equals(name, that.name) &&
            gender == that.gender &&
            Objects.equals(dob, that.dob);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, gender, dob);
  }
  
}