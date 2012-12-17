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
import org.certiCamara.inventario.entity.BodegaEntity;
import org.certiCamara.inventario.model.BodegaPojo;
import org.certiCamara.inventario.service.BodegaEJB;
import org.certiCamara.inventario.service.BodegaEJBLocal;

/**
 *
 * @author fenryr
 */
@ManagedBean
//@SessionScoped
public class BodegaManagedBean implements Serializable {

    @EJB
    private BodegaEJBLocal bodegaEJBLocal;
    private String crearLabelBoton;
    private String updateLabelBoton;
    private String deleteLabelBoton;
    private String readLabelBoton;
    private List bodegas;
    private BodegaEntity bodegaEntity;
    private BodegaPojo bodegaPojo;

    /**
     * Creates a new instance of BodegaManagedBean
     */
    public BodegaManagedBean() {
        try {
            crearLabelBoton = "Create";
            updateLabelBoton = "Update";
            deleteLabelBoton = "Delete";
            readLabelBoton = "Read";
            bodegas = new ArrayList<BodegaEntity>();
            System.out.println("BodegaBean() ");
            loadLista();
            bodegaPojo = new BodegaPojo();
        } catch (Exception e) {
            Logger.getLogger(BodegaManagedBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String getReadLabelBoton() {
        return readLabelBoton;
    }

    public void setReadLabelBoton(String readLabelBoton) {
        this.readLabelBoton = readLabelBoton;
    }

    public String getCrearLabelBoton() {
        return crearLabelBoton;
    }

    public void setCrearLabelBoton(String crearLabelBoton) {
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

    public String getCreateLabelBoton() {
        return crearLabelBoton;
    }

    public void setSaludo(String saludo) {
        this.crearLabelBoton = saludo;
    }

    public List getBodegas() {
        return bodegas;
    }

    public void setBodegas(List bodegas) {
        this.bodegas = bodegas;
    }

    public BodegaEntity getBodegaEntity() {
        return bodegaEntity;
    }

    public void setBodegaEntity(BodegaEntity bodegaEntity) {
        this.bodegaEntity = bodegaEntity;
    }

    public BodegaPojo getCreateBodegaPojo() {
        return bodegaPojo;
    }

    public void setCreateBodegaPojo(BodegaPojo createBodegaPojo) {
        this.bodegaPojo = createBodegaPojo;
    }

    public boolean validator(BodegaPojo bodegaPojo) {
        System.out.println("BodegaManagedBean Validador");
        if (bodegaPojo.getCode() <= 0) {
            bodegaPojo.setCode(0);
            return false;
        } else if (bodegaPojo.getAddress().trim() == null
                || "".equals(bodegaPojo.getAddress().trim())) {
            bodegaPojo.setAddress("");
            return false;
        } else {
            return true;
        }
    }

    public void loadLista() {
        try {
            bodegaEJBLocal = new BodegaEJB();
            bodegas = bodegaEJBLocal.loadLista();
        } catch (Exception ex) {
            Logger.getLogger(BodegaManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public String create() {
        try {
            if (validator(bodegaPojo)) {
                System.out.println("BodegaManagedBean Create");
                bodegaEJBLocal = new BodegaEJB();
                bodegaEJBLocal.save(bodegaPojo);
                loadLista();
                return null;
            } else {
                return null;
            }

        } catch (Exception ex) {
            Logger.getLogger(BodegaManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public String read() {
        try {

            System.out.println("BodegaManagedBean Read");
            bodegaEJBLocal = new BodegaEJB();
            bodegaEJBLocal.read(bodegaPojo);
            return null;

        } catch (Exception e) {
            Logger.getLogger(BodegaManagedBean.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public String update() {
        try {
            if (validator(bodegaPojo)) {
                System.out.println("BodegaManagedBean Update");
                bodegaEJBLocal = new BodegaEJB();
                bodegaEJBLocal.update(bodegaPojo);
                loadLista();
                return null;
            } else {
                return null;
            }
        } catch (Exception e) {
            Logger.getLogger(BodegaManagedBean.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public String delete() {
        try {

            System.out.println("BodegaManagedBean Delete");
            bodegaEJBLocal = new BodegaEJB();
            bodegaEJBLocal.delete(bodegaPojo);
            loadLista();
            return null;

        } catch (Exception e) {
            Logger.getLogger(BodegaManagedBean.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
