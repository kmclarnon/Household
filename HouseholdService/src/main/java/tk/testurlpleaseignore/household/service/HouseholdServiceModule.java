package tk.testurlpleaseignore.household.service;

import org.skife.jdbi.v2.DBI;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import tk.testurlpleaseignore.household.service.dao.ExpenseDao;

public class HouseholdServiceModule extends AbstractModule {

  @Override
  public void configure() {

  }

  @Provides
  public DBI providesDbi(Environment environment, HouseholdConfiguration configuration) {
    DBIFactory dbiFactory = new DBIFactory();
    return dbiFactory.build(environment, configuration.getDataSourceFactory(), "mysql");
  }

  @Provides
  public ExpenseDao providesExpenseDao(DBI dbi) {
    return dbi.onDemand(ExpenseDao.class);
  }
}
