/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiCamara.inventario.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.certiCamara.inventario.entity.ProveedorEntity;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fenryr
 */
public class proveedorDaoImplTest {

    private ProveedorEntity proveedor;
    private InventarioDao proveedorDao;
    private List<ProveedorEntity> list;

    public proveedorDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        //System.out.println("Before Class");        
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class InventarioDaoImpl.
     */
    @Test
    public void testCreate() {
        try {
            System.out.println("create");
            proveedor = new ProveedorEntity("proveedorName", "proveedorAddress", "proveedorPhoneNumber", "proveedorMail");
            proveedorDao = new InventarioDaoImpl(ProveedorEntity.class);
            proveedorDao.create(proveedor);
        } catch (Exception ex) {
            Logger.getLogger(proveedorDaoImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of readByString method, of class InventarioDaoImpl.
     */
    @Test
    public void testReadByString() {
        try {
            System.out.println("readByString");
            proveedor = new ProveedorEntity("proveedorName", "proveedorAddress", "proveedorPhoneNumber", "proveedorMail");
            proveedorDao = new InventarioDaoImpl(ProveedorEntity.class);

            list = proveedorDao.readByString("address", "proveedorAddress");

            for (ProveedorEntity proveedorFind : list) {
                System.out.println("proveedorFind Nombre= " + proveedorFind.getName());
                System.out.println("proveedorFind Direccion= " + proveedorFind.getAddress());
                System.out.println("proveedorFind Telefono=" + proveedorFind.getMail());
                assertEquals(proveedor.getName(), proveedorFind.getName());
            }
        } catch (Exception ex) {
            Logger.getLogger(proveedorDaoImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of updateString method, of class InventarioDaoImpl.
     */
    @Test
    public void testUpdate() {
        try {
            System.out.println("update");
            proveedor = new ProveedorEntity("proveedorName", "updateProveedorAddress", "updateProveedorPhoneNumber", "updateProveedorMail");
            proveedorDao = new InventarioDaoImpl(ProveedorEntity.class);
            proveedorDao.update(proveedor);

            list = proveedorDao.readByString("address", "updateProveedorAddress");

            for (ProveedorEntity proveedorFind : list) {
                System.out.println("proveedorFind Nombre= " + proveedorFind.getName());
                System.out.println("proveedorFind Direccion= " + proveedorFind.getAddress());
                System.out.println("proveedorFind Telefono=" + proveedorFind.getMail());
                assertEquals(proveedor.getName(), proveedorFind.getName());
            }
        } catch (Exception ex) {
            Logger.getLogger(proveedorDaoImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of deleteByString method, of class InventarioDaoImpl.
     */
    @Test
    public void testDelete() {
        try {
            System.out.println("delete");
            proveedor = new ProveedorEntity("proveedorName", "deleteProveedorAddress", "deleteProveedorPhoneNumber", "deleteProveedorMail");
            proveedorDao = new InventarioDaoImpl(ProveedorEntity.class);
            proveedorDao.update(proveedor);

            list = proveedorDao.readByString("address", "updateProveedorAddress");

            for (ProveedorEntity proveedorFind : list) {
                System.out.println("proveedorFind Nombre= " + proveedorFind.getName());
                System.out.println("proveedorFind Direccion= " + proveedorFind.getAddress());
                System.out.println("proveedorFind Telefono=" + proveedorFind.getMail());
                assertEquals(proveedor.getName(), proveedorFind.getName());
            }

            proveedorDao.delete(proveedor);

            list = proveedorDao.readByString("name", "proveedorName");
            assertEquals(0, list.size());
        } catch (Exception ex) {
            Logger.getLogger(proveedorDaoImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
