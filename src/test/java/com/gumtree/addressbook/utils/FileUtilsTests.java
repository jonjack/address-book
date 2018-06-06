package com.gumtree.addressbook.utils;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class FileUtilsTests {

  @Test
  public void resultSizeIsAsExpected() {
    Optional<List<String>> results = FileUtils.readLinesFromSourceFile("TestFile");
    assertEquals("Failure: number of lines in file should be reflected in result size",
            3, results.get().size());
  }

  @Test
  public void emptyResultWhenSourceFileCannotBeRead() {
    Optional<List<String>> results = FileUtils.readLinesFromSourceFile("NonExistentResource");
    assertEquals("Failure: non-readable resource should return an empty result",
            Optional.empty(), results);
  }

}