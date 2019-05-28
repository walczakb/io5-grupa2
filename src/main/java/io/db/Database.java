package io.db;

import io.domain.Item;
import io.domain.Store;

public class Database {

    public static Store loadStore(DbEngine engine) {
        Store store = new StoreProxy(engine);
        engine.readItems((id, name, count, price) -> {
            Item item = new ItemProxy(engine,id,name,count,price);
            store.loadItem(item);
            //store.addItem(name, count, price);
        });
        return store;
    }

}
