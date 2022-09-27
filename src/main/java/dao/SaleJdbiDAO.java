package dao;

import domain.Product;
import domain.Sale;
import domain.SaleItem;
import java.time.LocalDateTime;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.transaction.Transaction;

public interface SaleJdbiDAO extends SaleDAO {

    @SqlUpdate("INSERT INTO SALE(customerID, date, status) values(:customer.customerId, :date, :status)")
    @GetGeneratedKeys
    Integer insertSale(@BindBean Sale sale);

    @SqlUpdate("INSERT INTO SALE_ITEM(quantityPurchased, salePrice, saleId, productId) values(:quantityPurchased, :salePrice, :saleId, :product.productId)")
    void insertSaleItem(@BindBean SaleItem item, @Bind("saleId") Integer saleId);

    @SqlUpdate("UPDATE PRODUCT SET quantityInStock = quantityInStock - :quantityPurchased WHERE productId = :product.productId AND quantityInStock > 0;")
    void updateStockLevel(@BindBean SaleItem item);

    @Override
    @Transaction
    default void save(Sale sale) {
        // save current date
        sale.setDate(LocalDateTime.now());

        // set sale status
        sale.setStatus("NEW ORDER");

        // call the insertSale method, and get the generated sale ID.
        Integer saleId = insertSale(sale);
        sale.setSaleId(saleId);
        
       ProductDAO dao = DaoFactory.getProductDAO();

        // loop through the sale's items.
        for (SaleItem item : sale.getItems()) {
            Product p = dao.searchById(item.getProduct().getProductId());
            item.setSalePrice(p.getListPrice());
            insertSaleItem(item, saleId);
            updateStockLevel(item);
        }

    }
}