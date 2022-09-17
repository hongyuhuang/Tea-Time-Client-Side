/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import domain.Customer;
import domain.Sale;
import io.jooby.Jooby;
import io.jooby.StatusCode;

/**
 *
 * @author hongyuhuang
 */
public class SaleModule extends Jooby {

    public SaleModule() {
          get("/api/sales", ctx -> {
            return ctx.send(StatusCode.CREATED);
        });
    }
}
