package io;

import io.db.DbEngine;
import io.db.Database;
import io.swingui.SwingFacade;
import io.sqldb.SqlDbFactory;

public class Program {
    public static void main(String[] args) {
        Database db = new Database();
        SwingFacade.start(db.loadStore());
    }
}
