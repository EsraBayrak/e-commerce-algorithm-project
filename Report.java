package com.study.util;

import com.study.model.Product;
import com.study.repository.ProductRepository;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Report {

  private final static String filePath = "src\\reports\\report_" + LocalDate.now()+ ".txt";

  
  public static void createReport() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
      for (Product product : ProductRepository.productList) {
        writer.write(product.toString());
        writer.write("\n-------------------------------------\n");
      }
      System.out.println("Products have been saved to " + filePath);
    } catch (IOException e) {
      System.err.println("Error writing to file: " + e.getMessage());
    }
  }

}
