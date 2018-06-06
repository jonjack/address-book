package com.gumtree.addressbook.utils;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class DateUtilsTests {

  @Test
  public void converterReturnsExpectedDate() {
    LocalDate date = DateUtils.stringToDateConvertor("16/03/77");
    assertEquals(16, date.getDayOfMonth());
    assertEquals(03, date.getMonthValue());
    assertEquals(1977, date.getYear());
  }

}