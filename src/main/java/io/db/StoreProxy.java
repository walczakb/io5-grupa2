package io.db;

import io.domain.Item;
import io.domain.Store;

import java.util.Map;

class StoreProxy extends Store {

    private DbEngine engine;
    private Map<Item, Integer> ids;

    public StoreProxy(DbEngine engine, Map<Item, Integer> ids) {
        this.engine = engine;
        this.ids = ids;
        engine.readItems((id, name, count, price) -> {
            Item item = new ItemProxy(name, count, price, engine, ids);
            ids.put(item, id);
            items.add(item);
        });
    }

    @Override
    protected Item createItem(String name, int count, int price) {
        int id = engine.insertItem(name, count, price);
        Item item = new ItemProxy(name, count, price, engine, ids);
        ids.put(item, id);
        return item;
    }
}
