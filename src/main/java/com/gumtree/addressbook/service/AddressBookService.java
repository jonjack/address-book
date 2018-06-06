package com.gumtree.addressbook.service;

import com.gumtree.addressbook.model.AddressBook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AddressBookService {

  INSTANCE;

  private static final Logger LOG = LoggerFactory.getLogger(AddressBookService.class);

  private static final String ADDRESS_BOOK_NAME = "AddressBook";

  public AddressBookService getInstance() {
    return INSTANCE;
  }

  public static AddressBook getAddressBook() {
    throw new UnsupportedOperationException("Not yet implemented");
  }

}