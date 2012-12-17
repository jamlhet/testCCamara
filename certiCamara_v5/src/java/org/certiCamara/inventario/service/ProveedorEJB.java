/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiCamara.inventario.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import org.certiCamara.inventario.dao.InventarioDao;
import org.certiCamara.inventario.dao.InventarioDaoImpl;
import org.certiCamara.inventario.entity.ProveedorEntity;
import org.certiCamara.inventario.model.ProveedorPojo;

/**
 *
 * @author fenryr
 */
@Stateless
public class ProveedorEJB implements ProveedorEJBLocal {

    private InventarioDao proveedorDao;
    private ProveedorEntity proveedorEntity;

    public ProveedorEJB() {
    }

    @Override
    public List<ProveedorEntity> loadLista() {
        try {
            System.out.println("proveedorEJB readAll");
            List bodegas = new ArrayList<ProveedorEntity>();
            proveedorDao = new InventarioDaoImpl(ProveedorEntity.class);
            bodegas = proveedorDao.readAll();
            return bodegas;
        } catch (Exception e) {
            Logger.getLogger(
                    ProveedorEJB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean save(ProveedorPojo proveedorPojo) {
        try {
            List<ProveedorEntity> list = new ArrayList<ProveedorEntity>();
            System.out.println("proveedorEJB Create");
            proveedorEntity = new ProveedorEntity(
                    proveedorPojo.getName(),
                    proveedorPojo.getAddress(),
                    proveedorPojo.getPhone(),
                    proveedorPojo.getMail());
            proveedorDao = new InventarioDaoImpl(ProveedorEntity.class);
            list = proveedorDao.readByString("name", proveedorPojo.getName());
            if (list.size() > 0) {
                return false;
            } else {
                proveedorDao.create(proveedorEntity);
                return true;
            }

        } catch (Exception e) {
            Logger.getLogger(
                    ProveedorEJB.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public boolean update(ProveedorPojo proveedorPojo) {
        try {
            System.out.println("proveedorEJB Update");
            List<ProveedorEntity> list = new ArrayList<ProveedorEntity>();
            proveedorEntity = new ProveedorEntity(
                    proveedorPojo.getName(),
                    proveedorPojo.getAddress(),
                    proveedorPojo.getPhone(),
                    proveedorPojo.getMail());
            proveedorDao = new InventarioDaoImpl(ProveedorEntity.class);
            list = proveedorDao.readByString("name", proveedorPojo.getName());
            if (list.isEmpty()) {
                return false;
            } else {
                proveedorDao.update(proveedorEntity);
                return true;
            }

        } catch (Exception e) {
            Logger.getLogger(
                    ProveedorEJB.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public boolean delete(ProveedorPojo proveedorPojo) {
        try {
            System.out.println("proveedorEJB Delete");
            proveedorEntity = new ProveedorEntity(
                    proveedorPojo.getName(),
                    proveedorPojo.getAddress(),
                    proveedorPojo.getPhone(),
                    proveedorPojo.getMail());
            proveedorDao = new InventarioDaoImpl(ProveedorEntity.class);
            proveedorDao.deleteByString("name", proveedorEntity.getName());
            return true;
        } catch (Exception e) {
            Logger.getLogger(
                    ProveedorEJB.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public List<ProveedorPojo> read(ProveedorPojo bodegaPojo) {
        try {
            System.out.println("proveedorEJB read");
            List proveedores = new ArrayList<ProveedorEntity>();
            proveedorDao = new InventarioDaoImpl(ProveedorEntity.class);
            proveedores = proveedorDao.readByString("code", bodegaPojo.getName());
            return proveedores;
        } catch (Exception e) {
            Logger.getLogger(
                    ProveedorEJB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
