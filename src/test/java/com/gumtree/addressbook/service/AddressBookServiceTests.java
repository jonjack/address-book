package com.gumtree.addressbook.service;

import com.gumtree.addressbook.model.AddressBook;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AddressBookServiceTests {

  @Test
  public void converterReturnsExpectedDate() {
    AddressBookService abs = AddressBookService.INSTANCE.getInstance();
    AddressBook ab = AddressBookService.getAddressBook();
    assertTrue(ab.getEntries().size() == 5);
  }

}