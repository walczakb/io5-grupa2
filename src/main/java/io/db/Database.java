package io.db;

import io.domain.Store;

public class Database implements DbGateway {

    static public Store loadStore(DbEngine engine) {
        StoreProxy store = new StoreProxy(engine);
        engine.readItems((id, name, count, price) -> store.addItem(id, name, count, price));
        return store;
    }

}
