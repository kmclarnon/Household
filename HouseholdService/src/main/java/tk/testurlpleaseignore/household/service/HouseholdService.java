package tk.testurlpleaseignore.household.service;

import com.hubspot.dropwizard.guice.GuiceBundle;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HouseholdService extends Application<HouseholdConfiguration> {

  public static final String SERVICE_NAME = "Household Service";

  public static void main(String[] args) throws Exception {
    new HouseholdService().run(args);
  }

  @Override
  public void initialize(Bootstrap<HouseholdConfiguration> bootstrap) {

    GuiceBundle<HouseholdConfiguration> guiceBundle = GuiceBundle.<HouseholdConfiguration>newBuilder()
        .addModule(new HouseholdServiceModule())
        .enableAutoConfig(getClass().getPackage().getName())
        .setConfigClass(HouseholdConfiguration.class)
        .build();

    bootstrap.addBundle(guiceBundle);
  }

  @Override
  public String getName() {
    return SERVICE_NAME;
  }

  @Override
  public void run(HouseholdConfiguration configuration, Environment environment) throws Exception {
  }

}
