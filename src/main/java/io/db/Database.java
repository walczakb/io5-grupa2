package io.db;

import io.domain.Item;
import io.domain.Store;
import io.sqldb.SqlDbFactory;

import java.util.HashMap;
import java.util.Map;

public class Database {
    static final DbEngine engine = new SqlDbFactory().engine();

    public Database() {}

    public static StoreProxy loadStore() {
        StoreProxy store = new StoreProxy();
        engine.readItems((id, name, count, price) -> {
            //Item item = new Item(name, count, price);
            //Item item = store.addItem(name, count, price);
            store.addItem(name, count, price);
            //ids.put(item, id);
        });
        return store;
    }

    /*
    public void addItem(Item item) {
        int id = engine.insertItem(item.name(), item.count(), item.price());
        ids.put(item, id);
    }

    public void updateItem(Item item) {
        int id = ids.get(item);
        engine.updateItem(id, item.name(), item.count(), item.price());
    }
     */
}
