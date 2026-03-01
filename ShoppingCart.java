package com.study.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

  private List<Product> productList;

  public ShoppingCart() {
    this.productList = new ArrayList<>();
  }


  
  public Integer getCartPrice() {
    int sum = 0;
    for (Product product : this.productList) {
      sum += product.getPrice();
    }
    return sum;
  }

  public List<Product> getProductList() {
    return productList;
  }

  public void setProductList(List<Product> productList) {
    this.productList = productList;
  }

 
  public void clear() {
    this.productList.clear();
  }

 
  public void revertStock() {
    for(Product product: this.productList){
      product.setStock(product.getStock() + 1);
    }
  }
}




