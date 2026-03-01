package com.study.model;

public class User {

  private String userName;
  private String name;
  private String surname;
  private String password;
  private Integer balance;
  private Boolean isAdmin;
  private ShoppingCart shoppingCart = new ShoppingCart();

  public User(String userName, String name, String surname, String password, Integer balance, Boolean isAdmin) {
    this.userName = userName;
    this.name = name;
    this.surname = surname;
    this.password = password;
    this.balance = balance;
    this.isAdmin = isAdmin;
  }

 
  public void pay(){
    this.balance -= shoppingCart.getCartPrice();
  }

  public Boolean getAdmin() {
    return isAdmin;
  }

  public void setAdmin(Boolean admin) {
    isAdmin = admin;
  }

  
  public void addToShoppingCart(Product product) {
    this.shoppingCart.getProductList().add(product);
  }

  public void removeFromShoppingCart(Product product) {
    this.shoppingCart.getProductList().remove(product);
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getBalance() {
    return balance;
  }

  public void setBalance(Integer balance) {
    this.balance = balance;
  }

  public ShoppingCart getShoppingCart() {
    return shoppingCart;
  }

  public void setShoppingCart(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
  }
}
