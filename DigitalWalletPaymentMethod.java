package com.study.payment;

import com.study.model.User;

public class DigitalWalletPaymentMethod implements PaymentMethod{

  @Override
  public String pay(User user) {
    user.pay();
    return "Digital Wallet Payment Method Successful";
  }
}
