/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiCamara.inventario.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;

/**
 *
 * @author juan
 */
@Entity(value = "producto", noClassnameStored = true)
public class ProductoEntity {

    @Id
    private String name;
    private double price;
    private int amount;
    @Reference
    private ProveedorEntity proveedor;
    @Reference
    private BodegaEntity bodega;

    public ProductoEntity(String name, double price, int amount, ProveedorEntity proveedor, BodegaEntity bodega) {

        this.name = name;
        this.price = price;
        this.amount = amount;
        this.proveedor = proveedor;
        this.bodega = bodega;
    }

    private ProductoEntity() {
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
