package com.gumtree.addressbook.utils;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class DateUtilsTests {

  @Test
  public void converterReturnsExpectedDate() {
    LocalDate date = DateUtils.stringToDateConvertor("16/03/77");
    assertEquals("Failure: Days was not as expected",16, date.getDayOfMonth());
    assertEquals("Failure: Month was not as expected",03, date.getMonthValue());
    assertEquals("Failure: Years was not as expected", 1977, date.getYear());
  }

}