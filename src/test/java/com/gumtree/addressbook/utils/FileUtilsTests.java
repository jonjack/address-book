package com.gumtree.addressbook.utils;

import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class FileUtilsTests {

  @Test
  public void resultSizeIsAsExpected() throws IOException {
    Optional<List<String>> results = FileUtils.readLinesFromSourceFile("AddressBook");
    assertEquals("Failure: number of lines in address source file should be reflected " +
                    "in result size",
            5, results.get().size());
  }

  @Test
  public void emptyResultWhenSourceFileCannotBeRead() throws IOException {
    Optional<List<String>> results = FileUtils.readLinesFromSourceFile("NonExistentResource");
    assertEquals("Failure: non-readable resource should return an empty result",
            Optional.empty(), results);
  }

}