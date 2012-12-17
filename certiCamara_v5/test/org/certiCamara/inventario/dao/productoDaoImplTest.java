/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiCamara.inventario.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.certiCamara.inventario.entity.BodegaEntity;
import org.certiCamara.inventario.entity.ProductoEntity;
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
public class productoDaoImplTest {

    private ProductoEntity producto;
    private ProveedorEntity proveedor;
    private BodegaEntity bodega;
    private InventarioDao productoDao;
    private InventarioDao proveedorDao;
    private InventarioDao bodegaDao;
    private List<ProductoEntity> list;

    public productoDaoImplTest() {
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
            proveedor = new ProveedorEntity("proveedorTest", "addressTest", "phoneTest", "mailTest");
            proveedorDao = new InventarioDaoImpl(ProveedorEntity.class);
            proveedorDao.create(proveedor);
            bodega = new BodegaEntity(111, "addresTest");
            bodegaDao = new InventarioDaoImpl(BodegaEntity.class);
            bodegaDao.create(bodega);
            producto = new ProductoEntity("productName", 123456789, 123, proveedor, bodega);
            productoDao = new InventarioDaoImpl(ProductoEntity.class);
            productoDao.create(producto);
        } catch (Exception ex) {
            Logger.getLogger(productoDaoImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of readByString method, of class InventarioDaoImpl.
     */
    @Test
    public void testReadByString() {
        try {
            System.out.println("readByString");
            String productName = "productName";
            productoDao = new InventarioDaoImpl(ProductoEntity.class);

            list = productoDao.readByString("name", productName);

            for (ProductoEntity productoFind : list) {

                System.out.println("bodegaFind Nombre= " + productoFind.getName());
                System.out.println("bodegaFind Cantidad= " + productoFind.getAmount());
                assertEquals(productName, productoFind.getName());
            }
        } catch (Exception ex) {
            Logger.getLogger(productoDaoImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of readByString method, of class InventarioDaoImpl.
     */
    @Test
    public void testReadByNumber() {
        try {
            System.out.println("readByNumber");
            int amount = 123;
            productoDao = new InventarioDaoImpl(ProductoEntity.class);

            list = productoDao.readByNumber("amount", 123);

            for (ProductoEntity productoFind : list) {
                System.out.println("productoFind Nombre= " + productoFind.getName());
                System.out.println("productoFind Precion= " + productoFind.getPrice());
                System.out.println("productoFind Cantidad= " + productoFind.getAmount());
                System.out.println("productoFind Proveedor= " + productoFind.getProveedor().getName());
                System.out.println("productoFind Bodega= " + productoFind.getBodega().getCode());
                assertEquals(amount, productoFind.getAmount());
            }
        } catch (Exception ex) {
            Logger.getLogger(productoDaoImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of updateString method, of class InventarioDaoImpl.
     */
    @Test
    public void testUpdate() {
        try {
            System.out.println("update");
            proveedor = new ProveedorEntity("proveedorTest", "addressTest", "phoneTest", "mailTest");
            bodega = new BodegaEntity(111, "addresTest");
            producto = new ProductoEntity("productName", 99999, 555, proveedor, bodega);
            productoDao = new InventarioDaoImpl(ProductoEntity.class);
            productoDao.update(producto);

            list = productoDao.readByNumber("price", 99999);

            for (ProductoEntity productoFind : list) {
                System.out.println("productoFind Nombre= " + productoFind.getName());
                System.out.println("productoFind Precion= " + productoFind.getPrice());
                System.out.println("productoFind Cantidad= " + productoFind.getAmount());
                System.out.println("productoFind Proveedor= " + productoFind.getProveedor().getName());
                System.out.println("productoFind Bodega= " + productoFind.getBodega().getCode());
                assertEquals((int) 99999, (int) productoFind.getPrice());
            }
        } catch (Exception ex) {
            Logger.getLogger(productoDaoImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of deleteByString method, of class InventarioDaoImpl.
     */
    @Test
    public void testDelete() {
        try {
            System.out.println("delete");
            String productName = "productName";
            productoDao = new InventarioDaoImpl(ProductoEntity.class);

            list = productoDao.readByString("name", productName);

            for (ProductoEntity productoFind : list) {

                System.out.println("bodegaFind Nombre= " + productoFind.getName());
                System.out.println("bodegaFind Cantidad= " + productoFind.getAmount());
                assertEquals(productName, productoFind.getName());
                productoDao.delete(productoFind);
            }



            list = productoDao.readByString("name", productName);
            assertEquals(0, list.size());
        } catch (Exception ex) {
            Logger.getLogger(productoDaoImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
