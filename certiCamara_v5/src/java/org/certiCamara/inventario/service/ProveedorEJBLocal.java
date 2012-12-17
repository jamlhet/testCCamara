/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiCamara.inventario.service;

import java.util.List;
import javax.ejb.Local;
import org.certiCamara.inventario.entity.ProveedorEntity;
import org.certiCamara.inventario.model.ProveedorPojo;

/**
 *
 * @author fenryr
 */
@Local
public interface ProveedorEJBLocal {

    public List<ProveedorEntity> loadLista();

    public boolean save(ProveedorPojo bodegaPojo);

    public boolean update(ProveedorPojo bodegaPojo);

    public boolean delete(ProveedorPojo bodegaPojo);

    public List<ProveedorPojo> read(ProveedorPojo bodegaPojo);
}
