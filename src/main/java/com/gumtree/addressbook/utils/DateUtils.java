package com.gumtree.addressbook.utils;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class DateUtils {

  /**
   * Returns a LocalDate object for a given string pattern.
   * The string date argument must match the allowable pattern.
   *
   * @param date a String representation of a date in the format "16/03/77"
   * @return The LocalDate instance for the converted string.
   */
  public static LocalDate stringToDateConvertor(String date) {
    DateTimeFormatter df = new DateTimeFormatterBuilder()
            .appendPattern("dMM")
            .appendValueReduced(
                    ChronoField.YEAR, 2, 2, Year.now().getValue() - 80
            ).toFormatter();
    return LocalDate.parse(date.replace("/", ""), df);
  }

}