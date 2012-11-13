package com.github.croesch.purchimana.model.types;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

/**
 * Provides testcases for {@link Euro}
 * 
 * @author croesch
 * @since Date: Nov 13, 2012
 */
public class EurosTest {

  @Test
  public void testGetFullEuros() {
    assertThat(new Euros(200).getFullEuros()).isEqualTo(2);
    assertThat(new Euros(201).getFullEuros()).isEqualTo(2);
    assertThat(new Euros(391).getFullEuros()).isEqualTo(3);
    assertThat(new Euros(17).getFullEuros()).isEqualTo(0);
    assertThat(new Euros(-17).getFullEuros()).isEqualTo(0);
    assertThat(new Euros(-317).getFullEuros()).isEqualTo(-3);
    assertThat(new Euros(-100).getFullEuros()).isEqualTo(-1);
  }

  @Test
  public void testGetEuroCents() {
    assertThat(new Euros(200).getEuroCents()).isEqualTo(0);
    assertThat(new Euros(201).getEuroCents()).isEqualTo(1);
    assertThat(new Euros(391).getEuroCents()).isEqualTo(91);
    assertThat(new Euros(17).getEuroCents()).isEqualTo(17);
    assertThat(new Euros(-17).getEuroCents()).isEqualTo(-17);
    assertThat(new Euros(-317).getEuroCents()).isEqualTo(-17);
    assertThat(new Euros(-100).getEuroCents()).isEqualTo(0);
  }

  @Test
  public void testInCents() {
    assertThat(new Euros(200).inCents()).isEqualTo(200);
    assertThat(new Euros(201).inCents()).isEqualTo(201);
    assertThat(new Euros(391).inCents()).isEqualTo(391);
    assertThat(new Euros(17).inCents()).isEqualTo(17);
    assertThat(new Euros(-17).inCents()).isEqualTo(-17);
    assertThat(new Euros(-317).inCents()).isEqualTo(-317);
    assertThat(new Euros(-100).inCents()).isEqualTo(-100);
  }

  @Test
  public void testAsString() {
    // TODO asString(#0,00 EUR) ...
    assertThat(new Euros(200).asString()).isEqualTo("2,00 €");
    assertThat(new Euros(201).asString()).isEqualTo("2,01 €");
    assertThat(new Euros(391).asString()).isEqualTo("3,91 €");
    assertThat(new Euros(17).asString()).isEqualTo("0,17 €");
    assertThat(new Euros(-17).asString()).isEqualTo("-0,17 €");
    assertThat(new Euros(-317).asString()).isEqualTo("-3,17 €");
    assertThat(new Euros(-100).asString()).isEqualTo("-1,00 €");
  }

  @Test
  public void testEquals() {
    assertThat(new Euros(200)).isNotEqualTo(null);
    assertThat(new Euros(200)).isNotEqualTo(200);
    assertThat(new Euros(200)).isEqualTo(new Euros(200));

    final Euros euros = new Euros(200);
    assertThat(euros).isEqualTo(euros);

    assertThat(new Euros(184)).isEqualTo(new Euros(184));
    assertThat(new Euros(142184)).isEqualTo(new Euros(142184));
    assertThat(new Euros(-142184)).isEqualTo(new Euros(-142184));

    assertThat(new Euros(184)).isNotEqualTo(new Euros(-184));
    assertThat(new Euros(184)).isNotEqualTo(new Euros(284));
    assertThat(new Euros(184)).isNotEqualTo(new Euros(148));
  }

  @Test
  public void testHashCode() {
    assertThat(new Euros(200).hashCode()).isEqualTo(new Euros(200).hashCode());

    final Euros euros = new Euros(200);
    assertThat(euros.hashCode()).isEqualTo(euros.hashCode());

    assertThat(new Euros(184).hashCode()).isEqualTo(new Euros(184).hashCode());
    assertThat(new Euros(142184).hashCode()).isEqualTo(new Euros(142184).hashCode());
    assertThat(new Euros(-142184).hashCode()).isEqualTo(new Euros(-142184).hashCode());
  }
}
