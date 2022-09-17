/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import dao.CustomerCollectionsDAO;
import io.jooby.Jooby;
import io.jooby.StatusCode;

/**
 *
 * @author hongyuhuang
 */
public class CustomerModule extends Jooby {

    public CustomerModule(CustomerCollectionsDAO dao) {
        post("/api/customers/{username}", ctx -> {
            return ctx.send(StatusCode.CREATED);
        });
        
        get("/api/register/", ctx -> {
            return null;
        });
    }
}
