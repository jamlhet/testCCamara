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
import org.certiCamara.inventario.entity.BodegaEntity;
import org.certiCamara.inventario.model.BodegaPojo;

/**
 *
 * @author fenryr
 */
@Stateless//(name = "newSessionBean", mappedName = "newSessionBean")
public class BodegaEJB implements BodegaEJBLocal {

    private InventarioDao bodegaDao;
    private BodegaEntity bodegaEntity;

    /**
     *
     */
    public BodegaEJB() {
    }

    /**
     *
     * @return
     */
    @Override
    public List loadLista() {
        try {
            System.out.println("bodegaEJB readAll");
            List bodegas = new ArrayList<BodegaEntity>();
            bodegaDao = new InventarioDaoImpl(BodegaEntity.class);
            bodegas = bodegaDao.readAll();
            return bodegas;
        } catch (Exception ex) {
            Logger.getLogger(BodegaEJB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /**
     *
     * @param bodegaPojo
     * @return
     */
    public boolean save(BodegaPojo bodegaPojo) {
        try {
            List<BodegaEntity> list = new ArrayList<BodegaEntity>();
            System.out.println("bodegaEJB Create");
            bodegaEntity = new BodegaEntity(bodegaPojo.getCode(), bodegaPojo.getAddress());
            bodegaDao = new InventarioDaoImpl(BodegaEntity.class);
            list = bodegaDao.readByNumber("code", bodegaPojo.getCode());
            if (list.size() > 0) {
                return false;
            } else {
                bodegaDao.create(bodegaEntity);
                return true;
            }

        } catch (Exception ex) {
            Logger.getLogger(BodegaEJB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<BodegaPojo> read(BodegaPojo bodegaPojo) {
        try {
            System.out.println("bodegaEJB read");
            List bodegas = new ArrayList<BodegaEntity>();
            bodegaDao = new InventarioDaoImpl(BodegaEntity.class);
            bodegas = bodegaDao.readByNumber("code", bodegaPojo.getCode());
            return bodegas;
        } catch (Exception ex) {
            Logger.getLogger(BodegaEJB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     *
     * @param bodegaPojo
     * @return
     */
    public boolean update(BodegaPojo bodegaPojo) {
        try {
            System.out.println("bodegaEJB Update");
            List<BodegaEntity> list = new ArrayList<BodegaEntity>();
            bodegaEntity = new BodegaEntity(bodegaPojo.getCode(), bodegaPojo.getAddress());
            bodegaDao = new InventarioDaoImpl(BodegaEntity.class);
            list = bodegaDao.readByNumber("code", bodegaPojo.getCode());
            if (list.isEmpty()) {
                return false;
            } else {
                bodegaDao.update(bodegaEntity);
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(BodegaEJB.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

    }

    /**
     *
     * @param bodegaPojo
     * @return
     */
    @Override
    public boolean delete(BodegaPojo bodegaPojo) {
        try {
            System.out.println("bodegaEJB Delete");
            bodegaEntity = new BodegaEntity(bodegaPojo.getCode(), bodegaPojo.getAddress());
            bodegaDao = new InventarioDaoImpl(BodegaEntity.class);
            bodegaDao.deleteByNumber("code", bodegaEntity.getCode());
            return true;
        } catch (Exception e) {
            Logger.getLogger(BodegaEJB.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}
