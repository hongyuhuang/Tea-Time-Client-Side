/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import dao.ProductCollectionsDAO;
import io.jooby.Jooby;

/**
 *
 * @author hongyuhuang
 */
public class ProductModule extends Jooby{

    public ProductModule(ProductCollectionsDAO dao) {
        get("/api/products/", ctx -> {
            return null;
        });
        
        get("api/products/{id}", ctx -> {
            return null;
        });
        
        get("/api/categories/", ctx -> {
            return null;
        });
        
        get("/api/categories/{category}", ctx -> {
            return null;
        }); 
    }    
}
