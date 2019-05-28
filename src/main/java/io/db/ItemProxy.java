package io.db;

import io.domain.Item;

class ItemProxy extends Item {
    private final int id;
    private final DbEngine engine;

    public ItemProxy(DbEngine engine, int id, String name, int count, int price) {
        super(name, count, price);
        this.engine = engine;
        this.id = id;
    }

    @Override
    public void update(String name, int count, int price) {
        engine.updateItem(id, name, count, price);
        super.update(name,count,price);
    }
}
