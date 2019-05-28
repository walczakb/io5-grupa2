package io.db;
import io.domain.Item;
import io.domain.Store;

class StoreProxy extends Store{

    private final DbEngine engine;

    StoreProxy(DbEngine engine) {
        super();
        this.engine = engine;
    }

    @Override
    public Item createItem(String name, int count, int price) {
        int id = engine.insertItem(name, count, price);
        return new ItemProxy(name, count, price, id, engine);
    }

    void addItem(int id, String name, int count, int price) {
        Item item = new ItemProxy(name, count, price, id, engine);
        super.addItem(item);
    }

}
