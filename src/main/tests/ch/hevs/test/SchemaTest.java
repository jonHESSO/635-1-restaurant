package ch.hevs.test;

import junit.framework.TestCase;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;


public class SchemaTest extends TestCase {

	@Test
	public void testSchema() {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(ch.hevs.businessobject.Owner.class);
		cfg.addAnnotatedClass(ch.hevs.businessobject.Restaurant.class);
		cfg.addAnnotatedClass(ch.hevs.businessobject.Menu.class);
		cfg.addAnnotatedClass(ch.hevs.businessobject.Rating.class);
		cfg.setProperty("hibernate.dialect",
				"org.hibernate.dialect.HSQLDialect");
		cfg.setProperty("hibernate.connection.driver_class",
				"org.hsqldb.jdbcDriver");
		cfg.setProperty("hibernate.connection.driver_class",
				"org.hsqldb.jdbcDriver");
		cfg.setProperty("hibernate.connection.url",
				"jdbc:hsqldb:hsql://localhost/DB");
		cfg.setProperty("hibernate.connection.username", "sa");
		cfg.setProperty("hibernate.connection.password", "");

		new SchemaExport(cfg).setOutputFile("schema.ddl").create(false, true);
	}

}
