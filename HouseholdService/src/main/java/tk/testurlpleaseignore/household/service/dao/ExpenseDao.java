package tk.testurlpleaseignore.household.service.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;

import com.hubspot.rosetta.jdbi.BindWithRosetta;
import com.hubspot.rosetta.jdbi.RosettaMapperFactory;

import tk.testurlpleaseignore.household.core.Expense;

@RegisterMapperFactory(RosettaMapperFactory.class)
public interface ExpenseDao {
  String SET_FIELDS = "name=:name, necessity=:necessity, amount=:amount";

  @SqlQuery("SELECT * FROM expenses")
  List<Expense> getAllExpenses();

  @SqlUpdate("INSERT INTO expenses SET " + SET_FIELDS)
  void insert(@BindWithRosetta Expense expense);
}
