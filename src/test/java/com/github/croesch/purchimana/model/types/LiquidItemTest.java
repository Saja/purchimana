package com.github.croesch.purchimana.model.types;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

/**
 * Provides testcases for {@link LiquidItem}
 * 
 * @author croesch
 * @since Date: Nov 13, 2012
 */
public class LiquidItemTest {

  @Test(expected = IllegalArgumentException.class)
  public void testCstr_EurosNull() {
    new LiquidItem("Cola", null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCstr_NameNull() {
    new LiquidItem(null, new Euros(33));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCstr_NameNullEurosNull() {
    new LiquidItem(null, null);
  }

  @Test
  public void testGetEuros() {
    // TODO Menge
    assertThat(new LiquidItem("Cola", new Euros(12)).getEuros()).isEqualTo(new Euros(12));
    assertThat(new LiquidItem("Cola", new Euros(17)).getEuros()).isEqualTo(new Euros(17));
    assertThat(new LiquidItem("Wasser", new Euros(170)).getEuros()).isEqualTo(new Euros(170));
  }

  @Test
  public void testGetName() {
    assertThat(new LiquidItem("Cola", new Euros(12)).getName()).isEqualTo("Cola");
    assertThat(new LiquidItem("Cola", new Euros(17)).getName()).isEqualTo("Cola");
    assertThat(new LiquidItem("Fanta", new Euros(17)).getName()).isEqualTo("Fanta");
  }

  @Test
  public void testEquals() {
    assertThat(new LiquidItem("Fanta", new Euros(17))).isNotEqualTo(null);
    assertThat(new LiquidItem("Fanta", new Euros(17))).isNotEqualTo(new Euros(17));
    assertThat(new LiquidItem("Fanta", new Euros(17))).isEqualTo(new LiquidItem("Fanta", new Euros(17)));

    final Item item = new LiquidItem("Fanta", new Euros(17));
    assertThat(item).isEqualTo(item);

    assertThat(new LiquidItem("Fanta", new Euros(127))).isEqualTo(new LiquidItem("Fanta", new Euros(127)));
    assertThat(new LiquidItem("Coke", new Euros(17))).isEqualTo(new LiquidItem("Coke", new Euros(17)));
    assertThat(new LiquidItem("Bionade", new Euros(7))).isEqualTo(new LiquidItem("bionade", new Euros(7)));

    assertThat(new LiquidItem("Fanta", new Euros(17))).isNotEqualTo(new LiquidItem("theFanta", new Euros(17)));
    assertThat(new LiquidItem("Fanta", new Euros(17))).isNotEqualTo(new LiquidItem("Fantal", new Euros(17)));
    assertThat(new LiquidItem("Fanta", new Euros(127))).isNotEqualTo(new LiquidItem("Fanta", new Euros(27)));
  }

  @Test
  public void testHashCode() {
    assertThat(new LiquidItem("Fanta", new Euros(17)).hashCode()).isEqualTo(new LiquidItem("Fanta", new Euros(17)).hashCode());

    final Item item = new LiquidItem("Fanta", new Euros(17));
    assertThat(item.hashCode()).isEqualTo(item.hashCode());

    assertThat(new LiquidItem("Fanta", new Euros(127)).hashCode()).isEqualTo(new LiquidItem("Fanta", new Euros(127)).hashCode());
    assertThat(new LiquidItem("Coke", new Euros(17)).hashCode()).isEqualTo(new LiquidItem("Coke", new Euros(17)).hashCode());
    assertThat(new LiquidItem("Bionade", new Euros(7)).hashCode()).isEqualTo(new LiquidItem("bionade", new Euros(7)).hashCode());
  }
}
