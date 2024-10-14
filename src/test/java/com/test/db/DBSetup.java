package com.test.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import static org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@TestInstance(Lifecycle.PER_CLASS)
public abstract class DBSetup {
	protected static Logger logger = LoggerFactory.getLogger(DBSetup.class);

	static Boolean initialized = false;

	@Autowired
	protected DataSource dataSource;

	@Autowired
	private Environment environment;

	public boolean isDebugProfile() {
		return environment.acceptsProfiles("debug");
	}

	@BeforeAll
	public void cleanDB() {
		synchronized (DBSetup.class) {
			if (isDebugProfile() && !initialized) {
				try {
					Connection connection = dataSource.getConnection();
					DatabaseMetaData dmd = connection.getMetaData();
					ResultSet rs = dmd.getTables(null, "public", "%", new String[] { "TABLE" });
					while (rs.next()) {
						logger.error("Truncating table = {}", rs.getString("TABLE_NAME"));
						try (Statement stmt = connection.createStatement())
						{
							stmt.execute("TRUNCATE TABLE " + rs.getString("TABLE_NAME") + " CASCADE");
						}
					}
					rs.close();
					connection.close();
					initialized = true;
				} catch (SQLException ex) {
					logger.error("Error", ex);
				}
			}
		}
	}
}
