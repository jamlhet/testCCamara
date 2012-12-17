/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiCamara.inventario.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.certiCamara.inventario.entity.ProveedorEntity;
import org.certiCamara.inventario.model.ProveedorPojo;
import org.certiCamara.inventario.service.ProveedorEJB;
import org.certiCamara.inventario.service.ProveedorEJBLocal;

/**
 *
 * @author fenryr
 */
@ManagedBean
//@RequestScoped
public class ProveedorManagedBean implements Serializable {

    @EJB
    private ProveedorEJBLocal proveedorEJBLocal;
    private String crearLabelBoton;
    private String updateLabelBoton;
    private String deleteLabelBoton;
    private String readLabelBoton;
    private List proveedores;
    private ProveedorEntity proveedorEntity;
    private ProveedorPojo proveedorPojo;

    /**
     * Creates a new instance of ProveedorManagedBean
     */
    public ProveedorManagedBean() {
        try {
            crearLabelBoton = "Create";
            updateLabelBoton = "Update";
            deleteLabelBoton = "Delete";
            readLabelBoton = "Read";
            proveedores = new ArrayList<ProveedorEntity>();
            System.out.println("BodegaBean() ");
            loadLista();
            proveedorPojo = new ProveedorPojo();
        } catch (Exception e) {
            Logger.getLogger(ProveedorManagedBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ProveedorEJBLocal getProveedorEJBLocal() {
        return proveedorEJBLocal;
    }

    public void setProveedorEJBLocal(ProveedorEJBLocal proveedorEJBLocal) {
        this.proveedorEJBLocal = proveedorEJBLocal;
    }

    public String getCreateLabelBoton() {
        return crearLabelBoton;
    }

    public void setCreateLabelBoton(String crearLabelBoton) {
        this.crearLabelBoton = crearLabelBoton;
    }

    public String getUpdateLabelBoton() {
        return updateLabelBoton;
    }

    public void setUpdateLabelBoton(String updateLabelBoton) {
        this.updateLabelBoton = updateLabelBoton;
    }

    public String getDeleteLabelBoton() {
        return deleteLabelBoton;
    }

    public void setDeleteLabelBoton(String deleteLabelBoton) {
        this.deleteLabelBoton = deleteLabelBoton;
    }

    public String getReadLabelBoton() {
        return readLabelBoton;
    }

    public void setReadLabelBoton(String readLabelBoton) {
        this.readLabelBoton = readLabelBoton;
    }

    public List getProveedores() {
        return proveedores;
    }

    public void setProveedores(List proveedores) {
        this.proveedores = proveedores;
    }

    public ProveedorEntity getProveedorEntity() {
        return proveedorEntity;
    }

    public void setProveedorEntity(ProveedorEntity proveedorEntity) {
        this.proveedorEntity = proveedorEntity;
    }

    public ProveedorPojo getCreateProveedorPojo() {
        return proveedorPojo;
    }

    public void setCreateProveedorPojo(ProveedorPojo proveedorPojo) {
        this.proveedorPojo = proveedorPojo;
    }

    public boolean validator(ProveedorPojo proveedorPojo) {
        System.out.println("Bean Validador");
        if (proveedorPojo.getName().trim() == null
                || "".equals(proveedorPojo.getName().trim())
                || proveedorPojo.getAddress().trim() == null
                || "".equals(proveedorPojo.getAddress().trim())
                || proveedorPojo.getPhone().trim() == null
                || "".equals(proveedorPojo.getPhone().trim())
                || proveedorPojo.getMail().trim() == null
                || "".equals(proveedorPojo.getMail().trim())) {
            proveedorPojo.setName("");
            proveedorPojo.setAddress("");
            proveedorPojo.setPhone("");
            proveedorPojo.setMail("");
            return false;
        } else {
            return true;
        }
    }

    public void loadLista() {
        try {
            proveedorEJBLocal = new ProveedorEJB();
            proveedores = proveedorEJBLocal.loadLista();
        } catch (Exception ex) {
            Logger.getLogger(ProveedorManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String create() {
        try {
            if (validator(proveedorPojo)) {
                System.out.println("ProveedorManagedBean Create");
                proveedorEJBLocal = new ProveedorEJB();
                proveedorEJBLocal.save(proveedorPojo);
                loadLista();
                return null;
            } else {
                return null;
            }

        } catch (Exception ex) {
            Logger.getLogger(ProveedorManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public String read() {
        try {

            System.out.println("ProveedorManagedBean Read");
            proveedorEJBLocal = new ProveedorEJB();
            proveedorEJBLocal.read(proveedorPojo);
            return null;

        } catch (Exception e) {
            Logger.getLogger(ProveedorManagedBean.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public String update() {
        try {
            if (validator(proveedorPojo)) {
                System.out.println("ProveedorManagedBean Update");
                proveedorEJBLocal = new ProveedorEJB();
                proveedorEJBLocal.update(proveedorPojo);
                loadLista();
                return null;
            } else {
                return null;
            }
        } catch (Exception e) {
            Logger.getLogger(ProveedorManagedBean.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public String delete() {
        try {

            System.out.println("ProveedorManagedBean Delete");
            proveedorEJBLocal = new ProveedorEJB();
            proveedorEJBLocal.delete(proveedorPojo);
            loadLista();
            return null;

        } catch (Exception e) {
            Logger.getLogger(ProveedorManagedBean.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
