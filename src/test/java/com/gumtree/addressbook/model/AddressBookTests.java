package com.gumtree.addressbook.model;

import com.gumtree.addressbook.exception.AddressNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddressBookTests {

  AddressBook ab;

  @Before
  public void setUp() {
    List<AddressBookEntry> entryList = new ArrayList<>();
    entryList.add(new AddressBookEntry("Bill McKnight", Gender.MALE, LocalDate.of
            (1977, 3, 16)));
    entryList.add(new AddressBookEntry("Paul Robinson", Gender.MALE, LocalDate.of
            (1985, 1, 15)));
    entryList.add(new AddressBookEntry("Gemma Lane", Gender.FEMALE, LocalDate.of
            (1991, 11, 20)));
    entryList.add(new AddressBookEntry("Sarah Stone", Gender.FEMALE, LocalDate.of
            (1980, 9, 20)));
    entryList.add(new AddressBookEntry("Wes Jackson", Gender.MALE, LocalDate.of
            (1974, 8, 14)));
    this.ab = new AddressBook(entryList);
  }

  @Test
  public void gettingNumberOfMalesInBookReturnsCorrectResult() {
    int numberOfMalesFound = ab.numberOfMalesInBook();
    assertEquals("Failure: number of males in book not as expected",
            3, numberOfMalesFound);
  }

  @Test
  public void gettingOldestPersonInBookReturnsCorrectResult() {
    AddressBookEntry oldest = ab.oldestPersonInBook();
    assertEquals("Failure: oldest person not as expected",
            "Wes Jackson", oldest.name);
  }

  @Test
  public void gettingAgeDifferenceBetweenTwoPeopleReturnsCorrectResult() throws
          AddressNotFoundException {
    long diffInDays = ab.ageDiffInDaysBetweenTwoPersonsInBook("Bill McKnight", "Paul " + "Robinson");
    assertEquals("Failure: diff in age between two people in book not as expected", 2862, diffInDays);
  }

}