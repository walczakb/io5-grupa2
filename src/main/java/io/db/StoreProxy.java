package io.db;

import io.domain.Item;
import io.domain.Store;

class StoreProxy extends Store {
    private final DbEngine engine;

    public StoreProxy(DbEngine engine) {
        super();
        this.engine = engine;
    }

    protected Item createItem(String name, int count, int price) {
        int id = engine.insertItem(name, count, price);
        return new ItemProxy(name, count, price, id, engine);
    }
}
