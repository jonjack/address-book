package com.gumtree.addressbook.exception;

public class AddressNotFoundException extends Exception {
  public AddressNotFoundException() {
    super();
  }

  public AddressNotFoundException(String message) {
    super(message);
  }

  public AddressNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public AddressNotFoundException(Throwable cause) {
    super(cause);
  }
}