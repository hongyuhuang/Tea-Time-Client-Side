package web;

import dao.CustomerCollectionsDAO;
import dao.CustomerDAO;
import dao.ProductCollectionsDAO;
import dao.ProductDAO;
import domain.Sale;
import io.jooby.Jooby;
import io.jooby.ServerOptions;
import io.jooby.json.GsonModule;

public class Server extends Jooby {

    ProductDAO productDAO = new ProductCollectionsDAO();
    CustomerDAO customerDAO = new CustomerCollectionsDAO();
    Sale sale = new Sale();

    public Server() {
        setServerOptions(new ServerOptions().setPort(8085));

        install(new GsonModule());

        mount(new StaticAssetModule());
        mount(new ProductModule((ProductCollectionsDAO) productDAO));
        mount(new CustomerModule((CustomerCollectionsDAO) customerDAO));
        mount(new SaleModule(sale));
    }

    public static void main(String[] args) {
        System.out.println("\nStarting Server.");
        new Server().start();
    }

}
