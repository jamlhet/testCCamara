/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiCamara.inventario.model;

/**
 *
 * @author juan
 */
public class BodegaPojo {

    private int code;
    private String address;

    public BodegaPojo() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int codigo) {
        System.out.println("set Code");
        this.code = codigo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String direccion) {
        this.address = direccion;
    }
}
