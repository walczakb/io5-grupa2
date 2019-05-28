package io.db;

import io.domain.Item;
import io.domain.Store;

import java.util.HashMap;
import java.util.Map;

public class Database {
    public static Store loadStore(DbEngine engine) {
        Store store = new StoreProxy(engine);
        engine.readItems((id, name, count, price) -> {
            store.addItem(new ItemProxy(name, count, price, id, engine));
        });
        return store;
    }
}
