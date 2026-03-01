package com.study.repository;

import com.study.constant.Images;
import com.study.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
  public static List<Product> productList = new ArrayList<>();

  static {
    productList.add(new Product(Images.camera1, "Nicon", "xc300 Camera", "This is a detailed description of the product.", 600, "electronics", 50));
    productList.add(new Product(Images.camera2, "Canon", "EOS 500", "This is a detailed description of the product.", 130, "electronics", 50));
    productList.add(new Product(Images.glasses, "Ryban", "Sun Glasses", "This is a detailed description of the product.", 150, "wear", 50));
    productList.add(new Product(Images.headphone, "Logitech", "T5 Headphones", "This is a detailed description of the product.", 400, "electronics", 50));
    productList.add(new Product(Images.watch, "Rolex", "R Watch 2000", "This is a detailed description of the product.", 600, "wear", 50));
    productList.add(new Product(Images.glasses2, "Telko", "Cool Glasses", "This is a detailed description of the product.", 300, "wear", 50));
    productList.add(new Product(Images.bag, "Prada", "Zenon", "This is a detailed description of the product.", 360, "wear", 50));
    productList.add(new Product(Images.mouse, "Logitech", "G203", "This is a detailed description of the product.", 400, "electronics", 50));
    productList.add(new Product(Images.perfume, "Zara", "102", "This is a detailed description of the product.", 400, "garden", 50));
    productList.add(new Product(Images.shoes, "Nike", "Air", "This is a detailed description of the product.", 600, "wear", 50));
    productList.add(new Product(Images.speaker, "JBL", "Tnc300", "This is a detailed description of the product.", 350, "electronics", 50));
    productList.add(new Product(Images.toyCar, "Volkswagen", "Beetle", "This is a detailed description of the product.", 230, "garden", 50));
    productList.add(new Product(Images.vase, "Vase", "vase", "This is a detailed description of the product.", 50, "garden", 50));
    productList.add(new Product(Images.brush, "Gezer", "paint brush", "This is a detailed description of the product.", 80, "garden", 50));



  }


}
