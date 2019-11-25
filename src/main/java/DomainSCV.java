import entity.Product;
import entity.Shop;
import service.service_csv.OperationsService;
import service.service_csv.ProductService;
import service.service_csv.ShopService;


import java.sql.SQLException;

public class DomainSCV {

    public static void main(String[] args) {
        ShopService shopService = new ShopService();
        ProductService productService = new ProductService();
        OperationsService operationsService = new OperationsService();
        Shop shop = new Shop();
        shop.setId(3L);
        shop.setTitle("Пятерочка");

        Product product = new Product();
        product.setId(1L);
        product.setTitle("кефир");
        product.setPrice(70L);
        /*try {
            //shopService.add(shop);
            productService.add(product);
        }catch (SQLException e){
            e.printStackTrace();
        }*/
        //operationsService.addConsignment(shop, product, 300L);
        System.out.println(operationsService.findCheapestShop("Шоколад ‘Аленка’").toString());
    }
}
