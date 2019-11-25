package service.service_csv;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import dao.OperationsDAO;
import entity.Product;
import entity.Shop;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class OperationsService implements OperationsDAO {
    private String productsCsv = "products.csv";
    public void addConsignment(Shop shop, Product product, Long count) {
        try {
            CSVReader reader = new CSVReader(new FileReader(productsCsv), ',', '\0', 0);
            List<String[]> allProducts = reader.readAll();
            for(int i = 0; i < allProducts.size(); i++) {
                String[] row = allProducts.get(i);
                if(row[0].equals(product.getTitle())){
                    String new_string = new String();
                    for(String s : row){
                        new_string = new_string + s + ",";
                    }
                    String[] new_product = (new_string + shop.getId() + "," + product.getPrice() + "," + count)
                            .split(",");
                    allProducts.set(i, new_product);
                    break;
                }
                //System.out.println(Arrays.toString(row));
            }

            CSVWriter writer = new CSVWriter(new FileWriter(productsCsv, false), ',', '\0');

            for(String[] row : allProducts) {
                writer.writeNext(row);
            }

            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public Shop findCheapestShop(String titleProduct) {
        Shop shop = new Shop();
        try {
            CSVReader reader = new CSVReader(new FileReader(productsCsv), ',', '\0', 0);
            List<String[]> allProducts = reader.readAll();
                for (int i = 0; i < allProducts.size(); i++) {
                    String[] row = allProducts.get(i);
                    if((row.length - 1) % 3 == 0) {
                        if (row[0].equals(titleProduct)) {
                            int min = 1213123123;
                            Long minShop = 0L;
                            for (int j = 0; j < row.length; j++) {
                                String s = row[j];
                                if (j % 3 == 2 && min > Integer.parseInt(s)) {
                                    min = Integer.parseInt(s);
                                    minShop = Long.parseLong(row[j - 1]);
                                    ShopService shopService = new ShopService();
                                    shop = shopService.getById(minShop);
                                }
                            }
                            break;
                        }
                    }else{
                        System.out.println("wrong format");
                    }
                }
        }catch (IOException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return shop;
    }

    public void whatCanBy(Shop shop, Long money) {

    }

    public Long buyConsignment(String shopTitle, String productTitle, Long count) {
        return null;
    }

    public Shop findCheapestShop(String product, Long count) {
        return null;
    }
}
