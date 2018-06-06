package com.gumtree.addressbook.service;

import com.gumtree.addressbook.model.AddressBook;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddressBookServiceTests {

  @Test
  public void converterReturnsExpectedDate() {
    AddressBookService abs = AddressBookService.getInstance();
    AddressBook ab = AddressBookService.getAddressBook();
    assertEquals("Failure: Service returned an address book of incorrect size",
            ab.getEntries().size(), 5);
  }

}