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
import io.jooby.StatusCode;
import io.jooby.json.GsonModule;
import java.nio.file.Paths;
import java.util.Set;

public class Server extends Jooby {

    ProductDAO productDAO = JdbiDaoFactory.getProductDAO();
    CustomerDAO customerDAO = JdbiDaoFactory.getCustomerDAO();
    SaleDAO saleDAO = JdbiDaoFactory.getSaleDAO();

    public Server() {
        mount(new StaticAssetModule());
        install(new GsonModule());
        install(new BasicAccessAuth(customerDAO, Set.of("/api/.*"), 
        Set.of("/api/register")));

        mount(new ProductModule((ProductJdbiDAO) productDAO));
        mount(new CustomerModule((CustomerJdbiDAO) customerDAO));
        mount(new SaleModule((SaleJdbiDAO) saleDAO));

        error(StatusCode.SERVER_ERROR, (ctx, cause, code) -> {
            ctx.getRouter().getLog().error(cause.getMessage(), cause);
            ctx.send(Paths.get("static/500.html"));
        });
        

    }

    public static void main(String[] args) {
        System.out.println("\nStarting Server.");
        new Server().start();
    }

}
