import entity.Product;
import entity.Shop;
import service.service_db.OperationsService;
import service.service_db.ShopService;

public class DomainDB {

    public static void main(String[] args) {
        //Util util = new Util();
        //util.getConnection();

        ShopService shopService = new ShopService();
        OperationsService operationsService = new OperationsService();

        Shop shop = new Shop();
        shop.setId(2L);
        shop.setTitle("Пятерочка");

        Product product = new Product();
        product.setId(2L);
        product.setTitle("Веселый молочник");
        product.setPrice(90L);

        /*try {
            //shopService.add(shop);
        }catch (SQLException e){
            e.printStackTrace();
        }*/

        //operationsService.addConsignment(shop, product, 300L);
        //System.out.println(operationsService.findCheapestShop("Prostokvashino").toString());
        //operationsService.whatCanBy(shop, 100L);
        System.out.println(operationsService.buyConsignment("Пятерочк", "Простоквашинo", 15L));
    }
}
