package web;

import dao.CustomerDAO;
import dao.CustomerJdbiDAO;
import dao.JdbiDaoFactory;
import dao.ProductDAO;
import dao.ProductJdbiDAO;
import dao.SaleDAO;
import dao.SaleJdbiDAO;
import io.jooby.Jooby;
import io.jooby.ServerOptions;
import io.jooby.json.GsonModule;

public class Server extends Jooby {

    ProductDAO productDAO = JdbiDaoFactory.getProductDAO();
    CustomerDAO customerDAO = JdbiDaoFactory.getCustomerDAO();
    SaleDAO saleDAO = JdbiDaoFactory.getSaleDAO();

    public Server() {
        setServerOptions(new ServerOptions().setPort(8085));

        install(new GsonModule());

        mount(new StaticAssetModule());
        mount(new ProductModule((ProductJdbiDAO) productDAO));
        mount(new CustomerModule((CustomerJdbiDAO) customerDAO));
        mount(new SaleModule((SaleJdbiDAO) saleDAO));
    }

    public static void main(String[] args) {
        System.out.println("\nStarting Server.");
        new Server().start();
    }

}
