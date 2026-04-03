package tests;

import com.shaft.db.DatabaseActions;
import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;

public class Test {
    SHAFT.DB db;

    @org.testng.annotations.Test
    public void test() {
        db.executeSelectQuery("SELECT * FROM \"Branch\"");
    }

    @BeforeClass
    public void setup() {
        db = new SHAFT.DB(DatabaseActions.DatabaseType.POSTGRES_SQL,
                "165.22.80.135",
                "25060",
                "defaultdb",
                "doadmin",
                "LNkayQI4JtRpqh8Y");
    }
}
