package com.ydlclass.facade.moreDatabase;

/**
 * @author
 * @createTime 2023-05-26
 */
public class DatabaseFacade {
    private Database mysqlDatabase;
    private Database oracleDatabase;

    public DatabaseFacade() {
        mysqlDatabase = new MySQLDatabase();
        oracleDatabase = new OracleDatabase();
    }

    public void executeSQL(String sql, String databaseType) {
        if ("mysql".equals(databaseType.toLowerCase().trim())) {
            mysqlDatabase.execute(sql);
        } else if (databaseType.equals("Oracle")) {
            oracleDatabase.execute(sql);
        } else {
            throw new IllegalArgumentException("Unknown database type: " + databaseType);
        }
    }
}
