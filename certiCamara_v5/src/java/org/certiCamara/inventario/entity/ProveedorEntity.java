/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiCamara.inventario.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

/**
 *
 * @author juan
 */
@Entity(value = "proveedor", noClassnameStored = true)
public class ProveedorEntity {

    @Id
    private String name;
    private String address;
    private String phone;
    private String mail;

    public ProveedorEntity(String name, String address, String phone, String mail) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
    }

    private ProveedorEntity() {
    }

    public String getName() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
