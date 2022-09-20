package web;

import dao.CustomerCollectionsDAO;
import dao.CustomerDAO;
import dao.ProductCollectionsDAO;
import dao.ProductDAO;
import domain.Customer;
import domain.Product;
import io.jooby.Jooby;
import io.jooby.ServerOptions;
import io.jooby.json.GsonModule;
import java.math.BigDecimal;

public class Server extends Jooby {

    ProductDAO productDAO = new ProductCollectionsDAO();
    CustomerDAO customerDAO = new CustomerCollectionsDAO();

    public Server() {
        setServerOptions(new ServerOptions().setPort(8085));

        install(new GsonModule());

        mount(new StaticAssetModule());
        mount(new ProductModule((ProductCollectionsDAO) productDAO));
        mount(new CustomerModule((CustomerCollectionsDAO) customerDAO));
        mount(new SaleModule());
    }

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductCollectionsDAO();
        productDAO.saveProduct(new Product("1111", "French Earl Grey Teabag", "Black tea with sweet fruits, rose, sunflower and hibiscus, with a touch of bergamot to finish.", "Black Tea", new BigDecimal("19.00"), new BigDecimal("10")));
        productDAO.saveProduct(new Product("2222", "Melbourne Breakfast Loose Leaf", "Indulge and sip a smooth blend of bold, malty black tea and rich velvety vanilla.", "Black Tea", new BigDecimal("19.00"), new BigDecimal("10")));
        productDAO.saveProduct(new Product("3333", "White Jasmine Loose Leaf", "Elegant silver needles tea delivers earthiness and light sugarcane woven with fragrant jasmine.", "Green Tea", new BigDecimal("22.00"), new BigDecimal("10")));
        productDAO.saveProduct(new Product("4444", "100% Certified Organic Matcha", "Certified organic matcha brimming with fresh, sweet, grassy notes.", "Matcha", new BigDecimal("54.00"), new BigDecimal("10")));
        productDAO.saveProduct(new Product("5545", "Hammered Glass Teapot", "Handblown and hand pressed, it only takes one look to hammer the beauty of these teawares home.", "Teapot", new BigDecimal("65.00"), new BigDecimal("10")));
        
        CustomerDAO customerDAO = new CustomerCollectionsDAO();
        Customer aCustomer = new Customer("11", "11", "11", "11@11", "11", "11");
        customerDAO.save(aCustomer);

        System.out.println("\nStarting Server.");
        new Server().start();
    }

}
