package com.google.sps.data;

/** An item on a todo list. */
public final class Email {

  private final long key;
  private final String email;

  public Email(long key, String email) {
    this.key = key;
    this.email = email;
  }
}