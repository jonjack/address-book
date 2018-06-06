package com.gumtree.addressbook.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class FileUtils {

  private static final Logger LOG = LoggerFactory.getLogger(FileUtils.class);

  /**
   * Returns a representation of a file resource as a List of Lines.
   * A line is represented as a single String.
   * The file should reside in the local resource path.
   *
   * @param filename
   */
  public static Optional<List<String>> readLinesFromSourceFile(String filename) {
    Optional<List<String>> lines = Optional.empty();
    Optional<URL> opt = Optional.ofNullable(FileUtils.class.getClassLoader().getResource(filename));
    try {
      URL url = opt.orElseThrow(IOException::new);
      Path path = Paths.get(url.toURI());
      lines = Optional.ofNullable(Files.readAllLines(path));
    } catch (URISyntaxException | IOException ex) {
      LOG.error("Problem reading source file {} in path {} - {}", filename,
              Paths.get("resources").toUri(), ex.getClass());
    }
    return lines;
  }
  
}