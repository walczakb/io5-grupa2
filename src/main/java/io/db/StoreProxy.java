package io.db;

import io.domain.Store;

class StoreProxy extends Store {
    private final DbEngine engine;
    StoreProxy(DbEngine engine) {
        this.engine = engine;
    }
    @Override
    public ItemProxy createItem(String name, int count, int price) {
        int id = engine.insertItem(name, count, price);
        return new ItemProxy(name, count, price, engine, id);
    }
}
