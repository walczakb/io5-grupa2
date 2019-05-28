package io.db;

import io.domain.Item;

class ItemProxy extends Item {
    private final DbEngine engine;
    private int id;

    public ItemProxy(String name, int count, int price, int id, DbEngine engine) {
        super(name, count, price);
        this.id = id;
        this.engine = engine;
    }

    public void update(String name, int count, int price) {
        engine.updateItem(id, name, count, price);
        super.update(name, count, price);
    }
}
