package com.study.payment;

import com.study.model.User;

public class CreditCardPaymentMethod implements PaymentMethod{

  @Override
  public String pay(User user) {
    user.pay();
    return "Credit Card Payment Method Successful";
  }
}
