/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiCamara.inventario.service;

import java.util.List;
import javax.ejb.Local;
import org.certiCamara.inventario.entity.ProductoEntity;
import org.certiCamara.inventario.model.ProductoPojo;

/**
 *
 * @author fenryr
 */
@Local
public interface ProductoEJBLocal {

    public List<ProductoEntity> loadLista();

    public boolean save(ProductoPojo productoPojo);

    public boolean update(ProductoPojo productoPojo);

    public boolean delete(ProductoPojo productoPojo);

    public List<ProductoPojo> read(ProductoPojo productoPojo);
}
