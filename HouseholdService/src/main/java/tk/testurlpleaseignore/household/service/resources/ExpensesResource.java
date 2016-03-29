package tk.testurlpleaseignore.household.service.resources;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import tk.testurlpleaseignore.household.core.Expense;
import tk.testurlpleaseignore.household.service.dao.ExpenseDao;

@Path("expenses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Singleton
public class ExpensesResource {

  private final ExpenseDao expenseDao;

  @Inject
  public ExpensesResource(ExpenseDao expenseDao) {
    this.expenseDao = expenseDao;
  }

  @GET
  public List<Expense> getExpenses() {
    return ImmutableList.of(
        Expense.builder()
            .setAmount(new BigDecimal("5.00"))
            .setName("Breakfast")
            .setNecessity(true)
            .build(),
        Expense.builder()
            .setAmount(new BigDecimal("12.00"))
            .setName("Lunch")
            .setNecessity(true)
            .build(),
        Expense.builder()
            .setAmount(new BigDecimal("24.00"))
            .setName("Dinner")
            .setNecessity(true)
            .build());
  }
}
