package dao;

import entity.Product;

import java.util.List;

public interface ProductDAO {

    //create
    void add(Product product);

    //read
    List<Product> getAll();

    Product getById(Long id);

    //update
    void update(Product product);

    //delete
    void remove(Product product);
}
