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
import org.certiCamara.inventario.entity.ProductoEntity;
import org.certiCamara.inventario.entity.ProveedorEntity;
import org.certiCamara.inventario.model.BodegaPojo;
import org.certiCamara.inventario.model.ProductoPojo;
import org.certiCamara.inventario.model.ProveedorPojo;

/**
 *
 * @author fenryr
 */
@Stateless
public class ProductoEJB implements ProductoEJBLocal {

    private InventarioDao productoDao;
    private InventarioDao bodegaDao;
    private InventarioDao proveedorDao;
    private BodegaEntity bodegaEntity;
    private ProveedorEntity proveedorEntity;
    private ProductoEntity productoEntity;

    public ProductoEJB() {
    }

    /**
     *
     * @return
     */
    @Override
    public List<ProductoEntity> loadLista() {
        try {
            System.out.println("ProductoEJB readAll");
            List productos = new ArrayList<ProductoEntity>();
            productoDao = new InventarioDaoImpl(ProductoEntity.class);
            productos = productoDao.readAll();
            return productos;
        } catch (Exception ex) {
            Logger.getLogger(ProductoEJB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     *
     * @param productoPojo
     * @param proveedorPojo
     * @param bodegaPojo
     * @return
     */
    @Override
    public boolean save(ProductoPojo productoPojo) {
        try {
            List<ProductoEntity> listProductos = new ArrayList<ProductoEntity>();
            List<BodegaEntity> listBodegas = new ArrayList<BodegaEntity>();
            List<ProveedorEntity> listProveedores = new ArrayList<ProveedorEntity>();
            System.out.println("ProductoEJB Create");
            bodegaEntity = new BodegaEntity(
                    productoPojo.getBodega().getCode(),
                    productoPojo.getBodega().getAddress());
            bodegaDao = new InventarioDaoImpl(BodegaEntity.class);
            listBodegas = bodegaDao.readByNumber("code",
                    productoPojo.getBodega().getCode());
            proveedorEntity = new ProveedorEntity(
                    productoPojo.getProveedor().getName(),
                    productoPojo.getProveedor().getAddress(),
                    productoPojo.getProveedor().getPhone(),
                    productoPojo.getProveedor().getMail());
            proveedorDao = new InventarioDaoImpl(ProveedorEntity.class);
            listProveedores = proveedorDao.readByString("name",
                    productoPojo.getProveedor().getName());
            productoEntity = new ProductoEntity(
                    productoPojo.getName(),
                    productoPojo.getPrice(),
                    productoPojo.getAmount(),
                    productoPojo.getProveedor(),
                    productoPojo.getBodega());
            productoDao = new InventarioDaoImpl(ProductoEntity.class);
            listProductos = productoDao.readByString("name", productoPojo.getName());
            if (listProductos.size() > 0 || (listProveedores.size() < 1
                    || listBodegas.size() < 1)) {
                return false;
            } else {
                productoDao.create(productoEntity);
                return true;
            }

        } catch (Exception ex) {
            Logger.getLogger(ProductoEJB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     *
     * @param productoPojo
     * @param proveedorPojo
     * @param bodegaPojo
     * @return
     */
    @Override
    public boolean update(ProductoPojo productoPojo) {
        try {
            List<ProductoEntity> listProductos = new ArrayList<ProductoEntity>();
            List<BodegaEntity> listBodegas = new ArrayList<BodegaEntity>();
            List<ProveedorEntity> listProveedores = new ArrayList<ProveedorEntity>();
            System.out.println("ProductoEJB Create");
            bodegaEntity = new BodegaEntity(
                    productoPojo.getBodega().getCode(),
                    productoPojo.getBodega().getAddress());
            bodegaDao = new InventarioDaoImpl(BodegaEntity.class);
            listBodegas = bodegaDao.readByNumber("code",
                    productoPojo.getBodega().getCode());
            proveedorEntity = new ProveedorEntity(
                    productoPojo.getProveedor().getName(),
                    productoPojo.getProveedor().getAddress(),
                    productoPojo.getProveedor().getPhone(),
                    productoPojo.getProveedor().getMail());
            proveedorDao = new InventarioDaoImpl(ProveedorEntity.class);
            listProveedores = proveedorDao.readByString("name",
                    productoPojo.getProveedor().getName());
            productoEntity = new ProductoEntity(
                    productoPojo.getName(),
                    productoPojo.getPrice(),
                    productoPojo.getAmount(),
                    productoPojo.getProveedor(),
                    productoPojo.getBodega());
            productoDao = new InventarioDaoImpl(ProductoEntity.class);
            listProductos = productoDao.readByString("name", productoPojo.getName());
            if (listProveedores.size() < 1
                    || listBodegas.size() < 1) {
                return false;
            } else {
                productoDao.update(productoEntity);
                return true;
            }

        } catch (Exception ex) {
            Logger.getLogger(ProductoEJB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     *
     * @param productoPojo
     * @param proveedorPojo
     * @param bodegaPojo
     * @return
     */
    @Override
    public boolean delete(ProductoPojo productoPojo) {
        try {
            List<ProductoEntity> listProductos = new ArrayList<ProductoEntity>();
            productoEntity = new ProductoEntity(
                    productoPojo.getName(),
                    productoPojo.getPrice(),
                    productoPojo.getAmount(),
                    productoPojo.getProveedor(),
                    productoPojo.getBodega());
            productoDao = new InventarioDaoImpl(ProductoEntity.class);
            productoDao.deleteByString("name", productoPojo.getName());
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ProductoEJB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     *
     * @param productoPojo
     * @return
     */
    @Override
    public List<ProductoPojo> read(ProductoPojo productoPojo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
