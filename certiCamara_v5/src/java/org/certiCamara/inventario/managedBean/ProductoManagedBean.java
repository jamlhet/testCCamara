/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiCamara.inventario.managedBean;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.certiCamara.inventario.entity.ProductoEntity;
import org.certiCamara.inventario.model.ProductoPojo;
import org.certiCamara.inventario.service.ProductoEJB;
import org.certiCamara.inventario.service.ProductoEJBLocal;

/**
 *
 * @author fenryr
 */
@ManagedBean
//@RequestScoped
public class ProductoManagedBean {

    @EJB
    private ProductoEJBLocal productoEJBLocal;
    private String crearLabelBoton;
    private String updateLabelBoton;
    private String deleteLabelBoton;
    private String readLabelBoton;
    private List productos;
    private ProductoPojo productoPojo;

    /**
     * Creates a new instance of BodegaManagedBean
     */
    public ProductoManagedBean() {
        try {
            crearLabelBoton = "Create";
            updateLabelBoton = "Update";
            deleteLabelBoton = "Delete";
            readLabelBoton = "Read";
            productos = new ArrayList<ProductoEntity>();
            System.out.println("ProductoManagedBean() ");
            loadLista();
            productoPojo = new ProductoPojo();
        } catch (Exception e) {
            Logger.getLogger(ProductoManagedBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public boolean validator(ProductoPojo productoPojo) {
        System.out.println("ProductoManagedBean Validador");
        if (productoPojo.getName().isEmpty()) {
            productoPojo.setName("");
            return false;
        } else {
            return true;
        }
    }

    public void loadLista() {
        try {
            productoEJBLocal = new ProductoEJB();
            productos = productoEJBLocal.loadLista();
        } catch (Exception ex) {
            Logger.getLogger(ProductoManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public String create() {
        try {
            if (validator(productoPojo)) {
                System.out.println("ProductoManagedBean Create");
                productoEJBLocal = new ProductoEJB();
                productoEJBLocal.save(productoPojo);
                loadLista();
                return null;
            } else {
                return null;
            }

        } catch (Exception ex) {
            Logger.getLogger(ProductoManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public String read() {
        try {

            System.out.println("ProductoManagedBean Read");
            productoEJBLocal = new ProductoEJB();
            productoEJBLocal.read(productoPojo);
            return null;

        } catch (Exception e) {
            Logger.getLogger(ProductoManagedBean.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public String update() {
        try {
            if (validator(productoPojo)) {
                System.out.println("ProductoManagedBean Update");
                productoEJBLocal = new ProductoEJB();
                productoEJBLocal.update(productoPojo);
                loadLista();
                return null;
            } else {
                return null;
            }
        } catch (Exception e) {
            Logger.getLogger(ProductoManagedBean.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public String delete() {
        try {

            System.out.println("ProductoManagedBean Delete");
            productoEJBLocal = new ProductoEJB();
            productoEJBLocal.delete(productoPojo);
            loadLista();
            return null;

        } catch (Exception e) {
            Logger.getLogger(ProductoManagedBean.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
