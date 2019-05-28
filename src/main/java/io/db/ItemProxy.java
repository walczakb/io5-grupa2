package io.db;

import io.domain.Item;

import java.util.Map;

class ItemProxy extends Item {

    private Map<Item, Integer> ids;
    private DbEngine engine;

    public ItemProxy(String name, int count, int price, DbEngine engine, Map<Item, Integer> ids) {
        super(name, count, price);
        this.engine = engine;
        this.ids = ids;
    }

    @Override
    public void update(String name, int count, int price) {
        int id = ids.get(this);
        engine.updateItem(id, name, count, price);
        this.name = name;
        this.count = count;
        this.price = price;
        for (Observer observer : observers) observer.notifyUpdate(this);
    }
}
