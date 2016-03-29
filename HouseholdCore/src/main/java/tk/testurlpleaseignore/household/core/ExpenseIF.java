package tk.testurlpleaseignore.household.core;

import java.math.BigDecimal;

import org.immutables.value.Value;

@Value.Immutable
@HouseholdStyle
public interface ExpenseIF {
  String getName();
  boolean getNecessity();
  BigDecimal getAmount();
}
