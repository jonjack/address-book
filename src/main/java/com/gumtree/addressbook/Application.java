package com.gumtree.addressbook;

import com.gumtree.addressbook.exception.AddressNotFoundException;
import com.gumtree.addressbook.model.AddressBook;
import com.gumtree.addressbook.service.AddressBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

  private static final Logger LOG = LoggerFactory.getLogger(Application.class);

  private Application() {
  }

  public static void main(String[] args) throws AddressNotFoundException {
    AddressBookService abs = AddressBookService.getInstance();
    AddressBook ab = AddressBookService.getAddressBook();
    LOG.info("How many males are in the address book? Answer: {}", ab.numberOfMalesInBook());
    LOG.info("Who is the oldest person in the address book? Answer: {}", ab.oldestPersonInBook().getName());
    LOG.info("How many days older is Bill than Paul? Answer: {} days", ab
            .ageDiffInDaysBetweenTwoPersonsInBook("Bill McKnight", "Paul Robinson"));
  }

}