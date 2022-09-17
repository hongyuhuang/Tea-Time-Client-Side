/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import dao.ProductCollectionsDAO;
import domain.Product;
import io.jooby.Jooby;
import io.jooby.StatusCode;
import java.util.Collection;

/**
 *
 * @author hongyuhuang
 */
public class ProductModule extends Jooby {

    public ProductModule(ProductCollectionsDAO dao) {
        get("/api/products/", ctx -> dao.getProducts());

        get("api/products/{id}", ctx -> {
            String id = ctx.path("id").value();
            Product product = dao.searchById(id);
            
            if (product == null) {
                // no product with that ID found, so return a 404/Not Found error
                return ctx.send(StatusCode.NOT_FOUND);
            } else {
                return product;
            }
        });

        get("/api/categories/", ctx -> dao.getCategories());

        get("/api/categories/{category}", ctx -> {
            String category = ctx.path("category").value();
            Collection<Product> products = dao.filterByCategory(category);
            
            if (products == null) {
                // no products with that category found, so return a 404/Not Found error
                return ctx.send(StatusCode.NOT_FOUND);
            } else {
                return products;
            }
        });
    }
}
