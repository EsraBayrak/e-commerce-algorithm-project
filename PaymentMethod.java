package com.study.payment;

import com.study.model.User;

public interface PaymentMethod {

  String pay(User user);

}
