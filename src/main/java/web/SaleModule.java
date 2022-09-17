/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import io.jooby.Jooby;

/**
 *
 * @author hongyuhuang
 */
public class SaleModule extends Jooby {

    public SaleModule(Sale sale) {
          get("/api/sales", ctx -> {
            return null;
        });
    }
}
