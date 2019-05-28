package io.db;

import io.domain.Item;
import io.domain.Store;
import io.sqldb.SqlDbFactory;

class StoreProxy extends Store{
    DbEngine engine = new SqlDbFactory().engine();

    @Override
    protected Item createItem(String name, int count, int price) {
        int id = engine.insertItem(name, count, price);
        ItemProxy.ids.put(new ItemProxy(name,count, price), id);
        return super.createItem(name, count, price);
    }
}
