/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiCamara.inventario.service;

import java.util.List;
import javax.ejb.Local;
import org.certiCamara.inventario.entity.BodegaEntity;
import org.certiCamara.inventario.model.BodegaPojo;

/**
 *
 * @author fenryr
 */
@Local
public interface BodegaEJBLocal {

    public List<BodegaEntity> loadLista();

    public boolean save(BodegaPojo bodegaPojo);

    public boolean update(BodegaPojo bodegaPojo);

    public boolean delete(BodegaPojo bodegaPojo);

    public List<BodegaPojo> read(BodegaPojo bodegaPojo);
}