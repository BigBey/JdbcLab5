package dao;

import entity.ProductInShop;

import java.util.List;

public interface ProductInShopDAO {

    //create
    void add(ProductInShop productInShop);

    //read
    List<ProductInShop> getAll();

    ProductInShop getByShopIdAndProductId(Long shopId, Long productId);

    //update
    void update(ProductInShop productInShop);

    //delete
    void remove(ProductInShop productInShop);
}
