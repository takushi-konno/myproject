package model;

import java.io.Serializable;

public class Mutter implements Serializable {
  private int mutterId; // つぶやきid
  private String userId; // ユーザーID
  private String text; // つぶやき内容

  public Mutter() {
  }

  public Mutter(String userId, String text) {
    this.userId = userId;
    this.text = text;
  }

  public Mutter(int mutterId, String userId, String text) {
    this.mutterId = mutterId;
    this.userId = userId;
    this.text = text;
  }

  public int getMutterId() {
    return mutterId;
  }

  public String getUserId() {
    return userId;
  }

  public String getText() {
    return text;
  }
}