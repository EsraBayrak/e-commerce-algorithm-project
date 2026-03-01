package com.study.util;

import com.study.model.Product;
import com.study.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;

public class Filter {


  
  public static List<Product> filter(boolean electronics, boolean wear, boolean garden,
      int maxPrice) {

    List<Product> filteredProductList = new ArrayList<>();

    for (Product product : ProductRepository.productList) {

      if (electronics && product.getCategory().equals("electronics")) {
        filteredProductList.add(product);
      }
      if (wear && product.getCategory().equals("wear")) {
        filteredProductList.add(product);
      }
      if (garden && product.getCategory().equals("garden")) {
        filteredProductList.add(product);
      }

      if (product.getPrice() > maxPrice) {
        filteredProductList.remove(product);
      }

    }


    return filteredProductList;
  }
}
