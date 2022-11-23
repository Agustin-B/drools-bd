package poc.acceso_datos.utils;

import java.util.HashMap;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import poc.acceso_datos.entities.Actividad;

public class HikariCP {
   static SessionFactory sessionFactory;
   private static StandardServiceRegistry registry;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory == null) {
         try {
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
            Map<String, Object> settings = new HashMap<>();
            settings.put(Environment.DRIVER, "org.postgresql.Driver");
            settings.put(Environment.URL, "jdbc:postgresql://192.168.180.190/poc_bps");
            //    settings.put(Environment.USER, "pac");
            //    settings.put(Environment.PASS, "pac");
            settings.put(Environment.SHOW_SQL, true);

            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,
                  "org.hibernate.context.internal.ThreadLocalSessionContext");
            settings.put(Environment.CONNECTION_PROVIDER, "org.hibernate.hikaricp.internal.HikariCPConnectionProvider");

            // HikariCP
            // settings.put("hibernate.hikari.dataSource.url", "jdbc:postgresql://192.168.180.190/poc_bps");
            settings.put("hibernate.hikari.dataSource.user", "pac");
            settings.put("hibernate.hikari.dataSource.password", "pac");

            // Maximum waiting time for a connection from the pool
            settings.put("hibernate.hikari.connectionTimeout", "60000");
            // Minimum number of ideal connections in the pool
            settings.put("hibernate.hikari.minimumIdle", "5");
            // Maximum number of actual connection in the pool
            settings.put("hibernate.hikari.maximumPoolSize", "100");
            // Maximum time that a connection is allowed to sit ideal in the pool
            settings.put("hibernate.hikari.idleTimeout", "300000");
            settings.put("hibernate.hikari.maxLifetime", "1740000");
            settings.put("hibernate.hikari.leakDetectionThreshold", "60000");

            registryBuilder.applySettings(settings);
            registry = registryBuilder.build();
            MetadataSources sources = new MetadataSources(registry).addAnnotatedClass(Actividad.class);
            Metadata metadata = sources.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
         } catch (Exception e) {
            if (registry != null) {
               StandardServiceRegistryBuilder.destroy(registry);
            }
            e.printStackTrace();
         }
      }
      return sessionFactory;
   }
}