package com.springboot.thymeleafdemo.model;

import java.util.List;

public class Student {
  private String firstName;
  private String lastName;
  private String country;
  private String favoriteLang;
  private List<String> favoriteOper;

  public Student() {
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getFavoriteLang() {
    return favoriteLang;
  }

  public void setFavoriteLang(String favoriteLang) {
    this.favoriteLang = favoriteLang;
  }

  public List<String> getFavoriteOper() {
    return favoriteOper;
  }

  public void setFavoriteOper(List<String> favoriteOper) {
    this.favoriteOper = favoriteOper;
  }
}