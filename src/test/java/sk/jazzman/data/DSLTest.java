package sk.jazzman.data;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

public class DSLTest {
    @Test
    public void connectTest() {
        DataSource dataSource = getDataSource();
        try (Statement statement = dataSource.getConnection().createStatement()) {
            statement.execute("SELECT now();");
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            Timestamp date = resultSet.getTimestamp(1);
            System.out.println(date);

        } catch (Exception ex) {
            System.err.println("Failed" + ex);
        }
    }

    private static DataSource getDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/test");
//        config.setDriverClassName("");
        config.setUsername("test");
        config.setPassword("test");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return new HikariDataSource(config);
    }
}
