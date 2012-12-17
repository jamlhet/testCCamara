/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiCamara.inventario.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.certiCamara.inventario.entity.BodegaEntity;
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
public class bodegaDaoImplTest {

    private BodegaEntity bodega;
    private InventarioDao bodegaDao;
    //private static MongoDBConnection mcon;
    private List<BodegaEntity> list;

    public bodegaDaoImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        //System.out.println("Before Class");
        //mcon = new MongoDBConnection();
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
        System.out.println("create");
        bodega = new BodegaEntity(111, "test");
        try {
            bodegaDao = new InventarioDaoImpl(BodegaEntity.class);
        } catch (Exception ex) {
            Logger.getLogger(bodegaDaoImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        bodegaDao.create(bodega);
    }

    /**
     * Test of readByString method, of class InventarioDaoImpl.
     */
    @Test
    public void testReadByString() {
        try {
            System.out.println("readByString");
            bodega = new BodegaEntity(111, "test");
            bodegaDao = new InventarioDaoImpl(BodegaEntity.class);

            list = bodegaDao.readByString("address", "test");

            for (BodegaEntity bodegaFind : list) {

                System.out.println("bodegaFind Codigo= " + bodegaFind.getCode());
                System.out.println("bodegaFind Direccion= " + bodegaFind.getAddress());
                assertEquals(bodega.getCode(), bodegaFind.getCode());
            }
        } catch (Exception ex) {
            Logger.getLogger(bodegaDaoImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of readByString method, of class InventarioDaoImpl.
     */
    @Test
    public void testReadByNumber() {
        try {
            System.out.println("readByNumber");
            bodega = new BodegaEntity(111, "test");
            bodegaDao = new InventarioDaoImpl(BodegaEntity.class);

            list = bodegaDao.readByNumber("code", 111);

            for (BodegaEntity bodegaFind : list) {
                System.out.println("bodegaFind Codigo= " + bodegaFind.getCode());
                System.out.println("bodegaFind Direccion= " + bodegaFind.getAddress());
                assertEquals(bodega.getCode(), bodegaFind.getCode());
            }
        } catch (Exception ex) {
            Logger.getLogger(bodegaDaoImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of updateString method, of class InventarioDaoImpl.
     */
    @Test
    public void testUpdate() {
        try {
            System.out.println("update");
            bodega = new BodegaEntity(111, "update test");
            bodegaDao = new InventarioDaoImpl(BodegaEntity.class);
            bodegaDao.update(bodega);

            list = bodegaDao.readByString("address", "update test");

            for (BodegaEntity bodegaFind : list) {
                System.out.println("bodegaFind Codigo= " + bodegaFind.getCode());
                System.out.println("bodegaFind Direccion= " + bodegaFind.getAddress());
                assertEquals(bodega.getCode(), bodegaFind.getCode());
            }
        } catch (Exception ex) {
            Logger.getLogger(bodegaDaoImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of deleteByString method, of class InventarioDaoImpl.
     */
    @Test
    public void testDelete() {
        try {
            System.out.println("delete");
            bodega = new BodegaEntity(111, "delete test");
            bodegaDao = new InventarioDaoImpl(BodegaEntity.class);
            bodegaDao.update(bodega);
            list = bodegaDao.readByNumber("code", 888);

            for (BodegaEntity bodegaFind : list) {
                System.out.println("bodegaFind Codigo= " + bodegaFind.getCode());
                System.out.println("bodegaFind Direccion= " + bodegaFind.getAddress());
                assertEquals(bodega.getCode(), bodegaFind.getCode());
            }

            bodegaDao.delete(bodega);

            list = bodegaDao.readByNumber("code", 111);
            assertEquals(0, list.size());
            list = bodegaDao.readByString("address", "delete test");
            assertEquals(0, list.size());
        } catch (Exception ex) {
            Logger.getLogger(bodegaDaoImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
