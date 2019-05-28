package io.db;

import io.domain.Item;
import io.sqldb.SqlDbFactory;

import java.util.HashMap;
import java.util.Map;

class ItemProxy extends Item {
    static Map<Item, Integer> ids = new HashMap<>();
    DbEngine engine = new SqlDbFactory().engine();

    public ItemProxy(String name, int count, int price) {
        super(name, count, price);
    }

    @Override
    public void update(String name, int count, int price) {
        int id = ids.get(this);
        engine.updateItem(id, name, count, price);
        super.update(name, count, price);
    }
}
