package com.gumtree.addressbook.service;

import com.gumtree.addressbook.model.AddressBook;
import com.gumtree.addressbook.model.AddressBookEntry;
import com.gumtree.addressbook.model.Gender;
import com.gumtree.addressbook.utils.DateUtils;
import com.gumtree.addressbook.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddressBookService {

  private static final Logger LOG = LoggerFactory.getLogger(AddressBookService.class);
  private static final String ADDRESS_BOOK_NAME = "AddressBook";
  private static AddressBookService service;
  private static AddressBook book;
  private static final int EXPECTED_COLUMNS_ON_CSV_LINE = 3;

  private AddressBookService() {
  }

  public static AddressBookService getInstance() {
    if (service == null) {
      service = new AddressBookService();
    }
    return service;
  }

  public static AddressBook getAddressBook() {
    if (book == null) {
      book = buildAddressBook();
    }
    return book;
  }

  private static AddressBook buildAddressBook() {
    List<AddressBookEntry> addressList = FileUtils.readLinesFromSourceFile(ADDRESS_BOOK_NAME)
            .get().stream()
            .map(line -> Arrays.asList(line.split(",")))
            .filter(csvLine -> csvLine.size() == EXPECTED_COLUMNS_ON_CSV_LINE)
            .map(mapLineToAddressBookEntry)
            .collect(Collectors.toList());
    return new AddressBook(addressList);
  }

  private static Function<List<String>, AddressBookEntry> mapLineToAddressBookEntry = new
          Function<List<String>, AddressBookEntry>() {
    public AddressBookEntry apply(List<String> csvline) {
      List<String> values = csvline.stream()
              .map(x -> x.trim())
              .collect(Collectors.toList());
      String name = values.get(0);
      Gender gender = Gender.valueOf(values.get(1).toUpperCase());
      LocalDate dob = DateUtils.stringToDateConvertor(values.get(2));
      return new AddressBookEntry(name, gender, dob);
    }
  };

}