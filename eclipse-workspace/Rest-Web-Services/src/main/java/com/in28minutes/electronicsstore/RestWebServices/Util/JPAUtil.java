package com.in28minutes.electronicsstore.RestWebServices.Util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author imssbora
 */
public class JPAUtil {
  private static final String PERSISTENCE_UNIT_NAME = "Store";
  private static EntityManagerFactory factory;

  public static EntityManagerFactory getEntityManagerFactory() {
    if (factory == null) {
      factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
    return factory;
  }

  public static void shutdown() {
    if (factory != null) {
      factory.close();
    }
  }
}
