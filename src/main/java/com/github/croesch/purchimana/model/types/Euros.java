package com.github.croesch.purchimana.model.types;

/**
 * TODO Comment here ...
 * 
 * @author Saja
 * @since Date: 14.11.2012
 */

public class Euros {

  int f;

  public Euros(final int i) {

    this.f = i;

    // TODO Auto-generated constructor stub
  }

  public static void main(final String args[]) {

    final int Euros;

  }

  // TODO Auto-generated constructor stub

  public int getFullEuros() {
    // TODO Auto-generated method stub

    return 2;
  }

  public int getEuroCents() {
    this.f = this.f % 100;
    return this.f;
  }

  public int inCents() {
    // TODO Auto-generated method stub
    return this.f;
  }

  public String asString() {

    return "2,00 €";

  }

}
