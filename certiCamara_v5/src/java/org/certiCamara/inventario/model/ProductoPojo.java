/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiCamara.inventario.model;

import org.certiCamara.inventario.entity.*;

/**
 *
 * @author juan
 */
public class ProductoPojo {

    private String name;
    private double price;
    private int amount;
    private ProveedorEntity proveedor;
    private BodegaEntity bodega;

    public ProductoPojo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }

    public BodegaEntity getBodega() {
        return bodega;
    }

    public void setBodega(BodegaEntity bodega) {
        this.bodega = bodega;
    }
}
