package dao;

import entity.Shop;

import java.util.List;

public interface ShopDAO {

    //create
    void add(Shop shop);

    //read
    List<Shop> getAll();

    Shop getById(Long id);
    
}
