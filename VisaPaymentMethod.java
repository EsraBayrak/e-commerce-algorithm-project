package com.study.payment;

import com.study.model.User;

public class VisaPaymentMethod implements PaymentMethod{

  @Override
  public String pay(User user) {
    user.pay();
    return "Debit Card Payment Method Successful";
  }
}
