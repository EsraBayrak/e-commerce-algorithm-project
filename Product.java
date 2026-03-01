package com.study.model;

import java.awt.Image;


public class Product {

  private Image image;
  private String brand;
  private String name;
  private String description;
  private Integer price;
  private String category;
  private Integer stock;

  public Product(Image image, String brand, String name, String description, Integer price,
      String category, Integer stock) {
    this.image = image;
    this.brand = brand;
    this.name = name;
    this.description = description;
    this.price = price;
    this.category = category;
    this.stock = stock;
  }

  @Override
  public String toString() {
    return "Brand: " + brand + "\n" +
        "Name: " + name + "\n" +
        "Description: " + description + "\n" +
        "Price: " + price + "\n" +
        "Category: " + category + "\n" +
        "Stock: " + stock + "\n";
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

}
