import bl.Util;
import entity.Shop;
import service.ShopService;

import java.sql.SQLException;

public class Domain {

    public static void main(String[] args) {
        //Util util = new Util();
        //util.getConnection();

        ShopService shopService = new ShopService();

        Shop shop = new Shop();
        shop.setId(2L);
        shop.setTitle("Магнит");

        try {
            shopService.add(shop);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
