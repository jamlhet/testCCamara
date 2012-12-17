/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiCamara.inventario.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity(value = "bodega", noClassnameStored = true)
public class BodegaEntity {

    @Id
    private int code;
    private String address;

    public BodegaEntity(int code, String address) {
        this.code = code;
        this.address = address;
    }

    private BodegaEntity() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}